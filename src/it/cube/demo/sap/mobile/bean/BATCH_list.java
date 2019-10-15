package it.cube.demo.sap.mobile.bean;

import java.io.Serializable;

public class BATCH_list implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String MATNR = "";
	private String CHARG = "";
	private String LICHA = "";
	private String VFDAT = "";
	
	public String getMATNR() {
		return MATNR;
	}
	public void setMATNR(String mATNR) {
		MATNR = mATNR;
	}
	public String getCHARG() {
		return CHARG;
	}
	public void setCHARG(String cHARG) {
		CHARG = cHARG;
	}
	public String getLICHA() {
		return LICHA;
	}
	public void setLICHA(String lICHA) {
		LICHA = lICHA;
	}
	public String getVFDAT() {
		return VFDAT;
	}
	public void setVFDAT(String vFDAT) {
		VFDAT = vFDAT;
	}
}
