<%@page import="it.cube.demo.sap.mobile.constants.ConstantsSap"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>
<%@page import="it.cube.demo.sap.mobile.constants.Constants.*"%>

<%@include file="../include/_header.jsp"%>

<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
		<div class="panel panel-default">
			<div class="panel-body">
		    	
				<img src="images/logo.png" class="img-responsive center-block" alt="DEMO CUBE" />

		    	<form name="login" method="POST" action="MainUrl">
		    		
		    		<input type="hidden" name="<%=Constants.PagProvenienza %>" id="<%=Constants.PagProvenienza %>" value="<%=Constants.URL.LOGIN %>" />

		    		<div class="form-group">
						<label for="user">Utente</label>
						<input type="text" class="form-control input-lg" name="user" id="user" value="" maxlength="8" placeholder="Utente" autofocus />
					</div>

					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" name="password" class="form-control input-lg" placeholder="Password" id="password" value="" maxlength="4" />
					</div>

					<p class="text-center">
						<button type="reset" class="btn btn-lg btn-outline-info btn-block">Reset</button>
						<button type="submit" class="btn btn-lg btn-primary btn-block">Accedi</button>
					</p>
					
		    	</form>

			</div>
		</div>
	</div>
</div>

<%@include file="../include/_footer.jsp"%>
