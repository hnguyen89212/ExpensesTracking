<%@ include file="../header.jsp"%>

<div>
	<div>Are you sure about deleting the postal code "${ postalCode.postalCode }"?</div>
	<form:form action="delete/execute" modelAttribute="postalCode"
		method="DELETE">
		<form:hidden path="postalCode" value="${ postalCode.postalCode }" />
		<input type="submit" value="Delete" class="btn btn-danger" />
	</form:form>

	<a class="btn btn-warninig" href="delete/cancel">Cancel</a>
</div>

<%@ include file="../footer.jsp"%>