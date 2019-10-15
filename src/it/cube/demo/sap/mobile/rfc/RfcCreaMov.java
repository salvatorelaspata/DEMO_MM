package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MovWMBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;

public class RfcCreaMov extends RfcExtend implements Constants, ConstantsSap{
	private String	I_CHECK="",tipoMov;
	ArrayList<MovWMBean> listaMov=null;
	public RfcCreaMov(String tipoMov) throws Exception {
		super();
		String rfc="";this.tipoMov=tipoMov;
		if(tipoMov.indexOf(TipoMov.MOV311)!=-1)
			rfc="ZWPWM_CREA_MOV_311";
		else if(tipoMov.indexOf(TipoMov.MOV999)!=-1)
			rfc=ZWPWM_CREAZIONE_OT.Name;
		else if(tipoMov.indexOf(TipoMov.ESTERNI)!=-1)
			rfc="ZWPWM_SBLOCCA_INVIA";
		inizialize(rfc);
	}
	
	public void execute(){
		try{
			if(tipoMov.indexOf(TipoMov.MOV999)==-1 || tipoMov.indexOf(TipoMov.MOV311)==-1)// la 999 non supporta l'accodamento dei movimenti
				function.getImportParameterList().setValue("I_CHECK",I_CHECK);
			JCoTable crea= function.getImportParameterList().getTable(ZWPWM_CREAZIONE_OT.IT_CREA_MOV);
			for(int i=0;i<listaMov.size();i++){
				MovWMBean mov = listaMov.get(i);
				crea.appendRow();
				crea.setRow(i);
				crea.setValue(TB_MOV.MATERIAL,mov.getMATERIAL());
				crea.setValue(TB_MOV.PLANT,mov.getPLANT());
				crea.setValue(TB_MOV.BATCH,mov.getBATCH());
				crea.setValue(TB_MOV.STGE_LOC,mov.getSTGE_LOC());
				crea.setValue(TB_MOV.MOVE_TYPE,mov.getMOVE_TYPE());
				crea.setValue(TB_MOV.ENTRY_QNT,mov.getENTRY_QNT());
				crea.setValue(TB_MOV.ENTRY_UOM,mov.getENTRY_UOM());
				crea.setValue(TB_MOV.NLPLA,mov.getNLPLA());
				crea.setValue(TB_MOV.NLTYP,mov.getNLTYP());
				//crea.setValue(mov.getGRID_VALUE(),TB_MOV.GRID_VALUE,);
				crea.setValue(TB_MOV.VLPLA,mov.getVLPLA());
				crea.setValue(TB_MOV.VLTYP,mov.getVLTYP());		
				crea.setValue(TB_MOV.VLBER,mov.getVLBER());	
				crea.setValue(TB_MOV.NLBER,mov.getNLBER());	
				crea.setValue(TB_MOV.LGNUM,mov.getLGNUM());	
			}
			function.execute(destination);
			setEsitoAndMsg(ZWPWM_CREAZIONE_OT.RETURN);		
			int e=0;
			//int s=0;
			int i = 0;
//			msg="<table width='100%' class='ulList'>";
			for(i = 0;i<returnTable.getNumRows();i++){
//				msg+="<tr class='inlineBlock'>";
				returnTable.setRow(i);
				esito=returnTable.getString(SapRfc.Esito);
//				msg+="<td width='5%'>&nbsp;"+(i+1)+")</td>";
//				msg+="<td class='errorList'>"+returnTable.getString(SapRfc.Msg)+"</td>";
//				msg+="</tr>";
				if(!isEsitoOK())
			/*		s++;
				else*/
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
