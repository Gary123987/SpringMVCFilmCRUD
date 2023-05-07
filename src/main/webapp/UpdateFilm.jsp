<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Update a Film</h1>

	<form action="updateFilmV2.do">
		Film ID (<em>Locked</em>): <input type="text" name="ID"
			value="${film.filmId }" readonly><br> Title: <input
			type="text" value="${film.title}" name="title" required /><br>
		Description: <input type="text" value="${film.desc}"
			name="description" required /><br> Release Year: <input
			type="text" value="${film.releaseYear}" name="releaseYear" required /><br>
		Rental Duration: <input type="text" value="${film.rentDur}"
			name="rentalDuration" required /><br> Rental Rate: <input
			type="text" value="${film.rate}" name="rate" required /><br>
		Runtime: <input type="text" value="${film.length}" name="length"
			required /><br> Replacement Cost: <input type="text"
			value="${film.repCost}" name="repCost" required /><br> Rating
		(Current is ${film.rating}): <input type="radio" name="rating"
			value="G">G <input type="radio" name="rating" value="PG"
			required>PG <input type="radio" name="rating" value="PG13">PG13
		<input type="radio" name="rating" value="R">R <br> <inputs
			type="submit" class="btn btn-dark" />
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