<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin List</title>
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
		<a class="navbar-brand" href="#">Movie Cruiser <i class='fas fa-film' style='font-size: 45px'></i></a>
		 
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Movies</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="table">
			<h1>Movies</h1>
			<table class="table table-dark table_hover table-bordered">
				   <h1 style="font-size:25px;text-align: center;">Signup</h1>
            <div class="top-row">
                <div class="field-wrap">
                    <label>
                        Username<span class="req">=</span>
                    </label>
                    <input type="text" placeholder="Enter Username" name="username" required autocomplete="off" />
                    
                </div>
                
                <div class="field-wrap">
                <label>
                    Password<span class="req">=</span>
                </label>
                    <input type="password" placeholder="Enter Password" name="password" required autocomplete="off"/>
                     <label>
                   Confirm <br>Password<span class="req">=</span>
                </label>
                    <input type="password" placeholder="Enter Confirm Password" required autocomplete="off"/>
                </div>
            </div>

            <div class="clearfix">
                <button type="submit" class="btn btn-warning" style="background-color:#005b96;margin-left: 40%;">Signup</button>
                
            </div>
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