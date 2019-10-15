package it.cube.demo.sap.mobile.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1727449378606417306L;

	public void logMessage(){
	//	Logger log = Logger.getLogger(CustomException.class);
		String msg =this.getLocalizedMessage();
		System.out.println(msg);
		this.printStackTrace();
		StringWriter stack = new StringWriter();
	    this.printStackTrace(new PrintWriter(stack));
	   // Logger.debug(""+stack.toString());
	}
}
