package it.cube.demo.sap.mobile.bean;

import javax.servlet.http.HttpServletRequest;

import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.util.UtilString;

public class MovimentazioniBean {//ZSWM_MOVIMENTAZIONI

		private String MATNR="MATNR";//	Type	MATNR	CHAR	18	0	Codice materiale
		private String WERKS="WERKS";//	Type	WERKS_D	CHAR	4	0	Divisione
		private String CHARG="CHARG";//	Type	CHARG_D	CHAR	10	0	Numero partita
		private String LGORT="LGORT";//	Type	LGORT_D	CHAR	4	0	Magazzino
		private String BWART="BWART";//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		private String LGNUM="LGNUM";//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		private String SOBKZ="SOBKZ";//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		private String LIFNR="LIFNR";//	Type	LIFNR	CHAR	10	0	Numero conto del fornitore
		private String EBELN="EBELN";//	Type	EBELN	CHAR	10	0	Numero del documento acquisti
		private String EBELP="EBELP";//	Type	EBELP	NUMC	5	0	Numero posizione documento d'acquisto
		private String LFBJA="LFBJA";//	Type	LFBJA	NUMC	4	0	Esercizio di un documento di riferimento
		private String LFBNR="LFBNR";//	Type	LFBNR	CHAR	10	0	Numero di un documento di riferimento
		private String LFPOS="LFPOS";//	Type	LFPOS	NUMC	4	0	Posizione di un documento di riferimento
		private String WEMPF="WEMPF";//	Type	WEMPF	CHAR	12	0	Destinatario merci
		private String KOSTL="KOSTL";//	Type	KOSTL	CHAR	10	0	Centro di costo
		private String AUFNR="AUFNR";//	Type	AUFNR	CHAR	12	0	Numero ordine
		private String GJAHR="GJAHR";//	Type	GJAHR	NUMC	4	0	Esercizio
		private String BUKRS="BUKRS";//	Type	BUKRS	CHAR	4	0	Società
		private String RSNUM="RSNUM";//	Type	RSNUM	NUMC	10	0	Numero dell'impegno / del fabbisogno dipendente
		private String RSPOS="RSPOS";//	Type	RSPOS	NUMC	4	0	Numero posizione dell'impegno / del fabbisogno dipendente
		private String KZBEW="KZBEW";//	Type	KZBEW	CHAR	1	0	Codice movimento
		private String KZVBR="KZVBR";//	Type	KZVBR	CHAR	1	0	Registrazione consumo
		private String LGTYP="LGTYP";//	Type	LGTYP	CHAR	3	0	Tipo magazzino
		private String LGPLA="LGPLA";//	Type	LGPLA	CHAR	10	0	Ubicazione
		private String TBNUM="TBNUM";//	Type	TBNUM	NUMC	10	0	Numero fabbisogno di trasporto
		private String TBPOS="TBPOS";//	Type	TBPOS	NUMC	4	0	Posizione fabbisogno di trasporto
		private String PS_PSP_PNR="PS_PSP_PNR";//	Type	PS_POSID	CHAR	24	0	Elemento della Work Breakdown Structure (elemento WBS)
		private String NPLNR="NPLNR";//	Type	NPLNR	CHAR	12	0	Numero network per contabilizzazione
		private String ZUSTD_T156M="ZUSTD_T156M";//	Type	BAMOK_MSEG	CHAR	1	0	Modifica tipo stock (lettura della tabella T156M)
		private String MENGE="MENGE";//	Type	MENGE_D	QUAN	13	3	Quantità
		private String MEINS="MEINS";//	Type	MEINS	UNIT	3	0	Unità di misura di base
		private String VFDAT="VFDAT";//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		private String DATA_DOC="DATA_DOC";
		
		public String XBLNR="XBLNR";
		public String LICHA="LICHA";
		public String NOTE="NOTE";
		
		public String POSID = "POSID";

	public MovimentazioniBean(){};
	/**
	 * Valorizza l'oggetto tramite la request
	 * @param request
	 */
	public MovimentazioniBean(HttpServletRequest request){
		
		MATNR =UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.MATNR)).toUpperCase();
		WERKS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.WERKS)).toUpperCase();//	Type	WERKS_D	CHAR	4	0	Divisione
		CHARG=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.CHARG)).toUpperCase();//	Type	CHARG_D	CHAR	10	0	Numero partita
		LGORT=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGORT)).toUpperCase();//	Type	LGORT_D	CHAR	4	0	Magazzino
		BWART=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.BWART)).toUpperCase();//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		LGNUM=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGNUM)).toUpperCase();//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		SOBKZ=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.SOBKZ)).toUpperCase();//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		LIFNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LIFNR)).toUpperCase();//	Type	LIFNR	CHAR	10	0	Numero conto del fornitore
		EBELN=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.EBELN)).toUpperCase();//	Type	EBELN	CHAR	10	0	Numero del documento acquisti
		EBELP=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.EBELP)).toUpperCase();//	Type	EBELP	NUMC	5	0	Numero posizione documento d'acquisto
		LFBJA=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LFBJA)).toUpperCase();//	Type	LFBJA	NUMC	4	0	Esercizio di un documento di riferimento
		LFBNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LFBNR)).toUpperCase();//	Type	LFBNR	CHAR	10	0	Numero di un documento di riferimento
		LFPOS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LFPOS)).toUpperCase();//	Type	LFPOS	NUMC	4	0	Posizione di un documento di riferimento
		WEMPF=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.WEMPF)).toUpperCase();//	Type	WEMPF	CHAR	12	0	Destinatario merci
		KOSTL=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.KOSTL)).toUpperCase();//	Type	KOSTL	CHAR	10	0	Centro di costo
		AUFNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.AUFNR)).toUpperCase();//	Type	AUFNR	CHAR	12	0	Numero ordine
		GJAHR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.GJAHR)).toUpperCase();//	Type	GJAHR	NUMC	4	0	Esercizio
		BUKRS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.BUKRS)).toUpperCase();//	Type	BUKRS	CHAR	4	0	Società
		RSNUM=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.RSNUM)).toUpperCase();//	Type	RSNUM	NUMC	10	0	Numero dell'impegno / del fabbisogno dipendente
		RSPOS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.RSPOS)).toUpperCase();//	Type	RSPOS	NUMC	4	0	Numero posizione dell'impegno / del fabbisogno dipendente
		KZBEW=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.KZBEW)).toUpperCase();//	Type	KZBEW	CHAR	1	0	Codice movimento
		KZVBR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.KZVBR)).toUpperCase();//	Type	KZVBR	CHAR	1	0	Registrazione consumo
		LGTYP=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGTYP)).toUpperCase();//	Type	LGTYP	CHAR	3	0	Tipo magazzino
		LGPLA=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGPLA)).toUpperCase();//	Type	LGPLA	CHAR	10	0	Ubicazione
		TBNUM=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.TBNUM)).toUpperCase();//	Type	TBNUM	NUMC	10	0	Numero fabbisogno di trasporto
		TBPOS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.TBPOS)).toUpperCase();//	Type	TBPOS	NUMC	4	0	Posizione fabbisogno di trasporto
		PS_PSP_PNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR)).toUpperCase();//	Type	PS_POSID	CHAR	24	0	Elemento della Work Breakdown Structure (elemento WBS)
		NPLNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.NPLNR)).toUpperCase();//	Type	NPLNR	CHAR	12	0	Numero network per contabilizzazione
		ZUSTD_T156M=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.ZUSTD_T156M)).toUpperCase();//	Type	BAMOK_MSEG	CHAR	1	0	Modifica tipo stock (lettura della tabella T156M)
		MENGE=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.MENGE)).toUpperCase();//	Type	MENGE_D	QUAN	13	3	Quantità
		MEINS=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.MEINS)).toUpperCase();//	Type	MEINS	UNIT	3	0	Unità di misura di base
		VFDAT=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.VFDAT)).toUpperCase();//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		DATA_DOC=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.DATA_DOC)).toUpperCase();
	
		XBLNR=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.XBLNR)).toUpperCase();//	Type	MENGE_D	QUAN	13	3	Quantità
		LICHA=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LICHA)).toUpperCase();//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		NOTE=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.NOTE)).toUpperCase();
		
		POSID=UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.POSID)).toUpperCase();
	
	
	}
	public MovimentazioniBean(JCoTable t){
		
		
		MATNR =UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.MATNR));
		WERKS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.WERKS));//	Type	WERKS_D	CHAR	4	0	Divisione
		CHARG=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.CHARG));//	Type	CHARG_D	CHAR	10	0	Numero partita
		LGORT=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LGORT));//	Type	LGORT_D	CHAR	4	0	Magazzino
		BWART=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.BWART));//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		LGNUM=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LGNUM));//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		SOBKZ=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.SOBKZ));//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		LIFNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LIFNR));//	Type	LIFNR	CHAR	10	0	Numero conto del fornitore
		EBELN=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.EBELN));//	Type	EBELN	CHAR	10	0	Numero del documento acquisti
		EBELP=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.EBELP));//	Type	EBELP	NUMC	5	0	Numero posizione documento d'acquisto
		LFBJA=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LFBJA));//	Type	LFBJA	NUMC	4	0	Esercizio di un documento di riferimento
		LFBNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LFBNR));//	Type	LFBNR	CHAR	10	0	Numero di un documento di riferimento
		LFPOS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LFPOS));//	Type	LFPOS	NUMC	4	0	Posizione di un documento di riferimento
		WEMPF=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.WEMPF));//	Type	WEMPF	CHAR	12	0	Destinatario merci
		KOSTL=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.KOSTL));//	Type	KOSTL	CHAR	10	0	Centro di costo
		AUFNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.AUFNR));//	Type	AUFNR	CHAR	12	0	Numero ordine
		GJAHR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.GJAHR));//	Type	GJAHR	NUMC	4	0	Esercizio
		BUKRS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.BUKRS));//	Type	BUKRS	CHAR	4	0	Società
		RSNUM=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.RSNUM));//	Type	RSNUM	NUMC	10	0	Numero dell'impegno / del fabbisogno dipendente
		RSPOS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.RSPOS));//	Type	RSPOS	NUMC	4	0	Numero posizione dell'impegno / del fabbisogno dipendente
		KZBEW=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.KZBEW));//	Type	KZBEW	CHAR	1	0	Codice movimento
		KZVBR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.KZVBR));//	Type	KZVBR	CHAR	1	0	Registrazione consumo
		LGTYP=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LGTYP));//	Type	LGTYP	CHAR	3	0	Tipo magazzino
		LGPLA=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LGPLA));//	Type	LGPLA	CHAR	10	0	Ubicazione
		TBNUM=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.TBNUM));//	Type	TBNUM	NUMC	10	0	Numero fabbisogno di trasporto
		TBPOS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.TBPOS));//	Type	TBPOS	NUMC	4	0	Posizione fabbisogno di trasporto
		PS_PSP_PNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR));//	Type	PS_POSID	CHAR	24	0	Elemento della Work Breakdown Structure (elemento WBS)
		NPLNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.NPLNR));//	Type	NPLNR	CHAR	12	0	Numero network per contabilizzazione
		ZUSTD_T156M=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.ZUSTD_T156M));//	Type	BAMOK_MSEG	CHAR	1	0	Modifica tipo stock (lettura della tabella T156M)
		MENGE=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.MENGE));//	Type	MENGE_D	QUAN	13	3	Quantità
		MEINS=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.MEINS));//	Type	MEINS	UNIT	3	0	Unità di misura di base
		VFDAT=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.VFDAT));//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		DATA_DOC=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.DATA_DOC));
		
		XBLNR=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.XBLNR));//	Type	MEINS	UNIT	3	0	Unità di misura di base
		LICHA=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.LICHA));//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		NOTE=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.NOTE));
		
		POSID=UtilString.removeNull(t.getString(ZSWM_MOVIMENTAZIONI.POSID));
	}
	public void valorizzaStructure(JCoStructure movSap){

		movSap.setValue(ZSWM_MOVIMENTAZIONI.MATNR, this.getMATNR());//	Type	MATNR	CHAR	18	0	Codice materiale
		movSap.setValue(ZSWM_MOVIMENTAZIONI.WERKS, this.getWERKS());//	Type	WERKS_D	CHAR	4	0	Divisione
		movSap.setValue(ZSWM_MOVIMENTAZIONI.CHARG, this.getCHARG());//	Type	CHARG_D	CHAR	10	0	Numero partita
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LGORT, this.getLGORT());//	Type	LGORT_D	CHAR	4	0	Magazzino
		movSap.setValue(ZSWM_MOVIMENTAZIONI.BWART, this.getBWART());//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LGNUM, this.getLGNUM());//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		movSap.setValue(ZSWM_MOVIMENTAZIONI.SOBKZ, this.getSOBKZ());//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LIFNR, this.getLIFNR());//	Type	LIFNR	CHAR	10	0	Numero conto del fornitore
		movSap.setValue(ZSWM_MOVIMENTAZIONI.EBELN, this.getEBELN());//	Type	EBELN	CHAR	10	0	Numero del documento acquisti
		movSap.setValue(ZSWM_MOVIMENTAZIONI.EBELP, this.getEBELP());//	Type	EBELP	NUMC	5	0	Numero posizione documento d'acquisto
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LFBJA, this.getLFBJA());//	Type	LFBJA	NUMC	4	0	Esercizio di un documento di riferimento
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LFBNR, this.getLFBNR());//	Type	LFBNR	CHAR	10	0	Numero di un documento di riferimento
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LFPOS, this.getLFPOS());//	Type	LFPOS	NUMC	4	0	Posizione di un documento di riferimento
		movSap.setValue(ZSWM_MOVIMENTAZIONI.WEMPF, this.getWEMPF());//	Type	WEMPF	CHAR	12	0	Destinatario merci
		movSap.setValue(ZSWM_MOVIMENTAZIONI.KOSTL, this.getKOSTL());//	Type	KOSTL	CHAR	10	0	Centro di costo
		movSap.setValue(ZSWM_MOVIMENTAZIONI.AUFNR, this.getAUFNR());//	Type	AUFNR	CHAR	12	0	Numero ordine
		movSap.setValue(ZSWM_MOVIMENTAZIONI.GJAHR, this.getGJAHR());//	Type	GJAHR	NUMC	4	0	Esercizio
		movSap.setValue(ZSWM_MOVIMENTAZIONI.BUKRS, this.getBUKRS());//	Type	BUKRS	CHAR	4	0	Società
		movSap.setValue(ZSWM_MOVIMENTAZIONI.RSNUM, this.getRSNUM());//	Type	RSNUM	NUMC	10	0	Numero dell'impegno / del fabbisogno dipendente
		movSap.setValue(ZSWM_MOVIMENTAZIONI.RSPOS, this.getRSPOS());//	Type	RSPOS	NUMC	4	0	Numero posizione dell'impegno / del fabbisogno dipendente
		movSap.setValue(ZSWM_MOVIMENTAZIONI.KZBEW, this.getKZBEW());//	Type	KZBEW	CHAR	1	0	Codice movimento
		movSap.setValue(ZSWM_MOVIMENTAZIONI.KZVBR, this.getKZVBR());//	Type	KZVBR	CHAR	1	0	Registrazione consumo
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LGTYP, this.getLGTYP());//	Type	LGTYP	CHAR	3	0	Tipo magazzino
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LGPLA, this.getLGPLA());//	Type	LGPLA	CHAR	10	0	Ubicazione
		movSap.setValue(ZSWM_MOVIMENTAZIONI.TBNUM, this.getTBNUM());//	Type	TBNUM	NUMC	10	0	Numero fabbisogno di trasporto
		movSap.setValue(ZSWM_MOVIMENTAZIONI.TBPOS, this.getTBPOS());//	Type	TBPOS	NUMC	4	0	Posizione fabbisogno di trasporto
		movSap.setValue(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR, this.getPS_PSP_PNR());//	Type	PS_POSID	CHAR	24	0	Elemento della Work Breakdown Structure (elemento WBS)
		movSap.setValue(ZSWM_MOVIMENTAZIONI.NPLNR, this.getNPLNR());//	Type	NPLNR	CHAR	12	0	Numero network per contabilizzazione
		movSap.setValue(ZSWM_MOVIMENTAZIONI.ZUSTD_T156M, this.getZUSTD_T156M());//	Type	BAMOK_MSEG	CHAR	1	0	Modifica tipo stock (lettura della tabella T156M)
		movSap.setValue(ZSWM_MOVIMENTAZIONI.MENGE, this.getMENGE());//	Type	MENGE_D	QUAN	13	3	Quantità
		movSap.setValue(ZSWM_MOVIMENTAZIONI.MEINS, this.getMEINS());//	Type	MEINS	UNIT	3	0	Unità di misura di base
		movSap.setValue(ZSWM_MOVIMENTAZIONI.VFDAT, this.getVFDAT());//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		movSap.setValue(ZSWM_MOVIMENTAZIONI.DATA_DOC, this.getDATA_DOC());
		
		movSap.setValue(ZSWM_MOVIMENTAZIONI.XBLNR, this.getXBLNR());//	Type	MEINS	UNIT	3	0	Unità di misura di base
		movSap.setValue(ZSWM_MOVIMENTAZIONI.LICHA, this.getLICHA());//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		movSap.setValue(ZSWM_MOVIMENTAZIONI.NOTE, this.getNOTE());
		
		movSap.setValue(ZSWM_MOVIMENTAZIONI.POSID, this.getPOSID());
	}
	
	
	public String getXBLNR() {
		return XBLNR;
	}
	public void setXBLNR(String xBLNR) {
		XBLNR = xBLNR;
	}
	public String getLICHA() {
		return LICHA;
	}
	public void setLICHA(String lICHA) {
		LICHA = lICHA;
	}
	public String getNOTE() {
		return NOTE;
	}
	public void setNOTE(String nOTE) {
		NOTE = nOTE;
	}
	public String getDATA_DOC() {
		return DATA_DOC;
	}
	public void setDATA_DOC(String dATA_DOC) {
		DATA_DOC = dATA_DOC;
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
	public String getCHARG() {
		return CHARG;
	}
	public void setCHARG(String cHARG) {
		CHARG = cHARG;
	}
	public String getLGORT() {
		return LGORT;
	}
	public void setLGORT(String lGORT) {
		LGORT = lGORT;
	}
	public String getBWART() {
		return BWART;
	}
	public void setBWART(String bWART) {
		BWART = bWART;
	}
	public String getLGNUM() {
		return LGNUM;
	}
	public void setLGNUM(String lGNUM) {
		LGNUM = lGNUM;
	}
	public String getSOBKZ() {
		return SOBKZ;
	}
	public void setSOBKZ(String sOBKZ) {
		SOBKZ = sOBKZ;
	}
	public String getLIFNR() {
		return LIFNR;
	}
	public void setLIFNR(String lIFNR) {
		LIFNR = lIFNR;
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
	public String getLFBJA() {
		return LFBJA;
	}
	public void setLFBJA(String lFBJA) {
		LFBJA = lFBJA;
	}
	public String getLFBNR() {
		return LFBNR;
	}
	public void setLFBNR(String lFBNR) {
		LFBNR = lFBNR;
	}
	public String getLFPOS() {
		return LFPOS;
	}
	public void setLFPOS(String lFPOS) {
		LFPOS = lFPOS;
	}
	public String getWEMPF() {
		return WEMPF;
	}
	public void setWEMPF(String wEMPF) {
		WEMPF = wEMPF;
	}
	public String getKOSTL() {
		return KOSTL;
	}
	public void setKOSTL(String kOSTL) {
		KOSTL = kOSTL;
	}
	public String getAUFNR() {
		return AUFNR;
	}
	public void setAUFNR(String aUFNR) {
		AUFNR = aUFNR;
	}
	public String getGJAHR() {
		return GJAHR;
	}
	public void setGJAHR(String gJAHR) {
		GJAHR = gJAHR;
	}
	public String getBUKRS() {
		return BUKRS;
	}
	public void setBUKRS(String bUKRS) {
		BUKRS = bUKRS;
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
	public String getKZBEW() {
		return KZBEW;
	}
	public void setKZBEW(String kZBEW) {
		KZBEW = kZBEW;
	}
	public String getKZVBR() {
		return KZVBR;
	}
	public void setKZVBR(String kZVBR) {
		KZVBR = kZVBR;
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
	public String getTBNUM() {
		return TBNUM;
	}
	public void setTBNUM(String tBNUM) {
		TBNUM = tBNUM;
	}
	public String getTBPOS() {
		return TBPOS;
	}
	public void setTBPOS(String tBPOS) {
		TBPOS = tBPOS;
	}
	public String getPS_PSP_PNR() {
		return PS_PSP_PNR;
	}
	public void setPS_PSP_PNR(String pS_PSP_PNR) {
		PS_PSP_PNR = pS_PSP_PNR;
	}
	public String getNPLNR() {
		return NPLNR;
	}
	public void setNPLNR(String nPLNR) {
		NPLNR = nPLNR;
	}
	public String getZUSTD_T156M() {
		return ZUSTD_T156M;
	}
	public void setZUSTD_T156M(String zUSTD_T156M) {
		ZUSTD_T156M = zUSTD_T156M;
	}
	public String getMENGE() {
		return MENGE;
	}
	public void setMENGE(String mENGE) {
		MENGE = mENGE;
	}
	public String getMEINS() {
		return MEINS;
	}
	public void setMEINS(String mEINS) {
		MEINS = mEINS;
	}
	public String getVFDAT() {
		return VFDAT;
	}
	public void setVFDAT(String vFDAT) {
		VFDAT = vFDAT;
	}
	public String getPOSID() {
		return POSID;
	}
	public void setPOSID(String pOSID) {
		POSID = pOSID;
	}
	
}
