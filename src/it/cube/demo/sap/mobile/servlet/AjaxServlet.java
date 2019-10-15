package it.cube.demo.sap.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.bean.ConfermaOTBean;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovNetworkBean;
import it.cube.demo.sap.mobile.bean.MovWMBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.IT_LISTA_NETWORK;
import it.cube.demo.sap.mobile.util.UtilString;


/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/TestServlet")
public class AjaxServlet extends HttpServlet implements Constants{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AjaxServlet() {
        // TODO Auto-generated constructor stub
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
		PrintWriter pw =response.getWriter();
		
		try{
			DatiUtente du =(DatiUtente) request.getSession().getAttribute(DATIUTENTE);
			if(du==null)
				throw new Exception("Impossibile procedere.Sessione Scaduta");
			String action=request.getParameter("action");
			if("checkOT".equals(action)){
				
				Boolean value=Boolean.parseBoolean(request.getParameter("value"));
				Integer row=Integer.parseInt(request.getParameter("row"));
				@SuppressWarnings("unchecked")
				Map<Integer,String> check=(Map<Integer,String> )request.getSession().getAttribute(Session.CHECKLIST); 
				if(check==null)
					check=new HashMap<Integer,String>() ;
				check.put(row, ""+value);		
				request.getSession().setAttribute(Session.CHECKLIST, check);
				ArrayList<ConfermaOTBean> conf=(ArrayList<ConfermaOTBean>)request.getSession().getAttribute(Constants.Session.LISTAOT);
				conf.get(row).setCONFERMA(value?"X":"");
				System.out.println("row="+row+" value="+value);
				pw.write("row="+row+" value="+value);
				pw.flush();
				pw.close();
			}else if("mov".equals(action)){
				@SuppressWarnings("unchecked")
				ArrayList<MovWMBean> listaMov = (ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);//lista movimenti, se è vuota la inizializz
				String value=request.getParameter("value");
				Integer row=Integer.parseInt(request.getParameter("row"));
				listaMov.get(row).checked=!listaMov.get(row).checked;//listaMov.get(row).checked=Boolean.parseBoolean(value);
				System.out.println("Mov: "+row+" Html-Check: "+value+" Mov-Check: "+listaMov.get(row).checked);
				pw.write("Mov: "+row+" Html-Check: "+value+" Mov-Check: "+listaMov.get(row).checked);
				pw.close();
				pw.flush();
			}else if("Net".equals(action)){
				@SuppressWarnings("unchecked")
				ArrayList<MovNetworkBean> listaMov = (ArrayList<MovNetworkBean>)request.getSession().getAttribute(Session.LISTAMOV);//lista movimenti, se è vuota la inizializz
				String value=request.getParameter("value");
				Integer row=Integer.parseInt(request.getParameter("row"));
				listaMov.get(row).checked=!listaMov.get(row).checked;//listaMov.get(row).checked=Boolean.parseBoolean(value);
				System.out.println("Mov: "+row+" Html-Check: "+value+" Mov-Check: "+listaMov.get(row).checked);
				pw.write("Mov: "+row+" Html-Check: "+value+" Mov-Check: "+listaMov.get(row).checked);
				pw.close();
				pw.flush();
			}else if("magazzino".equals(action)){
				String value=request.getParameter("value");

				//pw.write("Mov: "+row+" Html-Check: "+value+" Mov-Check: "+listaMov.get(row).checked);
				Map<String, String> map= (Map<String, String>)request.getSession().getAttribute("al");
				pw.write(UtilString.removeNull(map.get(value)));
				pw.close();
				pw.flush();
			}else if("salvaModifiche281".equals(action)){
//				@SuppressWarnings("unchecked")
				ArrayList<MovNetworkBean> mov=(ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
				
//				int posDet  = Integer.parseInt(action.split("_")[1]);
				
				int pos = Integer.parseInt(request.getParameter("pos"));
				MovNetworkBean det = mov.get(pos);
				String BDMNG = request.getParameter(IT_LISTA_NETWORK.BDMNG);
				String CHARG = request.getParameter(IT_LISTA_NETWORK.CHARG);
				String LGPLA = request.getParameter(IT_LISTA_NETWORK.LGPLA);
				String LGTYP = request.getParameter(IT_LISTA_NETWORK.LGTYP);
				String LGNUM = request.getParameter(IT_LISTA_NETWORK.LGNUM);
				
				det.setBDMNG(BDMNG);
				det.setCHARG(CHARG);
				det.setLGNUM(LGNUM);
				det.setLGPLA(LGPLA);
				det.setLGTYP(LGTYP);
				
				mov.set(pos, det);
				request.getSession().setAttribute(Session.LISTAMOV,mov);
//				det.checked=Boolean.parseBoolean(CHECKED);
//				pagDest=URL.DETTAGLIO_MOV281;
				//request.setAttribute("dettaglio", det);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			pw.write(e.getLocalizedMessage());
			pw.close();
			pw.flush();
		}
	}
	

}
