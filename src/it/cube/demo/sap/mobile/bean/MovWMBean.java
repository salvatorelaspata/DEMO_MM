package it.cube.demo.sap.mobile.bean;

import javax.servlet.http.HttpServletRequest;

import it.cube.demo.sap.mobile.util.UtilString;

public class MovWMBean {
	public boolean checked=false;
	private String
	MATERIAL,//Codice materiale
	PLANT,//Divisione
	BATCH,//Magazzino
	STGE_LOC,//Numero partita
	MOVE_TYPE,//Tipo movimento (gestione stock)
	ENTRY_QNT,//Quantità in unità di misura di acquisizione
	ENTRY_UOM,//Valore matrice
	GRID_VALUE,//Valore Matrice
	VLTYP,//Tipo di magazzino di provenienza
	VLPLA,//Ubicazione di provenienza
	NLTYP,//Tipo di magazzino di destinazione
	NLPLA,//Ubicazione di destinazione
	STGE_LOC_DEST,
	VLBER="VLBER",
	NLBER="NLBER",
	LGNUM="LGNUM";
	public MovWMBean(){};
	/**
	 * Valorizza l'oggetto tramite la request
	 * @param request
	 */
	public MovWMBean(HttpServletRequest request){
		
		MATERIAL=UtilString.removeNull(request.getParameter("MATERIAL")).toUpperCase();//Codice materiale
		PLANT=UtilString.removeNull(request.getParameter("PLANT")).toUpperCase();//Divisione
		BATCH=UtilString.removeNull(request.getParameter("BATCH")).toUpperCase();//Magazzino
		STGE_LOC=UtilString.removeNull(request.getParameter("STGE_LOC")).toUpperCase();//Numero partita
		MOVE_TYPE=UtilString.removeNull(request.getParameter("MOVE_TYPE")).toUpperCase();//Tipo movimento (gestione stock)
		ENTRY_QNT=UtilString.removeNull(request.getParameter("ENTRY_QNT")).toUpperCase();//Quantità in unità di misura di acquisizione
		ENTRY_UOM=UtilString.removeNull(request.getParameter("ENTRY_UOM")).toUpperCase();//Valore matrice
		GRID_VALUE=UtilString.removeNull(request.getParameter("GRID_VALUE")).toUpperCase();//Valore Matrice
		VLTYP=UtilString.removeNull(request.getParameter("VLTYP")).toUpperCase();//Tipo di magazzino di provenienza
		VLPLA=UtilString.removeNull(request.getParameter("VLPLA")).toUpperCase();//Ubicazione di provenienza
		NLTYP=UtilString.removeNull(request.getParameter("NLTYP")).toUpperCase();//Tipo di magazzino di destinazione
		NLPLA=UtilString.removeNull(request.getParameter("NLPLA")).toUpperCase();//Ubicazione di destinazione
		STGE_LOC_DEST=UtilString.removeNull(request.getParameter("STGE_LOC_DEST")).toUpperCase();
		
		VLBER=UtilString.removeNull(request.getParameter("VLBER")).toUpperCase();
		NLBER=UtilString.removeNull(request.getParameter("NLBER")).toUpperCase();
		LGNUM=UtilString.removeNull(request.getParameter("LGNUM")).toUpperCase();
	}
	/**
	 * Imposta di nuovo gli attributi sulla request per un successivo utilizzo
	 * @param request
	 */
	public void updateRequestAttribute(HttpServletRequest request){
		request.setAttribute("MATERIAL",MATERIAL);//Codice materiale
		request.setAttribute("PLANT",PLANT);//Divisione
		request.setAttribute("BATCH",BATCH);//Magazzino
		request.setAttribute("STGE_LOC",STGE_LOC);//Numero partita
		request.setAttribute("MOVE_TYPE",MOVE_TYPE);//Tipo movimento (gestione stock)
		request.setAttribute("ENTRY_QNT",ENTRY_QNT);//Quantità in unità di misura di acquisizione
		request.setAttribute("ENTRY_UOM",ENTRY_UOM);//Valore matrice
		request.setAttribute("GRID_VALUE",GRID_VALUE);//Valore Matrice
		request.setAttribute("VLTYP",VLTYP);//Tipo di magazzino di provenienza
		request.setAttribute("VLPLA",VLPLA);//Ubicazione di provenienza
		request.setAttribute("NLTYP",NLTYP);//Tipo di magazzino di destinazione
		request.setAttribute("NLPLA",NLPLA);//Ubicazione di destinazione
		request.setAttribute("STGE_LOC_DEST",STGE_LOC_DEST);
		request.setAttribute("VLBER",VLBER);
		request.setAttribute("NLBER",NLBER);
		request.setAttribute("LGNUM",LGNUM);
	}
	public String getSTGE_LOC_DEST() {
		return STGE_LOC_DEST;
	}

	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getGRID_VALUE() {
		return GRID_VALUE;
	}
	public void setGRID_VALUE(String gRID_VALUE) {
		GRID_VALUE = gRID_VALUE;
	}
	public String getVLBER() {
		return VLBER;
	}
	public void setVLBER(String vLBER) {
		VLBER = vLBER;
	}
	public String getNLBER() {
		return NLBER;
	}
	public void setNLBER(String nLBER) {
		NLBER = nLBER;
	}
	public String getLGNUM() {
		return LGNUM;
	}
	public void setLGNUM(String lGNUM) {
		LGNUM = lGNUM;
	}
	public void setSTGE_LOC_DEST(String sTGE_LOC_DEST) {
		STGE_LOC_DEST = sTGE_LOC_DEST;
	}

	public String getMATERIAL() {
		return MATERIAL;
	}

	public void setMATERIAL(String mATERIAL) {
		MATERIAL = mATERIAL;
	}

	public String getPLANT() {
		return PLANT;
	}

	public void setPLANT(String pLANT) {
		PLANT = pLANT;
	}

	public String getBATCH() {
		return BATCH;
	}

	public void setBATCH(String bATCH) {
		BATCH = bATCH;
	}

	public String getSTGE_LOC() {
		return STGE_LOC;
	}

	public void setSTGE_LOC(String sTGE_LOC) {
		STGE_LOC = sTGE_LOC;
	}

	public String getMOVE_TYPE() {
		return MOVE_TYPE;
	}

	public void setMOVE_TYPE(String mOVE_TYPE) {
		MOVE_TYPE = mOVE_TYPE;
	}

	public String getENTRY_QNT() {
		return ENTRY_QNT;
	}

	public void setENTRY_QNT(String eNTRY_QNT) {
		ENTRY_QNT = eNTRY_QNT;
	}

	public String getENTRY_UOM() {
		return ENTRY_UOM;
	}

	public void setENTRY_UOM(String eNTRY_UOM) {
		ENTRY_UOM = eNTRY_UOM;
	}

//	public String getGRID_VALUE() {
//		return GRID_VALUE;
//	}
//
//	public void setGRID_VALUE(String gRID_VALUE) {
//		GRID_VALUE = gRID_VALUE;
//	}

	public String getVLTYP() {
		return VLTYP;
	}

	public void setVLTYP(String vLTYP) {
		VLTYP = vLTYP;
	}

	public String getVLPLA() {
		return VLPLA;
	}

	public void setVLPLA(String vLPLA) {
		VLPLA = vLPLA;
	}

	public String getNLTYP() {
		return NLTYP;
	}

	public void setNLTYP(String nLTYP) {
		NLTYP = nLTYP;
	}

	public String getNLPLA() {
		return NLPLA;
	}

	public void setNLPLA(String nLPLA) {
		NLPLA = nLPLA;
	}
	
	
	
}
