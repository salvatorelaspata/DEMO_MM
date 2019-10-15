package it.cube.demo.sap.mobile.rfc.OT;

import java.util.ArrayList;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.ConfermaOTBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;
import it.cube.demo.sap.mobile.util.UtilString;

public class RfcRicercaOT extends RfcExtend implements Constants, ConstantsSap{
	private String I_TANUM;
	private String I_DATA;
	private String I_BWART;
	private String I_LGNUM;
	private String I_MATNR;
	private String I_VLTYP;
	private String I_VLBER;
	private String I_VLPLA;
	private String I_NLTYP;
	private String I_NLBER;
	private String I_NLPLA;
	private String I_CHARG;
	private String LICHA;
	//private String I_J_3ASIZE;
	ArrayList<ConfermaOTBean> trasOT=new ArrayList<ConfermaOTBean>();
	//private ArrayList<String> f_utente =new ArrayList<String>(0); //new boolean[FUNCTION_MENU];
	public RfcRicercaOT() throws Exception {
		super(ZWPWM_RICERCA_OT.Name);
	}
	
	public void execute(){
		try{
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_TANUM, UtilString.removeNull(I_TANUM).toUpperCase());//Numero ordine di trasferimento
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_DATA, UtilString.removeNull(I_DATA).toUpperCase());//Data
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_BWART, UtilString.removeNull(I_BWART).toUpperCase());//Tipo movimento (gestione stock)
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_LGNUM, UtilString.removeNull(I_LGNUM).toUpperCase());//N. mag./complesso di magazzini
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_MATNR, UtilString.removeNull(I_MATNR).toUpperCase());//Codice materiale
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_VLTYP, UtilString.removeNull(I_VLTYP).toUpperCase());//Tipo di magazzino di provenienza
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_VLBER, UtilString.removeNull(I_VLBER).toUpperCase());//Area magazzino di provenienza
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_VLPLA, UtilString.removeNull(I_VLPLA).toUpperCase());//Ubicazione di provenienza
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_NLTYP, UtilString.removeNull(I_NLTYP).toUpperCase());//Tipo di magazzino di destinazione
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_NLBER, UtilString.removeNull(I_NLBER).toUpperCase());//Area magazzino di destinazione
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_NLPLA, UtilString.removeNull(I_NLPLA).toUpperCase());//Ubicazione di destinazione
			function.getImportParameterList().setValue(ZWPWM_RICERCA_OT.I_CHARG, UtilString.removeNull(I_CHARG).toUpperCase());//Partita
//			function.getImportParameterList().setValue(UtilString.removeNull(LICHA).toUpperCase(), "LICHA");//lotto
			function.execute(destination);
			setEsitoAndMsg(ZWPWM_RICERCA_OT.RETURN);
			if(isEsitoOK() || isEsitoInfo()){
    			JCoTable list = function.getExportParameterList().getTable(ZWPWM_RICERCA_OT.TB_OT);//.getTable("ZWPWM_LISTA_OT");
    			for(int i=0;i<list.getNumRows();i++){
    				ConfermaOTBean t= new ConfermaOTBean();
    				list.setRow(i);
    				t.setALTME(list.getString(TB_OT.ALTME));
    				t.setBNAME(list.getString(TB_OT.BNAME));
    				t.setLGNUM(list.getString(TB_OT.LGNUM));
    				t.setMAKTX(list.getString(TB_OT.MAKTX));
    				t.setMATNR(list.getString(TB_OT.MATNR));
    				t.setNISTA(list.getString(TB_OT.NISTA));
    				t.setNLBER(list.getString(TB_OT.NLBER));
    				t.setNLPLA(list.getString(TB_OT.NLPLA));
    				t.setNLTYP(list.getString(TB_OT.NLTYP));
    				t.setNSOLA(list.getString(TB_OT.NSOLA));
    				t.setTANUM(list.getString(TB_OT.TANUM));
    				t.setTAPOS(list.getString(TB_OT.TAPOS));
    				t.setVLBER(list.getString(TB_OT.VLBER));
    				t.setVLPLA(list.getString(TB_OT.VLPLA));
    				t.setVLTYP(list.getString(TB_OT.VLTYP));
    				t.setVSOLA(list.getString(TB_OT.VSOLA));
    				t.setBWART(list.getString(TB_OT.BWART));
    				t.setCHARG(list.getString(TB_OT.CHARG));
    				t.setSOBKZ(list.getString(TB_OT.SOBKZ));
    				t.setLSONR(list.getString(TB_OT.LSONR));
//    				t.setLICHA(list.getString(TB_OT.LICHA));
    				trasOT.add(i,t);
    			}
    			
    			
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


	

	public String getLICHA() {
		return LICHA;
	}

	public void setLICHA(String LICHA) {
		this.LICHA = LICHA;
	}

	public String getI_TANUM() {
		return I_TANUM;
	}

	public void setI_TANUM(String i_TANUM) {
		I_TANUM = i_TANUM;
	}

	public String getI_DATA() {
		return I_DATA;
	}

	public void setI_DATA(String i_DATA) {
		I_DATA = i_DATA;
	}

	public String getI_BWART() {
		return I_BWART;
	}

	public void setI_BWART(String i_BWART) {
		I_BWART = i_BWART;
	}

	public String getI_LGNUM() {
		return I_LGNUM;
	}

	public void setI_LGNUM(String i_LGNUM) {
		I_LGNUM = i_LGNUM;
	}

	public String getI_MATNR() {
		return I_MATNR;
	}

	public void setI_MATNR(String i_MATNR) {
		I_MATNR = i_MATNR;
	}

	public String getI_VLTYP() {
		return I_VLTYP;
	}

	public void setI_VLTYP(String i_VLTYP) {
		I_VLTYP = i_VLTYP;
	}

	public String getI_VLBER() {
		return I_VLBER;
	}

	public void setI_VLBER(String i_VLBER) {
		I_VLBER = i_VLBER;
	}

	public String getI_VLPLA() {
		return I_VLPLA;
	}

	public void setI_VLPLA(String i_VLPLA) {
		I_VLPLA = i_VLPLA;
	}

	public String getI_NLTYP() {
		return I_NLTYP;
	}

	public void setI_NLTYP(String i_NLTYP) {
		I_NLTYP = i_NLTYP;
	}

	public String getI_NLBER() {
		return I_NLBER;
	}

	public void setI_NLBER(String i_NLBER) {
		I_NLBER = i_NLBER;
	}

	public String getI_NLPLA() {
		return I_NLPLA;
	}

	public void setI_NLPLA(String i_NLPLA) {
		I_NLPLA = i_NLPLA;
	}

	public String getI_CHARG() {
		return I_CHARG;
	}

	public void setI_CHARG(String i_CHARG) {
		I_CHARG = i_CHARG;
	}

	public ArrayList<ConfermaOTBean> getTrasOT() {
		return trasOT;
	}

	public void setTrasOT(ArrayList<ConfermaOTBean> trasOT) {
		this.trasOT = trasOT;
	}

	
	
}
