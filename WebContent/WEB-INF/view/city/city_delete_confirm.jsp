<%@ include file="../header.jsp"%>

<%
	int cityID = 0;
if (request.getAttribute("cityID") != null) {
	System.out.println("cityID in JSP " + request.getAttribute("cityID"));
	cityID = (int) request.getAttribute("cityID");
}
%>

<div>
	<div>Are you sure about deleting the city "${ city.cityName }"?</div>
	<form:form action="delete/execute" modelAttribute="city"
		method="DELETE">
		<form:hidden path="cityID" value="<%=cityID%>" />
		<input type="submit" value="Delete" class="btn btn-danger" />
	</form:form>

	<!-- Go back to list of all cities -->
	<a class="btn btn-warninig" href="delete/cancel">Cancel</a>
</div>

<%@ include file="../footer.jsp"%>