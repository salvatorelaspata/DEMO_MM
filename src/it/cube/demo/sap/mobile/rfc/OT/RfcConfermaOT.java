package it.cube.demo.sap.mobile.rfc.OT;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.ConfermaOTBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;

public class RfcConfermaOT extends RfcExtend implements Constants, ConstantsSap{
	ArrayList<ConfermaOTBean> trasOT=new ArrayList<ConfermaOTBean>();
	Integer row=-2;
	int sup=0;
	boolean tutti=false;
	ArrayList<Integer> listcheck = new ArrayList<Integer>();
	//private ArrayList<String> f_utente =new ArrayList<String>(0); //new boolean[FUNCTION_MENU];
	public RfcConfermaOT() throws Exception {
		super(ZWPWM_CONFERMA_OT.Name);
	}
	//*******
	public void execute(){
		try{
			JCoTable lista= function.getImportParameterList().getTable(ZWPWM_CONFERMA_OT.IN_TB_OT);
			if(row>=0){		//singolo elemento row=n solo riga n viene confoermata		
					popolaListaTB(lista,row,0);				
			}else{// if(row==-2&&listcheck!=null && !listcheck.isEmpty()){
				for(int i=0;i<trasOT.size();i++){
					popolaListaTB(lista,i,i);				
				}
			}/*else{	
				for(int i=0;i<trasOT.size();i++)
					popolaListaTB(lista,i,i);				
			}*/	
			function.execute(destination);
			setEsitoAndMsg(ZWPWM_CONFERMA_OT.RETURN);	
			lista=function.getExportParameterList().getTable(ZWPWM_CONFERMA_OT.OUT_TB_OT);
			if(lista!=null && !lista.isEmpty()){
				if(row<0){
					msg="Operazione Fallita.\nDi seguito lista OT in errore";
					esito=SapRfc.Info;
				}
				trasOT=new ArrayList<ConfermaOTBean>(0);
    			for(int i=0;i<lista.getNumRows();i++){
    				ConfermaOTBean t= new ConfermaOTBean();
    				lista.setRow(i);
    				t.setALTME(lista.getString("ALTME"));
    				t.setBNAME(lista.getString("BNAME"));
    				t.setLGNUM(lista.getString("LGNUM"));
    				t.setMAKTX(lista.getString("MAKTX"));
    				t.setMATNR(lista.getString("MATNR"));
    				t.setNISTA(lista.getString("NISTA"));
    				t.setNLBER(lista.getString("NLBER"));
    				t.setNLPLA(lista.getString("NLPLA"));
    				t.setNLTYP(lista.getString("NLTYP"));
    				t.setNSOLA(lista.getString("NSOLA"));
    				t.setTANUM(lista.getString("TANUM"));
    				t.setTAPOS(lista.getString("TAPOS"));
    				t.setVLBER(lista.getString("VLBER"));
    				t.setVLPLA(lista.getString("VLPLA"));
    				t.setVLTYP(lista.getString("VLTYP"));
    				t.setVSOLA(lista.getString("VSOLA"));
    				t.setBWART(lista.getString("BWART"));
    				t.setCHARG(lista.getString("CHARG"));
//    				t.setLICHA(lista.getString("LICHA"));
    				t.setJ_3ASIZE(lista.getString("J_3ASIZE"));
    				trasOT.add(i,t);
    			}    			
    			
			}else{
				trasOT.clear();
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		finally{
			disconnectClient();
		}
	}
	
	private void popolaListaTB(JCoTable lista,Integer i,Integer l){
		lista.appendRow();
		lista.setRow(l);
		
		ConfermaOTBean t = trasOT.get(i);
		if(tutti || row>=0){
			t.setCONFERMA("X");
			
		}
		if("X".equalsIgnoreCase(t.getCONFERMA()))
				sup++;
		lista.setValue(TB_OT.CONFERMA, t.getCONFERMA());
		lista.setValue(TB_OT.ALTME, t.getALTME());
		lista.setValue(TB_OT.BNAME, t.getBNAME());
		lista.setValue(TB_OT.LGNUM, t.getLGNUM());
		lista.setValue(TB_OT.MAKTX, t.getMAKTX());
		lista.setValue(TB_OT.MATNR, t.getMATNR());
		lista.setValue(TB_OT.NISTA, t.getNISTA());
		lista.setValue(TB_OT.NLBER, t.getNLBER());
		lista.setValue(TB_OT.NLPLA, t.getNLPLA());
		lista.setValue(TB_OT.NLTYP, t.getNLTYP());
		lista.setValue(TB_OT.NSOLA, t.getNSOLA());
		lista.setValue(TB_OT.TANUM, t.getTANUM());
		lista.setValue(TB_OT.TAPOS, t.getTAPOS());
		lista.setValue(TB_OT.VLBER, t.getVLBER());
		lista.setValue(TB_OT.VLPLA, t.getVLPLA());
		lista.setValue(TB_OT.VLTYP, t.getVLTYP());
		lista.setValue(TB_OT.VSOLA, t.getVSOLA());
		lista.setValue(TB_OT.BWART, t.getBWART());
//		lista.setValue(TB_OT.LICHA, t.getLICHA());
		lista.setValue(TB_OT.CHARG, t.getCHARG());
	}
	
	
	public ArrayList<Integer> getListcheck() {
		return listcheck;
	}

	public void setListcheck(ArrayList<Integer> listcheck) {
		this.listcheck = listcheck;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public ArrayList<ConfermaOTBean> getTrasOT() {
		return trasOT;
	}

	public void setTrasOT(ArrayList<ConfermaOTBean> trasOT) {
		this.trasOT = trasOT;
	}

	public boolean isTutti() {
		return tutti;
	}

	public void setTutti(boolean tutti) {
		this.tutti = tutti;
	}

	
	
}
