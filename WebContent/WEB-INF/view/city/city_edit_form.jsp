<%@ include file="../header.jsp"%>

<h1>Edit City "${ city.cityName }"</h1>
<div id="city-edit-form">
	<form:form action="save-city" modelAttribute="city" method="PUT">
		<div class="form-group">
			<label for="city-name">City name</label>
			<form:input path="cityName" type="text" class="form-control"
				id="city-name" aria-describedby="cityNameHelp" />
			<small id="cityNameHelp" class="form-text text-muted">The
				city where you do groceries in.</small>
		</div>
		<input type="submit" value="Save" class="btn btn-primary" />
	</form:form>
</div>

<%@ include file="../footer.jsp"%>