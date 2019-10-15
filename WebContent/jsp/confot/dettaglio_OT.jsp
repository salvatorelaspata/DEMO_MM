<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../include/_header.jsp"%>

<%
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	ArrayList<ConfermaOTBean> lista = (ArrayList<ConfermaOTBean>) request.getSession().getAttribute(Session.LISTAOT);
	Integer ROW = (Integer) request.getAttribute("dettaglio");
	ConfermaOTBean t = lista.get(ROW);

	String I_LGNUM = t.getLGNUM();
	String I_TANUM = t.getTANUM();
	String I_DATA = t.getTAPOS();
	String I_MATNR = t.getMATNR();
	String I_MAKTX = t.getMAKTX();
	String I_BWART = t.getBWART();
	String I_CHARG = t.getCHARG();
	String LICHA = t.getLICHA();
	String I_VLTYP = t.getVLTYP();
	String I_VLPLA = t.getVLPLA();
	String I_VLBER = t.getVLBER();
	String qtaprevprov = t.getVSOLA();
	String umaltm = t.getALTME();
	String I_NLTYP = t.getNLTYP();
	String I_NLPLA = t.getNLPLA();
	String I_NLBER = t.getNLBER();
	String qtaprevistadest = t.getNSOLA();
	//String qtaeffetivadest = t.getNISTA();
	String nomeutente = t.getBNAME();
	String indicatoreposizione = t.getCONFERMA();
	

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
					<input type="hidden" name="action" id="action"/>
					<input type="hidden" name="dettaglio" id="dettaglio" value="<%=ROW %>" />
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.CONFOT3 %>"/>
				

					<div class="row">
						<div class="page-header <%=headerMarginBottomReset%>">
							<h4 class="text-center text-primary"><b>Dettaglio Ordine Trasferimento</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_TANUM">Codice OT</label>
							<div class="row">
								<div class="form-group col-md-8 col-sm-8 col-xs-8">
									<input type="text" class="form-control input-lg" name="I_TANUM" readonly value="<%=I_TANUM%>" />
								</div>
								<div class="form-group col-md-4 col-sm-4 col-xs-4">
									<input type="text" class="form-control input-lg" name="I_DATA" readonly value="<%=I_DATA%>" />
								</div>
							</div>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_CHARG">Partita</label>
							<input type="text" class="form-control input-lg" name="I_CHARG" readonly value="<%=I_CHARG%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_MATNR">Materiale</label>
							<input type="text" class="form-control input-lg" name="I_MATNR" readonly value="<%=I_MATNR%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_MAKTX">Descrizione Materiale</label>
							<textarea class="form-control" name="I_MAKTX"><%=I_MAKTX%></textarea>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_BWART">Quantit&agrave;</label>
							<input type="text" class="form-control input-lg" name="I_NSOLA" readonly value="<%=qtaprevistadest%>" />
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="ALTME">Unit&agrave; di misura</label>
							<input type="text" class="form-control input-lg" name="ALTME" readonly value="<%=umaltm%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di provenienza</h4>
							<hr/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_VLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg" name="I_VLTYP" value="<%=I_VLTYP%>" readonly/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_VLBER">Area</label>
	    					<input type="text" class="form-control input-lg" name="I_VLBER" value="<%=I_VLBER%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_VLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg" name="I_VLPLA" value="<%=I_VLPLA%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di destinazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_NLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg" name="I_NLTYP" value="<%=I_NLTYP%>" readonly/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="I_NLBER">Area</label>
	    					<input type="text" class="form-control input-lg" name="I_NLBER" value="<%=I_NLBER%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_NLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg" name="I_NLPLA" value="<%=I_NLPLA%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_BWART">Tipo Movimento</label>
	    					<input type="text" class="form-control input-lg" name="I_BWART" value="<%=I_BWART!=null && I_BWART.trim().length()<=0?"999":I_BWART%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="I_LGNUM">N&deg; Magazzino</label>
	    					<input type="text" class="form-control input-lg" name="I_LGNUM" value="<%=I_LGNUM%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="LSONR">Stock Speciali</label>
							<div class="row">
								<div class="form-group col-md-8 col-sm-8 col-xs-8">
									<input type="text" class="form-control input-lg" name="LSONR" readonly value="<%=t.getLSONR()%>" />
								</div>
								<div class="form-group col-md-4 col-sm-4 col-xs-4">
									<input type="text" class="form-control input-lg" name="SOBKZ" readonly value="<%=t.getSOBKZ()%>" />
								</div>
							</div>
						</div>

					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Conferma</button>
					</p>

				</form>
			</div>
		</div>
	</div>

</div>

<%@include file="../include/_footer.jsp"%>
