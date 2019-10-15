package it.cube.demo.sap.mobile.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


import com.sap.conn.jco.JCoTable;
import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import it.cube.demo.sap.mobile.constants.ConstantsSap.IT_LISTA_NETWORK;
import it.cube.demo.sap.mobile.util.UtilString;

public class MovNetworkBean implements Serializable{//IT_LISTA_NETWORK
		/**
	 * 
	 */
	private static final long serialVersionUID = -1710954791117014865L;
	public boolean checked=false;
	private String MATNR="MATNR";//	Type	MATNR	CHAR	18	0	Codice materiale
	private String WERKS="MATNWERKSR";//	Type	WERKS_D	CHAR	4	0	Divisione
	private String LGORT="LGORT";//	Type	LGORT_D	CHAR	4	0	Magazzino
	private String CHARG="CHARG";//	Type	CHARG_D	CHAR	10	0	Numero partita
	private String SOBKZ="SOBKZ";//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
	private String BDMNG="BDMNG";//	Type	BDMNG	QUAN	13	3	Quantità fabbisogno
	private String MEINS="MEINS";//	Type	MEINS	UNIT	3	0	Unità di misura di base
	private String FLAG="FLAG";//Type	FLAG	CHAR	1	0	Indicatore generale
	
	public String LGNUM="LGNUM";
	public String LGTYP="LGTYP";
	public String LGPLA="LGPLA";
	public String PSPEL="PSPEL";
	
	public String MAKTX="MAKTX";	//Descrizione Materiale
	public String LICHA="LICHA";	//Lotto
	public String POSID="POSID";	//WBS
	public String IS_GEST_PARTITA="IS_GEST_PARTITA";
	public String RSNUM = "RSNUM";
	public String RSPOS = "RSPOS";
	
	public String EBELN = "EBELN";
	public String EBELP = "EBELP";
		
		
	public MovNetworkBean(MovNetworkBean toClone) {
		super();
		MATNR = toClone.getMATNR();
		WERKS = toClone.getWERKS();
		LGORT = toClone.getLGORT();
		CHARG = toClone.getCHARG();
		SOBKZ = toClone.getSOBKZ();
		BDMNG = toClone.getBDMNG();
		MEINS = toClone.getMEINS();
		FLAG = toClone.getFLAG();
		LGNUM = toClone.getLGNUM();
		LGTYP = toClone.getLGTYP();
		LGPLA = toClone.getLGPLA();
		PSPEL = toClone.getPSPEL();
		MAKTX = toClone.getMAKTX();
		LICHA = toClone.getLICHA();
		POSID = toClone.getPOSID();
		IS_GEST_PARTITA = toClone.getIS_GEST_PARTITA();
		RSNUM = toClone.getRSNUM();
		RSPOS = toClone.getRSPOS();
		EBELN = toClone.getEBELN();
		EBELP = toClone.getEBELP();
	}
	
	public MovNetworkBean(){};
	/**
	 * Valorizza l'oggetto tramite la request
	 * @param request
	 */
	public MovNetworkBean(HttpServletRequest request){
		
		MATNR=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.MATNR)).toUpperCase();
		WERKS=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.WERKS)).toUpperCase();//	Type	WERKS_D	CHAR	4	0	Divisione
		CHARG=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.CHARG)).toUpperCase();//	Type	CHARG_D	CHAR	10	0	Numero partita
		LGORT=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.LGORT)).toUpperCase();//	Type	LGORT_D	CHAR	4	0	Magazzino
		BDMNG=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.BDMNG)).toUpperCase();//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		FLAG=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.FLAG)).toUpperCase();//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		SOBKZ=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.SOBKZ)).toUpperCase();//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		MEINS=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.MEINS)).toUpperCase();//	Type	MEINS	UNIT	3	0	Unità di misura di base
		
		LGNUM=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.LGNUM)).toUpperCase();
		LGTYP=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.LGTYP)).toUpperCase();
		LGPLA=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.LGPLA)).toUpperCase();
		PSPEL=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.PSPEL)).toUpperCase();
		MAKTX=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.MAKTX)).toUpperCase();	//Descrizione Materiale
		LICHA=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.LICHA)).toUpperCase();	//Lotto
		POSID=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.POSID)).toUpperCase();	//WBS
		IS_GEST_PARTITA = UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.IS_GEST_PARTITA)).toUpperCase();
		RSNUM=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.RSNUM)).toUpperCase();
		RSPOS=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.RSPOS)).toUpperCase();
		
		EBELN=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.EBELN)).toUpperCase();
		EBELP=UtilString.removeNull(request.getParameter(IT_LISTA_NETWORK.EBELP)).toUpperCase();
		
	}
	public MovNetworkBean(JCoTable t){
		
		
		MATNR=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.MATNR));
		WERKS=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.WERKS));//	Type	WERKS_D	CHAR	4	0	Divisione
		CHARG=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.CHARG));//	Type	CHARG_D	CHAR	10	0	Numero partita
		LGORT=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.LGORT));//	Type	LGORT_D	CHAR	4	0	Magazzino
		BDMNG=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.BDMNG));//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		FLAG=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.FLAG));//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		SOBKZ=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.SOBKZ));//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		MEINS=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.MEINS));//	Type	MEINS	UNIT	3	0	Unità di misura di base
		
		LGNUM=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.LGNUM));
		LGTYP=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.LGTYP));
		LGPLA=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.LGPLA));
		PSPEL=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.PSPEL));
		MAKTX=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.MAKTX));	//Descrizione Materiale
		LICHA=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.LICHA));	//Lotto
		POSID=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.POSID));	//WBS
		IS_GEST_PARTITA = UtilString.removeNull(t.getString(IT_LISTA_NETWORK.IS_GEST_PARTITA));
		
		RSNUM=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.RSNUM));
		RSPOS=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.RSPOS));
		
		EBELN=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.EBELN));
		EBELP=UtilString.removeNull(t.getString(IT_LISTA_NETWORK.EBELP));
		
	}
	
	public String getMATNR() {
		return MATNR;
	}
	public void setMATNR(String mATNR) {
		MATNR = mATNR;
	}
	public String getWERKS() {
		return WERKS;
	}
	public void setWERKS(String wERKS) {
		WERKS = wERKS;
	}
	public String getLGORT() {
		return LGORT;
	}
	public void setLGORT(String lGORT) {
		LGORT = lGORT;
	}
	public String getCHARG() {
		return CHARG;
	}
	public void setCHARG(String cHARG) {
		CHARG = cHARG;
	}
	public String getSOBKZ() {
		return SOBKZ;
	}
	public void setSOBKZ(String sOBKZ) {
		SOBKZ = sOBKZ;
	}
	public String getBDMNG() {
		return BDMNG;
	}
	public void setBDMNG(String bDMNG) {
		BDMNG = bDMNG;
	}
	public String getMEINS() {
		return MEINS;
	}
	public void setMEINS(String mEINS) {
		MEINS = mEINS;
	}
	public String getFLAG() {
		return FLAG;
	}
	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getLGNUM() {
		return LGNUM;
	}
	public void setLGNUM(String lGNUM) {
		LGNUM = lGNUM;
	}
	public String getLGTYP() {
		return LGTYP;
	}
	public void setLGTYP(String lGTYP) {
		LGTYP = lGTYP;
	}
	public String getLGPLA() {
		return LGPLA;
	}
	public void setLGPLA(String lGPLA) {
		LGPLA = lGPLA;
	}
	public String getPSPEL() {
		return PSPEL;
	}
	public void setPSPEL(String pSPEL) {
		PSPEL = pSPEL;
	}
	public String getMAKTX() {
		return MAKTX;
	}
	public void setMAKTX(String mAKTX) {
		MAKTX = mAKTX;
	}
	public String getLICHA() {
		return LICHA;
	}
	public void setLICHA(String lICHA) {
		LICHA = lICHA;
	}
	public String getPOSID() {
		return POSID;
	}
	public void setPOSID(String pOSID) {
		POSID = pOSID;
	}
	public String getIS_GEST_PARTITA() {
		return IS_GEST_PARTITA;
	}
	public void setIS_GEST_PARTITA(String iS_GEST_PARTITA) {
		IS_GEST_PARTITA = iS_GEST_PARTITA;
	}
	public String getRSNUM() {
		return RSNUM;
	}
	public void setRSNUM(String rSNUM) {
		RSNUM = rSNUM;
	}
	public String getRSPOS() {
		return RSPOS;
	}
	public void setRSPOS(String rSPOS) {
		RSPOS = rSPOS;
	}
	public String getEBELN() {
		return EBELN;
	}
	public void setEBELN(String eBELN) {
		EBELN = eBELN;
	}
	public String getEBELP() {
		return EBELP;
	}
	public void setEBELP(String eBELP) {
		EBELP = eBELP;
	}
	
	
}
