package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MovNetworkBean;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.bean.WBS_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;



public class RfcMovimentazioni extends RfcExtend implements Constants, ConstantsSap{
	MovimentazioniBean movimentazione = new MovimentazioniBean();
	private String I_CHECK="I_CHECK";
	private String I_MAT_DOC="I_MAT_DOC";
	private String I_DOC_YEAR="I_DOC_YEAR";
	private String I_USERID = "I_USERID";
	private ArrayList<MovNetworkBean> movNetworkList = new ArrayList<MovNetworkBean>();
	
	private ArrayList<WBS_list> wbs_list = new ArrayList<WBS_list>();;
	
	public RfcMovimentazioni() throws Exception {
		super(ZFMWM_CREA_MOVIMENTAZIONE.Name);
	}
	
	public void execute(){
		try{
			function.getImportParameterList().setValue(ZFMWM_CREA_MOVIMENTAZIONE.I_CHECK,I_CHECK);
			function.getImportParameterList().setValue(ZFMWM_CREA_MOVIMENTAZIONE.I_USERID,I_USERID);
			JCoStructure movSap = function.getImportParameterList().getStructure(ZFMWM_CREA_MOVIMENTAZIONE.ZSWM_MOVIMENTAZIONI);//.getTable("ZWPWM_LISTA_OT");
			movimentazione.valorizzaStructure(movSap);
			
			if(movNetworkList!=null && movNetworkList.size()>0)
				valorizzaNetWorkTableFromList();
			
			function.execute(destination);
			
			JCoTable tb_wbs = function.getTableParameterList().getTable(ZFMWM_CREA_MOVIMENTAZIONE.TB_WBS.Name);
			if (!tb_wbs.isEmpty()) {
				setWbsList(tb_wbs);
			}
			setEsitoAndMsg(ZFMWM_CREA_MOVIMENTAZIONE.RETURN);
    		if(isEsitoOK() || isEsitoInfo()){
    			I_MAT_DOC= function.getExportParameterList().getString(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC);
    			I_DOC_YEAR = function.getExportParameterList().getString(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR);
			}	
		}catch(Exception e){
			e.printStackTrace();
			if(e.getMessage().indexOf("DATE at field VFDAT")>-1){
				msg="Inserire una data corretta";
			}else{
				msg=e.getLocalizedMessage();
			}
			esito="E";
			
		}
		finally{
			disconnectClient();
		}
	}
	private void setWbsList(JCoTable tb_wbs) {
		if(tb_wbs!=null && tb_wbs.getNumRows()>0 ){
			for(int i=0; i<tb_wbs.getNumRows();i++){
				tb_wbs.setRow(i);
				WBS_list wbsBean = new WBS_list();
				wbsBean.setZFLAG(tb_wbs.getString(ZFMWM_CREA_MOVIMENTAZIONE.TB_WBS.ZFLAG));
				wbsBean.setPOSID(tb_wbs.getString(ZFMWM_CREA_MOVIMENTAZIONE.TB_WBS.POSID));
				wbs_list.add(wbsBean);
			}
		}
	}

	private void valorizzaNetWorkTableFromList(){
		JCoTable t = function.getImportParameterList().getTable(ZFMWM_CREA_MOVIMENTAZIONE.IT_LISTA_NETWORK);
		
		if(t!=null && movNetworkList !=null &&!movNetworkList.isEmpty()){
			t.clear();
			for(int i=0;i<movNetworkList.size();i++){
				MovNetworkBean mov = movNetworkList.get(i);	
				t.appendRow();
				t.setValue(IT_LISTA_NETWORK.BDMNG, mov.getBDMNG());
				t.setValue(IT_LISTA_NETWORK.CHARG, mov.getCHARG());
				t.setValue(IT_LISTA_NETWORK.FLAG, mov.getFLAG());
				t.setValue(IT_LISTA_NETWORK.LGORT, mov.getLGORT());
				t.setValue(IT_LISTA_NETWORK.MATNR, mov.getMATNR());
				t.setValue(IT_LISTA_NETWORK.MEINS, mov.getMEINS());
				t.setValue(IT_LISTA_NETWORK.SOBKZ, mov.getSOBKZ());
				t.setValue(IT_LISTA_NETWORK.WERKS, mov.getWERKS());
				
				t.setValue(IT_LISTA_NETWORK.LGNUM, mov.getLGNUM());
				t.setValue(IT_LISTA_NETWORK.LGTYP, mov.getLGTYP());
				t.setValue(IT_LISTA_NETWORK.LGPLA, mov.getLGPLA());
				t.setValue(IT_LISTA_NETWORK.PSPEL, mov.getPSPEL());
				
			}
			
		}
		
	}

	
	
	public String getI_USERID() {
		return I_USERID;
	}

	public void setI_USERID(String i_USERID) {
		I_USERID = i_USERID;
	}

	public ArrayList<MovNetworkBean> getMovNetworkList() {
		return movNetworkList;
	}

	public void setMovNetworkList(ArrayList<MovNetworkBean> movNetworkList) {
		this.movNetworkList = movNetworkList;
	}

	public MovimentazioniBean getMovimentazione() {
		return movimentazione;
	}

	public void setMovimentazione(MovimentazioniBean movimentazione) {
		this.movimentazione = movimentazione;
	}

	public String getI_CHECK() {
		return I_CHECK;
	}

	public void setI_CHECK(String i_CHECK) {
		I_CHECK = i_CHECK;
	}

	public String getI_MAT_DOC() {
		return I_MAT_DOC;
	}

	public void setI_MAT_DOC(String i_MAT_DOC) {
		I_MAT_DOC = i_MAT_DOC;
	}

	public String getI_DOC_YEAR() {
		return I_DOC_YEAR;
	}

	public void setI_DOC_YEAR(String i_DOC_YEAR) {
		I_DOC_YEAR = i_DOC_YEAR;
	}

	public ArrayList<WBS_list> getWbs_list() {
		return wbs_list;
	}

	public void setWbs_list(ArrayList<WBS_list> wbs_list) {
		this.wbs_list = wbs_list;
	}
	
}
