<%@page import="it.cube.demo.sap.mobile.util.UtilDate"%>
<%@page import="it.cube.demo.sap.mobile.bean.BATCH_list"%>
<%@page import="it.cube.demo.sap.mobile.bean.WBS_list"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovNetworkBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.IT_LISTA_NETWORK"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_MOV_NETWORK"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_ODA"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovimentazioniBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%	
	ArrayList<MovNetworkBean> movList = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
	int pos = (Integer)request.getAttribute("pos");
	MovNetworkBean mov = movList.get(pos);
	
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	String I_EBELN = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_MOV_NETWORK.EBELN));
	String I_EBELP = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_MOV_NETWORK.EBELP));
	
%>
<%

ArrayList<WBS_list> wbs_list = (request.getSession().getAttribute("wbs_list") != null ? (ArrayList<WBS_list>) request.getSession().getAttribute("wbs_list") : null);

if (wbs_list != null && wbs_list.size() > 1) {
%>
	<div class="modal fade" tabindex="-1" id="modalWBS" data-enabled="<%=wbs_list != null && wbs_list.size() > 1 %>" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title text-center text-primary">Selezionare WBS</h4>
				</div>
				<div class="modal-body">
					<%
						if (wbs_list != null)
							for(int i=0; i < wbs_list.size(); i++) {
								WBS_list wbs = wbs_list.get(i);
								String POSID = wbs.getPOSID();
					%>
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block setWbs" data-pos="<%=i%>" data-posid="<%=POSID %>">								
						<i class="glyphicon glyphicon-share-alt" aria-hidden="true"></i>&nbsp;<%=POSID%>
					</button>
						<%} %>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block" data-dismiss="modal" >Chiudi</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
 <%} %> 
 
 <%
ArrayList<BATCH_list> batch_list = (request.getSession().getAttribute("batch_list") != null ? (ArrayList<BATCH_list>) request.getSession().getAttribute("batch_list") : null);
if (batch_list != null && batch_list.size() > 1) {
%>
	<div class="modal fade" tabindex="-1" id="modalBATCH" data-enabled="<%=batch_list != null && batch_list.size() > 1 %>" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title text-center text-primary">Selezionare Partita</h4>
				</div>
				<div class="modal-body">
						<div class="row">
				    		<div class="text-center intestazioneBatch">
				    		Partita
				    		</div>
				    		<div class="text-center intestazioneBatch">
				    		Lotto
				    		</div>
				    		<div class="text-center intestazioneBatch">
				    		Data
				    		</div>
				    	</div>
					<%
						if (batch_list != null)
							for(int i=0; i < batch_list.size(); i++) {
								BATCH_list batch = batch_list.get(i);
								String CHARG = batch.getCHARG();
								String LICHA = batch.getLICHA();
								String VFDAT = batch.getVFDAT();
					%>
					    
				    <button type="button" 
				    	class="btn btn-lg btn-outline-secondary btn-block setBATCH" 
				    	data-pos="<%=i%>" 
				    	data-charg="<%=CHARG %>"
				    	data-licha="<%=LICHA %>"
				    	data-vfdat="<%=VFDAT %>">
				    	<div class="row modalBatch">
				    		<div>
				    		<i class="glyphicon glyphicon-share-alt" aria-hidden="true"></i>&nbsp; <b><%=CHARG %></b>
				    		</div>
				    		<div>
				    		<%=LICHA %>
				    		</div>
				    		<div>
				    		<%=UtilString.removeNull(UtilDate.reverseDateFormat(VFDAT, "-")) %>
				    		</div>
				    	</div>
					</button>
					
						<%} %>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block" data-dismiss="modal" >Chiudi</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
 <%} %> 
<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl" class="formCheckBatch">

					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_541 %>"/>
					<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZFMWM_GET_MOV_NETWORK.BWART %>" value="541"/>		
					
					<input type="hidden" name="<%=ZSWM_MOVIMENTAZIONI.EBELN %>" value="<%=UtilString.removeNull(mov.getEBELN()) %>"/>
					<input type="hidden" name="<%=ZSWM_MOVIMENTAZIONI.EBELP %>" value="<%=UtilString.removeNull(mov.getEBELP()) %>"/>
					
					<input type="hidden" name="<%=ZSWM_MOVIMENTAZIONI.WERKS %>" value="<%=UtilString.removeNull(mov.getWERKS()) %>"/>
					
					<input type="hidden" name="<%=ZSWM_MOVIMENTAZIONI.RSNUM %>" value="<%=mov.getRSNUM()%>"/>
					<input type="hidden" name="<%=ZSWM_MOVIMENTAZIONI.RSPOS %>" value="<%=mov.getRSPOS()%>"/>
					<input type="hidden" name="pos" id="pos" value="<%=pos%>"/>
					<!-- 
					<input type="hidden" name="checkPartita" value="<%=!mov.getIS_GEST_PARTITA().isEmpty()%>"/>
					 -->
					 
					<input type="hidden" name="IS_GEST_PARTITA" value="<%=!mov.getIS_GEST_PARTITA().isEmpty()%>"/>
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimentazione 541</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MATNR%>">Codice Materiale</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.MATNR%>" name="<%=ZSWM_MOVIMENTAZIONI.MATNR%>" value="<%=UtilString.removeNull(mov.getMATNR())%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=IT_LISTA_NETWORK.MAKTX%>">Descrizione Materiale</label>
	    					<input type="text" class="form-control input-lg" id="<%=IT_LISTA_NETWORK.MAKTX%>" name="<%=IT_LISTA_NETWORK.MAKTX%>" value="<%=UtilString.removeNull(mov.getMAKTX())%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MENGE %>">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" name="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" value="<%=UtilString.removeNull(mov.getBDMNG())%>" maxlength="13" required/>
						</div>
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MEINS %>">Unit&agrave;</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.MEINS %>" name="<%=ZSWM_MOVIMENTAZIONI.MEINS %>" value="<%=UtilString.removeNull(mov.getMEINS())%>" maxlength="13" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGORT %>">Magazzino</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" name="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" value="<%=UtilString.removeNull(mov.getLGORT())%>" maxlength="4" required/>
						</div>
						
						<!-- UBICAZIONE - Start -->
						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-4 col-sm-4 col-xs-4">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Tipo" id="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" name="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" value="<%=UtilString.removeNull(mov.getLGTYP())%>"/>
	    					<!-- <input class="form-control input-lg" id="scanner"> -->
						</div>
						<input type="hidden" name="LGNUM" id="LGNUM">
						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="VLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="VLBER" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Area" id="VLBER" name="VLBER"/>
						</div>

						<div class="form-group col-md-5 col-sm-5 col-xs-5">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Ubicazione" id="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" name="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" value="<%=UtilString.removeNull(mov.getLGPLA())%>"/>
	    				</div>
						<!-- UBICAZIONE - End -->
						
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.CHARG %>">Partita</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" name="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" value="<%=UtilString.removeNull(mov.getCHARG())%>" <%=mov.getIS_GEST_PARTITA().isEmpty() ? "readonly" : "required" %>/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LICHA %>">Lotto</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" name="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" value="<%=UtilString.removeNull(mov.getLICHA())%>" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=IT_LISTA_NETWORK.POSID %>">WBS di Partenza</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.PS_PSP_PNR %>" name="<%=ZSWM_MOVIMENTAZIONI.PS_PSP_PNR %>" value="<%=UtilString.removeNull(mov.getPOSID())%>" maxlength="24" required/>
						</div>
						
					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="reset" class="btn btn-lg btn-outline-info btn-block goToReset">Reset</button>
						<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3" >Registra</button>
					</p>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
