package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;


public class RfcMovRicerca101 extends RfcExtend implements Constants, ConstantsSap{
	ArrayList<MovimentazioniBean> movimentazioneList = new ArrayList<MovimentazioniBean>();
	
	private String I_EBELN="I_EBELN";
	private String I_EBELP="I_EBELP";
	
	public RfcMovRicerca101() throws Exception {
		
		super(ZFMWM_GET_ODA.Name);
	}
	
	
	public void execute(){
		try{
			
			function.getImportParameterList().setValue(ZFMWM_GET_ODA.I_EBELP, I_EBELP);
			function.getImportParameterList().setValue(ZFMWM_GET_ODA.I_EBELN, I_EBELN);
				
			function.execute(destination);
			
			//leggo tabella movimentazioni con relativi messaggi
			
			setEsitoAndMsg(ZFMWM_CREA_MOVIMENTAZIONE.RETURN);
			
    		if(isEsitoOK() || isEsitoInfo()){
    			
    			JCoTable movSap = function.getExportParameterList().getTable(ZFMWM_GET_ODA.OT_CREA_MOV);//.getTable("ZWPWM_LISTA_OT");
    			
    			if(movSap!=null){
    				for(int i=0;i < movSap.getNumRows(); i++){
    					movSap.setRow(i);
    					
    					MovimentazioniBean mov = new MovimentazioniBean(movSap);
    					movimentazioneList.add(mov);
    				}
    				
    			}
    		}
		}catch(Exception e){
			e.printStackTrace();
			msg=e.getLocalizedMessage();
			esito="E";
			
		}
		finally{
			disconnectClient();
		}
	}

	public ArrayList<MovimentazioniBean> getMovimentazioneList() {
		return movimentazioneList;
	}


	public void setMovimentazioneList(
			ArrayList<MovimentazioniBean> movimentazioneList) {
		this.movimentazioneList = movimentazioneList;
	}


	public String getI_EBELN() {
		return I_EBELN;
	}


	public void setI_EBELN(String i_EBELN) {
		I_EBELN = i_EBELN;
	}


	public String getI_EBELP() {
		return I_EBELP;
	}


	public void setI_EBELP(String i_EBELP) {
		I_EBELP = i_EBELP;
	}
	
	
	
}
