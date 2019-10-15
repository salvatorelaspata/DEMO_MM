package it.cube.demo.sap.mobile.action;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.login.RfcLogIn;
import it.cube.demo.sap.mobile.util.UtilRequest;

public class LoginAction implements Constants, ConstantsSap, ActionInterface {

	@Override
	public String execute (HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = URL.LOGIN;
		
		try {

			HttpSession session = request.getSession();
			session = request.getSession(false);

			String ip=request.getRemoteAddr();
//			ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("it.cube.demo.sap.mobile.properties.proprieta");
//			String ip = RESOURCE_BUNDLE.getString("ip");
			
			//trovo ip
			if (ip != null)
				if (UtilRequest.isThisRequestCommingFromAMobileDevice(request))
					ip = UtilRequest.getIP(request);

			System.out.println("IP address : " + ip + " Time: " + new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss:SS").format(new Date()));
			
			RfcLogIn log = new RfcLogIn();
			log.setUser(request.getParameter("user"));
			log.setPassword(request.getParameter("password"));
			log.setIp(ip);
			log.execute();
			
			if (log.isEsitoOK()) {
				pagina = URL.MENU;
				session.setAttribute(DATIUTENTE, log.getDatiutente());
			}

			request.setAttribute("errorMessage", log.getMsg());
			request.setAttribute("show", log.getEsito());

			return pagina;

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getLocalizedMessage());
			request.setAttribute("show", Error);
			return pagina;
		}
		
	}
}