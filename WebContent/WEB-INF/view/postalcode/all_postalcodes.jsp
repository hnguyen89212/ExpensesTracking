<%@ include file="../header.jsp"%>
<h1>All Postal Codes</h1>
<c:forEach var="eachPostalCode" items="${ postalCodes }">
	<li>"${ eachPostalCode.postalCode }"</li>
</c:forEach>
<%@ include file="../footer.jsp"%>