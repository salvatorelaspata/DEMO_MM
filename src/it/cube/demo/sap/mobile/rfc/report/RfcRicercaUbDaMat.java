package it.cube.demo.sap.mobile.rfc.report;

import java.util.ArrayList;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.MaterialeBean;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;

public class RfcRicercaUbDaMat extends RfcExtend implements ConstantsSap{
	private String I_LGNUM=null,I_LGPLA=null,I_LGTYP=null,I_USER=null,I_WERKS=null,I_LICHA=null;
	private ArrayList<MaterialeBean> listaMat= new ArrayList<MaterialeBean>(0); 
	public RfcRicercaUbDaMat() throws Exception {
		super(ZFMWM_GETLIST_STORAGE.Name);
	}
	
	public void execute() throws JCoException{
		
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_LGNUM, I_LGNUM );
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_LGPLA, I_LGPLA);
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_LGTYP, I_LGTYP);
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_USER, I_USER);
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_WERKS, I_WERKS);
		function.getImportParameterList().setValue(ZFMWM_GETLIST_STORAGE.I_LICHA, I_LICHA);

		function.execute(destination);
//
//		System.err.println("["+this.getClass().getName()+":Exe]OrdProd: "+ordineProd+" ObjId: "+OBJID +" Time: "+new SimpleDateFormat("dd/MM/yyyy - HH:ss:SS").format(new Date()));
		setEsitoAndMsg(ZFMWM_GETLIST_STORAGE.RETURN);	
		JCoTable lista=function.getExportParameterList().getTable(ZFMWM_GETLIST_STORAGE.OT_LISTA);
		if(!esito.equals(SapRfc.Error)){
			if((lista!=null && lista.getNumRows()>0)){
				System.out.println("lista.getNumRows()= "+lista.getNumRows());
				for(int i=0;i<lista.getNumRows();i++){
					MaterialeBean tb =new MaterialeBean();
					lista.setRow(i);
					tb.setAUSME(lista.getString(ST_MATERIALI.AUSME));
					tb.setBESTQ(lista.getString(ST_MATERIALI.BESTQ));
					tb.setCHARG(lista.getString(ST_MATERIALI.CHARG));
					tb.setLICHA(lista.getString(ST_MATERIALI.LICHA));
					tb.setEINME(lista.getString(ST_MATERIALI.EINME));
					tb.setFLAG_LGPLA(lista.getString(ST_MATERIALI.FLAG_LGPLA));
					tb.setGESME(lista.getString(ST_MATERIALI.GESME));
					tb.setLGNUM(lista.getString(ST_MATERIALI.LGNUM));
					tb.setLGORT(lista.getString(ST_MATERIALI.LGORT));
					tb.setLGPLA(lista.getString(ST_MATERIALI.LGPLA));
					tb.setLGTYP(lista.getString(ST_MATERIALI.LGTYP));
					tb.setMAKTX(lista.getString(ST_MATERIALI.MAKTX));
					tb.setMATNR(lista.getString(ST_MATERIALI.MATNR));
					tb.setMEINS(lista.getString(ST_MATERIALI.MEINS));
					tb.setVERME(lista.getString(ST_MATERIALI.VERME));
					tb.setVFDAT(lista.getString(ST_MATERIALI.VFDAT));
					tb.setWDATU(lista.getString(ST_MATERIALI.WDATU));
					tb.setWERKS(lista.getString(ST_MATERIALI.WERKS));
					
					tb.setSOBKZ(lista.getString(ST_MATERIALI.SOBKZ));//AGGIUNTA POST COLLAUDO
					tb.setSONUM(lista.getString(ST_MATERIALI.SONUM));
					tb.setLSONR(lista.getString(ST_MATERIALI.LSONR));
					
					listaMat.add(i,tb);
				}
			}
		}
		disconnectClient();
	}

	public String getI_LICHA() {
		return I_LICHA;
	}

	public void setI_LICHA(String i_LICHA) {
		I_LICHA = i_LICHA;
	}

	public String getI_LGNUM() {
		return I_LGNUM;
	}

	public void setI_LGNUM(String i_LGNUM) {
		I_LGNUM = i_LGNUM;
	}

	public String getI_LGPLA() {
		return I_LGPLA;
	}

	public void setI_LGPLA(String i_LGPLA) {
		I_LGPLA = i_LGPLA;
	}

	public String getI_LGTYP() {
		return I_LGTYP;
	}

	public void setI_LGTYP(String i_LGTYP) {
		I_LGTYP = i_LGTYP;
	}

	public String getI_USER() {
		return I_USER;
	}

	public void setI_USER(String i_USER) {
		I_USER = i_USER;
	}

	public String getI_WERKS() {
		return I_WERKS;
	}

	public void setI_WERKS(String i_WERKS) {
		I_WERKS = i_WERKS;
	}

	public ArrayList<MaterialeBean> getListaMat() {
		return listaMat;
	}

	public void setListaMat(ArrayList<MaterialeBean> listaMat) {
		this.listaMat = listaMat;
	}
	
}
