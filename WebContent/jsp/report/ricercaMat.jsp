<%@page import="it.cube.demo.sap.mobile.constants.Constants.MapUrl.Host"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GETLIST_MATERIALE"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@include file="../include/_header.jsp"%>

<%

String I_LGTYP = UtilString.removeNull((String)request.getAttribute(ZFMWM_GETLIST_MATERIALE.I_LGTYP));
String I_MATNR = UtilString.removeNull((String)request.getAttribute(ZFMWM_GETLIST_MATERIALE.I_MATNR));
String I_WERKS = UtilString.removeNull((String)request.getAttribute(ZFMWM_GETLIST_MATERIALE.I_WERKS));
String I_LGNUM = UtilString.removeNull((String)request.getAttribute(ZFMWM_GETLIST_MATERIALE.I_LGNUM));
String I_LICHA = UtilString.removeNull((String)request.getAttribute(ZFMWM_GETLIST_MATERIALE.I_LICHA));

%>

<div class="row">

	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl">
					
					<input type="hidden" name="host" id="host" value="<%=Host.Url() %>"/>
					<input type="hidden" name="action" id="action" value=""/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.RICERCA_MATERIALE %>"/>

					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Report Materiale</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_MATNR">Codice materiale</label>
	    					<input type="text" class="form-control input-lg" placeholder="Codice Materiale" id="I_MATNR" name="I_MATNR" maxlength="18" value="<%=I_MATNR%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_WERKS">Divisione<sup>*</sup></label>
	    					<input type="text" class="form-control input-lg" placeholder="Divisione" id="I_WERKS" name="I_WERKS" maxlength="4" value="<%=UtilString.removeNull(I_WERKS).length()>0 ?I_WERKS:Constants.CWERKS%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_LGNUM">N&deg; Magazzino<sup>*</sup></label>
	    					<input type="text" class="form-control input-lg" placeholder="N&deg; Magazzino" id="I_LGNUM" name="I_LGNUM" maxlength="4" value="<%=I_LGNUM%>" />
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_LGTYP">Tipo Magazzino</label>
	    					<input type="text" class="form-control input-lg" placeholder="Tipo Magazzino" id="I_LGTYP" name="I_LGTYP" maxlength="3" value="<%=I_LGTYP%>" />
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="I_LICHA">Lotto</label>
	    					<input type="text" class="form-control input-lg" placeholder="Lotto" id="I_LICHA" name="I_LICHA" maxlength="15" value="<%=I_LICHA%>" />
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
