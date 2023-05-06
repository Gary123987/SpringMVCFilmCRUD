<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Update a Film</h1>

	<form action="updateFilmV2.do">
		Film ID: <input type="text" name="ID" value="${film.filmId }" readonly><br>
		Title: <input type="text" value="${film.title}" name="title" /><br>
		Description: <input type="text" value="${film.desc}"
			name="description" /><br> Release Year: <input type="text"
			value="${film.releaseYear}" name="releaseYear" /><br> Rental
		Duration: <input type="text" value="${film.rentDur}"
			name="rentalDuration" /><br> Rental Rate: <input type="text"
			value="${film.rate}" name="rate" /><br> Length: <input
			type="text" value="${film.length}" name="length" /><br>
		Replacement Cost: <input type="text" value="${film.repCost}"
			name="repCost" /><br> Rating: (Current is ${film.rating})<input
			type="radio" name="rating" value="G">G <input type="radio"
			name="rating" value="PG" required>PG <input type="radio"
			name="rating" value="PG13">PG13 <input type="radio"
			name="rating" value="R">R <br> <input type="submit" />
	</form>





	<hr>
	<p>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add
			a Film</a> <a href="DeleteFilm.jsp" class="btn btn-secondary"
			role="button">Delete a Film</a> <a href="LookupFilm.jsp"
			class="btn btn-secondary" role="button">Lookup another Film</a>
	</p>
</body>
</html>