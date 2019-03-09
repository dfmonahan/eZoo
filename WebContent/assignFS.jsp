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
		eZoo <small>Assign Animal Feeding Schedule</small>
	</h1>

	<hr class="paw-primary">

	<table
		class="table table-striped table-hover table-responsive ezoo-datatable">
		<thead>
			<tr>
				<th class="text-center">Animal ID</th>
				<th class="text-center">Animal name</th>
				<th class="text-center">Feeding schedule ID</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="animal" items="${animals}">
				<tr>
					<td><fmt:formatNumber value="${animal.animalid}" /></td>
					<td><c:out value="${animal.name}" /></td>
					<td><c:out value="${animal.schedule_id}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>
		eZoo <small>List of Available Feeding Schedules</small>
	</h1>
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
		<h1>
			eZoo <small>Assign Feeding Schedule</small>
		</h1>

		<form action="AssignFS" method="post" class="form-horizontal">
		
			<div class="form-group">
				<label for="animalid" class="col-sm-4 control-label">Animal
					ID</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="animalid"
						name="animalid" placeholder="ID" required="required" />
				</div>
			</div>
			<div class="form-group">
				<label for="schedule_id" class="col-sm-4 control-label">Feeding
					schedule ID</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="schedule_id"
						name="schedule_id" placeholder="schedule_id" required="required" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</div>
		</form>
	</div>
</header>
<!-- Footer -->
<jsp:include page="footer.jsp" />
