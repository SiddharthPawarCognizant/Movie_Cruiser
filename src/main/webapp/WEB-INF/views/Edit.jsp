<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Menu-Edit</title>

<link href="Style.css" type="text/css" rel="stylesheet">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>


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
					<a href="returnAdmin"><span>Main Page</span></a>
				</div>
			</nav>
		</header>
	</div>
	<!----------------------------------------------------->
	<div class="admin">
		<h1>Edit Movie</h1>
		<form method="post" onsubmit="myFun()">
			<label for="itemedit"><b>Movie</b></label> <br> <br> <input
				type="text" placeholder="Enter Item name" id="itemedit" name="itemedit" required="">
			<span id="iname-res"></span>
			<div class="editform">
				<div class="four-col">
					<label for="price"><b>Box Office</b></label> <br> <br> <input
						type="number" id="price" name="price" required=""> <span
						id="pname-res"></span>
				</div>

				<div class="four-col">
					<label for="activity"><b>Active</b></label> <br> <br> <input
						type="radio" value="Yes" name="activity" id="activity" required="">Yes
					<input type="radio" value="No" name="activity" id="activity"
						required="">No
				</div>
				<div class="four-col">
					<label for="date"><b>Date of Launch</b></label> <br> <br>
					<input type="date" id="date" required=""> <span
						id="dname-res"></span>
				</div>
				<div class="four-col">
					<label for="Category"><b>Genre</b></label> <br> <br> <select
						name="Category" id="Category" required="">
						<option value="Choose">Choose</option>
						<option value="Science Friction">Science Friction</option>
						<option value="Superhero">Superhero</option>
						<option value="Romance">Romance</option>
						<option value="Science Friction">Science Friction</option>
						<option value="Superhero ">Superhero</option>
					</select> <span id="cname-res"></span>
				</div>

			</div>
			
			<div class="freed">
				<label for="activity"><b>Has Teaser</b></label> <br> <br>
				<input type="radio" value="Yes" name="free" id="free" required="">Yes
				<input type="radio" value="No" name="free" id="free" required="">No
			</div>
			<div>
				<a href="edit"><input type="submit" id="editsub" value="Save"></a>
			</div>
		</form>

	</div>

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