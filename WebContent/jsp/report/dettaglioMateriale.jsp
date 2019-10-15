<%@page import="it.cube.demo.sap.mobile.bean.MaterialeBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.URL"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovWMBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../include/_header.jsp"%>

<%

	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	MaterialeBean materiale = (MaterialeBean) request.getAttribute("materiale");

	String FLAG_LGPLA = materiale.getFLAG_LGPLA();
	String AUSME = materiale.getAUSME();
	String BESTQ = materiale.getBESTQ();
	String CHARG = materiale.getCHARG();
	String EINME = materiale.getEINME();
	String GESME = materiale.getGESME();
	String LGNUM = materiale.getLGNUM();
	String LGORT = materiale.getLGORT();
	String LGPLA = materiale.getLGPLA();
	String LGTYP = materiale.getLGTYP();
	String MAKTX = materiale.getMAKTX();
	String MATNR = materiale.getMATNR();
	String MEINS = materiale.getMEINS();
	String VERME = materiale.getVERME();
	String VFDAT = materiale.getVFDAT();
	String WDATU = materiale.getWDATU();
	String WERKS = materiale.getWERKS();
	String LICHA = materiale.getLICHA();
	String WENUM = materiale.getWENUM();

	String panelBodyPaddingReset = "pb0";
	String headerMarginBottomReset = "mb0";

%>

<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body <%=panelBodyPaddingReset%>">
			
				<form name="form" method="post" action="MainUrl">
					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.DETTAGLIOMATERIALE %>"/>
				</form>

				<div class="row">
					<div class="page-header <%=headerMarginBottomReset%>">
						<h4 class="text-center text-primary"><b>Dettaglio Ubicazioni</b></h4>
					</div>

					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label for="MATNR">Codice materiale</label>
						<input type="text" class="form-control input-lg" readonly value="<%=MATNR%>" />
					</div>

					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label for="MAKTX">Descrizione materiale</label>
						<input type="text" class="form-control input-lg" readonly value="<%=MAKTX%>" />
					</div>
					
					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label for="WENUM">BEM</label>
						<input type="text" class="form-control input-lg" readonly value="<%=WENUM%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="LGPLA">Ubicazione</label>
						<input type="text" class="form-control input-lg" readonly value="<%=LGPLA%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="LGTYP">Tipo Magazzino</label>
						<input type="text" class="form-control input-lg" readonly value="<%=LGTYP%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="CHARG">Partita</label>
						<input type="text" class="form-control input-lg" readonly value="<%=CHARG%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="LICHA">Lotto</label>
						<input type="text" class="form-control input-lg" readonly value="<%=LICHA%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="WDATU">Data Emissione</label>
						<input type="text" class="form-control input-lg" readonly value="<%=WDATU%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="WDATU">Data Scadenza</label>
						<input type="text" class="form-control input-lg" readonly value="<%=WDATU%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="BESTQ">Tipo Stock</label>
						<input type="text" class="form-control input-lg" readonly value="<%=BESTQ%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="MEINS">Unit&agrave; Misura</label>
						<input type="text" class="form-control input-lg" readonly value="<%=MEINS%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="AUSME">Totale</label>
						<input type="text" class="form-control input-lg" readonly value="<%=GESME%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="MEINS">Disponibile</label>
						<input type="text" class="form-control input-lg" readonly value="<%=VERME%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="AUSME">Da Immagazzinare</label>
						<input type="text" class="form-control input-lg" readonly value="<%=EINME%>" />
					</div>

					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label for="MEINS">Da Prelevare</label>
						<input type="text" class="form-control input-lg" readonly value="<%=AUSME%>" />
					</div>

				</div>

				<p class="text-center">
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
				</p>

			</div>
		</div>
	</div>

</div>


<%@include file="../include/_footer.jsp"%>
