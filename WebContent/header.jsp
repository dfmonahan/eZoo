<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eZoo</title>
<link rel="shortcut icon" href="resources/imgs/favicon.png"
	type="image/x-icon">

<!-- CSS - Custom fonts -->
<link href="resources/libraries/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<!-- <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> -->

<!-- CSS - jQuery DataTables -->
<link
	href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />

<!-- CSS - Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="resources/libraries/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="resources/libraries/css/freelancer.css" />
<link rel="stylesheet" type="text/css"
	href="resources/libraries/css/half-slider.css" />

<!-- CSS - Custom -->
<link rel="stylesheet" type="text/css"
	href="resources/styles/custom.css" />

</head>
<body id="page-top" class="index">

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!--                 <a class="navbar-brand" href="#page-top">PubHub</a> -->
			<a tabindex="-1" class="navbar-brand"
				href="${pageContext.request.contextPath }">eZoo</a>
			<c:if test="${authUser != null }">
				<p class="navbar-text">Welcome: ${authUser.username}</p>
			</c:if>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a tabindex="-1" href="#"
					class="dropdown-toggle" data-toggle="dropdown">Animal Care<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="animalCare">Home (Level 100)</a></li>
						<li class="divider"></li>
						<li><a href="addAnimal">Add Animal</a></li>
						<li><a href="FeedingSchedules">Feeding Schedules</a></li>
						<li><a href="AddFeedingScheduleServlet">Create Feeding
								Schedule</a></li>
						<li><a href="UpdateFS">Update Feeding Schedules</a></li>
						<li><a href="DeleteFeedingScheduleServlet">Delete Feeding
								Schedule</a></li>
						<li><a href="AssignFS">Assign Animal Feeding Schedule</a></li>
						<li><a href="RemoveFS">Remove Animal Feeding Schedule</a></li>
					</ul></li>
				<li class="dropdown"><a tabindex="-1" href="#"
					class="dropdown-toggle" data-toggle="dropdown">Event Management<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="eventManagement">Home (Level 200)</a></li>
						<li class="divider"></li>
						<li><a href="#">Create Event</a></li>
					</ul></li>
				<li class="dropdown"><a tabindex="-1" href="#"
					class="dropdown-toggle" data-toggle="dropdown">Employee
						Management<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="employeeManagement">Home (Level 300)</a></li>
						<li class="divider"></li>
						<li><a href="#">Health Plans</a></li>
						<li><a href="#">All Users</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
</body>
</html>