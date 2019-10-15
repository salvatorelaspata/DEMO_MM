package it.cube.demo.sap.mobile.util;

import javax.servlet.http.HttpServletRequest;

import it.cube.demo.sap.mobile.bean.BATCH_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.rfc.RfcCheckBatch;
import it.cube.demo.sap.mobile.rfc.RfcCheckWbs;

public class UtilCheck implements Constants{
	
	public static RfcCheckWbs checkWBS(HttpServletRequest request, String matnr, String werks, String lgort, String charg, 
			String sobkz, String menge, String ps_psp_pnr, String meins, String lgnum, String lgtyp, String lgpla) {
		menge = menge.replace(",", ".");
		
		RfcCheckWbs rfcWBS = null;
		try {
			rfcWBS = new RfcCheckWbs(matnr, werks, lgort, charg, sobkz, menge, ps_psp_pnr, meins, lgnum, lgtyp, lgpla);;
			rfcWBS.execute();
			
			if (rfcWBS.getWbs_list() != null && !rfcWBS.getWbs_list().isEmpty()) {
				if (!rfcWBS.getWbs_list().isEmpty()) {
					request.getSession().setAttribute("wbs_list", rfcWBS.getWbs_list());
				}
				else {
					request.getSession().removeAttribute("wbs_list");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rfcWBS;
	}
	
	public static RfcCheckBatch checkBatch(HttpServletRequest request, String menge, String matnr, String lgort, String werks,
			String licha, String charg, String lgnum, String lgtyp, String lgpla, String ps_psp_pnr) {
		menge = menge.replace(",", ".");
		RfcCheckBatch rfcBatch = null;
		try {
			rfcBatch = new RfcCheckBatch(matnr, werks, lgort, charg, ps_psp_pnr, lgnum, lgtyp, lgpla, menge);
			rfcBatch.execute();
			
			if (rfcBatch.getBatch_list() != null && !rfcBatch.getBatch_list().isEmpty()) {
				if (rfcBatch.getBatch_list().size() > 1) {
					//propongo la modale con le partite possibili
					request.getSession().setAttribute("batch_list", rfcBatch.getBatch_list());
				}else if(rfcBatch.getBatch_list().size() == 1){
					//prepopolo il campo
					BATCH_list batch = rfcBatch.getBatch_list().get(0);
					request.setAttribute(ZSWM_MOVIMENTAZIONI.CHARG, batch.getCHARG());// partita
					request.setAttribute(ZSWM_MOVIMENTAZIONI.LICHA, batch.getLICHA());// lotto
				}else {
					request.getSession().removeAttribute("batch_list");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rfcBatch;
	}
}
