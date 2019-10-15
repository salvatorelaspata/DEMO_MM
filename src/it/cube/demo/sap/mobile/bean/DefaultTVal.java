package it.cube.demo.sap.mobile.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import it.cube.demo.sap.mobile.util.UtilString;

public class DefaultTVal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String dMag="",dTipo="",dUbic="",pMag="",pTipo="",pUbic="";
	
	public void setFromRequest(HttpServletRequest request){
		dMag=UtilString.removeNull(request.getParameter("dMag"));
		dTipo=UtilString.removeNull(request.getParameter("dTipo"));
		dUbic=UtilString.removeNull(request.getParameter("dUbic"));
		pMag=UtilString.removeNull(request.getParameter("pMag"));
		pTipo=UtilString.removeNull(request.getParameter("pTipo"));
		pUbic=UtilString.removeNull(request.getParameter("pUbic"));
	}
}
