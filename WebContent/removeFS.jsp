<!-- Header -->
<jsp:include page="header.jsp" />

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- 	Just some stuff you need -->
<header>
	<div class="container">

		<c:choose>
			<c:when test="${not empty message }">
				<p class="alert ${messageClass}">${message }</p>
				<%
					session.setAttribute("message", null);
							session.setAttribute("messageClass", null);
				%>
			</c:when>
		</c:choose>


		<h1>
			eZoo <small>Remove Animal Feeding Schedule</small>
		</h1>

		<hr class="paw-primary">

		<table
			class="table table-striped table-hover table-responsive ezoo-datatable">
			<thead>
				<tr>
					<th class="text-center">Animal ID</th>
					<th class="text-center">Animal name</th>
					<th class="text-center">Feeding schedule ID</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="animal" items="${animals}">
					<tr>
						<td><fmt:formatNumber value="${animal.animalid}" /></td>
						<td><c:out value="${animal.name}" /></td>
						<td><c:out value="${animal.schedule_id}" /></td>
						<td><form action="RemoveFS" method="post"
								class="form-horizontal">
								<input type="hidden" name="animalid"
									value="${animal.getAnimalid()}" />
								<button type="submit" class="btn btn-primary">Remove</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			</div>
</header>
<!-- Footer -->
<jsp:include page="footer.jsp" />

