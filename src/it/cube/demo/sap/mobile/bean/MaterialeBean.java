package it.cube.demo.sap.mobile.bean;

public class MaterialeBean {
	public boolean checked=false;
	private String	
	MATNR="MATNR",//codice materiale 18
	WERKS="WERKS",//divisione 4
	LGNUM="LGNUM",//n mag 3
	MAKTX="MAKTX",//testo breve 40
	LGTYP="LGTYP",//tipo 3
	LGPLA="LGPLA",//ubica 10
	VERME="VERME",//qta 20
	GESME="GESME",//qta 20
	AUSME="AUSME",//qta 20
	EINME="EINME",//qta 20
	MEINS="MEINS",//unita di misura 3
	WDATU="WDATU",//data entrata 10
	VFDAT="VFDAT",//data scadenza 10
	CHARG="CHARG",//numero partita 10
	LICHA="LICHA",
	BESTQ="BESTQ",//tipo stock 4
	FLAG_LGPLA="FLAG_LGPLA",//flag ubicazione
	LGORT="LGORT",//magazzino 4
	WENUM = "WENUM",
	SONUM = "SONUM",
	SOBKZ = "SOBKZ",
	LSONR = "LSONR";
	public MaterialeBean(){}
	
	 
	
	public String getLSONR() {
		return LSONR;
	}



	public void setLSONR(String lSONR) {
		LSONR = lSONR;
	}



	public String getWENUM() {
		return WENUM;
	}
	
	
	public String getSONUM() {
		return SONUM;
	}

	public void setSONUM(String sONUM) {
		SONUM = sONUM;
	}

	public String getSOBKZ() {
		return SOBKZ;
	}

	public void setSOBKZ(String sOBKZ) {
		SOBKZ = sOBKZ;
	}

	public void setWENUM(String wENUM) {
		WENUM = wENUM;
	}

	public String getLICHA() {
		return LICHA;
	}
	public void setLICHA(String LICHA) {
		this.LICHA = LICHA;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
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
	public String getLGNUM() {
		return LGNUM;
	}
	public void setLGNUM(String lGNUM) {
		LGNUM = lGNUM;
	}
	public String getMAKTX() {
		return MAKTX;
	}
	public void setMAKTX(String mAKTX) {
		MAKTX = mAKTX;
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
	public String getVERME() {
		return VERME;
	}
	public void setVERME(String vERME) {
		VERME = vERME;
	}
	public String getGESME() {
		return GESME;
	}
	public void setGESME(String gESME) {
		GESME = gESME;
	}
	public String getAUSME() {
		return AUSME;
	}
	public void setAUSME(String aUSME) {
		AUSME = aUSME;
	}
	public String getEINME() {
		return EINME;
	}
	public void setEINME(String eINME) {
		EINME = eINME;
	}
	public String getMEINS() {
		return MEINS;
	}
	public void setMEINS(String mEINS) {
		MEINS = mEINS;
	}
	public String getWDATU() {
		return WDATU;
	}
	public void setWDATU(String wDATU) {
		WDATU = wDATU;
	}
	public String getVFDAT() {
		return VFDAT;
	}
	public void setVFDAT(String vFDAT) {
		VFDAT = vFDAT;
	}
	public String getCHARG() {
		return CHARG;
	}
	public void setCHARG(String cHARG) {
		CHARG = cHARG;
	}
	public String getBESTQ() {
		return BESTQ;
	}
	public void setBESTQ(String bESTQ) {
		BESTQ = bESTQ;
	}
	public String getFLAG_LGPLA() {
		return FLAG_LGPLA;
	}
	public void setFLAG_LGPLA(String fLAG_LGPLA) {
		FLAG_LGPLA = fLAG_LGPLA;
	}
	public String getLGORT() {
		return LGORT;
	}
	public void setLGORT(String lGORT) {
		LGORT = lGORT;
	};
//	/**
//	 * Valorizza l'oggetto tramite la request
//	 * @param request
//	 */
//	public ListaMaterialiBean(HttpServletRequest request){
//		
//		MATNR=UtilString.removeNull(request.getParameter("MATERIAL")).toUpperCase();//Codice materiale
//		WERKS=UtilString.removeNull(request.getParameter("PLANT")).toUpperCase();//Divisione
//		LGNUM=UtilString.removeNull(request.getParameter("BATCH")).toUpperCase();//Magazzino
//		MAKTX=UtilString.removeNull(request.getParameter("STGE_LOC")).toUpperCase();//Numero partita
//		LGTYP=UtilString.removeNull(request.getParameter("MOVE_TYPE")).toUpperCase();//Tipo movimento (gestione stock)
//		LGPLA=UtilString.removeNull(request.getParameter("ENTRY_QNT")).toUpperCase();//Quantità in unità di misura di acquisizione
//		VERME=UtilString.removeNull(request.getParameter("ENTRY_UOM")).toUpperCase();//Valore matrice
//		GRID_VALUE=UtilString.removeNull(request.getParameter("GRID_VALUE")).toUpperCase();//Valore Matrice
//		VLTYP=UtilString.removeNull(request.getParameter("VLTYP")).toUpperCase();//Tipo di magazzino di provenienza
//		VLPLA=UtilString.removeNull(request.getParameter("VLPLA")).toUpperCase();//Ubicazione di provenienza
//		NLTYP=UtilString.removeNull(request.getParameter("NLTYP")).toUpperCase();//Tipo di magazzino di destinazione
//		NLPLA=UtilString.removeNull(request.getParameter("NLPLA")).toUpperCase();//Ubicazione di destinazione
//		STGE_LOC_DEST=UtilString.removeNull(request.getParameter("STGE_LOC_DEST")).toUpperCase();
//		VLTYP=UtilString.removeNull(request.getParameter("VLTYP")).toUpperCase();//Tipo di magazzino di provenienza
//		VLPLA=UtilString.removeNull(request.getParameter("VLPLA")).toUpperCase();//Ubicazione di provenienza
//		NLTYP=UtilString.removeNull(request.getParameter("NLTYP")).toUpperCase();//Tipo di magazzino di destinazione
//		NLPLA=UtilString.removeNull(request.getParameter("NLPLA")).toUpperCase();//Ubicazione di destinazione
//		STGE_LOC_DEST=UtilString.removeNull(request.getParameter("STGE_LOC_DEST")).toUpperCase();
//	}
//	/**
//	 * Imposta di nuovo gli attributi sulla request per un successivo utilizzo
//	 * @param request
//	 */
//	public void updateRequestAttribute(HttpServletRequest request){
//		request.setAttribute("MATERIAL",MATNR);//Codice materiale
//		request.setAttribute("PLANT",WERKS);//Divisione
//		request.setAttribute("BATCH",BATCH);//Magazzino
//		request.setAttribute("STGE_LOC",STGE_LOC);//Numero partita
//		request.setAttribute("MOVE_TYPE",MOVE_TYPE);//Tipo movimento (gestione stock)
//		request.setAttribute("ENTRY_QNT",ENTRY_QNT);//Quantità in unità di misura di acquisizione
//		request.setAttribute("ENTRY_UOM",ENTRY_UOM);//Valore matrice
//		request.setAttribute("GRID_VALUE",GRID_VALUE);//Valore Matrice
//		request.setAttribute("VLTYP",VLTYP);//Tipo di magazzino di provenienza
//		request.setAttribute("VLPLA",VLPLA);//Ubicazione di provenienza
//		request.setAttribute("NLTYP",NLTYP);//Tipo di magazzino di destinazione
//		request.setAttribute("NLPLA",NLPLA);//Ubicazione di destinazione
//		request.setAttribute("STGE_LOC_DEST",STGE_LOC_DEST);
//	}	
	
}
