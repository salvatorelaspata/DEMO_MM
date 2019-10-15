package it.cube.demo.sap.mobile.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

public final class UtilString {
	
	public static boolean isEmpty(String input){
		return (input==null||input.trim().length()==0);
	}
	
	public static String convertStringNumber(String input){
		input=input.replace(".", "");
		return input.replace(",", "."); 
	}
	
	public static boolean isGreaterThenZero(Long num){
		boolean result = false;
		if(num!=null && num.longValue()>0) result= true;
		return result;
	}
	
	public static String[] decodeBarcode(String barcode){
		return barcode.split("-");
	}
	public static String removeNull(String input){
		String result = "";
		if(input!=null && !"null".equals(input)){
			result = input;
		}
		return result;
		
	}
	
	public static String tronca(String input, int lunghezza){
		if(input==null)return null;
		if(input.length()<=40)return input;
		return input.substring(0, lunghezza);
	}
	
	public static String euroFormat(BigDecimal input){
		String result = "";
		if(input!=null){
			NumberFormat  format = NumberFormat.getCurrencyInstance(Locale.ITALY);
			String currency = format.format(input);
			result = currency;
		}
		return result;
		
	}
	
	public static boolean isNumber(String input){
		boolean result = false;
		String numeri = "0123456789";
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			if(numeri.indexOf(c)!=-1){
				result = true;
			}else{
				result = false;
				break;
			}
		}
		return  result;
	}
	/**
	 * Legge un file di testo convertendolo in una stringa.
	 * 
	 * @param filePath the file path
	 * 
	 * @return the string
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String readFileAsString(String filePath)
			throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		URL url = new URL(filePath); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			fileData.append(buf, 0, numRead);
		}
		reader.close();
		return fileData.toString();
	}
	
	public static void main(String[] args){
	//	convertStringNumber("7,000");
	}
	
	public static byte[] byteAppend(byte[] a, byte[] b) {
	    byte[] result = new byte[a.length + b.length]; 
	    System.arraycopy(a, 0, result, 0, a.length); 
	    System.arraycopy(b, 0, result, a.length, b.length); 
	    return result;
	}

}
