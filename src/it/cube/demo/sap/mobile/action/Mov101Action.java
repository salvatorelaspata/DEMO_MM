package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_ODA;
import it.cube.demo.sap.mobile.rfc.RfcMovRicerca101;
import it.cube.demo.sap.mobile.rfc.RfcMovimentazioni;

public class Mov101Action implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null;//azione=null;
	String ip=null;
	private String action=""; 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(Constants.PagProvenienza);
		if(URL.MENU.equals(action))
			pagDest=URL.MENU;
		else if(URL.MOV_RICERCA_101.equals(pagProv)){
			ricerca(request, response);
			
		}else if(URL.MOV_RIEPILOGO_101.equals(pagProv)){
			pagDest = URL.MOV_RICERCA_101;
			if (action!=null && action.contains("pos_")){
				dettaglio(request, response);
			}
		}else if(URL.MOV_101.equals(pagProv)){
			pagDest=URL.MOV_101;
			if("b1".equals(action))
				pagDest=URL.MOV_RIEPILOGO_101;
			else{			
				ricercaEconferma(request, response);
			}
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		return pagDest;
	}
	
	private void ricerca(HttpServletRequest request, HttpServletResponse response){
		pagDest=URL.MOV_RICERCA_101;
		if("b1".equals(action))
			pagDest=URL.MENU;
		else{
		
			String I_EBELP = request.getParameter(ZFMWM_GET_ODA.I_EBELP);
			String I_EBELN = request.getParameter(ZFMWM_GET_ODA.I_EBELN);
			request.setAttribute(ZFMWM_GET_ODA.I_EBELP, I_EBELP);
			request.setAttribute(ZFMWM_GET_ODA.I_EBELN, I_EBELN);
			
			try {
				
				getLista(I_EBELP,I_EBELN,request);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				esito =Error;
				msg = e.getLocalizedMessage();
			}
		}
		
	}
	
	private void ricercaEconferma(HttpServletRequest request, HttpServletResponse response) {
		String I_EBELP = request.getParameter(ZFMWM_GET_ODA.I_EBELP);
		String I_EBELN = request.getParameter(ZFMWM_GET_ODA.I_EBELN);
		request.setAttribute(ZFMWM_GET_ODA.I_EBELP, I_EBELP);
		request.setAttribute(ZFMWM_GET_ODA.I_EBELN, I_EBELN);
		
		if("b1".equals(action)){
			pagDest= URL.MOV_RIEPILOGO_101;
		}else if("b3".equals(action) || action==null){
			request.setAttribute("pos", new Integer(request.getParameter("pos")));
			try{
				pagDest=URL.MOV_101;
				MovimentazioniBean movimentazione=new MovimentazioniBean(request);
				RfcMovimentazioni rfc= new RfcMovimentazioni();
				rfc.setMovimentazione(movimentazione);
				rfc.setI_CHECK("X");
				DatiUtente du = (DatiUtente)request.getSession().getAttribute(Constants.DATIUTENTE);
				rfc.setI_USERID(du.getUser());
				rfc.execute();
				
				
				if(rfc.isEsitoOK()){
					rfc.setI_CHECK("");
					rfc.execute();
					if(rfc.isEsitoOK()){
						esito=Success;
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC, rfc.getI_MAT_DOC());
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR, rfc.getI_DOC_YEAR());
						rfc.setMsg("Creato Doc. Materiale "+ rfc.getI_MAT_DOC()+" \\ "+rfc.getI_DOC_YEAR());
						
						getLista(I_EBELP,I_EBELN,request);
						pagDest=URL.MOV_RIEPILOGO_101;
					}
				}
				esito=rfc.getEsito();
				msg=rfc.getMsg();
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.MOV_101;
			}
		}
		

	}
	
	private void getLista(String I_EBELP,String I_EBELN,HttpServletRequest request) throws Exception{
		

			RfcMovRicerca101 rfc= new RfcMovRicerca101();
			rfc.setI_EBELP(I_EBELP);
			rfc.setI_EBELN(I_EBELN);
			rfc.execute();
			if(rfc.isEsitoOK()){
				request.getSession().setAttribute(Constants.Session.LISTAMOV,  rfc.getMovimentazioneList());
				pagDest=URL.MOV_RIEPILOGO_101;
			}else{
				esito=rfc.getEsito();
				msg=rfc.getMsg();
				
			}

	}
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		String I_EBELP = request.getParameter(ZFMWM_GET_ODA.I_EBELP);
		String I_EBELN = request.getParameter(ZFMWM_GET_ODA.I_EBELN);
		request.setAttribute(ZFMWM_GET_ODA.I_EBELP, I_EBELP);
		request.setAttribute(ZFMWM_GET_ODA.I_EBELN, I_EBELN);
		ArrayList<MovimentazioniBean> mov=(ArrayList<MovimentazioniBean>) request.getSession().getAttribute(Session.LISTAMOV);
		int posDet  = Integer.parseInt(action.split("_")[1]);
		
		pagDest=URL.MOV_101;
		request.setAttribute("pos", posDet);
		
	}
	
//
//	private void conferma(HttpServletRequest request, HttpServletResponse response){
//		try{
//			ArrayList<ConfermaOTBean> tob=(ArrayList<ConfermaOTBean>)request.getSession().getAttribute(Session.LISTAOT);
//
//			RfcConfermaOT rfc=new RfcConfermaOT();
//			rfc.setTrasOT(tob);
//			rfc.setTutti(Boolean.parseBoolean(request.getParameter("tutti")));
//			rfc.execute();
//			esito=rfc.getEsito();
//			tob=rfc.getTrasOT();
//			msg=rfc.getMsg();
//			if(rfc.isEsitoOK() || rfc.isEsitoInfo()){
//				pagDest=URL.CONFOT2;	
////				remove(tob,listcheck);
//			}
//			if(tob==null || tob.isEmpty()){
//				pagDest=URL.CONFOT;
//			}
//			request.getSession().setAttribute(Session.LISTAOT,tob);
//
//		}catch(Exception e){
//			e.printStackTrace();
//			msg=e.getLocalizedMessage();
//			esito=SapRfc.Error;
//		}
//		
//	}
}
