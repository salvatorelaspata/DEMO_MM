<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_GET_ODA"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.Session"%>
<%@page import="it.cube.demo.sap.mobile.bean.MovimentazioniBean"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZFMWM_CREA_MOVIMENTAZIONE"%>
<%@page import="it.cube.demo.sap.mobile.util.UtilString"%>
<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap.ZSWM_MOVIMENTAZIONI"%>
<%@page import="it.cube.demo.sap.mobile.bean.ConfermaOTBean"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../include/_header.jsp"%>

<%
	ArrayList<MovimentazioniBean> movList = (ArrayList<MovimentazioniBean>) request.getSession().getAttribute(Session.LISTAMOV);
	int pos = (Integer)request.getAttribute("pos");
	MovimentazioniBean mov = movList.get(pos);
	
	String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	String I_EBELN = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_ODA.I_EBELN));
	String I_EBELP = UtilString.removeNull((String) request.getAttribute(ZFMWM_GET_ODA.I_EBELP));

	String EBELN = UtilString.removeNull(mov.getEBELN());
	String EBELP = UtilString.removeNull(mov.getEBELP());
	String MENGE = UtilString.removeNull(mov.getMENGE());
	String VFDAT = UtilString.removeNull(mov.getVFDAT());
	String DATA_DOC = UtilString.removeNull(mov.getDATA_DOC());
	//String I_MAT_DOC = UtilString.removeNull(mov.get);
	//String I_DOC_YEAR = UtilString.removeNull(mov.get);
	//String LICHA =request.getAttribute("LICHA")!=null?(String)request.getAttribute("LICHA"):"";
	
	String XBLNR = UtilString.removeNull(mov.getXBLNR());
	String LICHA = UtilString.removeNull(mov.getLICHA());
	String NOTE = UtilString.removeNull(mov.getNOTE());
	String MEINS = UtilString.removeNull(mov.getMEINS());
	
	String LGORT = UtilString.removeNull(mov.getLGORT());
	
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
					<input type="hidden" name="pos" id="pos" value="<%=pos%>"/>
					<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>"  value="<%=Constants.URL.MOV_101 %>"/>
					<input type="hidden" id="<%=ZSWM_MOVIMENTAZIONI.BWART %>" name="<%=ZSWM_MOVIMENTAZIONI.BWART %>" value="101"/>		
					<input type="hidden" name="<%=ZFMWM_GET_ODA.I_EBELN %>" value="<%=I_EBELN %>"/>
					<input type="hidden" name="<%=ZFMWM_GET_ODA.I_EBELP %>" value="<%=I_EBELP %>"/>
					
					<div class="row">

						<div class="page-header">
							<h4 class="text-center text-primary"><b>Movimentazione 101</b></h4>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.EBELN%>">Ordine d'acquisto</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.EBELN%>" name="<%=ZSWM_MOVIMENTAZIONI.EBELN%>" value="<%=EBELN%>" readonly/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.EBELP %>">Posizione Documento</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.EBELP %>" name="<%=ZSWM_MOVIMENTAZIONI.EBELP %>" value="<%=EBELP%>" readonly/>
						</div>

						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MENGE %>">Quantit&agrave;</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" name="<%=ZSWM_MOVIMENTAZIONI.MENGE %>" value="<%=MENGE%>" maxlength="13" required/>
						</div>
						
						<div class="form-group col-md-6 col-sm-6 col-xs-6">
							<label for="<%=ZSWM_MOVIMENTAZIONI.MEINS %>">Unit&agrave; di misura</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.MEINS %>" name="<%=ZSWM_MOVIMENTAZIONI.MEINS %>" value="<%=MEINS%>" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LGORT %>">Magazzino</label>
	    					<input type="text" class="form-control input-lg" id="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" name="<%=ZSWM_MOVIMENTAZIONI.LGORT %>" value="<%=LGORT%>" readonly/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.LICHA %>">Lotto</label>
	    					<input type="text" class="form-control input-lg" placeholder="Lotto" id="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" name="<%=ZSWM_MOVIMENTAZIONI.LICHA %>" maxlength="10" value="<%=LICHA%>" required/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.DATA_DOC %>">Data Documento</label>
	    					<input type="date" class="form-control input-lg" placeholder="gg/mm/aaaa" id="<%=ZSWM_MOVIMENTAZIONI.DATA_DOC %>" name="<%=ZSWM_MOVIMENTAZIONI.DATA_DOC %>" maxlength="10" value="<%=DATA_DOC%>"/>
						</div>

						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.VFDAT %>">Data Scadenza</label>
	    					<input type="date" class="form-control input-lg" placeholder="gg/mm/aaaa" id="<%=ZSWM_MOVIMENTAZIONI.VFDAT %>" name="<%=ZSWM_MOVIMENTAZIONI.VFDAT %>" maxlength="10" value="<%=VFDAT%>"/>
						</div>
						
						<div class="form-group col-md-12 col-sm-12 col-xs-12">
							<label for="<%=ZSWM_MOVIMENTAZIONI.XBLNR %>">Doc. Riferimento</label>
	    					<input type="text" class="form-control input-lg" placeholder="Doc. Riferimento" id="<%=ZSWM_MOVIMENTAZIONI.XBLNR %>" name="<%=ZSWM_MOVIMENTAZIONI.XBLNR %>" maxlength="10" value="<%=XBLNR%>" required/>
						</div>

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
