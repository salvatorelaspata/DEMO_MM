<%@page import="it.cube.demo.sap.mobile.bean.WBS_list"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovWMBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.URL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>

<%@include file="../../include/_header.jsp"%>

<%
String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
ArrayList<WBS_list> wbs_list = null;
String MATERIAL = "";//mov.getMATERIAL();
String PLANT  = "";//mov.getPLANT();
String BATCH = "";//mov.getBATCH();
String STGE_LOC = "";//mov.getSTGE_LOC();
String MOVE_TYPE = "";//mov.getMOVE_TYPE();
String ENTRY_QNT = "";//mov.getENTRY_QNT();
String ENTRY_UOM = "";//mov.getENTRY_UOM();
String VLTYP = "";//mov.getVLTYP();
String VLPLA = "";//mov.getVLPLA();
String NLPLA = "";//mov.getNLPLA();
String NLTYP = "";//mov.getNLTYP();
String STGE_LOC_DEST = "";//mov.getSTGE_LOC_DEST();
String VLBER = "";//mov.getVLBER();
String NLBER = "";//mov.getNLBER();
String LGNUM = "";//mov.getLGNUM();

if (request.getAttribute("mov") != null) {
	MovWMBean mov = (MovWMBean) request.getAttribute("mov");
	MATERIAL = mov.getMATERIAL();
	PLANT  = mov.getPLANT();
	BATCH = mov.getBATCH();
	STGE_LOC = mov.getSTGE_LOC();
	MOVE_TYPE = mov.getMOVE_TYPE();
	ENTRY_QNT = mov.getENTRY_QNT();
	ENTRY_UOM = mov.getENTRY_UOM();
	VLTYP = mov.getVLTYP();
	VLPLA = mov.getVLPLA();
	NLPLA = mov.getNLPLA();
	NLTYP = mov.getNLTYP();
	STGE_LOC_DEST = mov.getSTGE_LOC_DEST();
	VLBER = mov.getVLBER();
	NLBER = mov.getNLBER();
	LGNUM = mov.getLGNUM();
	wbs_list = (request.getSession().getAttribute("wbs_list") != null ? (ArrayList<WBS_list>) request.getSession().getAttribute("wbs_list") : null);
}
if (wbs_list != null && wbs_list.size() > 1) {
%>
	<div class="modal fade" tabindex="-1" id="modalWBS" data-enabled="<%=wbs_list != null && wbs_list.size() > 1 %>" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title text-center text-primary">Selezionare WBS</h4>
				</div>
				<div class="modal-body">
					<%
						if (wbs_list != null)
							for(int i=0; i < wbs_list.size(); i++) {
								WBS_list wbs = wbs_list.get(i);
								String POSID = wbs.getPOSID();
					%>
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block setWbs" data-pos="<%=i%>">								
						<i class="glyphicon glyphicon-share-alt" aria-hidden="true"></i>&nbsp;<%=POSID%>
					</button>
						<%} %>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-lg btn-outline-secondary btn-block" data-dismiss="modal" >Chiudi</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
 <%} %> 
<div class="row">
	<div id="header" class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<img src="images/logo.png" class="img-responsive center-block goBack" alt="DEMO CUBE" data-href="<%=Constants.URL.MENU%>" data-hidden="action"/>
	</div>
	
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<form name="form" method="post" action="MainUrl">
					<input type="hidden" name="wbs" id="wbs" value=""/>
					<input type="hidden" name="action" id="action" value="b3"/>
					<input type="hidden" name="host" id="host" value="<%=host %>"/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_999 %>"/>
					<input type="hidden" id="MOVE_TYPE" name="MOVE_TYPE" size="3" maxlength="3" value="999"/>
					<input type="hidden" id="ENTRY_UOM" name="ENTRY_UOM" size="3" maxlength="3" value="<%=ENTRY_UOM%>"/>
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Crea Ordine Trasferimento</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="MATERIAL">Codice materiale</label>
	    					<input type="text" class="form-control input-lg" placeholder="Codice Materiale" id="MATERIAL" name="MATERIAL" maxlength="18" value="<%=MATERIAL%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="MATERIAL">Partita</label>
	    					<input type="text" class="form-control input-lg" placeholder="Partita" id="BATCH" name="BATCH" maxlength="10" value="<%=BATCH%>"/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="ENTRY_QNT">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg numeric" placeholder="Quantit&agrave;" id="ENTRY_QNT" name="ENTRY_QNT" maxlength="13" value="<%=ENTRY_QNT%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="PLANT">Divisione</label>
	    					<input type="text" class="form-control input-lg" placeholder="Divisione" id="PLANT" name="PLANT" maxlength="4" value="<%=UtilString.removeNull(PLANT).length()>0 ?PLANT:Constants.CWERKS%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="STGE_LOC">Magazzino</label>
	    					<input type="text" class="form-control input-lg" placeholder="Magazzino logico provenienza" id="STGE_LOC" name="STGE_LOC" maxlength="4" value="<%=STGE_LOC%>" required/>
						</div>
						

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di provenienza</h4>
							<hr/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="LGNUM">N&deg; Mag.</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="VLTYP" %>-<%="VLPLA"%>" placeholder="N&deg; Magazzino" id="LGNUM" name="LGNUM" maxlength="3" value="<%=LGNUM%>" required/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="VLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="VLTYP" %>-<%="VLPLA"%>" placeholder="Area" id="VLBER" name="VLBER" maxlength="3" value="<%=VLBER%>" required/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="VLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="VLTYP" %>-<%="VLPLA"%>" placeholder="Tipo" id="VLTYP" name="VLTYP" maxlength="3" value="<%=VLTYP%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="VLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM" %>-<%="VLBER" %>-<%="VLTYP" %>-<%="VLPLA"%>" placeholder="Ubicazione" id="VLPLA" name="VLPLA" maxlength="19" value="<%=VLPLA%>" required/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12 section">
							<hr/>
							<h4 class="text-center text-primary">Ubicazione di destinazione</h4>
							<hr/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="LGNUM2">N&deg; Mag.</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM2" %>-<%="NLBER" %>-<%="NLTYP" %>-<%="NLPLA"%>" placeholder="N&deg; Magazzino" id="LGNUM2" name="LGNUM2" maxlength="3" value="<%=LGNUM%>" required/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="NLBER">Area</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM2" %>-<%="NLBER" %>-<%="NLTYP" %>-<%="NLPLA"%>" placeholder="Area" id="NLBER" name="NLBER" maxlength="3" value="<%=NLBER%>" required/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="NLTYP">Tipo</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM2" %>-<%="NLBER" %>-<%="NLTYP" %>-<%="NLPLA"%>" placeholder="Tipo" id="NLTYP" name="NLTYP" maxlength="3" value="<%=NLTYP%>" required/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="NLPLA">Ubicazione</label>
	    					<input type="text" class="form-control input-lg scanSplit" data-pattern="3-3-3-10" data-next="<%="LGNUM2" %>-<%="NLBER" %>-<%="NLTYP" %>-<%="NLPLA"%>" placeholder="Ubicazione" id="NLPLA" name="NLPLA" maxlength="19" value="<%=NLPLA%>" required/>
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
							<button type="submit" class="btn btn-lg btn-block btn-primary">Crea OT</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="../../include/_footer.jsp"%>
