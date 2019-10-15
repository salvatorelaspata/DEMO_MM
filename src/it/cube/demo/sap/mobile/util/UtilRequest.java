package it.cube.demo.sap.mobile.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilRequest {
	public static void copyAllAttributeFromParameter(HttpServletRequest request, HttpServletResponse response){
		try{
			Enumeration<String> x = request.getParameterNames();
			while(x.hasMoreElements()) {
				String par = x.nextElement();
				String val = UtilString.removeNull(request.getParameter(par));
				request.setAttribute(par, val);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getMAC(){		 
		InetAddress ip;
		StringBuilder sb = new StringBuilder();
		try {		 
			ip = InetAddress.getLocalHost();	 
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);	 
			byte[] mac = network.getHardwareAddress();	 
			System.out.print("Current MAC address : ");
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}		 
		} catch (Exception e) {		 
			e.printStackTrace();	 
		}
		System.out.println(sb.toString());
		 return sb.toString();
	   }
	
	public static String getIP(HttpServletRequest request){		 
		String ip="";
		try {		 
			/*InetAddress IP =*/ InetAddress.getLocalHost();
			//ip=IP.getHostAddress();
			//ip=request.getRemoteAddr();
			 ip = request.getHeader("X-FORWARDED-FOR");  
			   if (ip == null) {  
				   ip = request.getRemoteAddr();  
			   }
			
		} catch (Exception e) {		 
			e.printStackTrace();	 
		}
		 return ip;
	   }

	public static boolean isThisRequestCommingFromAMobileDevice(HttpServletRequest request){

	    // http://www.hand-interactive.com/m/resources/detect-mobile-java.htm
	    String userAgent = request.getHeader("User-Agent");
	    String httpAccept = request.getHeader("Accept");

	    UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);

	    if (detector.detectMobileQuick()) {
	        return true;
	    }

	    return false;
	}
}
