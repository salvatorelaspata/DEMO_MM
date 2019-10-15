package it.cube.demo.sap.mobile.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface Constants {
	//nomi parametri passaggio locazione
	static final String PagProvenienza = "pagProv";
	static final String PagDestinazione = "pagDest";
	public final String ErrorMessage = "errorMessage";
	public final String Show = "show";
	//esiti generali
	public static final String Error = "E";
	public static final String Success = "S";
	public static final String Info = "I";
	///***///***///***///***///***///***///
	public static final int F_AVANZ_PROD = 0;
	public static final int FUNCTION_MENU = 1;
	public static final String DATIUTENTE = "DATIUTENTE";
	public static final String ALERT_PAGE = "jsp/include/page_alert.jsp";
	public static final String CWERKS = "CS01";


	// costanti per passaggio di parametri tramite sessione
	public class Session {
		public static final String LISTAOT = "LISTAOT";
		public static final String LISTAMAT = "LISTAMAT";
		public static final String CHECKLIST = "CHECKOT";
		public static final String LISTAMOV = "LISTAMOV";

		public static final String DEFAULT = "DEFAULT";
	}
	public class TipoMov {
		public static final String ESTERNI = "esterni";
		public static final String MOV311 = "311";
		public static final String MOV999 = "999";
		public static final String TERZISTA = "terzista";

	}
	//url e identificazioni delle pagine
	public class URL {
		public static final String LOGIN="jsp/main/login.jsp";
		public static final String MENU = "jsp/main/menu.jsp";
		//***
		public static final String MOVMAT = "jsp/movmat/";
		public static final String RIEPILOGO = "/riepilogo";
		public static final String DETTAGLIO = "/dettaglio";

		public static final String MOV_101 = "jsp/movmat/101/101.jsp";
		public static final String MOV_RICERCA_101 = "jsp/movmat/101/ricerca101.jsp";
		public static final String MOV_RIEPILOGO_101 = "jsp/movmat/101/riepilogo101.jsp";
		
		public static final String MOV_201 = "jsp/movmat/201/201.jsp";

		public static final String MOV_281 = "jsp/movmat/281/281.jsp";
		public static final String MOV_281_ELENCO = "jsp/movmat/281/elenco.jsp";
		public static final String MOV_RIEPILOGO281 = "jsp/movmat/281/riepilogo281.jsp";
		public static final String DETTAGLIO_MOV281 = "jsp/movmat/281/dettaglio281.jsp";

		public static final String MOV_221 = "jsp/movmat/221/221.jsp";
		public static final String MOV_RIEPILOGO221 = "jsp/movmat/221/riepilogo221.jsp";
		public static final String DETTAGLIO_MOV221 = "jsp/movmat/221/dettaglio221.jsp";
		
		public static final String MOV_581 = "jsp/movmat/581/581.jsp";
		public static final String MOV_RIEPILOGO581 = "jsp/movmat/581/riepilogo581.jsp";
		public static final String DETTAGLIO_MOV581 = "jsp/movmat/581/dettaglio581.jsp";
		
		public static final String MOV_309 = "jsp/movmat/309/309.jsp";
		public static final String MOV_RIEPILOGO309 = "jsp/movmat/309/riepilogo309.jsp";
		public static final String DETTAGLIO_MOV309 = "jsp/movmat/309/dettaglio309.jsp";
		
		public static final String MOV_311 = "jsp/movmat/311/311.jsp"; //verso produzione
		public static final String DEFAULT311 = "jsp/movmat/311/default311.jsp";
		public static final String RIEPILOGO311 = "jsp/movmat/311/riepilogo311.jsp";
		public static final String DETTAGLIO_MOV311 = "jsp/movmat/311/dettaglio311.jsp";

		public static final String MOV_999 = "jsp/movmat/999/999.jsp"; //interni//conferma OT
		public static final String DEFAULT999 = "jsp/movmat/999/default999.jsp";
		public static final String RIEPILOGO999 = "jsp/movmat/999/riepilogo999.jsp";
		public static final String DETTAGLIO_MOV999 = "jsp/movmat/999/dettaglio999.jsp";

		public static final String TRAS_ESTERNI = "jsp/movmat/esterni/esterni.jsp";
		public static final String RIEPILOGO_ESTERNI = "jsp/movmat/esterni/riepilogoEsterni.jsp";
		public static final String DETTAGLIO_ESTERNI = "jsp/movmat/esterni/dettaglioEsterni.jsp";

		public static final String TRAS_TERZISTA = "jsp/movmat/terzista/terzista.jsp";
		public static final String RIEPILOGO_TERZISTA = "jsp/movmat/terzista/riepilogoTerzista.jsp";
		public static final String DETTAGLIO_TERZISTA = "jsp/movmat/terzista/dettaglioTerzista.jsp";

		//*** finiti

		public static final String PRELIEVO1 = "jsp/prelievo/prelievo1.jsp";
		public static final String PRELIEVO2 = "jsp/prelievo/prelievo2.jsp";
		public static final String PRELIEVO_RIEPILOGO = "jsp/prelievo/riepilogopdc.jsp";
		public static final String PRELIEVO3 = "jsp/prelievo/prelievo3.jsp";

		public static final String CONFOT = "jsp/confot/conferma_OT.jsp";
		public static final String CONFOT2 = "jsp/confot/elenco_OT.jsp";
		public static final String CONFOT3 = "jsp/confot/dettaglio_OT.jsp";
		//***

		public static final String PIANICARICO1 = "jsp/pianicarico/pianicarico1.jsp";
		public static final String PIANICARICO2 = "jsp/pianicarico/pianicarico2.jsp";
		public static final String PIANICARICO3 = "jsp/pianicarico/pianicarico3.jsp";

		public static final String REPORT = "jsp/report/report.jsp";
		public static final String RICERCA_MATERIALE = "jsp/report/ricercaMat.jsp";
		public static final String RICERCA_UBICAZIONE = "jsp/report/ricercaUbica.jsp";
		public static final String ELENCOMATERIALI = "jsp/report/elencoMateriali.jsp";
		public static final String ELENCOUBICAZIONI = "jsp/report/elencoUbicazioni.jsp";

		public static final String DETTAGLIOMATERIALE = "jsp/report/dettaglioMateriale.jsp";
		public static final String DETTAGLIOUBICAZIONE = "jsp/report/dettaglioUbicazione.jsp";

//			public static final String RICERCA_UBICA_DA_MAT="jsp/report/ricercaUbicaDaMat.jsp";
//			public static final String RICERCA_UBICA_DA_MAT="jsp/report/ricercaUbicaDaMat.jsp";

		//***
		public static final String INVENTARIO = "jsp/inventario/inventario.jsp";
		public static final String REGISTRA_CONTEGGIO = "jsp/inventario/registraConteggio.jsp";
		//***
		public static final String SPED_CLIENTE = "jsp/movmat/spedCliente.jsp";
		
		public static final String MOV_261 = "jsp/movmat/261/261.jsp";
		public static final String MOV_RICERCA_261 = "jsp/movmat/261/ricerca261.jsp";
		public static final String MOV_RIEPILOGO_261 = "jsp/movmat/261/riepilogo261.jsp";
		
		public static final String MOV_541 = "jsp/movmat/541/541.jsp";
		public static final String MOV_RICERCA_541 = "jsp/movmat/541/ricerca541.jsp";
		public static final String MOV_RIEPILOGO_541 = "jsp/movmat/541/riepilogo541.jsp";
		
		public static final String MOV_411 = "jsp/movmat/411/411.jsp";
		
		public static final String MOV_415 = "jsp/movmat/415/415.jsp";
		
		public static final String MOV_291 = "jsp/movmat/291/291.jsp";
		
	}
	public static final class MapUrl {
		public static final Map<String, String> map;
		static {
			Map<String, String> m = new HashMap<String, String>();
			//menu 01
			m.put("01", URL.MOV_999);
			m.put("02", URL.CONFOT);
			//menu 03
			m.put("030301", URL.MOV_RICERCA_101);
			m.put("030302", URL.MOV_581);
			m.put("030303", URL.MOV_281);
			m.put("030304", URL.MOV_201);
			//m.put("030305", URL.MOV_221);
//			m.put("030307", URL.MOV_309);
			m.put("030305", URL.MOV_RICERCA_261);
			m.put("030306", URL.MOV_291);
			m.put("030307", URL.MOV_RICERCA_541);
			m.put("030308", URL.MOV_411);
			m.put("030309", URL.MOV_415);
			//menu 04
			//m.put("040401",URL.PRELIEVO1);
			m.put("040401", URL.RICERCA_UBICAZIONE);
			m.put("040402", URL.RICERCA_MATERIALE);
			//menu 05
			m.put("050000", URL.PIANICARICO1);
			map = Collections.unmodifiableMap(m);
		}
		public static String getURL(String cod) {
			String url = map.containsKey(cod) ? map.get(cod) : URL.MENU;
			System.out.println("COD: " + cod + " - URL: " + url);
			return url;
		}
		public static final class Host {
			static String url = null;
			public static String Url() {
				return url;
			}
			public static void InizializeUrl(HttpServletRequest request) {
				if (url == null) {
					url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
				}
			}
		}
	}

}
