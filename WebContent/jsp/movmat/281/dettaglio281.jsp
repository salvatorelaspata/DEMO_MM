<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="com.sun.corba.se.impl.javax.rmi.CORBA.Util"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovNetworkBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.URL"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovWMBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%
String RSPOS = UtilString.removeNull((String) request.getAttribute(ZSWM_MOVIMENTAZIONI.RSPOS));
String NPLNR = UtilString.removeNull((String)request.getAttribute(ZSWM_MOVIMENTAZIONI.NPLNR));
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	MovNetworkBean det = (MovNetworkBean)request.getAttribute("dettaglio");

%>

<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl">

					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.DETTAGLIO_MOV281 %>"/>
					<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" name="<%=ZSWM_MOVIMENTAZIONI.NPLNR %>" size="18" maxlength="10" value="<%=NPLNR%>"/>			
					<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.RSPOS  %>" name="<%=ZSWM_MOVIMENTAZIONI.RSPOS  %>"  maxlength="4" style="font-size: 10px;width: 55px;"value="<%=RSPOS %>"/>
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Dettaglio Movimento Esterno</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="MATERIAL">Codice Materiale</label>
	    					<input type="text" class="form-control input-lg" name="MATERIAL" value="<%=det.getMATNR()%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="PLANT">Divisione</label>
	    					<input type="text" class="form-control input-lg" name="PLANT" value="<%=det.getWERKS()%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="BATCH">Partita</label>
	    					<input type="text" class="form-control input-lg" name="BATCH" value="<%=det.getCHARG()%>" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="BATCH">Magazzino</label>
	    					<input type="text" class="form-control input-lg" name="" value="<%=det.getLGORT()%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="ENTRY_QNT">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg" name="ENTRY_QNT" value="<%=det.getBDMNG()%>" readonly/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="ENTRY_QNT">Unit&agrave; di misura</label>
	    					<input type="text" class="form-control input-lg" name="ENTRY_QNT" value="<%=det.getMEINS()%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="STGE_LOC">Stock Speciale</label>
	    					<input type="text" class="form-control input-lg" name="STGE_LOC" value="<%=det.getSOBKZ()%>" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione</h4>
							<hr/>
						</div>
						
						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label>Tipo</label>
	    					<input type="text" class="form-control input-lg tipo" id="tipo" name="tipo" readonly placeholder="Tipo" value="<%=det.getLGTYP()%>" maxlength="3" required/>
						</div>
	
						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label>Numero</label>
	    					<input type="text" class="form-control input-lg numero" id="numero" name="numero" readonly placeholder="Numero" value="<%=det.getLGNUM()%>" maxlength="3" required/>
						</div>
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label>Ubicazione</label>
	    					<input type="text" class="form-control input-lg ubicazione " id="ubicazione" name="ubicazione" readonly placeholder="Ubicazione" value="<%=det.getLGPLA()%>" required/>
						</div>
					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="<%=URL.MOV_RIEPILOGO281%>">Indietro</button>
					</p>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
