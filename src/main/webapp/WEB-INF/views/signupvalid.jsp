<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="loginvalidation.js"></script>
<link href="login.css" type="text/css" rel="stylesheet">

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
		<h1>Sign Up</h1>
		<form method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Name</label> <input type="text"
					class="form-control" id="name" aria-describedby="emailHelp"
					placeholder="Enter name" name="name">
				<h5 id="usercheck" style="color: red;">**Username is missing</h5>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="password"
					placeholder="Password" name="password">
				<h5 id="passcheck" style="color: red;">**Please Fill the
					password</h5>
			</div>
			<div class="form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary" id="submit">Submit</button>
		</form>
	</div>
	<!--------------------------------------------------------------------->
	<div id="footer">
		<footer>
			<span>Copyright &#169; 2019</span>
		</footer>
	</div>

</body>
</html>
