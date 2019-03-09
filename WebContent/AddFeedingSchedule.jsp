
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
			eZoo <small>Add Feeding Schedule</small>
		</h1>
		<hr class="paw-primary">

		<form action="AddFeedingScheduleServlet" method="post"
			class="form-horizontal">

			<div class="form-group">
				<label for="schedule_id" class="col-sm-4 control-label">ID</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" id="schedule_id"
						name="schedule_id" placeholder="ID" required="required" />
				</div>
			</div>
			<div class="form-group">
				<label for="food" class="col-sm-4 control-label">Food</label>
				<div class="col-sm-4">
					<select required="required" name="food" class="form-control">
						<option value="hay">hay</option>
						<option value="fruit and vegetable mix">fruit and
							vegetable mix</option>
						<option value="pollen and nectar">pollen and nectar</option>
						<option value="mealworms and smelt">mealworms and smelt</option>
						<option value="goat chow">goat chow</option>
						<option value="feline chow">feline chow</option>
						<option value="beef">beef</option>
						<option value="crickets">crickets</option>
						<option value="canned primate diet">canned primate diet</option>
						<option value="monkey biscuits">monkey biscuits</option>
						<option value="straw">straw</option>
						<option value="frozen rodents">frozen rodents</option>
						<option value="insect mix">insect mix</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="notes" class="col-sm-4 control-label">notes</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="notes" name="notes"
						placeholder="notes" />
				</div>
			</div>
			<div class="form-group">
				<label for="numberPounds" class="col-sm-4 control-label">number
					of pounds (lbs)</label>
				<div class="col-sm-4">
					<input type="number" step="0.10" class="form-control"
						id="numberPounds" name="numberPounds" placeholder="numberPounds"
						required="required" />
				</div>
			</div>
			<div class="form-group">
				<label for="hoursBetweenFeedings" class="col-sm-4 control-label">number
					of hours between feedings (hours)</label>
				<div class="col-sm-4">
					<input type="number" step="0.25" class="form-control"
						id="hoursBetweenFeedings" name="hoursBetweenFeedings"
						placeholder="hoursBetweenFeedings" required="required" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-1">
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</div>
		</form>
	</div>
</header>


<!-- Footer -->
<jsp:include page="footer.jsp" />