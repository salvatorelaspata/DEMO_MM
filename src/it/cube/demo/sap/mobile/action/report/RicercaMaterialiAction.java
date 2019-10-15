package it.cube.demo.sap.mobile.action.report;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.MaterialeBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GETLIST_MATERIALE;
import it.cube.demo.sap.mobile.rfc.report.RfcRicercaMatDaUb;
import it.cube.demo.sap.mobile.util.UtilString;


public class RicercaMaterialiAction implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null;
	
	String ip=null;
	private String action="";//tipoMov;
	// i movimenti sono formati solitamente da Prima pagina(inserimento dati),Dettagli Mov,Rieplilogo coda movimenti, 
	//tutti finiscono con il nome della cartella in cui sono contenuti, utilizzo questo per valorizzare la pagina destinazione
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(PagProvenienza);
		if(URL.MENU.equals(action)){
			pagDest=URL.MENU;
		}else if(URL.RICERCA_MATERIALE.equals(action)){
			pagDest=URL.RICERCA_MATERIALE;
		}else if(URL.RICERCA_MATERIALE.equals(pagProv)){
			ricerca(request, response);
		}else if(URL.ELENCOMATERIALI.equals(pagProv)){
			
			elenco(request, response);
		}else if(URL.DETTAGLIOMATERIALE.equals(pagProv)){
			
			dettaglio(request, response);
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		
		return pagDest;
	}
	
	private void ricerca(HttpServletRequest request, HttpServletResponse response){
		
		String I_LGNUM=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_MATERIALE.I_LGNUM)).toUpperCase(),
				I_MATNR=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_MATERIALE.I_MATNR)).toUpperCase(),
				I_LGTYP=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_MATERIALE.I_LGTYP)).toUpperCase(),
				I_WERKS=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_MATERIALE.I_WERKS)).toUpperCase(),
				I_LICHA=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_MATERIALE.I_LICHA)).toUpperCase();
		
		
//		DatiUtente utente= (DatiUtente)request.getSession().getAttribute(DATIUTENTE);
		request.setAttribute("I_WERKS", I_WERKS);
		request.setAttribute("I_LGTYP", I_LGTYP);
		request.setAttribute("I_MATNR", I_MATNR);
		request.setAttribute("I_LGNUM", I_LGNUM);
		request.setAttribute("I_LICHA", I_LICHA);
		if("b3".equals(action)){
			try {
				RfcRicercaMatDaUb rfc= new RfcRicercaMatDaUb();
				rfc.setI_LGNUM(I_LGNUM);
				rfc.setI_MATNR(I_MATNR);
				rfc.setI_LGTYP(I_LGTYP);
//				rfc.setI_USER(utente.getUser());
				rfc.setI_LICHA(I_LICHA);
				rfc.setI_WERKS(I_WERKS);
				rfc.execute();
				if(Error.equalsIgnoreCase(rfc.getEsito())){
					pagDest=URL.RICERCA_MATERIALE;
					msg=rfc.getMsg();
					esito=rfc.getEsito();
				}else{
					request.getSession().setAttribute(Session.LISTAMAT, rfc.getListaMat());
					pagDest=URL.ELENCOMATERIALI;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getMessage();
				esito=Error;
			}
		}
	}
	private void elenco(HttpServletRequest request, HttpServletResponse response){
		if(action!=null && action.startsWith("pos_")){
			ArrayList<MaterialeBean> lista = (ArrayList<MaterialeBean>)request.getSession().getAttribute(Session.LISTAMAT);
			Integer pos=new Integer(action.split("_")[1]);
			MaterialeBean materiale= lista.get(pos);
			request.setAttribute("materiale", materiale);
			pagDest=URL.DETTAGLIOMATERIALE;
		}else if(URL.RICERCA_MATERIALE.equals(action)){
			pagDest = URL.RICERCA_MATERIALE;
		}else{
			pagDest=URL.ELENCOMATERIALI;
			msg="Errore nell'esecuzione del comando";
			esito=Error;
		}
	}
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		pagDest=URL.ELENCOMATERIALI;
	}

}
