<%@ include file="../header.jsp"%>

<% String title = "Add new City"; %>
<% String method_ = "POST"; %>
<% String action_ = "save-city"; %>
<% int cityID = (int) request.getAttribute("cityID"); %>

<c:if test="${ isEdit }">
	<% title = "Edit City"; %>
	<% method_ = "PUT"; %>
	<% action_ = request.getAttribute("cityID") + "/save-city"; %>
</c:if>

<!-- A form to add new city. -->
<h1><%= title %></h1>

<div id="city-add-form">
	<!-- In case of addition, this form is available at /city/form/add. -->
	<!-- Pay attention to the "action" attribute, it means to be "/city/form/save-city" due to relative mapping from the method getCityAddForm(). -->

	<!-- In case of edition, this form is served at /city/form/edit{cityID}. -->
	<!-- The action attribute in that case is "/city/form/edit/{cityID}/save-city" due to relative mapping from updateCity(). -->

	<form:form action="<%= action_ %>" modelAttribute="city"
		method="<%= method_ %>">

		<!-- cityID of the City object, we hide it, but it needs to be there to associate the whole model attribute to a specific City in DB via the ID. -->
		<form:hidden path="cityID" value="<%= cityID %>" />

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