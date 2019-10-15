package it.cube.demo.sap.mobile.bean;

import java.io.Serializable;

public class WBS_list implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8807108174059233324L;
	private String ZFLAG="",POSID="";
	public String getZFLAG() {
		return ZFLAG;
	}
	public void setZFLAG(String zFLAG) {
		ZFLAG = zFLAG;
	}
	public String getPOSID() {
		return POSID;
	}
	public void setPOSID(String pOSID) {
		POSID = pOSID;
	}
	
	
}
