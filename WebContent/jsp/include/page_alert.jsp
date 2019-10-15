<%@page import="it.cube.demo.sap.mobile.constants.Constants"%>

<%
	String errorMessage = (String) request.getAttribute(Constants.ErrorMessage);
	String show = (String) request.getAttribute(Constants.Show);
	String classe = "alert-warning";
	String display = errorMessage == null  || errorMessage.trim().length() == 0 ? "none" : "";
	if(errorMessage!=null && errorMessage.trim().length()>0){
		if (Constants.Success.equals(show)) { 
			classe = "alert-success";
		} else if (Constants.Error.equals(show)) {
			classe = "alert-danger";
		} else if (Constants.Info.equals(show)) {
			classe = "alert-info";
		}
	}
%>

	<div class="alert <%=classe%> alert-dismissible <%=display%> text-center" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<b><%=errorMessage%></b>
	</div>