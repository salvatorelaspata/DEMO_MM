<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.MapUrl.Host"%>
<%@page import="it.cube.demo.sap.mobile.bean.MaterialeBean"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../include/_header.jsp"%>

<%	
ArrayList<MaterialeBean> listOT = (ArrayList<MaterialeBean>)request.getSession().getAttribute(Session.LISTAMAT);
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
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.ELENCOMATERIALI %>"/>
					<input type="hidden" name="host" id="host" value="<%=Host.Url() %>"/>
				</form>

				<div class="row">
					<div class="page-header <%=headerMarginBottomReset%>">
						<h4 class="text-center text-primary"><b>Elenco Ubicazioni</b></h4>
					</div>
				</div>

				<%
				if (listOT.size() == 0) {
				%>
					<div class="row">
						<p class="text-center text-muted"> Nessun Ubicazione trovata.</p>
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
				MaterialeBean tob = listOT.get(i);
				%>
				<li class="list-group-item noUpdate goTo" data-hidden="action" data-href="pos_<%=i%>">
					<p class="clearfix mb0">
						<span class="pull-right"><b class="text-muted">Materiale: </b><%=tob.getMATNR() != null ? tob.getMATNR() : "N/D" %></span>
						<span class="pull-left"><b class="text-muted">Ubicazione: </b><%=tob.getLGPLA() != null ? tob.getLGPLA() : "N/D" %></span>
					</p>
					<p class="clearfix mb0">
						<span class="pull-right"><b class="text-muted">WBS: </b><%=tob.getLSONR() != null ? tob.getLSONR() : "N/D" %></span>
						<span class="pull-left"><b class="text-muted">Tipo Stock: </b><%=tob.getBESTQ() != null ? tob.getBESTQ() : "N/D" %></span>
					</p>
					<p class="clearfix mb0">
						<span class="pull-left"><b class="text-muted">Quantit&agrave;: </b><%=tob.getVERME() != null ? tob.getVERME() : "N/D" %></span>
						<span class="pull-right"><b class="text-muted">Unit&agrave;: </b><%=tob.getMEINS() != null ? tob.getMEINS() : "N/D" %></span>
					</p>
					<span class="arrow">
						<i class="glyphicon glyphicon-chevron-right"></i>
					</span>
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
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="<%=Constants.URL.RICERCA_MATERIALE%>">Indietro</button>
				</p>
			</div>

		</div>
	</div>

</div>

<%@include file="../include/_footer.jsp"%>
