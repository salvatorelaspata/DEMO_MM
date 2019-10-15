<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../include/_header.jsp"%>

<%
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	ArrayList<ConfermaOTBean> listOT = (ArrayList<ConfermaOTBean>) request.getSession().getAttribute(Session.LISTAOT);
	String panelBodyPaddingReset = listOT.size() > 0 ? "pb0" : "";
	String headerMarginBottomReset = listOT.size() > 0 ? "mb0" : "";
%>

<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body <%=panelBodyPaddingReset%>">

				<form id="form" name="form" method="post" action="MainUrl">          
					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.CONFOT2%>"/>
				</form>

				<div class="row">
					<div class="page-header <%=headerMarginBottomReset%>">
						<h4 class="text-center text-primary"><b>Lista Ordini Trasferimento</b></h4>
					</div>
				</div>

				<%
				if (listOT.size() == 0) {
				%>
					<div class="row">
						<p class="text-center text-muted"> Nessun Ordine di Trasferimento trovato.</p>
					</div>
				<%
				}
				%>
			</div>
			<%
			if (listOT.size() > 0) {
			%>
			<ul class="list-group">
				<%
				for (int i = 0; i < listOT.size(); i++) {
					ConfermaOTBean tob = listOT.get(i);
				%>
				<li class="list-group-item" data-hidden="action" data-href="pos_<%=i%>" data-row="<%=i%>">
					<p class="list-group-item-heading"><b class="text-muted">Codice Materiale: </b><%=tob.getMATNR() != null ? tob.getMATNR() : "N/D" %></p>
					<p><b class="text-muted">Codice OT: </b><%=tob.getTANUM() != null ? tob.getTANUM() : "N/D" %></p>
					<p><b class="text-muted">Posizione OT: </b><%=tob.getTAPOS() != null ? tob.getTAPOS() : "N/D" %></p>
					<p class="clearfix mb0">
						<span class="pull-right"><b class="text-muted">Quantit&agrave;: </b><%=tob.getNSOLA() != null ? tob.getNSOLA() : "N/D" %></span>
						<span class="pull-left"><b class="text-muted">Movimento: </b><%=tob.getBWART()!=null && tob.getBWART().trim().length()<=0?"999":tob.getBWART() %></span>
					</p>
				</li>
				<%
				}
				%>
			</ul>
			<%
			} 
			%>

			<div class="panel-body">
				<p class="text-center">
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
					<button type="button" class="btn btn-lg btn-outline-primary btn-block goTo" data-hidden="action" data-href="b2">Conferma</button>
					<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Dettaglio</button>
				</p>
			</div>

		</div>
	</div>

</div>

<%@include file="../include/_footer.jsp"%>