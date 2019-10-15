package it.cube.demo.sap.mobile.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ConstantsSap {

	public class SapRfc{
		public static final String Error = "E";
		public static final String Success = "S";
		public static final String Info = "I";
		public static final String Warning = "W";
		public static final String Esito = "TYPE";
		public static final String Msg = "MESSAGE";
		public static final String ReturnTable = "RETURN";
		public static final String ConnectionProblem = "Problemi di Connessione a Sap";	
	}
//	public class ZPPTW_AVANZ_PROD{
//		//AvanzamentoProduzione
//			public static final String Name = "ZPPTW_AVANZ_PROD";
//			public static final String TB_ZPPTW_SCELTA_ARBPL = "TB_ZPPTW_SCELTA_ARBPL";
//			public static final String TB_ZPPTW_LOGALLPALM="TB_ZPPTW_LOGALLPALM";
//	}
	public class RETURN {
		public static final String MESSAGE="MESSAGE";//azioni
		public static final String TYPE="TYPE";//matchcode tasti
	}
	public class ZWP_LOGON{
		public static final String Name = "ZFMWM_LOGON";
		//INPUT
		public static final String I_USERID="I_USERID";
		public static final String I_PIN="I_PIN";
		public static final String I_IP="I_IP";
		//OUTPUT
		public static final String TB_AZIONI_USER="OT_ZTWM_USER";//azioni
		public static final String TB_MATCH_CODE="OT_ZTWM_MATCHCODE";//matchcode tasti
		public static final String TB_MENU="OT_ZTWM_MENU";
		public static final String RETURN="OT_RETURN";

	}
	public class ZFMWM_GETLIST_STORAGE{
		public static final String Name = "ZFMWM_GETLIST_STORAGE";
		//INPUT
		public static final String I_LGNUM="I_LGNUM";
		public static final String I_USER="I_USER";
		public static final String I_LGTYP="I_LGTYP";
		public static final String I_WERKS="I_WERKS";
		public static final String I_LGPLA="I_LGPLA";
		public static final String I_LICHA="I_LICHA";
		
		//OUTPUT
		public static final String RETURN="OT_RETURN";
		public static final String OT_LISTA="OT_LISTA";//ST_MATERIALE
	}
	public class ZFMWM_GETLIST_MATERIALE{
		public static final String Name = "ZFMWM_GETLIST_MATERIALE";
		//INPUT
		public static final String I_LGNUM="I_LGNUM";
		public static final String I_USER="I_USER";
		public static final String I_LGTYP="I_LGTYP";
		public static final String I_WERKS="I_WERKS";
		public static final String I_MATNR="I_MATNR";
		public static final String I_LICHA="I_LICHA";

		
		//OUTPUT
		public static final String RETURN="OT_RETURN";
		public static final String OT_LISTA="OT_LISTA";//ST_MATERIALE
	}
	public class ZFMWM_CREA_MOVIMENTAZIONE{
		public static final String Name="ZFMWM_CREA_MOVIMENTAZIONE";
		public static final String ZSWM_MOVIMENTAZIONI="IS_CREA_MOV";
		public static final String IT_LISTA_NETWORK="IT_LISTA_NETWORK";
		public static final String I_CHECK="I_CHECK";
		
		public static final String I_USERID = "I_USERID"; // aggiunta post collaudo
		
		public static final String RETURN="RETURN";
		
		public static final String I_MAT_DOC="I_MAT_DOC";
		public static final String I_DOC_YEAR="I_DOC_YEAR";
		
		public static TB_WBS TB_WBS;
	}
	
	public class TB_WBS {
		public static final String Name = "TB_WBS";
		
		public static final String ZFLAG = "ZFLAG";
		public static final String POSID = "POSID";
	}
	
	public class ZSWM_MOVIMENTAZIONI{//ZSWM_MOVIMENTAZIONI
		public static final String MATNR="MATNR";//	Type	MATNR	CHAR	18	0	Codice materiale
		public static final String WERKS="WERKS";//	Type	WERKS_D	CHAR	4	0	Divisione
		public static final String CHARG="CHARG";//	Type	CHARG_D	CHAR	10	0	Numero partita
		public static final String LGORT="LGORT";//	Type	LGORT_D	CHAR	4	0	Magazzino
		public static final String BWART="BWART";//	Type	BWART	CHAR	3	0	Tipo movimento (gestione stock)
		public static final String LGNUM="LGNUM";//	Type	LGNUM	CHAR	3	0	N. mag./complesso di magazzini
		public static final String SOBKZ="SOBKZ";//	Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		public static final String LIFNR="LIFNR";//	Type	LIFNR	CHAR	10	0	Numero conto del fornitore
		public static final String EBELN="EBELN";//	Type	EBELN	CHAR	10	0	Numero del documento acquisti
		public static final String EBELP="EBELP";//	Type	EBELP	NUMC	5	0	Numero posizione documento d'acquisto
		public static final String LFBJA="LFBJA";//	Type	LFBJA	NUMC	4	0	Esercizio di un documento di riferimento
		public static final String LFBNR="LFBNR";//	Type	LFBNR	CHAR	10	0	Numero di un documento di riferimento
		public static final String LFPOS="LFPOS";//	Type	LFPOS	NUMC	4	0	Posizione di un documento di riferimento
		public static final String WEMPF="WEMPF";//	Type	WEMPF	CHAR	12	0	Destinatario merci
		public static final String KOSTL="KOSTL";//	Type	KOSTL	CHAR	10	0	Centro di costo
		public static final String AUFNR="AUFNR";//	Type	AUFNR	CHAR	12	0	Numero ordine
		public static final String GJAHR="GJAHR";//	Type	GJAHR	NUMC	4	0	Esercizio
		public static final String BUKRS="BUKRS";//	Type	BUKRS	CHAR	4	0	Società
		public static final String RSNUM="RSNUM";//	Type	RSNUM	NUMC	10	0	Numero dell'impegno / del fabbisogno dipendente
		public static final String RSPOS="RSPOS";//	Type	RSPOS	NUMC	4	0	Numero posizione dell'impegno / del fabbisogno dipendente
		public static final String KZBEW="KZBEW";//	Type	KZBEW	CHAR	1	0	Codice movimento
		public static final String KZVBR="KZVBR";//	Type	KZVBR	CHAR	1	0	Registrazione consumo
		public static final String LGTYP="LGTYP";//	Type	LGTYP	CHAR	3	0	Tipo magazzino
		public static final String LGPLA="LGPLA";//	Type	LGPLA	CHAR	10	0	Ubicazione
		public static final String TBNUM="TBNUM";//	Type	TBNUM	NUMC	10	0	Numero fabbisogno di trasporto
		public static final String TBPOS="TBPOS";//	Type	TBPOS	NUMC	4	0	Posizione fabbisogno di trasporto
		public static final String PS_PSP_PNR="PS_PSP_PNR";//	Type	PS_POSID	CHAR	24	0	Elemento della Work Breakdown Structure (elemento WBS)
		public static final String NPLNR="NPLNR";//	Type	NPLNR	CHAR	12	0	Numero network per contabilizzazione
		public static final String ZUSTD_T156M="ZUSTD_T156M";//	Type	BAMOK_MSEG	CHAR	1	0	Modifica tipo stock (lettura della tabella T156M)
		public static final String MENGE="MENGE";//	Type	MENGE_D	QUAN	13	3	Quantità
		public static final String MEINS="MEINS";//	Type	MEINS	UNIT	3	0	Unità di misura di base
		public static final String VFDAT="VFDAT";//	Type	VFDAT	DATS	8	0	Data scad. o data minima conservazione
		public static final String DATA_DOC="DATA_DOC";
		public static final String XBLNR="XBLNR";
		public static final String LICHA="LICHA";
		public static final String NOTE="NOTE";
		public static final String POSID = "POSID"; //wbs di destinazione
	}
	
	public class ZFMWM_GET_MOV_NETWORK{
		public static final String Name ="ZFMWM_GET_MOV_NETWORK";//(Come RFC ZFMWM_CREA_MOVIMENTAZIONE) i campi da valorizzare sono i seguenti:

		public static final String	BWART = "BWART"; //(Tipo Movimento - 281-581)
		public static final String 	NPLNR = "NPLNR"; //(Network)
		public static final String 	RSPOS = "RSPOS"; //(Posizione Network)
		public static final String  AUFNR = "AUFNR"; //OdP
		public static final String  EBELN = "EBELN"; //OdA
		public static final String  EBELP = "EBELP"; //posizione OdA
		
		//Parametri Output:
		public static final String RETURN ="RETURN";//(Gestita come le altre RFC)
		public static final String IT_LISTA_NETWORK="IT_LISTA_NETWORK" ;//contiene i seguenti campi:(Tabella che contiene la lista da fare vedere a video)

		
		
	}
	
//	ZTWM_LISTA_NETWORK
	public class IT_LISTA_NETWORK{
		public static final String Name ="IT_LISTA_NETWORK";

		public static final String MATNR="MATNR";	//Type	MATNR	CHAR	18	0	Codice materiale
		public static final String WERKS="WERKS";	//Type	WERKS_D	CHAR	4	0	Divisione
		public static final String LGORT="LGORT";	//Type	LGORT_D	CHAR	4	0	Magazzino
		public static final String CHARG="CHARG";	//Type	CHARG_D	CHAR	10	0	Numero partita
		public static final String SOBKZ="SOBKZ";	//Type	SOBKZ	CHAR	1	0	Cd. stock speciale
		public static final String BDMNG="BDMNG";	//Type	BDMNG	QUAN	13	3	Quantità fabbisogno
		public static final String MEINS="MEINS";	//Type	MEINS	UNIT	3	0	Unità di misura di base
		public static final String FLAG="FLAG";		//Type	FLAG	CHAR	1	0	Indicatore generale

		public static final String LGNUM="LGNUM";
		public static final String LGTYP="LGTYP";
		public static final String LGPLA="LGPLA";
		public static final String PSPEL="PSPEL";
		public static final String MAKTX="MAKTX";	// Descrizione Materiale 
		public static final String LICHA="LICHA";	// Lotto
		public static final String POSID="POSID";	// WBS
		public static final String IS_GEST_PARTITA="IS_GEST_PARTITA";
		
		public static final String RSNUM = "RSNUM";
		public static final String RSPOS = "RSPOS";
		
		public static final String EBELN = "EBELN";
		public static final String EBELP = "EBELP";
		
	}
	
	public class ZWPWM_RICERCA_OT{
		public static final String Name = "ZFMWM_RICERCA_OT";
		//INPUT
		public static final String I_TANUM="I_TANUM";
		public static final String I_DATA="I_DATA";
		public static final String I_BWART="I_BWART";
		public static final String I_LGNUM="I_LGNUM";
		public static final String I_MATNR="I_MATNR";
		public static final String I_VLTYP="I_VLTYP";
		public static final String I_VLBER="I_VLBER";
		public static final String I_VLPLA="I_VLPLA";
		public static final String I_NLTYP="I_NLTYP";
		public static final String I_NLBER="I_NLBER";
		public static final String I_NLPLA="I_NLPLA";
		public static final String I_CHARG="I_CHARG";
		//public static final String LICHA="CHARG";

		//OUTPUT
		public static final String TB_OT="OT_LISTA_OT";
		public static final String RETURN="OT_RETURN";
	}
	public class ZWPWM_CREAZIONE_OT{
		public static final String Name = "ZFMWM_CREAZIONE_OT";
		//INPUT
		public static final String IT_CREA_MOV="IT_CREA_MOV";
		//OUTPUT
		public static final String RETURN="OT_RETURN";
	}
	public class ZWPWM_CONFERMA_OT{
		public static final String Name = "ZFMWM_CONFERMA_OT";
		//INPUT
		public static final String IN_TB_OT="IT_LISTA_OT";//tb_mov
		//OUTPUT
		public static final String RETURN="OS_RETURN";
		public static final String OUT_TB_OT="OT_LISTA_OT";
	}
	
	
	
	
	// GENERALI
	
	public class ST_MATERIALI{
		public static final String 
		MATNR="MATNR",
		WERKS="WERKS",
		LGNUM="LGNUM",
		MAKTX="MAKTX",
		LGTYP="LGTYP",
		LGPLA="LGPLA",
		VERME="VERME",
		GESME="GESME",
		AUSME="AUSME",
		EINME="EINME",
		MEINS="MEINS",
		WDATU="WDATU",
		VFDAT="VFDAT",
		CHARG="CHARG",
		LICHA="LICHA",
		BESTQ="BESTQ",
		FLAG_LGPLA="FLAG_LGPLA",
		LGORT="LGORT",
		WENUM = "WENUM",
		
		SOBKZ = "SOBKZ", //aggiunto dopo collaudo
		SONUM = "SONUM",
		LSONR = "LSONR";
	}
	public class TB_MOV{//tabella generale dei movimenti
		public static final String 
		MATERIAL="MATERIAL",//Codice materiale
		PLANT="PLANT",//Divisione
		BATCH="BATCH",//Magazzino
		STGE_LOC="STGE_LOC",//Numero partita
		MOVE_TYPE="MOVE_TYPE",//Tipo movimento (gestione stock)
		ENTRY_QNT="ENTRY_QNT",//Quantità in unità di misura di acquisizione
		ENTRY_UOM="ENTRY_UOM",//Valore matrice
		//GRID_VALUE="GRID_VALUE",//Valore Matrice
		VLTYP="VLTYP",//Tipo di magazzino di provenienza
		VLPLA="VLPLA",//Ubicazione di provenienza
		NLTYP="NLTYP",//Tipo di magazzino di destinazione
		NLPLA="NLPLA",//Ubicazione di destinazione
		STGE_LOC_DEST="STGE_LOC_DEST",
		VLBER="VLBER",
		NLBER="NLBER",
		LGNUM="LGNUM";
		
	}
	public class TB_OT{//tabella genarale degli ot
		//public static final String TYPE="ZTTWM_LISTA_OT";
		public static final  String 
		LGNUM="LGNUM",
		TANUM="TANUM",
		TAPOS="TAPOS",
		MATNR="MATNR",
		MAKTX="MAKTX",
		BWART="BWART",// --    Tipo movimento (gestione stock);
		CHARG="CHARG", //--     Numero partita;
		LICHA="CHARG",
		VLTYP="VLTYP",
		VLPLA="VLPLA",
		VLBER="VLBER",
		VSOLA="VSOLA",
		ALTME="ALTME",
		NLTYP="NLTYP",
		NLPLA="NLPLA",
		NLBER="NLBER",
		NSOLA="NSOLA",
		NISTA="NISTA",
		BNAME="BNAME",
		LSONR="LSONR",
		SOBKZ="SOBKZ",
		CONFERMA="CONFERMA";
	}
	
	public static class ZFMWM_GET_ODA {
		public static String Name="ZFMWM_GET_ODA";

//		IMPORTING 
		public static String I_EBELN="I_EBELN";// (CHAR10)
		public static String I_EBELP ="I_EBELP";//(NUMC5)
		
//		EXPORTING 
		public static String RETURN="RETURN"; //(Solita tabella utilizzata per la gestione dei messaggi)
		public static String OT_CREA_MOV = "OT_CREA_MOV";// (Solita tabella utilizzata per la creazione delle movimentazioni)
	}
	
	public class ZFMWM_CHECK_WBS {
		public static final String Name = "ZFMWM_CHECK_WBS";
		//importing
		public static final String I_MATNR = "I_MATNR";
		public static final String I_WERKS = "I_WERKS";
		public static final String I_LGORT = "I_LGORT";
		public static final String I_CHARG = "I_CHARG";
		public static final String SOBKZ   = "SOBKZ";
		public static final String I_QNT   = "I_QNT";
		public static final String I_WBS   = "I_WBS";
		public static final String I_UM    = "I_UM";
		
		public static final String I_LGNUM = "I_LGNUM";
		public static final String I_LGTYP = "I_LGTYP";
		public static final String I_LGPLA = "I_LGPLA";
		
		public static BAPIRET2_T RETURN;
		public static ZZWM_WBS_LIST ZZWM_WBS_LIST;
	}
	
	public class ZFMWM_CHECK_BATCH {
		public static final String Name = "ZFMWM_GET_BATCH_LIST";
		//importing
		public static final String I_MATNR = "I_MATNR";
		public static final String I_WERKS = "I_WERKS";
		public static final String I_LGORT = "I_LGORT";
		public static final String I_CHARG = "I_CHARG";
		public static final String I_PS_PSP_PNR = "I_PS_PSP_PNR";
		public static final String I_LGNUM = "I_LGNUM";
		public static final String I_LGTYP = "I_LGTYP";
		public static final String I_LGPLA = "I_LGPLA";
		public static final String I_QNT = "I_QNT";
		public static final String I_IS_GEST_PART = "I_IS_GEST_PART";
		
		//exporting
		public static BAPIRET2_T RETURN;
		public static TB_BATCH TB_BATCH;
		public static final String IS_GEST_PARTITA = "IS_GEST_PARTITA";
	}
	
	public class BAPIRET2_T {
		public static final String Name	= "RETURN";
		
		public static final String TYPE         = "TYPE";
		public static final String ID           = "ID";
		public static final String NUMBER       = "NUMBER";
		public static final String MESSAGE      = "MESSAGE";
		public static final String LOG_NO       = "LOG_NO";
		public static final String LOG_MSG_NO   = "LOG_MSG_NO";
		public static final String MESSAGE_V1   = "MESSAGE_V1";
		public static final String MESSAGE_V2   = "MESSAGE_V2";
		public static final String MESSAGE_V3   = "MESSAGE_V3";
		public static final String MESSAGE_V4   = "MESSAGE_V4";
		public static final String PARAMETER    = "PARAMETER";
		public static final String ROW          = "ROW";
		public static final String FIELD        = "FIELD";
		public static final String SYSTEM       = "SYSTEM";
	}
	
	public class ZZWM_WBS_LIST {
		public static final String Name	= "TB_WBS";
		
		public static final String ZFLAG = "ZFLAG";
		public static final String POSID = "POSID";
	}
	public class TB_BATCH {
		public static final String Name = "TB_BATCH";
		
		public static final String MATNR = "MATNR";
		public static final String CHARG = "CHARG";
		public static final String LICHA = "LICHA";
		public static final String VFDAT = "VFDAT";
	}
}
