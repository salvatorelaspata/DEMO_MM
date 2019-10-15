package it.cube.demo.sap.mobile.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.cube.demo.sap.mobile.Interface.ActionInterface;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MovimentazioniBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE;
import it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI;
import it.cube.demo.sap.mobile.rfc.RfcMovimentazioni;

public class Mov201Action implements ActionInterface, Constants{
	private String pagProv=null, pagDest=URL.MENU,msg=null,esito=null;//azione=null;
	String ip=null;
	private String action=""; 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		action=request.getParameter("action");
		pagProv=request.getParameter(Constants.PagProvenienza);
		if(URL.MOV_201.equals(pagProv)){
			request.setAttribute(ZSWM_MOVIMENTAZIONI.MENGE,request.getParameter(ZSWM_MOVIMENTAZIONI.MENGE));//10
			request.setAttribute(ZSWM_MOVIMENTAZIONI.MATNR,request.getParameter(ZSWM_MOVIMENTAZIONI.MATNR));//5
			request.setAttribute(ZSWM_MOVIMENTAZIONI.WERKS,request.getParameter(ZSWM_MOVIMENTAZIONI.WERKS));//10
			request.setAttribute(ZSWM_MOVIMENTAZIONI.LGORT,request.getParameter(ZSWM_MOVIMENTAZIONI.LGORT));//5
			request.setAttribute(ZSWM_MOVIMENTAZIONI.KOSTL,request.getParameter(ZSWM_MOVIMENTAZIONI.KOSTL));//10
			request.setAttribute(ZSWM_MOVIMENTAZIONI.CHARG,request.getParameter(ZSWM_MOVIMENTAZIONI.CHARG));//5
			request.setAttribute(ZSWM_MOVIMENTAZIONI.LGNUM,request.getParameter(ZSWM_MOVIMENTAZIONI.LGNUM));//16
			request.setAttribute(ZSWM_MOVIMENTAZIONI.LGTYP,request.getParameter(ZSWM_MOVIMENTAZIONI.LGTYP));//8
			request.setAttribute(ZSWM_MOVIMENTAZIONI.LGPLA,request.getParameter(ZSWM_MOVIMENTAZIONI.LGPLA));//8
			request.setAttribute(ZSWM_MOVIMENTAZIONI.NOTE,request.getParameter(ZSWM_MOVIMENTAZIONI.NOTE));//8
			ricercaEconferma(request, response);
		}else {
			pagDest=URL.MENU;
		}
		request.setAttribute(Show,esito);
		request.setAttribute(ErrorMessage, msg);
		return pagDest;
	}
	
	private void ricercaEconferma(HttpServletRequest request, HttpServletResponse response) {
		if("b1".equals(action)){
			pagDest= URL.MENU;
		}else if("b3".equals(action) || action==null){
			try{
				MovimentazioniBean movimentazione=new MovimentazioniBean(request);
				RfcMovimentazioni rfc= new RfcMovimentazioni();
				rfc.setMovimentazione(movimentazione);
				rfc.setI_CHECK("X");
				DatiUtente du = (DatiUtente)request.getSession().getAttribute(Constants.DATIUTENTE);
				rfc.setI_USERID(du.getUser());
				rfc.execute();
				
				
				if(rfc.isEsitoOK()){
					rfc.setI_CHECK("");
					rfc.execute();
					if(rfc.isEsitoOK()){
						esito=Success;
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_MAT_DOC, rfc.getI_MAT_DOC());
						request.setAttribute(ZFMWM_CREA_MOVIMENTAZIONE.I_DOC_YEAR, rfc.getI_DOC_YEAR());
						rfc.setMsg("Creato Doc. Materiale "+ rfc.getI_MAT_DOC()+" \\ "+rfc.getI_DOC_YEAR());
					}
				}
				
				pagDest=URL.MOV_201;
				esito=rfc.getEsito();
				msg=rfc.getMsg();
			}catch(Exception e){
				esito="E";
				msg=e.getLocalizedMessage();
				e.printStackTrace();
				pagDest=URL.MOV_201;
			}
		}
		

	}
}
