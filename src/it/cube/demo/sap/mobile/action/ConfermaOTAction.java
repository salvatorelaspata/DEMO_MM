package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.ConfermaOTBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.SapRfc;
import it.cube.demo.sap.mobile.rfc.OT.RfcConfermaOT;
import it.cube.demo.sap.mobile.rfc.OT.RfcRicercaOT;


public class ConfermaOTAction implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null;//azione=null;
	String ip=null;
	private String action=""; 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(PagProvenienza);
		if(URL.CONFOT.equals(pagProv)){
			request.setAttribute("I_TANUM",request.getParameter("I_TANUM"));
			request.setAttribute("I_DATA",request.getParameter("I_DATA"));
			request.setAttribute("I_BWART",request.getParameter("I_BWART"));
			request.setAttribute("I_LGNUM",request.getParameter("I_LGNUM"));
			request.setAttribute("I_MATNR",request.getParameter("I_MATNR"));
			request.setAttribute("I_VLTYP",request.getParameter("I_VLTYP"));
			request.setAttribute("I_VLBER",request.getParameter("I_VLBER"));
			request.setAttribute("I_VLPLA",request.getParameter("I_VLPLA"));
			request.setAttribute("I_NLTYP",request.getParameter("I_NLTYP"));
			request.setAttribute("I_NLBER",request.getParameter("I_NLBER"));
			request.setAttribute("I_NLPLA",request.getParameter("I_NLPLA"));
			request.setAttribute("I_CHARG",request.getParameter("I_CHARG"));
//			request.setAttribute("LICHA",request.getParameter("LICHA"));
			ricerca(request, response);
		}else if(URL.CONFOT2.equals(pagProv)){
			exe2(request, response);//seconda pagina
		}else if(URL.CONFOT3.equals(pagProv)){
			exe3(request, response);//terza pagina
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		return pagDest;
	}
	
	private void ricerca(HttpServletRequest request, HttpServletResponse response) {
		if("b1".equals(action)){
			pagDest= URL.MENU;
		}else if("b3".equals(action) || action==null){
			try{
				request.getSession().setAttribute(Session.CHECKLIST, null);
				RfcRicercaOT rfc= new RfcRicercaOT();
				
				rfc.setI_TANUM(request.getParameter("I_TANUM"));
				rfc.setI_DATA(request.getParameter("I_DATA"));
				rfc.setI_BWART(request.getParameter("I_BWART"));
				rfc.setI_LGNUM(request.getParameter("I_LGNUM"));
				rfc.setI_MATNR(request.getParameter("I_MATNR"));
				rfc.setI_VLTYP(request.getParameter("I_VLTYP"));
				rfc.setI_VLBER(request.getParameter("I_VLBER"));
				rfc.setI_VLPLA(request.getParameter("I_VLPLA"));
				rfc.setI_NLTYP(request.getParameter("I_NLTYP"));
				rfc.setI_NLBER(request.getParameter("I_NLBER"));
				rfc.setI_NLPLA(request.getParameter("I_NLPLA"));
				rfc.setI_CHARG(request.getParameter("I_CHARG"));
				//rfc.setLICHA(request.getParameter("LICHA"));
				//rfc.setI_J_3ASIZE(request.getParameter("I_J_3ASIZE"));
				rfc.execute();
				request.getSession().setAttribute(Session.LISTAOT,rfc.getTrasOT());
				esito=rfc.getEsito();
				msg=rfc.getMsg();
				if(rfc.getTrasOT().size()>1)
					pagDest=URL.CONFOT2;
				else if(rfc.getTrasOT().size()==1){
					request.setAttribute("dettaglio", 0);
					pagDest=URL.CONFOT3;
				}
				if(!SapRfc.Error.equals(esito))
						esito="dc";
				else
					pagDest=URL.CONFOT;
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.CONFOT;
			}
		}
		

	}
	
	private void exe2(HttpServletRequest request, HttpServletResponse response){
		if("b1".equals(action)){
			pagDest=URL.CONFOT;
		}else if("b2".equals(action)){
			conferma(request, response);
			//pagDest=URL.CONFOT2;
		}else if("b3".equals(action) || action == null){
			dettaglio(request, response);	
		}
	} 
	private void conferma(HttpServletRequest request, HttpServletResponse response){
		try{
			ArrayList<ConfermaOTBean> tob=(ArrayList<ConfermaOTBean>)request.getSession().getAttribute(Session.LISTAOT);

			RfcConfermaOT rfc=new RfcConfermaOT();
			rfc.setTrasOT(tob);
			rfc.setTutti(Boolean.parseBoolean(request.getParameter("tutti")));
			rfc.execute();
			esito=rfc.getEsito();
			tob=rfc.getTrasOT();
			msg=rfc.getMsg();
			if(rfc.isEsitoOK() || rfc.isEsitoInfo()){
				pagDest=URL.CONFOT2;	
//				remove(tob,listcheck);
				msg="OT Confermato correttamente";
			}
			if(tob==null || tob.isEmpty()){
				pagDest=URL.CONFOT;
			}
			request.getSession().setAttribute(Session.LISTAOT,tob);

		}catch(Exception e){
			e.printStackTrace();
			msg=e.getLocalizedMessage();
			esito=SapRfc.Error;
		}
		
	}
	/**
	 * semplicemente conferma del singolo elemento e INDIETRO
	 */
	private void exe3(HttpServletRequest request, HttpServletResponse response){
		Integer row=new Integer(request.getParameter("dettaglio"));
		request.setAttribute("dettaglio",row);
		if("b1".equals(action)){ // si torna indietro 
			ArrayList<ConfermaOTBean> list=(ArrayList<ConfermaOTBean>) request.getSession().getAttribute(Session.LISTAOT);
			if(list.size()==1){
				pagDest=URL.CONFOT;
			}else{
				Map<Integer, String> map=(Map<Integer, String>) request.getSession().getAttribute(Session.CHECKLIST);
				map.clear();
				request.getSession().setAttribute(Session.CHECKLIST, map);
				pagDest=URL.CONFOT2;
			}
			
		}else if("b2".equals(action)){// nessuna azione
			pagDest=URL.CONFOT3;
		}else if("b3".equals(action)  || action == null){
			try {//conferma di un singolo elemento
				ArrayList<ConfermaOTBean> list=(ArrayList<ConfermaOTBean>) request.getSession().getAttribute(Session.LISTAOT);
				RfcConfermaOT rfc=new RfcConfermaOT();
				rfc.setTrasOT(list);
				rfc.setRow(row);
				rfc.execute();
				if(rfc.isEsitoOK()){
					if(list.size()>1)
						pagDest=URL.CONFOT2;
					else
						pagDest=URL.CONFOT;
					remove(list,row);
				}else{
					pagDest=URL.CONFOT3;
				}
				esito=rfc.getEsito();
				msg=rfc.getMsg();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pagDest=URL.CONFOT3;
			}
			
			
		}
	} 
	/**
	 * riceve dalla sessione la lista dei check e setta "dettaglio" ovvero la posizione del primo elemento checkato
	 * @param request
	 * @param response
	 */
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		Map<Integer, String> check =(Map<Integer, String>)request.getSession().getAttribute(Session.CHECKLIST);
//		ArrayList<ConfermaOTBean> tob=(ArrayList<ConfermaOTBean>)request.getSession().getAttribute(Session.LISTAOT);
		if(check!=null && !check.isEmpty()){
			Iterator<Integer> i=check.keySet().iterator();
			Integer det=0;
			Boolean v=false;
			while(i.hasNext() && !v){
				Integer k=i.next();
				v =Boolean.parseBoolean(check.get(k)); 
				if(v)
					det=k;
			}
			pagDest=URL.CONFOT3;
			request.setAttribute("dettaglio", det);
		}else{
			pagDest=URL.CONFOT2;
		}
		
	}
	
	
	public void remove(ArrayList<ConfermaOTBean> list,ArrayList<Integer> remove){
		for(int i=0; i<remove.size();i++){
			list.remove(remove.get(i).intValue());
		}
	}
	public void remove(ArrayList<ConfermaOTBean> list,Integer remove){
			list.remove(remove);
	}


}
