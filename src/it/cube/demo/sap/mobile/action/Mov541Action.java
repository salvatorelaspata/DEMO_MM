package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.BATCH_list;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovNetworkBean;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.bean.WBS_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_MOV_NETWORK;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.rfc.RfcCheckBatch;
import it.cube.demo.sap.mobile.rfc.RfcCheckWbs;
import it.cube.demo.sap.mobile.rfc.RfcMovNetwork;
import it.cube.demo.sap.mobile.rfc.RfcMovimentazioni;
import it.cube.demo.sap.mobile.util.UtilCheck;

public class Mov541Action implements ActionInterface, Constants{
	private String 	pagProv=null, 
					pagDest=URL.MENU,
					msg=null,
					esito=null,
					action="";
	
	//initial form
	private MovNetworkBean movNetworkInitial = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action = request.getParameter("action");
		pagProv = request.getParameter(Constants.PagProvenienza);
		
		request.getSession().removeAttribute("wbs_list");
		request.getSession().removeAttribute("batch_list");
		
		String pos = request.getParameter("pos");
		ArrayList<MovNetworkBean> movListDetail = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		if (pos != null) {
			MovNetworkBean movDetail = movListDetail.get(Integer.parseInt(pos));
			
			String matnr = request.getParameter("MATNR");
			this.movNetworkInitial = (MovNetworkBean) request.getSession().getAttribute("DETTAGLIO_INIZIALE");
			String maktx = this.movNetworkInitial.getMAKTX();//request.getParameter("MAKTX");
			String werks = request.getParameter("WERKS");
			String lgort = request.getParameter("LGORT");
			String charg = request.getParameter("CHARG");
			String licha = request.getParameter("LICHA");
			String posid = request.getParameter("PS_PSP_PNR");
			String lgnum = request.getParameter("LGNUM");
			String lgtyp = request.getParameter("LGTYP");
			String lgpla = request.getParameter("LGPLA");
			String menge = request.getParameter("MENGE");
			String meins = request.getParameter("MEINS");
			String rsnum = request.getParameter("RSNUM");
			String rspos = request.getParameter("RSPOS");
			
			String IS_GEST_PARTITA = request.getParameter("IS_GEST_PARTITA");
			String checkPartita = request.getParameter("checkPartita");
			if("reset".equals(action)) {
				reset(request, movDetail);
			}else {
				movDetail.setMATNR(matnr);
				movDetail.setMAKTX(maktx);
				movDetail.setWERKS(werks);
				movDetail.setLGORT(lgort);
				movDetail.setCHARG(charg);
				movDetail.setPOSID(posid);
				movDetail.setLGNUM(lgnum);
				movDetail.setLGTYP(lgtyp);
				movDetail.setLGPLA(lgpla);
				movDetail.setBDMNG(menge);
				movDetail.setMEINS(meins);
				movDetail.setRSNUM(rsnum);
				movDetail.setRSPOS(rspos);
			}
			request.setAttribute("checkPartita", checkPartita);
			
			
			if ("check".equals(action)) {
				if("true".equalsIgnoreCase(IS_GEST_PARTITA)){
					RfcCheckBatch rfcBatch = UtilCheck.checkBatch(request, menge, matnr, lgort, werks, licha, charg, lgnum, lgtyp, lgpla, "");
					if(rfcBatch.getBatch_list() != null && rfcBatch.getBatch_list().size() == 1){
						//prepopolo il campo
						BATCH_list batch = rfcBatch.getBatch_list().get(0);
						movDetail.setLICHA(batch.getLICHA());
						movDetail.setCHARG(batch.getCHARG());
						licha = batch.getLICHA();
						charg = batch.getCHARG();
						
						rfcBatch.setEsito(Success);
					}
					if ("S".equalsIgnoreCase(rfcBatch.getEsito()) || rfcBatch.getEsito() == null) {
						RfcCheckWbs rfcWBS = UtilCheck.checkWBS(request, matnr, werks, lgort, charg, "Q", menge, "", "", lgnum, lgtyp, lgpla);
						
						
						esito = rfcWBS.getEsito();
						
						msg = rfcWBS.getMsg();
						if(rfcWBS.getWbs_list() != null && rfcWBS.getWbs_list().size() == 1){
							//prepopolo il campo
							WBS_list wbs = rfcWBS.getWbs_list().get(0);
							request.setAttribute(ZSWM_MOVIMENTAZIONI.POSID, wbs.getPOSID());
							movDetail.setPOSID(wbs.getPOSID());
							posid = wbs.getPOSID();
							request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, wbs.getPOSID());			
						}
					}else {
						esito = rfcBatch.getEsito();
						msg = rfcBatch.getMsg();
						pagDest=URL.MOV_541;
					}
				}else {
					RfcCheckWbs rfcWBS = UtilCheck.checkWBS(request, matnr, werks, lgort, charg, "Q", menge, posid, "", lgnum, lgtyp, lgpla);
					esito = rfcWBS.getEsito();
					msg = rfcWBS.getMsg();
					if(rfcWBS.getWbs_list() != null && rfcWBS.getWbs_list().size() == 1){
						//prepopolo il campo
						WBS_list wbs = rfcWBS.getWbs_list().get(0);
						request.setAttribute(ZSWM_MOVIMENTAZIONI.POSID, wbs.getPOSID());
						movDetail.setPOSID(wbs.getPOSID());
						posid = wbs.getPOSID();
						request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, wbs.getPOSID());			
					}
//					if ("S".equalsIgnoreCase(rfcWBS.getEsito())) {
////					if(!UtilString.isEmpty(posid)) {
////						if("true".equalsIgnoreCase(IS_GEST_PARTITA)){
//							RfcCheckBatch rfcBatch = UtilCheck.checkBatch(request, menge, matnr, lgort, werks, licha, charg, lgnum, lgtyp, lgpla, posid, "true".equals(IS_GEST_PARTITA) ? "X" : "");
//							esito = rfcBatch.getEsito();
//							msg = rfcBatch.getMsg();
//							if(rfcBatch.getBatch_list() != null && rfcBatch.getBatch_list().size() == 1){
//								//prepopolo il campo
//								BATCH_list batch = rfcBatch.getBatch_list().get(0);
//								movDetail.setLICHA(batch.getLICHA());
//								movDetail.setCHARG(batch.getCHARG());
//								licha = batch.getLICHA();
//								charg = batch.getCHARG();
//							}
//							pagDest=URL.MOV_541;
////						}
//					}else {
//						esito = rfcWBS.getEsito();
//						msg = rfcWBS.getMsg();
//						pagDest=URL.MOV_541;
//					}
				}
				
			}
		}
		if(URL.MENU.equals(action))
			pagDest=URL.MENU;
		else if(URL.MOV_RICERCA_541.equals(pagProv)) {
			if ((request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN) == null || request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN) == "") && action == "b3") {
				esito = Error;
				msg = "E' necessario inserire un Ordine d`Acquisto per poter procedere.";
				pagDest=URL.MOV_RICERCA_541;
			}
			else{
				ricerca(request, response);
			}
			
		}
			
		else if(URL.MOV_RIEPILOGO_541.equals(pagProv)){
			pagDest = URL.MOV_RICERCA_541;
			if (action!=null && action.contains("pos_")){
				dettaglio(request, response);
			}
		}else if(URL.MOV_541.equals(pagProv)){
			pagDest=URL.MOV_541;
			if("b1".equals(action)) {
				try {
					getLista(request);	
				} catch (Exception e) {
					e.printStackTrace();
				}
				pagDest=URL.MOV_RIEPILOGO_541;
			}
			else{			
				ricercaEconferma(request, response);
			}
		}
		
		if (esito != null) {
			request.setAttribute(Show,esito);
			request.setAttribute(ErrorMessage, msg);
		}
		return pagDest;
	}
	
	private void reset(HttpServletRequest request, MovNetworkBean movDetail) {
		this.movNetworkInitial = (MovNetworkBean) request.getSession().getAttribute("DETTAGLIO_INIZIALE");
		movDetail.setMATNR(this.movNetworkInitial.getMATNR());
		movDetail.setMAKTX(this.movNetworkInitial.getMAKTX());
		movDetail.setWERKS(this.movNetworkInitial.getWERKS());
		movDetail.setLGORT(this.movNetworkInitial.getLGORT());
		movDetail.setCHARG(this.movNetworkInitial.getCHARG());
		movDetail.setPOSID(this.movNetworkInitial.getPOSID());
		movDetail.setLGNUM(this.movNetworkInitial.getLGNUM());
		movDetail.setLGTYP(this.movNetworkInitial.getLGTYP());
		movDetail.setLGPLA(this.movNetworkInitial.getLGPLA());
		movDetail.setBDMNG(this.movNetworkInitial.getBDMNG());
		movDetail.setMEINS(this.movNetworkInitial.getMEINS());
		movDetail.setRSNUM(this.movNetworkInitial.getRSNUM());
		movDetail.setRSPOS(this.movNetworkInitial.getRSPOS());
	}

	private void ricerca(HttpServletRequest request, HttpServletResponse response){
		pagDest=URL.MOV_RICERCA_541;
		if("b1".equals(action))
			pagDest=URL.MENU;
		else{
		
			String I_BWART = request.getParameter(ZFMWM_GET_MOV_NETWORK.BWART);
			
			String I_EBELN = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN);
			String I_EBELP = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELP);

			request.setAttribute(ZFMWM_GET_MOV_NETWORK.BWART, I_BWART);
			request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELN, I_EBELN);
			request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELP, I_EBELP);
			
			try {
				getLista(request);
			} catch (Exception e) {
				e.printStackTrace();
				esito = Error;
				msg = e.getLocalizedMessage();
			}
			
		}
		
	}

	private void ricercaEconferma(HttpServletRequest request, HttpServletResponse response) {
		
		String I_BWART = request.getParameter(ZFMWM_GET_MOV_NETWORK.BWART);
		String I_EBELN = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN);
		String I_EBELP = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELP);
		
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.BWART, I_BWART);
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELN, I_EBELN);
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELP, I_EBELP);
		
		String pos = request.getParameter("pos");
		request.setAttribute("pos", new Integer(pos));
		
		if("b1".equals(action)){
			
			try {
				getLista(request);
				pagDest = URL.MOV_RIEPILOGO_541;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("b3".equals(action) || action==null){
			request.setAttribute("pos", new Integer(request.getParameter("pos")));
			try{
				pagDest = URL.MOV_541;
				MovimentazioniBean movimentazione = new MovimentazioniBean(request);
				RfcMovimentazioni rfc = new RfcMovimentazioni();
				if (movimentazione.getMENGE().indexOf(",") != -1) 
					movimentazione.setMENGE(movimentazione.getMENGE().replace(",", "."));
				
				rfc.setMovimentazione(movimentazione);
				rfc.setI_CHECK("X");
				
				DatiUtente du = (DatiUtente)request.getSession().getAttribute(Constants.DATIUTENTE);
				rfc.setI_USERID(du.getUser().toString());
				
				ArrayList<MovNetworkBean> listaNetwork = caricaLista(request);
				rfc.setMovNetworkList(listaNetwork);
				
				rfc.execute();
				
				if(rfc.isEsitoOK()){
					rfc.setI_CHECK("");
					rfc.execute();
					if(rfc.isEsitoOK()){
						request.getSession().removeAttribute("wbs_list");
						
						esito = Success;
						
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC, rfc.getI_MAT_DOC());
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR, rfc.getI_DOC_YEAR());
						
						rfc.setMsg("Creato Doc. Materiale "+ rfc.getI_MAT_DOC()+" \\ "+rfc.getI_DOC_YEAR());

						getLista(request);
						pagDest=URL.MOV_RIEPILOGO_541;
					}
				} 
//				else {
//
//					this.noAction = true;
//					
//					ArrayList<WBS_list> listaWbs = rfc.getWbs_list();
//					
//					ArrayList<MovNetworkBean> movList = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
//					
//					MovNetworkBean mov = movList.get(Integer.parseInt(pos));
//					mov.setBDMNG(request.getParameter("MENGE"));
//					mov.setLGNUM(request.getParameter("LGNUM"));
//					mov.setLGPLA(request.getParameter("LGPLA"));
//					mov.setLGTYP(request.getParameter("LGTYP"));
//					mov.setCHARG(request.getParameter("CHARG"));
//					mov.setLICHA(request.getParameter("LICHA"));
//					mov.setPOSID(request.getParameter("PS_PSP_PNR"));
//					
//					if (!listaWbs.isEmpty()) {
//						request.getSession().setAttribute("wbs_list", listaWbs);
//					}else {
//						request.getSession().removeAttribute("wbs_list");
//					}
//					
//				}
				
				esito=rfc.getEsito();
				msg=rfc.getMsg();
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.MOV_541;
			}
		}
	}
	
	private ArrayList<MovNetworkBean> caricaLista(HttpServletRequest request){
		ArrayList<MovNetworkBean> mov = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		ArrayList<MovNetworkBean> send = new ArrayList<MovNetworkBean>();
		int pos = Integer.parseInt(request.getParameter("pos"));
		
		for(int i = 0; i < mov.size();i++){
			MovNetworkBean m = mov.get(i);
			if (i == pos) {
				m.setFLAG("X");
			}
			send.add(i, m);
		}
		
		return send;
	
	}
	
	private void getLista(HttpServletRequest request) throws Exception{
		
		try{
			MovimentazioniBean movimentazione = new MovimentazioniBean(request);
			RfcMovNetwork rfc = new RfcMovNetwork();
			rfc.setMovimentazione(movimentazione);
			rfc.execute();		
			if(rfc.isEsitoOK()){
				String I_BWART = request.getParameter(ZFMWM_GET_MOV_NETWORK.BWART);
				String I_EBELN = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN);
				String I_EBELP = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELP);
				
				request.setAttribute(ZFMWM_GET_MOV_NETWORK.BWART, I_BWART);
				request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELN, I_EBELN);
				request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELP, I_EBELP);
				
				request.getSession().setAttribute(Session.LISTAMOV, rfc.getMovNetworkList());
				pagDest = URL.MOV_RIEPILOGO_541;
			}else{
				pagDest = rfc.getMovNetworkList().size() > 0 ? URL.MOV_RIEPILOGO_541 : URL.MOV_RICERCA_541;
			}

			esito = rfc.getEsito();
			msg = rfc.getMsg();
			
		}catch(Exception e){
			esito = "E";
			msg = e.getLocalizedMessage();
			e.printStackTrace();
			pagDest = URL.MOV_RICERCA_541;
		}

	}
	
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		
		String I_BWART = request.getParameter(ZFMWM_GET_MOV_NETWORK.BWART);
		String I_EBELN = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELN);
		String I_EBELP = request.getParameter(ZFMWM_GET_MOV_NETWORK.EBELP);
		
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.BWART, I_BWART);
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELN, I_EBELN);
		request.setAttribute(ZFMWM_GET_MOV_NETWORK.EBELP, I_EBELP);
		
		int posDet  = Integer.parseInt(action.split("_")[1]);

		ArrayList<MovNetworkBean> movList = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
		MovNetworkBean mov = movList.get(posDet);
		
		ArrayList<MovNetworkBean> clone = new ArrayList<MovNetworkBean>(movList.size());
	    for(MovNetworkBean item : movList) {
	    	MovNetworkBean itemClone = new MovNetworkBean(item);
	    	clone.add((MovNetworkBean)itemClone);
	    }
		
	    MovNetworkBean inizialePos = clone.get(posDet);

		request.getSession().setAttribute("DETTAGLIO_INIZIALE", inizialePos);
		this.movNetworkInitial = mov;
		             
		pagDest = URL.MOV_541;
		
		request.setAttribute("pos", posDet);
		
	}

}
