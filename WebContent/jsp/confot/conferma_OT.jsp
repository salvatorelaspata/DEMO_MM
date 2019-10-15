<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../include/_header.jsp"%>
<%

String host = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
String I_TANUM = request.getAttribute("I_TANUM") != null ? (String)request.getAttribute("I_TANUM") : "";
String I_DATA  = request.getAttribute("I_DATA") != null ? (String)request.getAttribute("I_DATA") : "";
String I_BWART = request.getAttribute("I_BWART") != null ? (String)request.getAttribute("I_BWART") : "";
String I_LGNUM = request.getAttribute("I_LGNUM") != null ? (String)request.getAttribute("I_LGNUM") : "";
String I_MATNR = request.getAttribute("I_MATNR") != null ? (String)request.getAttribute("I_MATNR") : "";
String I_VLTYP = request.getAttribute("I_VLTYP") != null ? (String)request.getAttribute("I_VLTYP") : "";
String I_VLBER = request.getAttribute("I_VLBER") != null ? (String)request.getAttribute("I_VLBER") : "";
String I_VLPLA = request.getAttribute("I_VLPLA") != null ? (String)request.getAttribute("I_VLPLA") : "";
String I_NLTYP = request.getAttribute("I_NLTYP") != null ? (String)request.getAttribute("I_NLTYP") : "";
String I_NLBER = request.getAttribute("I_NLBER") != null ? (String)request.getAttribute("I_NLBER") : "";
String I_NLPLA = request.getAttribute("I_NLPLA") != null ? (String)request.getAttribute("I_NLPLA") : "";
String I_CHARG = request.getAttribute("I_CHARG") != null ? (String)request.getAttribute("I_CHARG") : "";
//String LICHA = request.getAttribute("LICHA") != null ? (String)request.getAttribute("LICHA") : "";

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
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.CONFOT %>"/>

					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Ricerca Ordini Trasferimento</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_TANUM">Codice Ordine Trasferimento</label>
	    					<input type="text" class="form-control input-lg" placeholder="Codice Ordine Trasferimento" id="I_TANUM" name="I_TANUM" maxlength="10" value="<%=I_TANUM%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_DATA">Data Creazione</label>
	    					<input type="date" class="form-control input-lg" placeholder="gg/mm/aaaa" id="I_TANUM" name="I_DATA" maxlength="10" value="<%=I_DATA%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_CHARG">Partita</label>
	    					<input type="text" class="form-control input-lg" placeholder="Partita" id="I_CHARG" name="I_CHARG" maxlength="10" value="<%=I_CHARG%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_MATNR">Materiale</label>
	    					<input type="text" class="form-control input-lg" placeholder="Materiale" id="I_MATNR" name="I_MATNR" maxlength="18" value="<%=I_CHARG%>"/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_BWART">Tipo Movimento</label>
	    					<input type="text" class="form-control input-lg" placeholder="Tipo Movimento" id="I_BWART" name="I_BWART" maxlength="3" value="<%=I_BWART%>"/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_LGNUM">N&deg; Magazzino</label>
	    					<input type="text" class="form-control input-lg" placeholder="N&deg; Magazzino" id="I_LGNUM" name="I_LGNUM" maxlength="3" value="<%=I_LGNUM%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di provenienza</h4>
							<hr/>
						</div>

						<div class="form-group col-md-4 col-sm-4 col-xs-4">
							<label for="I_VLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_VLBER" %>-<%="I_VLTYP" %>-<%="I_VLPLA"%>" placeholder="Tipo" id="I_VLTYP" name="I_VLTYP" maxlength="3" value="<%=I_VLTYP%>"/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_VLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_VLBER" %>-<%="I_VLTYP" %>-<%="I_VLPLA"%>" placeholder="Area" id="I_VLBER" name="I_VLBER" maxlength="3" value="<%=I_VLBER%>"/>
						</div>

						<div class="form-group col-md-5 col-sm-5 col-xs-5">
							<label for="I_VLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_VLBER" %>-<%="I_VLTYP" %>-<%="I_VLPLA"%>" placeholder="Ubicazione" id="I_VLPLA" name="I_VLPLA" maxlength="19" value="<%=I_VLPLA%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di destinazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-4 col-sm-4 col-xs-4">
							<label for="I_NLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_NLBER" %>-<%="I_NLTYP" %>-<%="I_NLPLA"%>" placeholder="Tipo" id="I_NLTYP" name="I_NLTYP" maxlength="3" value="<%=I_NLTYP%>" />
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_NLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_NLBER" %>-<%="I_NLTYP" %>-<%="I_NLPLA"%>" placeholder="Area" id="I_NLBER" name="I_NLBER" maxlength="3" value="<%=I_NLBER%>" />
						</div>

						<div class="form-group col-md-5 col-sm-5 col-xs-5">
							<label for="I_NLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="I_LGNUM" %>-<%="I_NLBER" %>-<%="I_NLTYP" %>-<%="I_NLPLA"%>" placeholder="Ubicazione" id="I_NLPLA" name="I_NLPLA" maxlength="19" value="<%=I_NLPLA%>" />
						</div>


					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						<button class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Ricerca</button>
					</p>

				</form>

			</div>
		</div>
	</div>

</div>

<%@include file="../include/_footer.jsp"%>
