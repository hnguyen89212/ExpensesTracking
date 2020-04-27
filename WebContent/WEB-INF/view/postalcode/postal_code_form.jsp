<%@ include file="../header.jsp"%>

<%
	String title_ = "Add a new Postal Code";
	String method_ = "POST";
	String action_ = "/ExpensesTracking/postalcodes/";
	boolean readOnly_ = false;
%>
<%
	// Upon editing postal code, it is better to pre-choose the city of that code.
	String cityID = "";
	if (request.getAttribute("cityID") != null) {
		cityID = (String) request.getAttribute("cityID");
	}
%>
<%
	if (request.getAttribute("isEdit") != null) {
	title_ = "Edit an existing Postal Code";
	method_ = "PUT";
	action_ = "edit/execute";
	readOnly_ = true;
}
%>

<h1><%=title_%></h1>

<div id="postal-code-form">
	<form:form action="<%=action_%>" modelAttribute="postalCode"
		method="<%=method_%>">

		<!-- text element to enter new postal code. -->
		<div class="form-group">
			<label for="postal-code">Postal Code:</label>
			<form:input path="postalCode" type="text" class="form-control"
				id="postal-code" aria-placeholder="Enter postal code here..."
				aria-describedby="postalCodeHelp" disabled="<%=readOnly_%>" />
			<div id="postalCodeHelp">
				<small class="form-text text-muted">A valid postal code has
					form of X#X#X#. For example, N5C7U1.</small> <small
					class="form-text text-muted">When you are editing an
					existing postal code, you can only change the city it belongs to.
					Consider deleting the postal code and re-create if the postal code
					itself is wrong.</small>
			</div>

		</div>

		<!-- select elenent to choose existing city. -->
		<div class="form-group">
			<label for="city">City:</label>
			<form:select path="city" id="city">
				<c:forEach var="eachCity" items="${ cities }">
					<%-- There is no counterpart for c:if so c:choose is the choice here. --%>
					<c:choose>
						<c:when test="${ eachCity.cityID == cityID }">
							<form:option value="${ eachCity.cityID }"
								label="${ eachCity.cityName }" selected="true" />
						</c:when>
						<c:otherwise>
							<form:option value="${ eachCity.cityID }"
								label="${ eachCity.cityName }" />
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</form:select>
		</div>

		<!-- Submit button -->
		<input type="submit" value="Save" class="btn btn-primary" />
	</form:form>
</div>

<%@ include file="../footer.jsp"%>