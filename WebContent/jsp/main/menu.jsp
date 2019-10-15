<%@page import="java.util.Set"%>
<%@page import="it.cube.demo.sap.mobile.bean.BottoniBean"%>
<%@page import="java.util.Map"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.*"%>
<%@page import="it.cube.demo.sap.mobile.bean.DatiUtente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>

<%
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	DatiUtente du = (DatiUtente) request.getSession().getAttribute(Constants.DATIUTENTE); 
	ArrayList<String> permessi = du.getPermessi();
	Map<String,ArrayList<BottoniBean>> bottoni = du.getMenu(); 
	BottoniBean bb = null;
%>

<%@include file="../include/_header.jsp"%>

<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
				
				<img src="images/logo.png" class="img-responsive center-block" alt="DEMO CUBE" />
				<br />
				
				<form id="menuform" name="menuform" method="POST" action="MainUrl" >
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>" value="<%= Constants.URL.MENU%>"/>
					<input type="hidden" id="input" name="input">
					<input type="hidden" id="codice" name="codice"/>
				</form>

				<% 
				for (String cod:bottoni.keySet()) {  
        		
        			bb = bottoni.get(cod).get(0);
        			System.out.println("Pulsanti" + bb.getDescmenu()+" -> "+bb.getDescsottomenu());
        			String url = MapUrl.getURL(cod+bb.getSottomenu()); 
    				String shouldGo = bb.getDescsottomenu().trim().length() == 0 ? "go" : "hasMenu";
        		%>
	          	<div class="menu">	
	          		<p class="text-center">

						<button class="btn btn-lg btn-block btn-primary <%=shouldGo%>" data-go="<%=url%>">
							<%=bb.getDescmenu() %>
						</button>

						<%
						if (bb.getDescsottomenu().trim().length() > 0) { %>  

						<div id="<%=cod%>" class="subMenu">
							<%
							for (BottoniBean sub: bottoni.get(cod) ) { 
								url = MapUrl.getURL(cod+sub.getSottomenu()); 
							%>
								<button class="btn btn-lg btn-block btn-outline-info go" data-codice="<%=sub.getSottomenu() %>" data-go="<%=url%>">
									<%=sub.getDescsottomenu() %>
								</button>

							<%} %>

						</div>
						<%}%>
					</p>
				</div>				
				<%} %>
			</div>
		</div>
	</div>
</div>

<%@include file="../include/_footer.jsp"%>
