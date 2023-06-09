<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Film</title>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Add a Film</h1>
	<form action="AddFilm.do">
		Title: <input type="text" name="title" required><br>
		Description: <input type="text" name="description" required><br>
		Release Year: <input type="text" name="releaseYear" required><br>
		Rental Duration: <input type="text" name="rentalDuration" required><br>
		Rental Rate: <input type="text" name="rentalRate" required><br>
		Runtime: <input type="text" name="length" required><br>
		Replacement Cost: <input type="text" name="replacementCost" required><br>
		Rating: <input type="radio" name="rating" value="G">G <input
			type="radio" name="rating" value="PG" required>PG <input
			type="radio" name="rating" value="PG13">PG-13 <input
			type="radio" name="rating" value="R">R <br> <input
			type="submit" class="btn btn-dark">
	</form>

	<hr>
	<p>
		<a href="home.do"><img
			src="https://images.freeimages.com/clg/istock/previews/1056/105623323-home-sign-icon-main-page-button-navigation.jpg"
			width="40" height="40" alt="home icon"></a> <a href="AddFilm.jsp"
			class="btn btn-secondary" role="button">Add Film</a> <a
			href="DeleteFilm.jsp" class="btn btn-secondary" role="button">Delete
			Film</a> <a href="LookupFilm.jsp" class="btn btn-secondary" role="button">Lookup
			Film</a>
	</p>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>