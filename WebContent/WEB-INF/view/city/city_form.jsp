<%@ include file="../header.jsp"%>

<%
	String title = "Add new City";
	String method_ = "POST";
	String action_ = "/ExpensesTracking/cities/";
%>
<%
	int cityID = 0;
	if(request.getAttribute("cityID") != null) {
		System.out.println("cityID in JSP " + request.getAttribute("cityID"));
		cityID = (int) request.getAttribute("cityID");
	}
%>
<c:if test="${ isEdit }">
	<%
		title = "Edit City";
		method_ = "PUT";
		action_ = "edit/execute";
	%>
</c:if>

<!-- A form to add new city. -->
<h1><%=title%></h1>

<div id="city-form">
	<!-- In case of addition, this form is available at /city/new. -->
	<!-- Pay attention to the "action" attribute, it means to be "/cities/new" due to relative mapping from the method getCityAddForm(). -->

	<!-- In case of edition, this form is served at /city/form/edit{cityID}. -->
	<!-- The action attribute in that case is "/city/form/edit/{cityID}/save-city" due to relative mapping from updateCity(). -->

	<form:form action="<%=action_%>" modelAttribute="city"
		method="<%=method_%>">

		<!-- cityID of the City object, we hide it, but it needs to be there to associate the whole model attribute to a specific City in DB via the ID. -->
		<form:hidden path="cityID" value="<%=cityID%>" />

		<!-- cityName of the City object. -->
		<div class="form-group">
			<label for="city-name">City name</label>
			<form:input path="cityName" type="text" class="form-control"
				id="city-name" placeholder="Enter city name here..."
				aria-describedby="cityNameHelp" />
			<small id="cityNameHelp" class="form-text text-muted">The
				city where you do groceries in.</small>
		</div>

		<!-- Submit button -->
		<input type="submit" value="Save" class="btn btn-primary" />
	</form:form>
</div>

<%@ include file="../footer.jsp"%>