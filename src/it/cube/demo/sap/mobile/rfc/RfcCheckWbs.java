package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.WBS_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;
import it.cube.demo.sap.mobile.util.UtilString;

public class RfcCheckWbs extends RfcExtend implements Constants, ConstantsSap{

	ArrayList<WBS_list> wbs_list = null;
	
	private String I_MATNR = null;
	private String I_WERKS = null;
	private String I_LGORT = null; 
	private String I_CHARG = null;
	private String SOBKZ   = null;
	private String I_QNT   = null;
	private String I_WBS   = null;
	private String I_UM    = null;
	private String I_LGNUM = null;
	private String I_LGTYP = null;
	private String I_LGPLA = null;
	
	
	public RfcCheckWbs(
			String I_MATNR, 
			String I_WERKS, 
			String I_LGORT, 
			String I_CHARG, 
			String SOBKZ,
			String I_QNT,
			String I_WBS,
			String I_UM,
			String I_LGNUM,
			String I_LGTYP,
			String I_LGPLA) throws Exception {
		super(ZFMWM_CHECK_WBS.Name);
		
		this.I_MATNR = I_MATNR;
		this.I_WERKS = I_WERKS; 
		this.I_LGORT = I_LGORT;
		this.I_CHARG = I_CHARG;
		this.SOBKZ = SOBKZ;
		this.I_QNT = I_QNT;
		this.I_WBS = I_WBS;
		this.I_UM = I_UM;
		this.I_LGNUM = I_LGNUM;
		this.I_LGTYP = I_LGTYP;
		this.I_LGPLA = I_LGPLA;
		
	}
	
	public ArrayList<WBS_list> getWbs_list() {
		return this.wbs_list;
	}

	public void setWbs_list(ArrayList<WBS_list> wbs_list) {
		this.wbs_list = wbs_list;
	}

	public void execute(){
		try{
			
			//inserisco la struttura movimentazioni
			if(!UtilString.isEmpty(this.I_MATNR))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_MATNR, this.I_MATNR);
			if(!UtilString.isEmpty(this.I_WERKS))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_WERKS, this.I_WERKS);
			if(!UtilString.isEmpty(this.I_LGORT))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_LGORT, this.I_LGORT);
			if(!UtilString.isEmpty(this.I_CHARG))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_CHARG, this.I_CHARG);
			if(!UtilString.isEmpty(this.SOBKZ))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.SOBKZ, this.SOBKZ);
			if(!UtilString.isEmpty(this.I_QNT))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_QNT, this.I_QNT);
			if(!UtilString.isEmpty(this.I_WBS))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_WBS, this.I_WBS);
			if(!UtilString.isEmpty(this.I_UM))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_UM, this.I_UM);

			if(!UtilString.isEmpty(this.I_LGNUM))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_LGNUM, this.I_LGNUM);
			if(!UtilString.isEmpty(this.I_LGTYP))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_LGTYP, this.I_LGTYP);
			if(!UtilString.isEmpty(this.I_LGPLA))
			    function.getImportParameterList().setValue( ZFMWM_CHECK_WBS.I_LGPLA, this.I_LGPLA);
			
			function.execute(destination);
//			returnTable = function.getExportParameterList().getTable(ZFMWM_CHECK_WBS.RETURN.Name);
//			if (returnTable == null) {
				setEsitoAndMsg(ZFMWM_CHECK_WBS.RETURN.Name);				
//			}
			
			function.getTableParameterList();
			
			JCoTable wbss= function.getTableParameterList().getTable(ZFMWM_CHECK_WBS.ZZWM_WBS_LIST.Name);
    		if(!wbss.isEmpty()){

    			
				wbs_list = new ArrayList<WBS_list>(0);
				for (int i = 0; i < wbss.getNumRows(); i++) {
					wbss.setRow(i);
					String ZFLAG = wbss.getString(ZFMWM_CHECK_WBS.ZZWM_WBS_LIST.ZFLAG);
					String POSID = wbss.getString(ZFMWM_CHECK_WBS.ZZWM_WBS_LIST.POSID);
					WBS_list wbs = new WBS_list();
					wbs.setPOSID(POSID);
					wbs.setZFLAG(ZFLAG);
					wbs_list.add(i, wbs);
				}
    		}
    		
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			
		}
		finally{
			disconnectClient();
		}
	}

	public String getI_MATNR() {
		return I_MATNR;
	}

	public void setI_MATNR(String i_MATNR) {
		I_MATNR = i_MATNR;
	}

	public String getI_WERKS() {
		return I_WERKS;
	}

	public void setI_WERKS(String i_WERKS) {
		I_WERKS = i_WERKS;
	}

	public String getI_LGORT() {
		return I_LGORT;
	}

	public void setI_LGORT(String i_LGORT) {
		I_LGORT = i_LGORT;
	}

	public String getI_CHARG() {
		return I_CHARG;
	}

	public void setI_CHARG(String i_CHARG) {
		I_CHARG = i_CHARG;
	}

	public String getSOBKZ() {
		return SOBKZ;
	}

	public void setSOBKZ(String sOBKZ) {
		SOBKZ = sOBKZ;
	}

	public String getI_QNT() {
		return I_QNT;
	}

	public void setI_QNT(String i_QNT) {
		I_QNT = i_QNT;
	}

	public String getI_WBS() {
		return I_WBS;
	}

	public void setI_WBS(String i_WBS) {
		I_WBS = i_WBS;
	}

	public String getI_UM() {
		return I_UM;
	}

	public void setI_UM(String i_UM) {
		I_UM = i_UM;
	}
}
