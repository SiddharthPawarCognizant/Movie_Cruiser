<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- <script src="proj.js"></script> -->

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta name="viewport" content="width=device-width, initial-scale">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>


<style>
#footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #A9A9A9;
	height: 50px;
}

#footer span {
	line-height: 50px;
	padding-left: 30px;
}
</style>
</head>
<body>


	<nav class="navbar navbar-expand-md bg-primary navbar-dark">
		<a class="navbar-brand" href="#">Movie Cruiser <i
			class='fas fa-film' style='font-size: 45px'></i></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="car">Favourites</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="table">
			<h1>Movies</h1>
			<table class="table table-dark table_hover table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Box Office</th>
						<th>Genre</th>
						<th>Has Teaser</th>
						<th>Action</th>
<!-- 						<th>JS Button</th>
 -->					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listCust}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.title}</td>
							<td>$${item.boxOffice}</td>
							<td>${item.genre}</td>
							<td>${item.hasTeaser}</td>
							<td><a href="cart?menu_id=${item.id}">Add To Favourites</a></td>
<%-- 							<td><a class="btn btn-warning" onClick="cartt('${item.title}','${item.id}')">Add-To-Cart</a></td>	
 --%>						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div id="footer">
		<footer>
			<span>Copyright &#169; 2019</span>
		</footer>
	</div>
</body>
</html>