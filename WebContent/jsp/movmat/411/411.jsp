<%@page import="it.cube.demo.sap.mobile.util.UtilDate"%>
<%@page import="it.cube.demo.sap.mobile.bean.BATCH_list"%>
<%@page import="it.cube.demo.sap.mobile.bean.WBS_list"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%

	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

	String MENGE = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.MENGE));
	String MATNR = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.MATNR));
	String LGORT = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.LGORT));
	String WERKS = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.WERKS));
	String CHARG = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.CHARG));
	String LGNUM = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.LGNUM));
	String LGTYP = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.LGTYP));
	String LGPLA = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.LGPLA));
	String LICHA = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.LICHA));
	String PS_PSP_PNR = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.PS_PSP_PNR));
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
								String CHARG_I = batch.getCHARG();
								String LICHA_I = batch.getLICHA();
								String VFDAT_I = batch.getVFDAT();
					%>
					    
				    <button type="button" 
				    	class="btn btn-lg btn-outline-secondary btn-block setBATCH" 
				    	data-pos="<%=i%>" 
				    	data-charg="<%=CHARG_I %>"
				    	data-licha="<%=LICHA_I %>"
				    	data-vfdat="<%=VFDAT_I %>">
				    	<div class="row modalBatch">
				    		<div>
				    		<i class="glyphicon glyphicon-share-alt" aria-hidden="true"></i>&nbsp; <b><%=CHARG_I %></b>
				    		</div>
				    		<div>
				    		<%=LICHA_I %>
				    		</div>
				    		<div>
				    		<%=UtilString.removeNull(UtilDate.reverseDateFormat(VFDAT_I, "-")) %>
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
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_411 %>"/>
					<input type="hidden" class="l10 span text" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZSWM_MOVIMENTAZIONI.BWART %>" value="411"/>
					<input type="hidden" class="l10 span text" id="<%=ZSWM_MOVIMENTAZIONI.SOBKZ %>" name="<%=ZSWM_MOVIMENTAZIONI.SOBKZ %>" value="Q"/>	
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimentazione 411</b></h4>	
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MATNR %>">Materiale</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" placeholder="Materiale" id="<%=ZSWM_MOVIMENTAZIONI.MATNR %>" name="<%=ZSWM_MOVIMENTAZIONI.MATNR %>" maxlength="18" value="<%=MATNR %>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.WERKS %>">Divisione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Divisione" id="<%=ZSWM_MOVIMENTAZIONI.WERKS %>" name="<%=ZSWM_MOVIMENTAZIONI.WERKS %>" maxlength="4" value="<%=UtilString.removeNull(WERKS).length()>0 ? WERKS:Constants.CWERKS%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MENGE %>">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" placeholder="Quantit&agrave;" id="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" name="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" maxlength="16" value="<%=MENGE%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGORT %>">Magazzino</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" placeholder="Magazzino" id="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" name="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" maxlength="4" value="<%=LGORT%>" required/>
						</div>

						<!-- UBICAZIONE - Start -->
						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-4 col-sm-4 col-xs-4">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Tipo" id="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" name="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" value="<%=UtilString.removeNull(LGTYP)%>"/>
	    					<!-- <input class="form-control input-lg" id="scanner"> -->
						</div>
						<input type="hidden" name="LGNUM" id="LGNUM">
						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="VLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="VLBER" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Area" id="VLBER" name="VLBER"/>
						</div>

						<div class="form-group col-md-5 col-sm-5 col-xs-5">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Ubicazione" id="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" name="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" value="<%=UtilString.removeNull(LGPLA)%>"/>
	    				</div>
						<!-- UBICAZIONE - End -->

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.CHARG %>">Partita</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" id="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" name="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" maxlength="10" value="<%=UtilString.removeNull(CHARG)%>" <%="true".equals(request.getAttribute("IS_GEST_PARTITA")) || request.getAttribute("IS_GEST_PARTITA") == null ? "required" : "readonly" %>/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LICHA %>">Lotto</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" id="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" name="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" value="<%=UtilString.removeNull(LICHA)%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.PS_PSP_PNR %>">WBS di Partenza</label>
	    					<input type="text" class="form-control input-lg cleanOnReset" id="<%=ZSWM_MOVIMENTAZIONI.PS_PSP_PNR %>" name="<%=ZSWM_MOVIMENTAZIONI.PS_PSP_PNR %>" value="<%=UtilString.removeNull(PS_PSP_PNR)%>" maxlength="24" required/>
						</div>
					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="reset" id="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Registra</button>
					</p>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
