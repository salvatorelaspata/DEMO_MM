<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%

	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

	String MENGE = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.MENGE));
	String MATNR = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.MATNR));
	String WERKS = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.WERKS));
	String LGORT = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGORT));
	String KOSTL = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.KOSTL));
	String CHARG = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.CHARG));
	String LGNUM = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGNUM));
	String LGTYP = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGTYP));
	String LGPLA = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.LGPLA));
	String NOTE = UtilString.removeNull(request.getParameter(ZSWM_MOVIMENTAZIONI.NOTE));

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
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_201 %>"/>
					<input type="hidden" class="l10 span text" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZSWM_MOVIMENTAZIONI.BWART %>" value="201"/>	
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimentazione 201</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MATNR %>">Materiale</label>
	    					<input type="text" class="form-control input-lg" placeholder="Materiale" id="<%=ZSWM_MOVIMENTAZIONI.MATNR %>" name="<%=ZSWM_MOVIMENTAZIONI.MATNR %>" maxlength="18" value="<%=MATNR %>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.WERKS %>">Divisione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Divisione" id="<%=ZSWM_MOVIMENTAZIONI.WERKS %>" name="<%=ZSWM_MOVIMENTAZIONI.WERKS %>" maxlength="4" value="<%=UtilString.removeNull(WERKS).length()>0 ?WERKS:Constants.CWERKS%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MENGE %>">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg" placeholder="Quantit&agrave;" id="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" name="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" maxlength="16" value="<%=MENGE%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGORT %>">Magazzino</label>
	    					<input type="text" class="form-control input-lg" placeholder="Magazzino" id="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" name="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" maxlength="4" value="<%=LGORT%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.KOSTL %>">Centro di Costo</label>
	    					<input type="text" class="form-control input-lg" placeholder="Centro di Costo" id="<%=ZSWM_MOVIMENTAZIONI.KOSTL %>" name="<%=ZSWM_MOVIMENTAZIONI.KOSTL %>" maxlength="10" value="<%=KOSTL%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.CHARG %>">Partita</label>
	    					<input type="text" class="form-control input-lg" placeholder="Partita" id="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" name="<%=ZSWM_MOVIMENTAZIONI.CHARG %>" maxlength="10" value="<%=CHARG%>" required/>
						</div>
						
						<!-- UBICAZIONE - Start -->
						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-4 col-sm-4 col-xs-4">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Tipo" id="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" name="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" value="<%=UtilString.removeNull(LGTYP)%>"/>
	    					<!-- <input class="form-control input-lg" id="scanner"> -->
						</div>
						<input type="hidden" name="LGNUM" id="LGNUM">
						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="VLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="VLBER" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Area" id="VLBER" name="VLBER"/>
						</div>

						<div class="form-group col-md-5 col-sm-5 col-xs-5">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit check" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="LGTYP" %>-<%="LGPLA"%>" placeholder="Ubicazione" id="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" name="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" value="<%=UtilString.removeNull(LGPLA)%>"/>
	    				</div>
						<!-- UBICAZIONE - End -->
						
						<!-- 
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>">Ubicazione</label>
							<div class="row">
								<div class="form-group col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>-<%="VLBER" %>-<%=ZSWM_MOVIMENTAZIONI.LGTYP %>-<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" placeholder="N Mag" id="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>" name="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>" value="<%=LGNUM%>" maxlength="3" required/>
								</div>
								<div class="form-group col-md-3 col-sm-3 col-xs-3">
									<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>-<%="VLBER" %>-<%=ZSWM_MOVIMENTAZIONI.LGTYP %>-<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" placeholder="Tipo" id="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" name="<%=ZSWM_MOVIMENTAZIONI.LGTYP %>" value="<%=LGTYP%>" maxlength="3" required/>
								</div>
								<input type="hidden" name="VLBER" id="VLBER">
								<div class="form-group col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%=ZSWM_MOVIMENTAZIONI.LGNUM %>-<%="VLBER" %>-<%=ZSWM_MOVIMENTAZIONI.LGTYP %>-<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" placeholder="Ubicazione" id="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" name="<%=ZSWM_MOVIMENTAZIONI.LGPLA %>" value="<%=LGPLA%>" maxlength="19" required/>
								</div>
							</div>
						</div>
						-->
							<div class="form-group col-md-12 col-sm-12 col-xs-12">
								<label for="<%=ZSWM_MOVIMENTAZIONI.NOTE %>">Note</label>
		    					<input type="text" class="form-control input-lg" placeholder="Note" id="<%=ZSWM_MOVIMENTAZIONI.NOTE %>" name="<%=ZSWM_MOVIMENTAZIONI.NOTE %>" maxlength="25" value="<%=NOTE%>" required/>
							</div>
					</div>

					<p class="text-center">
						<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="b1">Indietro</button>
						<button type="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						<button type="button" class="btn btn-lg btn-primary btn-block goTo" data-hidden="action" data-href="b3">Registra</button>
					</p>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
