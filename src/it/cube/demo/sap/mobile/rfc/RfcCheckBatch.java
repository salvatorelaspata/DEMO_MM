package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.BATCH_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;
import it.cube.demo.sap.mobile.util.UtilString;

public class RfcCheckBatch extends RfcExtend implements Constants, ConstantsSap {

	private String I_MATNR = "I_MATNR"; // 0600088
	private String I_WERKS = "I_WERKS"; // CS01
	private String I_LGORT = "I_LGORT"; // S10
	private String I_CHARG = "I_CHARG"; //
	private String I_PS_PSP_PNR = "I_PS_PSP_PNR"; // V17E250-P-1-01-75
	private String I_LGNUM = "I_LGNUM"; //
	private String I_LGTYP = "I_LGTYP"; // ZLO
	private String I_LGPLA = "I_LGPLA"; // ACCETT
	private String I_QNT = "I_QNT  "; // 10

	private boolean isGestPartita = false;

	ArrayList<BATCH_list> batch_list = null;

	public RfcCheckBatch(String I_MATNR, String I_WERKS, String I_LGORT, String I_CHARG, String I_PS_PSP_PNR,
			String I_LGNUM, String I_LGTYP, String I_LGPLA, String I_QNT) throws Exception {
		super(ZFMWM_CHECK_BATCH.Name);

		this.I_MATNR = I_MATNR;
		this.I_WERKS = I_WERKS;
		this.I_LGORT = I_LGORT;
		this.I_CHARG = I_CHARG;
		this.I_PS_PSP_PNR = I_PS_PSP_PNR;
		this.I_LGNUM = I_LGNUM;
		this.I_LGTYP = I_LGTYP;
		this.I_LGPLA = I_LGPLA;
		this.I_QNT = I_QNT;
	}

	public void execute() {
		try {
			if (!UtilString.isEmpty(this.I_MATNR))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_MATNR, this.I_MATNR);
			if (!UtilString.isEmpty(this.I_WERKS))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_WERKS, this.I_WERKS);
			if (!UtilString.isEmpty(this.I_LGORT))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_LGORT, this.I_LGORT);
			if (!UtilString.isEmpty(this.I_CHARG))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_CHARG, this.I_CHARG);
			if (!UtilString.isEmpty(this.I_PS_PSP_PNR))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_PS_PSP_PNR, this.I_PS_PSP_PNR);
			if (!UtilString.isEmpty(this.I_LGNUM))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_LGNUM, this.I_LGNUM);
			if (!UtilString.isEmpty(this.I_LGTYP))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_LGTYP, this.I_LGTYP);
			if (!UtilString.isEmpty(this.I_LGPLA))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_LGPLA, this.I_LGPLA);
			if (!UtilString.isEmpty(this.I_QNT))
				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_QNT, this.I_QNT);
//			if(!UtilString.isEmpty(this.I_IS_GEST_PART))
//				function.getImportParameterList().setValue(ZFMWM_CHECK_BATCH.I_IS_GEST_PART, this.I_IS_GEST_PART);
			function.execute(destination);

//			returnTable = function.getExportParameterList().getTable(ZFMWM_CHECK_WBS.RETURN.Name);
//			if (returnTable == null || "S".equalsIgnoreCase(returnTable.getString(SapRfc.Esito)) || "W".equalsIgnoreCase(returnTable.getString(SapRfc.Esito))) {
			setEsitoAndMsg(BAPIRET2_T.Name);
//			}

//			try{
//				returnTable = function.getExportParameterList().getTable(ZFMWM_CHECK_BATCH.RETURN.Name);	
//				returnTable.setRow(0);
//				esito=returnTable.getString(SapRfc.Esito);
//				msg= returnTable.getString(SapRfc.Msg);
//			}catch(Exception e){
//				e.printStackTrace();
//				esito=SapRfc.Error;
//				msg=e.getLocalizedMessage();
//			}
//			
//			setEsito(esito);
//			setMsg(msg);

//			if (isEsitoOK() || isEsitoWarning()) {
			JCoTable batchList = function.getExportParameterList().getTable(TB_BATCH.Name);
			if (batchList != null && !batchList.isEmpty()) {
				batch_list = new ArrayList<BATCH_list>(0);
				for (int i = 0; i < batchList.getNumRows(); i++) {
					batchList.setRow(i);
					BATCH_list batch = new BATCH_list();
					batch.setMATNR(batchList.getString(TB_BATCH.MATNR));
					batch.setCHARG(batchList.getString(TB_BATCH.CHARG));
					batch.setLICHA(batchList.getString(TB_BATCH.LICHA));
					batch.setVFDAT(batchList.getString(TB_BATCH.VFDAT));

					batch_list.add(i, batch);
				}
			}

			isGestPartita = UtilString.isEmpty(
					function.getExportParameterList().getString(ZFMWM_CHECK_BATCH.IS_GEST_PARTITA)) ? false : true;
//			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			disconnectClient();
		}
	}

	public ArrayList<BATCH_list> getBatch_list() {
		return this.batch_list;
	}

	public void setWbs_list(ArrayList<BATCH_list> batch_list) {
		this.batch_list = batch_list;
	}

	public boolean isGestPartita() {
		return isGestPartita;
	}

	public void setGestPartita(boolean isGestPartita) {
		this.isGestPartita = isGestPartita;
	}
}
