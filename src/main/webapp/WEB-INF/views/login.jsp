<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>movie-list-customer</title>
<meta name="viewport" content="width=device-width, initial-scale">
<link href="login.css" type="text/css" rel="stylesheet">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script type="text/javascript" src="js.js"></script>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
nav {
	background-color: #005b96;
	color: #ffffff;
	display: flex;
	height: 60px;
}

.start {
	width: 50%;
	margin: auto;
	font-family: inherit;
	display: flex;
}

.start a {
	color: white;
	float: right;
	font-size: 1.5em;
	margin-left: 500px
}

.start p {
	font-size: 24px;
	padding-left: 30px;
	margin: 0px;
	padding-top: 10px;
	padding-right: 20px
}
</style>
<!------------------------------------------------------------------>
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
					<a href="#"><span>Support</span></a>
				</div>
			</nav>
		</header>
	</div>
	<!----------------------------------------------------->
	
	<form method="post" id="myForm" name="myForm" class="col-1" >
		<table>
			<h1 style="font-size: 30px; text-align: center;">Login</h1>
			<font color="red">${errorMessage}</font>
			<tr>
				<td>Username</td>
				<td><input id="username" type="text" maxlength="12"
					name="name" placeholder="Enter Username">
				<div id="mycar"></div></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><input id=password type="password" maxlength="12"
					name="password" placeholder="Enter Password"></td>
			</tr>


		</table>
		<br>
		<br>

		<div class="col-2">
			<input
				style="background-color: #005b96; margin-left: 20%; color: white;"
				type="Submit" value="Login"> <span class="psw">New
				here? <a href="Signup">Signup</a>
			</span>
		</div>


	</form>
	<!--------------------------------------------------------------------->
	<div id="footer">
		<footer>
			<span>Copyright &#169; 2019</span>
		</footer>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>