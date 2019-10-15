package it.cube.demo.sap.mobile.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.action.ActionResolver;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.Constants.MapUrl.Host;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/TestServlet")
public class MainServlet extends HttpServlet implements Constants{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
        // TODO Auto-generated constructor stub
		//url=request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    	
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWork(request, response);
	}
	
	private void doWork(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Host.InizializeUrl(request);
//		SapUtil.inizialize(this.getServletContext().getRealPath("/properties/proprieta.properties"));
		
//		ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("it.cube.demo.sap.mobile.properties.proprieta");
//		//*************
//		String ip=RESOURCE_BUNDLE.getString("ip");
//		request.setAttribute("IP", ip);
//		System.out.println("MainServlet "+ System.getProperty("user.dir"));
	
		String pagDest=Constants.URL.LOGIN;	
		String pagProv = request.getParameter(PagProvenienza);
		DatiUtente du =(DatiUtente) request.getSession().getAttribute(DATIUTENTE);
		if(pagProv==null)
			pagProv=(String)request.getAttribute(PagProvenienza);
		
		ActionInterface obj = null;
			 if(URL.LOGIN.equalsIgnoreCase(pagProv) || du!=null || pagProv==null){
				 ActionResolver resolver = new ActionResolver();
				 System.out.println("pagProv "+pagProv);
				 obj = resolver.resolveAction(pagProv);
				 pagDest=obj.execute(request, response);
			}else{
				request.setAttribute("errorMessage", "Sessione Scaduta");
				request.setAttribute("show",Constants.Error );
			}
			 System.out.println("PageDest "+ pagDest);
		request.getRequestDispatcher(pagDest).forward(request, response);
	
	}
	

}
