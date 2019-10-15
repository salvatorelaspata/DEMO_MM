package it.cube.demo.sap.mobile.action.report;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.MaterialeBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GETLIST_STORAGE;
import it.cube.demo.sap.mobile.rfc.report.RfcRicercaUbDaMat;
import it.cube.demo.sap.mobile.util.UtilString;


public class RicercaUbicazioni implements ActionInterface, Constants{
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
		}else if(URL.RICERCA_UBICAZIONE.equals(action)){
			pagDest=URL.RICERCA_UBICAZIONE;
		}else if(URL.RICERCA_UBICAZIONE.equals(pagProv)){			
			ricerca(request, response);
		}else if(URL.ELENCOUBICAZIONI.equals(pagProv)){			
			elenco(request, response);
		}else if(URL.DETTAGLIOUBICAZIONE.equals(pagProv)){			
			dettaglio(request, response);
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		
		return pagDest;
	}
	
	private void ricerca(HttpServletRequest request, HttpServletResponse response){
		
		String I_LGNUM=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_STORAGE.I_LGNUM)).toUpperCase(),
			I_LGPLA=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_STORAGE.I_LGPLA)).toUpperCase(),
			I_LGTYP=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_STORAGE.I_LGTYP)).toUpperCase(),
			I_WERKS=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_STORAGE.I_WERKS)).toUpperCase(),
			I_LICHA=UtilString.removeNull(request.getParameter(ZFMWM_GETLIST_STORAGE.I_LICHA)).toUpperCase();
		
		request.setAttribute("I_WERKS", I_WERKS);
		request.setAttribute("I_LGTYP", I_LGTYP);
		request.setAttribute("I_LGPLA", I_LGPLA);
		request.setAttribute("I_LGNUM", I_LGNUM);
		request.setAttribute("I_LICHA", I_LICHA);
		if("b3".equals(action)){
			try {
				RfcRicercaUbDaMat rfc= new RfcRicercaUbDaMat();
				rfc.setI_LGNUM(I_LGNUM);
				rfc.setI_LGPLA(I_LGPLA);
				rfc.setI_LGTYP(I_LGTYP);
//				rfc.setI_USER(utente.getUser());
				rfc.setI_WERKS(I_WERKS);
				rfc.setI_LICHA(I_LICHA);
				rfc.execute();
				if(Error.equalsIgnoreCase(rfc.getEsito())){
					pagDest=URL.RICERCA_UBICAZIONE;
					msg=rfc.getMsg();
					esito=rfc.getEsito();
				}else{
					request.getSession().setAttribute(Session.LISTAMAT, rfc.getListaMat());
					pagDest=URL.ELENCOUBICAZIONI;
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
			pagDest=URL.DETTAGLIOUBICAZIONE;
		}else if(URL.RICERCA_UBICAZIONE.equals(action)){
			pagDest = URL.RICERCA_UBICAZIONE;
		}else{
			pagDest=URL.ELENCOUBICAZIONI;
//			msg="Errore nell'esecuzione del comando";
//			esito=Error;
		}
	}
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		pagDest=URL.ELENCOUBICAZIONI;
	}

}
