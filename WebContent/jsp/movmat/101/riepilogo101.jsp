<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_ODA"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovimentazioniBean"%>
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
	ArrayList<MovimentazioniBean> lista = (ArrayList<MovimentazioniBean>) request.getSession().getAttribute(Session.LISTAMOV);
	
	String I_EBELN = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_ODA.I_EBELN));
	String I_EBELP = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_ODA.I_EBELP));
	
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
						<input type="hidden" name="<%=Constants.PagProvenienza%>" id="<%=Constants.PagProvenienza%>"  value="<%=Constants.URL.MOV_RIEPILOGO_101%>"/>					
						<input type="hidden" id="maxRow" name="maxRow" value="<%=lista.size()%>"/>
						<input type="hidden" name="action" id="action" value=""/>
						<input type="hidden" name="host" id="host" value="<%=Host.Url() %>"/>
						<input type="hidden" name="<%=ZFMWM_GET_ODA.I_EBELN %>" value="<%=I_EBELN %>"/>
						<input type="hidden" name="<%=ZFMWM_GET_ODA.I_EBELP %>" value="<%=I_EBELP %>"/>
	
					<div class="row">
						<div class="page-header <%=headerMarginBottomReset%>">
							<h4 class="text-center text-primary"><b>Lista Movimentazione 101</b></h4>
						</div>
					</div>
					
					<%
					if (lista.size() == 0) {
					%>
						<div class="row">
							<p class="text-center text-muted"> Nessuna Movimentazione 101 trovata.</p>
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
						MovimentazioniBean tob = lista.get(i);
						String MATNR = tob.getMATNR();// materiale
						String EBELP = tob.getEBELP();// posizione
						String EBELN = tob.getEBELN();//numero
						String MENGE = tob.getMENGE();//quantita
						String MEINS = tob.getMEINS();//um
						String LGORT = tob.getLGORT();//magazzino
					%>
	
						<li class="list-group-item noUpdate">
							<div class="row">
								<div class="col-md-10 col-sm-10 col-xs-10">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<p class="list-group-item-heading"><b class="text-muted">Codice Materiale: </b><%=tob.getMATNR() != null ? tob.getMATNR() : "N/D" %></p>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<p><span class="pull-right"><b class="text-muted">Posizione: </b><span><%=tob.getEBELP() != null ? tob.getEBELP() : "N/D" %></span></span></p>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="row">
												<div class="col-md-6 col-sm-6 col-xs-6">
													<p><span class="pull-left"><b class="text-muted">Quantit&agrave;: </b><span><%=tob.getMENGE() != null ? tob.getMENGE() : "N/D" %></span></span></p>
												</div>
												<div class="col-md-6 col-sm-6 col-xs-6">
													<p><span class="pull-right"><b class="text-muted">Unit&agrave;: </b><span><%=tob.getMEINS() != null ? tob.getMEINS() : "N/D" %></span></span></p>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-2">
									<p class="text-right">
										<button type="button" class="btn btn-link goTo" data-hidden="action" data-href='pos_<%=i%>'>
											<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
										</button>
									</p>
								</div>
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
					</p>
				</div>
				
			</div>
		</div>
	
	</div>
</form>

<%@include file="../../include/_footer.jsp"%>
		
