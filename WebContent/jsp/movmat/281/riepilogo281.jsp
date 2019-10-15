<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.IT_LISTA_NETWORK"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovNetworkBean"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovWMBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.MapUrl.Host"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	ArrayList<MovNetworkBean> lista = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
	String RSPOS = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.RSPOS));
	String NPLNR = UtilString.removeNull((String)request.getAttribute(ZSWM_MOVIMENTAZIONI.NPLNR));
	String panelBodyPaddingReset = lista.size() > 0 ? "pb0" : "";
	String headerMarginBottomReset = lista.size() > 0 ? "mb0" : "";
	Boolean isMobile = request.getHeader("User-Agent").indexOf("Mobile") != -1;
%>

<form id="form" name="form" method="post" action="MainUrl">
	<div class="row">
	
		<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
			<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
		</div>
		
		<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
			<div class="panel panel-default">
				<div class="panel-body <%=panelBodyPaddingReset%>">
	
					
						<input type="hidden" name="tutti" id="tutti" value="true"/>
						<input type="hidden" name="<%=Constants.PagProvenienza%>" id="<%=Constants.PagProvenienza%>"  value="<%=Constants.URL.MOV_RIEPILOGO281%>"/>
						<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZSWM_MOVIMENTAZIONI.BWART %>" value="281"/>		
						<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" name="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" size="18" maxlength="10" value="<%=NPLNR%>"/>			
						<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.RSPOS  %>" name="<%=ZSWM_MOVIMENTAZIONI.RSPOS  %>"  maxlength="4" style="font-size: 10px;width: 55px;"value="<%=RSPOS %>"/>					
						<input type="hidden" id="maxRow" name="maxRow" value="<%=lista.size()%>"/>
						<input type="hidden" name="action" id="action" value=""/>
						<input type="hidden" name="host" id="host" value="<%=Host.Url() %>"/>
					
	
					<div class="row">
						<div class="page-header <%=headerMarginBottomReset%>">
							<h4 class="text-center text-primary"><b>Lista Movimentazione 281</b></h4>
						</div>
					</div>
					
					<%
					if (lista.size() == 0) {
					%>
						<div class="row">
							<p class="text-center text-muted"> Nessuna Movimentazione 281 trovata.</p>
						</div>
					<%
					}
					%>
				</div>
				<%
				if (lista.size() > 0) {
				%>
				<ul class="list-group">
					<%
					for(int i=0; i < lista.size(); i++){
						MovNetworkBean tob = lista.get(i);
					%>
	
						<li class="list-group-item noUpdate withModal">
							<div class="row">
							<% if (!isMobile) { %>
								
									
									<div class="col-md-1 col-sm-1 col-xs-1">
										<div class="checkbox">
										    <label>
										    	<input type="checkbox" name="check_<%= i%>" />
											</label>
										</div>
									</div>
									
									<div class="col-md-8 col-sm-8 col-xs-8">
										<p class="list-group-item-heading"><b class="text-muted">Codice Materiale: </b><%=tob.getMATNR() != null ? tob.getMATNR() : "N/D" %></p>
										<p>
											<span class="pull-left pta"><b class="text-muted">Partita: </b><span><%=tob.getCHARG() != null ? tob.getCHARG() : "N/D" %></span></span>
											<span class="pull-right qta"><b class="text-muted">Quantit&agrave;: </b><span><%=tob.getBDMNG() != null ? tob.getBDMNG() : "N/D" %></span></span>
										</p>
									</div>
									
									<div class="col-md-3 col-sm-3 col-xs-3">
										<p>
											<button type="button" class="btn btn-link">
												<span class="glyphicon glyphicon-edit" aria-hidden="true" data-pos="<%=i%>" data-toggle="modal" data-target=".modal" data-pta-v="<%=tob.getCHARG() %>" data-pta="<%=IT_LISTA_NETWORK.CHARG+"_"+i%>" data-qta-v="<%=tob.getBDMNG() %>" data-qta="<%=IT_LISTA_NETWORK.BDMNG+"_"+i %>" data-idx="<%=i%>"></span>
											</button>
											<button type="button" class="btn btn-link goTo" data-hidden="action" data-href='pos_<%=i%>'>
												<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
											</button>
										</p>
									</div>
								
							<%} else { %>
								<div class="col-sm-1 col-xs-1">
									<div class="checkbox">
									    <label>
									    	<input type="checkbox" name="check_<%= i%>" />
										</label>
									</div>
								</div>
								
								<div class="col-sm-11 col-xs-11">
									<div class="row">
										<div class="col-sm-12 col-xs-12">
											<p class="list-group-item-heading"><b class="text-muted">Codice Materiale: </b><%=tob.getMATNR() != null ? tob.getMATNR() : "N/D" %></p>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-6 col-xs-6">
											<div class="row">
												<div class="col-sm-12 col-xs-12">
													<p><span class="pull-left pta"><b class="text-muted">Partita: </b><span><%=tob.getCHARG() != null ? tob.getCHARG() : "N/D" %></span></span></p>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12 col-xs-12">
													<p><span class="pull-left qta"><b class="text-muted">Quantit&agrave;: </b><span><%=tob.getBDMNG() != null ? tob.getBDMNG() : "N/D" %></span></span></p>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-xs-6">
											<p class="text-right">
												<button type="button" class="btn btn-link">
												<span class="glyphicon glyphicon-edit" aria-hidden="true" data-pos="<%=i%>" data-toggle="modal" data-target=".modal" 
												data-numero-v="<%=tob.getLGNUM() %>" data-numero="<%=IT_LISTA_NETWORK.LGNUM+"_"+i%>" 
												data-ubicazione-v="<%=tob.getLGPLA() %>" data-uicazione="<%=IT_LISTA_NETWORK.LGPLA+"_"+i%>" 
												data-tipo-v="<%=tob.getLGTYP()%>" data-tipo="<%=IT_LISTA_NETWORK.LGTYP+"_"+i%>" 
												data-pta-v="<%=tob.getCHARG() %>" data-pta="<%=IT_LISTA_NETWORK.CHARG+"_"+i%>" 
												data-qta-v="<%=tob.getBDMNG() %>" data-qta="<%=IT_LISTA_NETWORK.BDMNG+"_"+i %>" 
												data-idx="<%=i%>"></span>
											</button>
												<button type="button" class="btn btn-link goTo" data-hidden="action" data-href='pos_<%=i%>'>
													<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
												</button>
												
											</p>
										</div>
									</div>
								</div>
							<%} %>
							
							</div>
						</li>
						
					<%} %>		
				
				</ul>
				<%
				}
				%>
	
				<div class="panel-body">
					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Salva</button>
					</p>
				</div>
				
			</div>
		</div>
	
	</div>
</form>

<%@include file="../../include/_modaleNetWork.jsp"%>
<%@include file="../../include/_footer.jsp"%>
		
