<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_MOV_NETWORK"%>
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
	ArrayList<MovNetworkBean> lista = (ArrayList<MovNetworkBean>) request.getSession().getAttribute(Session.LISTAMOV);
	
	String I_AUFNR = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_MOV_NETWORK.AUFNR));
	String I_BWART = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_MOV_NETWORK.BWART));
	
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
						<input type="hidden" name="<%=Constants.PagProvenienza%>" id="<%=Constants.PagProvenienza%>"  value="<%=Constants.URL.MOV_RIEPILOGO_261%>"/>					
						<input type="hidden" id="maxRow" name="maxRow" value="<%=lista.size()%>"/>
						<input type="hidden" name="action" id="action" value=""/>
						<input type="hidden" name="host" id="host" value="<%=Host.Url() %>"/>
						<input type="hidden" name="<%=ZFMWM_GET_MOV_NETWORK.AUFNR %>" value="<%=I_AUFNR %>"/>
						<input type="hidden" name="<%=ZFMWM_GET_MOV_NETWORK.BWART %>" value="<%=I_BWART %>"/>
	
					<div class="row">
						<div class="page-header <%=headerMarginBottomReset%>">
							<h4 class="text-center text-primary"><b>Lista Movimentazione 261</b></h4>
						</div>
					</div>
					
					<%
					if (lista.size() == 0) {
					%>
						<div class="row">
							<p class="text-center text-muted"> Nessuna Movimentazione 261 trovata.</p>
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
						MovNetworkBean bean = lista.get(i);
						String MATNR = bean.getMATNR(); // materiale
						String BDMNG = bean.getBDMNG(); //Quantità fabbisogno
						String MEINS = bean.getMEINS(); //UM
					%>
	
						<li class="list-group-item noUpdate">
							<div class="row fullHeightContentRow">
								<div class="col-md-10 col-sm-10 col-xs-10">
									<div class="row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<b class="text-muted">Codice Materiale: </b>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<p class="list-group-item-heading"><%=bean.getMATNR() != null ? bean.getMATNR() : "N/D" %></p>
										</div>
									</div>
									<div class="row">	
										<div class="col-md-6 col-sm-6 col-xs-6">
											<b class="text-muted">Quantit&agrave;: </b>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<p class="list-group-item-heading"><%=bean.getBDMNG() != null ? bean.getBDMNG() : "N/D" %></p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-sm-6 col-xs-6">
											<b class="text-muted">Unit&agrave; di misura: </b>
										</div>
										<div class="col-md-6 col-sm-6 col-xs-6">
											<p class="list-group-item-heading"><%=bean.getMEINS() != null ? bean.getMEINS() : "N/D" %></p>
										</div>
									</div>
								</div>
								<div class="col-md-2 col-sm-2 col-xs-2 centeredBtnAction">
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
		
