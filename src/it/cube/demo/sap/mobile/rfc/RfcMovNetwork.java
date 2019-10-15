package it.cube.demo.sap.mobile.rfc;

import java.util.ArrayList;

import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MovNetworkBean;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;


public class RfcMovNetwork extends RfcExtend implements Constants, ConstantsSap{
	MovimentazioniBean movimentazione = new MovimentazioniBean();
	ArrayList<MovNetworkBean> movNetworkList = new ArrayList<MovNetworkBean>();
	
	private String BWART="BWART";
	private String NPLNR="NPLNR";
	private String RSPOS="RSPOS";
	
	public RfcMovNetwork() throws Exception {
		
		super(ZFMWM_GET_MOV_NETWORK.Name);
	}
	
	
	public void execute(){
		try{
			//inserisco la struttura movimentazioni
			JCoStructure movSap = function.getImportParameterList().getStructure(ZFMWM_CREA_MOVIMENTAZIONE.ZSWM_MOVIMENTAZIONI);//.getTable("ZWPWM_LISTA_OT");
			movimentazione.valorizzaStructure(movSap);

			function.execute(destination);
			
			//leggo tabella movimentazioni con relativi messaggi
			
			setEsitoAndMsg(ZFMWM_CREA_MOVIMENTAZIONE.RETURN);
			
    		if(isEsitoOK() || isEsitoInfo()){
    			JCoTable lista= function.getExportParameterList().getTable(ZFMWM_GET_MOV_NETWORK.IT_LISTA_NETWORK);
				if(lista!=null && !lista.isEmpty()){
					int row = lista.getNumRows();
					if(row<0){
						msg="Operazione Fallita.\n";
						esito=SapRfc.Error;
					}else
		    			for(int i=0;i<lista.getNumRows();i++){
		    				lista.setRow(i);
		    				movNetworkList.add(new MovNetworkBean(lista));
		    			}
				}
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


	public MovimentazioniBean getMovimentazione() {
		return movimentazione;
	}


	public void setMovimentazione(MovimentazioniBean movimentazione) {
		this.movimentazione = movimentazione;
	}


	public ArrayList<MovNetworkBean> getMovNetworkList() {
		return movNetworkList;
	}


	public void setMovNetworkList(ArrayList<MovNetworkBean> movNetworkList) {
		this.movNetworkList = movNetworkList;
	}


	public String getBWART() {
		return BWART;
	}


	public void setBWART(String bWART) {
		BWART = bWART;
	}


	public String getNPLNR() {
		return NPLNR;
	}


	public void setNPLNR(String nPLNR) {
		NPLNR = nPLNR;
	}


	public String getRSPOS() {
		return RSPOS;
	}


	public void setRSPOS(String rSPOS) {
		RSPOS = rSPOS;
	}
	
}
