<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Cruiser</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="Style.css" type="text/css" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta name="viewport" content="width=device-width, initial-scale">

<!--------------------------------------------------------------------------------------------------->


<!--------------------------------------------------------------------------------------------------->

</head>
<body>
	<div id="section1">
		<header>
			<nav>
				<div class="start">
					<p>Movie Cruiser</p>
					<i class='fas fa-film' style='font-size: 45px'></i>
				</div>
				<div class="start">
					<a href="#"><span>Movies</span></a>
				</div>
			</nav>
		</header>
	</div>
	<div class="container">
		<h1>Movie List</h1>
		<table class=table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Box Office</th>
					<th>Active</th>
					<th>Date Of Launch</th>
					<th>Genre</th>
					<th>Has Teaser</th>
					<th>Action</th>
				</tr>
			</thead>
			</tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.title}</td>
					<td>$${item.boxOffice}</td>
					<td>${item.isActive}</td>
					<td>${item.date_of_launch}</td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser}</td>
					<td><a href="edit?menu_id=${item.id}">${item.action}</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>


	</div>
	<!--------------------------------------------------------------------------------------------------->

	<div id="footer">
		<footer>
			<span>Copyright &#169; 2019</span>
		</footer>
	</div>
	<!--------------------------------------------------------------------------------------------------->

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>