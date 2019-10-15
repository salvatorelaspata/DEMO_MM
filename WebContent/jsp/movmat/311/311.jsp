<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.bean.DefaultTVal"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.URL"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>

<%@include file="../../include/_header.jsp"%>

<%
String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

String MATERIAL = request.getAttribute("MATERIAL") != null ? (String)request.getAttribute("MATERIAL") : "";
String PLANT  = request.getAttribute("PLANT") !=null ? (String)request.getAttribute("PLANT") : "";
String BATCH = request.getAttribute("BATCH") != null ? (String)request.getAttribute("BATCH") :"";
String STGE_LOC = request.getAttribute("STGE_LOC") != null ? (String)request.getAttribute("STGE_LOC") : "";
String MOVE_TYPE = request.getAttribute("MOVE_TYPE") != null ? (String)request.getAttribute("MOVE_TYPE") : "";
String ENTRY_QNT = request.getAttribute("ENTRY_QNT") != null ? (String)request.getAttribute("ENTRY_QNT") : "";
String ENTRY_UOM = request.getAttribute("ENTRY_UOM") != null ? (String)request.getAttribute("ENTRY_UOM") : "";
String VLTYP = request.getAttribute("VLTYP") != null ? (String)request.getAttribute("VLTYP") : "";
String VLPLA = request.getAttribute("VLPLA") != null ? (String)request.getAttribute("VLPLA") : "";
String NLPLA = request.getAttribute("NLPLA") != null ? (String)request.getAttribute("NLPLA") : "";
String NLTYP = request.getAttribute("NLTYP") != null ? (String)request.getAttribute("NLTYP") : "";
String STGE_LOC_DEST = request.getAttribute("STGE_LOC_DEST") != null ? (String)request.getAttribute("STGE_LOC_DEST") : "";
String VLBER = request.getAttribute("VLBER") != null ? (String)request.getAttribute("VLBER") : "";
String NLBER = request.getAttribute("NLBER") != null ? (String)request.getAttribute("NLBER") : "";
String LGNUM = request.getAttribute("LGNUM") != null ? (String)request.getAttribute("LGNUM") : "";

DefaultTVal bean = (DefaultTVal)request.getSession().getAttribute(Session.DEFAULT);

if (bean != null) {
	STGE_LOC = bean.pMag.isEmpty() ? STGE_LOC : bean.pMag;
	VLTYP = bean.pTipo.isEmpty() ? VLTYP : bean.pTipo;
	VLPLA = bean.pUbic.isEmpty() ? VLPLA : bean.pUbic;
	STGE_LOC_DEST = bean.pMag.isEmpty() ? STGE_LOC_DEST : bean.pMag;
	NLTYP = bean.dTipo.isEmpty() ? NLTYP : bean.dTipo;
	NLPLA = bean.dUbic.isEmpty() ? NLPLA : bean.dUbic;
}

%>

<div class="row">
	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl">

					<input type="hidden" name="action" id="action" value="b3"/>
					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_311 %>"/>
					<input type="hidden" id="MOVE_TYPE" name="MOVE_TYPE" size="3" maxlength="3" value="999"/>
					<input type="hidden" id="ENTRY_UOM" name="ENTRY_UOM" size="3" maxlength="3" value="<%=ENTRY_UOM%>"/>
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimento 311</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="MATERIAL">Codice materiale</label>
	    					<input type="text" class="form-control input-lg" placeholder="Codice Materiale" id="MATERIAL" name="MATERIAL" maxlength="18" value="<%=MATERIAL%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="MATERIAL">Partita</label>
	    					<input type="text" class="form-control input-lg" placeholder="Partita" id="BATCH" name="BATCH" maxlength="10" value="<%=BATCH%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="ENTRY_QNT">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg numeric" placeholder="Quantit&agrave;" id="ENTRY_QNT" name="ENTRY_QNT" maxlength="13" value="<%=ENTRY_QNT%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="PLANT">Divisione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Divisione" id="PLANT" name="PLANT" maxlength="4" value="<%=PLANT%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="LGNUM">N&deg; Magazzino</label>
	    					<input type="text" class="form-control input-lg" placeholder="N&deg; Magazzino" id="LGNUM" name="LGNUM" maxlength="3" value="<%=LGNUM%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di provenienza</h4>
							<hr/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="VLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg" placeholder="Tipo" id="VLTYP" name="VLTYP" maxlength="3" value="<%=VLTYP%>" required/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="VLBER">Area</label>
	    					<input type="text" class="form-control input-lg" placeholder="Area" id="VLBER" name="VLBER" maxlength="3" value="<%=VLBER%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="VLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Ubicazione" id="VLPLA" name="VLPLA" maxlength="10" value="<%=VLPLA%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="STGE_LOC">Magazzino logico</label>
	    					<input type="text" class="form-control input-lg" placeholder="Magazzino logico provenienza" id="STGE_LOC" name="STGE_LOC" maxlength="18" value="<%=STGE_LOC%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di destinazione</h4>
							<hr/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="NLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg" placeholder="Tipo" id="NLTYP" name="NLTYP" maxlength="3" value="<%=NLTYP%>" required/>
						</div>

						<div class="form-group col-md-3 col-sm-3 col-xs-3">
							<label for="NLBER">Area</label>
	    					<input type="text" class="form-control input-lg" placeholder="Area" id="NLBER" name="NLBER" maxlength="3" value="<%=NLBER%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="NLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Ubicazione" id="NLPLA" name="NLPLA" maxlength="10" value="<%=NLPLA%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="STGE_LOC_DEST">Magazzino logico</label>
	    					<input type="text" class="form-control input-lg" placeholder="Magazzino logico destinazione" id="STGE_LOC_DEST" name="STGE_LOC_DEST" maxlength="18" value="<%=STGE_LOC_DEST%>" required/>
						</div>

					</div>
					
					<br/>
					
					<div class="row">
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<button type="button" class="btn btn-lg btn-outline-secondary btn-block goBack" data-hidden="action" data-href="<%=Constants.URL.MENU%>">Indietro</button>
						</div>
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<button type="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						</div>
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<button type="submit" class="btn btn-lg btn-block btn-primary">Salva</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../../include/_footer.jsp"%>
