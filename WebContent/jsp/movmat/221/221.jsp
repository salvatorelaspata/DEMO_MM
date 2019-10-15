<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.URL"%>
<%@page import="it.cube.demo.sap.mobile.bean.DefaultTVal"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovWMBean"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@include file="../../include/_header.jsp"%>

<%

	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

	String RSPOS = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.RSPOS));
	String NPLNR = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.NPLNR));

%>

<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl">

					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_221 %>"/>
					<input type="hidden" class="l10 span text" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZSWM_MOVIMENTAZIONI.BWART %>" value="221"/>	
					 
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimentazione 221</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>">Network</label>
	    					<input type="text" class="form-control input-lg" placeholder="Network" id="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" name="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" maxlength="18" value="<%=NPLNR %>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.RSPOS %>">Posizione Network</label>
	    					<input type="text" class="form-control input-lg" placeholder="Posizione Network" id="<%=ZSWM_MOVIMENTAZIONI.RSPOS %>" name="<%=ZSWM_MOVIMENTAZIONI.RSPOS %>" maxlength="4" value="<%=RSPOS%>" required/>
						</div>

					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Ricerca</button>
					</p>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
