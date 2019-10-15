package it.cube.demo.sap.mobile.action;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovNetworkBean;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.IT_LISTA_NETWORK;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.rfc.RfcMovNetwork;
import it.cube.demo.sap.mobile.rfc.RfcMovimentazioni;
import it.cube.demo.sap.mobile.util.UtilString;

public class Mov221Action implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null;//azione=null;
	String ip=null;
	private String action=""; 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(Constants.PagProvenienza);
		
		String RSPOS=UtilString.removeNull( request.getParameter(ZSWM_MOVIMENTAZIONI.RSPOS));
		String NPLNR=UtilString.removeNull( request.getParameter(ZSWM_MOVIMENTAZIONI.NPLNR));
		request.setAttribute(ZSWM_MOVIMENTAZIONI.RSPOS,RSPOS);
		request.setAttribute(ZSWM_MOVIMENTAZIONI.NPLNR,NPLNR);
		if(URL.MOV_221.equals(pagProv)){

			ricercaEconferma(request, response);
		}else if(URL.MOV_RIEPILOGO221.equals(pagProv)){
			riepilogoAction(request, response);
		}else if(URL.DETTAGLIO_MOV221.equals(pagProv)){
			if(action.contains(".jsp")){
				pagDest=action;
			}
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		return pagDest;
	}
	
	private void riepilogoAction(HttpServletRequest request, HttpServletResponse response) {
		
		if("b1".equals(action)){
			pagDest= URL.MOV_221;
		}else if("b3".equals(action) || action==null){ //azione di conferma e creazione della movimentazione
			pagDest=URL.MOV_RIEPILOGO221;
			
			
			try{
				MovimentazioniBean movimentazione=new MovimentazioniBean(request);
				RfcMovimentazioni rfc= new RfcMovimentazioni();
				rfc.setMovimentazione(movimentazione); 
				rfc.setMovNetworkList(caricaLista(request));
				DatiUtente du = (DatiUtente)request.getSession().getAttribute(Constants.DATIUTENTE);
				rfc.setI_USERID(du.getUser());
				rfc.setI_CHECK("X");
				rfc.execute();	
				if(rfc.isEsitoOK()){//EFFETTUO IL CONTROLLO SUL CHECK DEI RECORD LATO SAP
					rfc.setI_CHECK("");
					rfc.execute();
					if(rfc.isEsitoOK()){//SE è ANDATO TUTTO OK LA MOVIMENTAZIONE è ANDATA A BUON FINE
						esito=Success;
						request.getSession().setAttribute(Session.LISTAMOV, rfc.getMovNetworkList());
						
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC, rfc.getI_MAT_DOC());
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR, rfc.getI_DOC_YEAR());
						rfc.setMsg("Creato Doc. Materiale "+ rfc.getI_MAT_DOC()+" \\ "+rfc.getI_DOC_YEAR());
						
						pagDest=URL.MOV_221;
					}
				}else{
					pagDest=URL.MOV_RIEPILOGO221;
				}

				esito=rfc.getEsito();
				
				msg=rfc.getMsg();
				
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.MOV_221;
			}
			
		}else if (action!=null && action.contains("pos_")){
			dettaglio(request, response);
		}
	}
	private ArrayList<MovNetworkBean> caricaLista(HttpServletRequest request){
		ArrayList<MovNetworkBean> mov=(ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		ArrayList<MovNetworkBean> send = new ArrayList<MovNetworkBean>();
		int maxRow = Integer.parseInt(request.getParameter("maxRow"));
		//if(mov==null) mov = new ArrayList<MovNetworkBean>();
		for(int i=0; i<maxRow;i++){
			MovNetworkBean m = mov.get(i);
			String CHECK = request.getParameter("check_"+i);
			
			if("on".equals(CHECK)){
				m.setFLAG("X");
//				send.add(i, m);
			}
			send.add(i, m);
		}
		
		return send;
	
	}
	
	
	private void ricercaEconferma(HttpServletRequest request, HttpServletResponse response) {
		if("b1".equals(action)){
			pagDest= URL.MENU;
		}else if("b3".equals(action) || action==null){
			try{
				MovimentazioniBean movimentazione=new MovimentazioniBean(request);
				RfcMovNetwork rfc= new RfcMovNetwork();
				rfc.setMovimentazione(movimentazione);
				rfc.execute();		
				if(rfc.isEsitoOK()){					
					esito=Success;
					request.getSession().setAttribute(Session.LISTAMOV, rfc.getMovNetworkList());
					pagDest=URL.MOV_RIEPILOGO221;
				}else{
					pagDest=URL.MOV_221;
				}

				esito=rfc.getEsito();
				msg=rfc.getMsg();
				request.setAttribute("RSPOS", movimentazione.getRSPOS());
				request.setAttribute("NPLNR", movimentazione.getNPLNR());
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.MOV_221;
			}
			
		}
	}
	
	public static void salvaModifica(HttpServletRequest request, HttpServletResponse response){
		ArrayList<MovNetworkBean> mov=(ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		
//		int posDet  = Integer.parseInt(action.split("_")[1]);
		
		int pos = Integer.parseInt(request.getParameter("pos"));
		MovNetworkBean det = mov.get(pos);
		String BDMNG = request.getParameter(IT_LISTA_NETWORK.BDMNG);
		String CHARG = request.getParameter(IT_LISTA_NETWORK.CHARG);
		
		det.setBDMNG(BDMNG);
		det.setCHARG(CHARG);
		
		mov.set(pos, det);
		request.getSession().setAttribute(Session.LISTAMOV,mov);
//		det.checked=Boolean.parseBoolean(CHECKED);
//		pagDest=URL.DETTAGLIO_MOV221;
		//request.setAttribute("dettaglio", det);
		
	}
	
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		ArrayList<MovNetworkBean> mov=(ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		int posDet  = Integer.parseInt(action.split("_")[1]);
		MovNetworkBean det = mov.get(posDet);
		pagDest=URL.DETTAGLIO_MOV221;
		request.setAttribute("dettaglio", det);
		
	}
}
