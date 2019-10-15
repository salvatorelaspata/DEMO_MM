package it.cube.demo.sap.mobile.util;

public class UtilDate {
	public static String reverseDateFormat(String data, String separatore) {
		String dataFormattata = null;
		
		String[] dataArray = data.split(separatore);
		dataFormattata = dataArray[2] + separatore + dataArray[1] + separatore + dataArray[0];
		
		return dataFormattata;
	}
}
