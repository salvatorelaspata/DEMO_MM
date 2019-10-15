package it.cube.demo.sap.mobile.rfc.OT;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MovWMBean;
import it.cube.demo.sap.mobile.bean.WBS_list;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.constants.Constants.TipoMov;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;

public class RfcCreaOT extends RfcExtend implements Constants, ConstantsSap{
	private String I_CHECK="";
	ArrayList<MovWMBean> listaMov=null;
	ArrayList<WBS_list> wbs_list=null;

	public ArrayList<WBS_list> getWbs_list() {
		return wbs_list;
	}

	public void setWbs_list(ArrayList<WBS_list> wbs_list) {
		this.wbs_list = wbs_list;
	}

	public RfcCreaOT(String tipoMov) throws Exception {
		super();
		inizialize(ZWPWM_CREAZIONE_OT.Name);
	}
	
	public void execute(){
		try{
//			if(tipoMov.indexOf(TipoMov.MOV999)==-1)// la 999 non supporta l'accodamento dei movimenti
//				function.getImportParameterList().setValue(I_CHECK, "I_CHECK");
			JCoTable crea= function.getImportParameterList().getTable(ZWPWM_CREAZIONE_OT.IT_CREA_MOV);
			if (wbs_list != null && wbs_list.size() > 0) {
				JCoTable wbsi= function.getTableParameterList().getTable("WBS_LIST");
				for(int i=0;i<wbs_list.size();i++){
					WBS_list wbs = wbs_list.get(i);
					wbsi.appendRow();
					wbsi.setRow(i);
					wbsi.setValue("POSID", wbs.getPOSID());
					wbsi.setValue("ZFLAG", wbs.getZFLAG());
				}
			}
			for(int i=0;i<listaMov.size();i++){
				MovWMBean mov = listaMov.get(i);
				crea.appendRow();
				crea.setRow(i);
				crea.setValue(TB_MOV.MATERIAL, mov.getMATERIAL());
				crea.setValue(TB_MOV.PLANT, mov.getPLANT());
				crea.setValue(TB_MOV.BATCH, mov.getBATCH());
				crea.setValue(TB_MOV.STGE_LOC, mov.getSTGE_LOC());
				crea.setValue(TB_MOV.MOVE_TYPE, mov.getMOVE_TYPE());
				crea.setValue(TB_MOV.ENTRY_QNT, mov.getENTRY_QNT());
				crea.setValue(TB_MOV.ENTRY_UOM, mov.getENTRY_UOM());
				crea.setValue(TB_MOV.NLPLA, mov.getNLPLA());
				crea.setValue(TB_MOV.NLTYP, mov.getNLTYP());
//				crea.setValue(TB_MOV.MATERIAL, mov.getGRID_VALUE()GRID_VALUE);
				crea.setValue(TB_MOV.VLPLA, mov.getVLPLA());
				crea.setValue(TB_MOV.VLTYP, mov.getVLTYP());			
				crea.setValue(TB_MOV.STGE_LOC_DEST, mov.getSTGE_LOC_DEST());	
				crea.setValue(TB_MOV.VLBER, mov.getVLBER());	
				crea.setValue(TB_MOV.NLBER, mov.getNLBER());	
				crea.setValue(TB_MOV.LGNUM, mov.getLGNUM());	
			}
			function.execute(destination);
			setEsitoAndMsg(ZWPWM_CREAZIONE_OT.RETURN);		

			if("I".equals(esito)) {
				JCoTable wbss= function.getTableParameterList().getTable("WBS_LIST");
				wbs_list = new ArrayList<WBS_list>(0);
				for (int i = 0; i < wbss.getNumRows(); i++) {
					wbss.setRow(i);
					String ZFLAG = wbss.getString("ZFLAG");
					String POSID = wbss.getString("POSID");
					WBS_list wbs = new WBS_list();
					wbs.setPOSID(POSID);
					wbs.setZFLAG(ZFLAG);
					wbs_list.add(i, wbs);
				}
			}
			
			int e=0;
			int i = 0;
//			msg="<table width='100%' class='ulList'>";
			for(i = 0;i<returnTable.getNumRows();i++){
//				msg+="<tr class='inlineBlock'>";
				returnTable.setRow(i);
				esito=returnTable.getString(SapRfc.Esito);
//				msg+="<td width='5%'>&nbsp;"+(i+1)+")</td>";
//				msg+="<td class='errorList'>"+returnTable.getString(SapRfc.Msg)+"</td>";
//				msg+="</tr>";
				if(isEsitoOK()) {
				} else
					e++;
			}
//			msg+="</table>";
			if(i>0 && e>0 && i>e){
				msg="Operazione completata parzialmente";
			}
		}catch(Exception e){
			e.printStackTrace();
			esito="E";
			msg=e.getLocalizedMessage();
		}
		finally{
			disconnectClient();
		}
	}

	public String getI_CHECK() {
		return I_CHECK;
	}

	public void setI_CHECK(String I_CHECK) {
		this.I_CHECK = I_CHECK;
	}

	public ArrayList<MovWMBean> getListaMov() {
		return listaMov;
	}

	public void setListaMov(ArrayList<MovWMBean> listaMov) {
		this.listaMov = listaMov;
	}


}
