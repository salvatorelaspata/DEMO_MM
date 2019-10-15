package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.MovWMBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;

public class MenuAction  implements ConstantsSap,Constants, ActionInterface
{
	
	@Override
	public String execute (HttpServletRequest request, HttpServletResponse response){
		String pagina = URL.MENU;
//		String pagProv = request.getParameter(PagProvenienza);
		String codiceMow=request.getParameter("codice");
		request.getSession().setAttribute("codice", codiceMow);
		String input=request.getParameter("input");
		if(input!=null){
				pagina=input;
		}else{
			pagina=URL.LOGIN;
		}
		if(pagina!=null && pagina.indexOf("default")>-1){
			request.getSession().setAttribute(Session.DEFAULT, null);
			
		}
		if(URL.DEFAULT311.equals(pagina)){
				ArrayList<MovWMBean> listaMov = (ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);
				if(listaMov!=null)
					listaMov.clear();
		}else if(URL.DEFAULT999.equals(pagina)){
			ArrayList<MovWMBean> listaMov = (ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);
			if(listaMov!=null)
				listaMov.clear();
			/*try {
				if(request.getSession().getAttribute("al")==null){
					RfcSelectTpMag rfc= new RfcSelectTpMag();
					rfc.execute();
					request.getSession().setAttribute("al", rfc.getTableScelta());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}else if(URL.CONFOT.equals(pagina)){
			ArrayList<MovWMBean> listaOT = (ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAOT);
			if(listaOT!=null)
				listaOT.clear();
		}		
		return pagina;
	}
}