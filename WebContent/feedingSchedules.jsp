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
			eZoo <small>Feeding Schedules</small>
		</h1>

		<hr class="paw-primary">

		<table
			class="table table-striped table-hover table-responsive ezoo-datatable">
			<thead>
				<tr>
					<th class="text-center">Feeding schedule ID</th>
					<th class="text-center">Food</th>
					<th class="text-center">Notes</th>
					<th class="text-center">Time between feedings (in hours)</th>
					<th class="text-center">Amount to feed (in pounds)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="feedingSchedule" items="${feedingSchedules}">
					<tr>
						<td><fmt:formatNumber value="${feedingSchedule.schedule_id}" /></td>
						<td><c:out value="${feedingSchedule.food}" /></td>
						<td><c:out value="${feedingSchedule.notes}" /></td>
						<td><fmt:formatNumber
								value="${feedingSchedule.hoursBetweenFeedings}" /></td>
						<td><fmt:formatNumber value="${feedingSchedule.numberPounds}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</header>
<!-- Footer -->
<jsp:include page="footer.jsp" />