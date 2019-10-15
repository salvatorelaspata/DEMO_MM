package it.cube.demo.sap.mobile.action;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.action.report.RicercaMaterialiAction;
import it.cube.demo.sap.mobile.action.report.RicercaUbicazioni;
import it.cube.demo.sap.mobile.constants.Constants.URL;

public class ActionResolver {
	public ActionInterface resolveAction(String provenienza) {
		if (provenienza != null && provenienza.indexOf("999") != -1) {
			return new CreaOTAction();
		} else if (URL.CONFOT.equalsIgnoreCase(provenienza) || URL.CONFOT2.equalsIgnoreCase(provenienza) || URL.CONFOT3.equalsIgnoreCase(provenienza)) {
			return new ConfermaOTAction();
		} else if (URL.RICERCA_MATERIALE.equalsIgnoreCase(provenienza) || URL.ELENCOMATERIALI.equalsIgnoreCase(provenienza) || URL.DETTAGLIOMATERIALE.equalsIgnoreCase(provenienza)) {
			return new RicercaMaterialiAction();
		} else if (URL.RICERCA_UBICAZIONE.equalsIgnoreCase(provenienza) || URL.ELENCOUBICAZIONI.equalsIgnoreCase(provenienza) || URL.DETTAGLIOUBICAZIONE.equalsIgnoreCase(provenienza)) {
			return new RicercaUbicazioni();
		} else if (URL.MOV_101.equalsIgnoreCase(provenienza) || URL.MOV_RICERCA_101.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO_101.equalsIgnoreCase(provenienza)) {
			return new Mov101Action();
		} else if (URL.MOV_201.equalsIgnoreCase(provenienza)) {
			return new Mov201Action();
		} else if (URL.MOV_221.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO221.equalsIgnoreCase(provenienza) || URL.DETTAGLIO_MOV221.equalsIgnoreCase(provenienza)) {
			return new Mov221Action();
		} else if (URL.MOV_311.equalsIgnoreCase(provenienza)){
			return new Mov311Action();
//		} else if (URL.MOV_309.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO309.equalsIgnoreCase(provenienza) || URL.DETTAGLIO_MOV309.equalsIgnoreCase(provenienza)) {
//			return new Mov309Action();
		} else if (URL.MOV_281.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO281.equalsIgnoreCase(provenienza) || URL.DETTAGLIO_MOV281.equalsIgnoreCase(provenienza)) {
			return new Mov281Action();
		} else if (URL.MOV_221.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO221.equalsIgnoreCase(provenienza) || URL.DETTAGLIO_MOV221.equalsIgnoreCase(provenienza)) {
			return new Mov281Action();
		} else if (URL.MOV_581.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO581.equalsIgnoreCase(provenienza) || URL.DETTAGLIO_MOV581.equalsIgnoreCase(provenienza)) {
			return new Mov581Action();
		} else if (URL.LOGIN.equalsIgnoreCase(provenienza)) {
			return new LoginAction();
		} else if (URL.MOV_261.equalsIgnoreCase(provenienza) || URL.MOV_RICERCA_261.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO_261.equalsIgnoreCase(provenienza)) {
			return new Mov261Action();
		} else if (URL.MOV_541.equalsIgnoreCase(provenienza) || URL.MOV_RICERCA_541.equalsIgnoreCase(provenienza) || URL.MOV_RIEPILOGO_541.equalsIgnoreCase(provenienza)) {
			return new Mov541Action();
		} else if (URL.MOV_411.equalsIgnoreCase(provenienza)) {
			return new Mov411Action();
		} else if (URL.MOV_415.equalsIgnoreCase(provenienza)) {
			return new Mov415Action();
		} else if (URL.MOV_291.equalsIgnoreCase(provenienza)) {
			return new Mov291Action();
		}
		else {
			return new MenuAction();
		}
	}
}
