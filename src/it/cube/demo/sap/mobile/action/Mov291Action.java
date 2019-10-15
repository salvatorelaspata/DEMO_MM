package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.BATCH_list;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.bean.WBS_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.rfc.RfcCheckBatch;
import it.cube.demo.sap.mobile.rfc.RfcCheckWbs;
import it.cube.demo.sap.mobile.rfc.RfcMovimentazioni;
import it.cube.demo.sap.mobile.util.UtilCheck;
import it.cube.demo.sap.mobile.util.UtilString;

public class Mov291Action implements ActionInterface, Constants {
	private String 	pagProv = null, 
					pagDest = URL.MENU, 
					msg = null, 
					esito = null, 
					action = "";

	private String 	licha = "", 
					charg = "";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().removeAttribute("wbs_list");
		request.getSession().removeAttribute("batch_list");

		action = request.getParameter("action");
		pagProv = request.getParameter(Constants.PagProvenienza);

		String menge = request.getParameter(ZSWM_MOVIMENTAZIONI.MENGE);
		String matnr = request.getParameter(ZSWM_MOVIMENTAZIONI.MATNR);
		String lgort = request.getParameter(ZSWM_MOVIMENTAZIONI.LGORT);
		String werks = request.getParameter(ZSWM_MOVIMENTAZIONI.WERKS);
		String lgnum = request.getParameter(ZSWM_MOVIMENTAZIONI.LGNUM);
		String lgtyp = request.getParameter(ZSWM_MOVIMENTAZIONI.LGTYP);
		String lgpla = request.getParameter(ZSWM_MOVIMENTAZIONI.LGPLA);
		String ps_psp_pnr = request.getParameter(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR);
		this.charg = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.CHARG));
		this.licha = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LICHA));

		request.setAttribute(ZSWM_MOVIMENTAZIONI.MENGE, menge); // quantità
		request.setAttribute(ZSWM_MOVIMENTAZIONI.MATNR, matnr); // codice materiale
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGORT, lgort); // magazzino
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGNUM, lgnum); // area mag
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGTYP, lgtyp); // tipo mag
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGPLA, lgpla); // ubicazione
		request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, ps_psp_pnr); // wbs
		request.setAttribute(ZSWM_MOVIMENTAZIONI.SOBKZ, "Q");

		if ("check".equals(action)) {
			RfcCheckBatch rfcBatch = UtilCheck.checkBatch(request, menge, matnr, lgort, werks, this.licha, this.charg, lgnum, lgtyp, lgpla, "");
			boolean isGestPartita = rfcBatch.isGestPartita();
			request.setAttribute("IS_GEST_PARTITA", isGestPartita);
			if(isGestPartita) {
				if(rfcBatch.getBatch_list() != null && rfcBatch.getBatch_list().size() == 1){
					BATCH_list batch = rfcBatch.getBatch_list().get(0);
					request.setAttribute(ZSWM_MOVIMENTAZIONI.LICHA, batch.getLICHA()); // lotto
					request.setAttribute(ZSWM_MOVIMENTAZIONI.CHARG, batch.getCHARG()); // partita
					this.licha = batch.getLICHA();
					this.charg = batch.getCHARG();
					
					rfcBatch.setEsito(Success);
				}
				if ("S".equalsIgnoreCase(rfcBatch.getEsito())) {
					RfcCheckWbs rfcWBS = UtilCheck.checkWBS(request, matnr, werks, lgort, this.charg, "Q", menge, ps_psp_pnr, "", lgnum, lgtyp, lgpla);
					esito = rfcWBS.getEsito();
					msg = rfcWBS.getMsg();
					if(rfcWBS.getWbs_list() != null && rfcWBS.getWbs_list().size() == 1){
						//prepopolo il campo
						WBS_list wbs = rfcWBS.getWbs_list().get(0);
						ps_psp_pnr = wbs.getPOSID();
						request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, wbs.getPOSID());			
					}
				}else {
					esito = rfcBatch.getEsito();
					msg = rfcBatch.getMsg();
					pagDest=URL.MOV_291;
				}
			}else {
				RfcCheckWbs rfcWBS = UtilCheck.checkWBS(request, matnr, werks, lgort, charg, "Q", menge, ps_psp_pnr, "", lgnum, lgtyp, lgpla);
				esito = rfcWBS.getEsito();
				msg = rfcWBS.getMsg();
				if(rfcWBS.getWbs_list() != null && rfcWBS.getWbs_list().size() == 1){
					//prepopolo il campo
					//prepopolo il campo
					WBS_list wbs = rfcWBS.getWbs_list().get(0);
					ps_psp_pnr = wbs.getPOSID();
					request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, wbs.getPOSID());			
				}
			}
		}

		if (esito != Error) {
			if (URL.MOV_291.equals(pagProv)) {
				registra(request, response);
			} else {
				pagDest = URL.MENU;
			}
		}

		if (this.licha != null && this.licha != "")
			request.setAttribute(ZSWM_MOVIMENTAZIONI.LICHA, this.licha); // lotto
		if (this.charg != null && this.charg != "")
			request.setAttribute(ZSWM_MOVIMENTAZIONI.CHARG, this.charg); // partita

		request.setAttribute(Show, esito);
		request.setAttribute(ErrorMessage, msg);
		return pagDest;
	}

	private void registra(HttpServletRequest request, HttpServletResponse response) {

		if ("b1".equals(action)) {
			pagDest = URL.MENU;
		} else if ("b3".equals(action) || action == null) {
			try {
				MovimentazioniBean movimentazione = new MovimentazioniBean(request);
				RfcMovimentazioni rfc = new RfcMovimentazioni();
				rfc.setMovimentazione(movimentazione);
				rfc.setI_CHECK("X");
				DatiUtente du = (DatiUtente) request.getSession().getAttribute(Constants.DATIUTENTE);
				rfc.setI_USERID(du.getUser());
				rfc.execute();

				if (rfc.isEsitoOK()) {
					rfc.setI_CHECK("");
					rfc.execute();
					if (rfc.isEsitoOK()) {
						request.getSession().removeAttribute("wbs_list");
						esito = Success;
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC, rfc.getI_MAT_DOC());
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR, rfc.getI_DOC_YEAR());
						rfc.setMsg("Creato Doc. Materiale " + rfc.getI_MAT_DOC() + " \\ " + rfc.getI_DOC_YEAR());

						this.licha = "";
						this.charg = "";

						clearOnSuccess(request);

					}
				} else {
					ArrayList<WBS_list> listaWbs = rfc.getWbs_list();

					if (!listaWbs.isEmpty())
						request.getSession().setAttribute("wbs_list", listaWbs);
					else
						request.getSession().removeAttribute("wbs_list");

				}

				pagDest = URL.MOV_291;
				esito = rfc.getEsito();
				msg = rfc.getMsg();
			} catch (Exception e) {
				esito = "E";
				msg = e.getLocalizedMessage();
				e.printStackTrace();
				pagDest = URL.MOV_291;
			}
		} else {
			pagDest = URL.MOV_291;
			System.err.println(
					"[291] JAVA - LICHA: " + request.getAttribute("LICHA") + "CHARG: " + request.getAttribute("CHARG"));
		}

	}

	private void clearOnSuccess(HttpServletRequest request) {
		request.setAttribute(ZSWM_MOVIMENTAZIONI.MENGE, ""); // quantità
		request.setAttribute(ZSWM_MOVIMENTAZIONI.MATNR, ""); // codice materiale
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGORT, ""); // magazzino
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LICHA, ""); // lotto
		request.setAttribute(ZSWM_MOVIMENTAZIONI.CHARG, ""); // partita
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGNUM, ""); // area mag
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGTYP, ""); // tipo mag
		request.setAttribute(ZSWM_MOVIMENTAZIONI.LGPLA, ""); // ubicazione
		request.setAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, ""); // wbs
		request.setAttribute(ZSWM_MOVIMENTAZIONI.SOBKZ, "Q");
	}

}
