package it.cube.demo.sap.mobile.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.DefaultTVal;
import it.cube.demo.sap.mobile.bean.MovWMBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.SapRfc;
import it.cube.demo.sap.mobile.rfc.RfcCreaMov;


public class NewTrasferimentiAction implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null,
	urlMov,urlRiepilogo,urlDettaglio;
	String ip=null;
	private String action="",tipoMov; 
	// i movimenti sono formati solitamente da Prima pagina(inserimento dati),Dettagli Mov,Rieplilogo coda movimenti, 
	//tutti finiscono con il nome della cartella in cui sono contenuti, utilizzo questo per valorizzare la pagina destinazione
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(PagProvenienza);
		
		tipoMov=request.getParameter("movimentazione");

		urlMov= URL.MOVMAT+"/"+tipoMov+"/"+tipoMov+".jsp";
		urlRiepilogo= URL.MOVMAT+"/"+tipoMov+"/"+URL.RIEPILOGO+".jsp";
		urlDettaglio= URL.MOVMAT+"/"+tipoMov+"/"+URL.DETTAGLIO+".jsp";
		
		if(action!=null && action.indexOf(".jsp")!=-1){
			if(pagProv!=null && pagProv.indexOf("default")>-1){
				DefaultTVal dtv= new DefaultTVal();
				dtv.setFromRequest(request);
				request.getSession().setAttribute(Session.DEFAULT, dtv);
			}
			pagDest=action;
		}else if(urlMov.equals(pagProv)){
			exeMov(request, response);
		}else if(urlRiepilogo.equals(pagProv)){
			exeRiepilogo(request, response);
		}else if(urlDettaglio.equals(pagProv)){
			pagDest=urlRiepilogo;
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);

		return pagDest;
	}
	public void exeMov(HttpServletRequest request, HttpServletResponse response){
		if("b1".equals(action)){
			pagDest= urlRiepilogo;
		}else if("b3".equals(action)){
			creaMov(request, response);
		}else if("b2".equalsIgnoreCase(action)){
			accodaMov(request,response);
		}	
	}
	public void exeRiepilogo(HttpServletRequest request, HttpServletResponse response){
		if("b1".equals(action)){//cancella
			annulla(request, response);
		}else if("b2".equals(action)){//conferma creazione mov
			confermaMov(request, response);
		}else if("b3".equals(action)){//dettaglio
			dettaglio(request, response);
		}	
	}	
//****************************************************************************************************
	/**
	 * crea un movimento
	 * @param request
	 * @param response
	 */
	public void creaMov(HttpServletRequest request, HttpServletResponse response){
		MovWMBean mov=new MovWMBean(request);
		try{			
			RfcCreaMov rfc= new RfcCreaMov(tipoMov);
			ArrayList<MovWMBean> singoloMovimento = new ArrayList<MovWMBean>();
			singoloMovimento.add(mov);
			rfc.setI_CHECK("");//non effettuo il controllo sap
			rfc.setListaMov(singoloMovimento);
			rfc.execute();
			esito=rfc.getEsito();
			msg=rfc.getMsg();
			pagDest=urlMov;
		}catch(Exception e){
			esito=SapRfc.Error;
			msg=e.getLocalizedMessage();
		}
		//mov.updateRequestAttribute(request);//ripasso tutti gli attributi alla request
	}
	/**
	 * accoda i movimenti ad una lista
	 * @param request
	 * @param response
	 */
	public void accodaMov(HttpServletRequest request, HttpServletResponse response){
		MovWMBean mov=new MovWMBean(request);
		
		@SuppressWarnings("unchecked")
		ArrayList<MovWMBean> listaMov = (ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);//lista movimenti, se è vuota la inizializzo
		if(listaMov==null)
			listaMov= new ArrayList<MovWMBean>(0);
		
		try{
			RfcCreaMov rfc= new RfcCreaMov(tipoMov);
			ArrayList<MovWMBean> singoloMovimento = new ArrayList<MovWMBean>();
			singoloMovimento.add(mov);
			rfc.setI_CHECK("X");
			rfc.setListaMov(singoloMovimento);
			rfc.execute();
			esito=rfc.getEsito();
			msg=rfc.getMsg();
			pagDest=urlMov;
		}catch(Exception e){
			esito="E";
			msg=e.getLocalizedMessage();
		}
		if(!"E".equals(esito)){//se non è negativo,accodo il movimento alla listMov
			
			listaMov.add(mov);
			request.setAttribute("riepilogo","true");//dato che è stato aggiunto un elemento alla lista ora viene sostituito il tasto crea movimenti con Riepilogo
			request.getSession().setAttribute(Session.LISTAMOV, listaMov);
		}else{
			mov.updateRequestAttribute(request);//ripasso tutti gli attributi alla request

		}
		System.out.println("ListaMov Aggiornata Size= "+(listaMov!=null?listaMov.size():"0"));
	}
	
	private void annulla(HttpServletRequest request, HttpServletResponse response){
		try{
			@SuppressWarnings("unchecked")
			ArrayList<MovWMBean> listaMov=(ArrayList<MovWMBean>) request.getSession().getAttribute(Session.LISTAMOV);
			if(!listaMov.isEmpty()){
				boolean cancellaTutto=true;
				for(int i=0;i<listaMov.size();i++){
					MovWMBean mov=listaMov.get(i);
					if(mov.checked){
						listaMov.remove(i);
						cancellaTutto=false;
					}
				}
				if(cancellaTutto){
					listaMov.clear();
				}
			}
			if(listaMov.isEmpty())
				pagDest=urlMov;
			else
				pagDest=urlRiepilogo;
			msg="Movimenti annullati corretamente";
			esito=SapRfc.Success;
			//request.getSession().setAttribute(Session.LISTAMOV, listaMov);
		}catch(Exception e){
			e.printStackTrace();
			msg=e.getLocalizedMessage();
			esito=SapRfc.Error;
		}
		
	}

	/**
	 *  conferma tutti i movimenti creati
	 * @param request
	 * @param response
	 */
	private void confermaMov(HttpServletRequest request, HttpServletResponse response){
		try{
			@SuppressWarnings("unchecked")
			ArrayList<MovWMBean> listamov=(ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);
			RfcCreaMov rfc=new RfcCreaMov(tipoMov);
			rfc.setListaMov(listamov);
			rfc.execute();
			esito=rfc.getEsito();
			msg=rfc.getMsg();
			if(rfc.isEsitoOK()){
			//	msg="Lista Movimenti Confermata";
				pagDest=urlMov;	
				listamov.clear();
			}else if(rfc.isEsitoInfo()){
				pagDest=urlRiepilogo;	
			}else{
				pagDest=urlRiepilogo;
			}
		}catch(Exception e){
			e.printStackTrace();
			msg=e.getLocalizedMessage();
			esito=SapRfc.Error;
		}
		
	}
	
	/**
	 * preleva il primo elemento selezionato e ne visualizza il dettaglio, impossibile visualizzare più elementi contemporaneamente
	 * @param request
	 * @param response
	 */
	private void dettaglio(HttpServletRequest request, HttpServletResponse response){
		@SuppressWarnings("unchecked")
		ArrayList<MovWMBean> listaMov=(ArrayList<MovWMBean>)request.getSession().getAttribute(Session.LISTAMOV);
		MovWMBean mov=null;
		if(listaMov!=null && !listaMov.isEmpty()){
			Integer i=-1;
			do{
				i++;
				mov=listaMov.get(i);		
			}while(!mov.checked && i<listaMov.size());
			pagDest=urlDettaglio;
			mov.checked=false;
			request.setAttribute("dettaglio",i);
			mov.updateRequestAttribute(request);
		}
		
	}
	

}
