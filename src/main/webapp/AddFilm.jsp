<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
	<h1>Add a Film</h1>
	<br>
	<form action="AddFilm.do">
		Title:<input type="text" name="title"><br> Description:<input
			type="text" name="description"><br> Release Year:<input
			type="text" name="releaseYear"><br> Rental Duration:<input
			type="text" name="rentalDuration"><br> Rental Rate:<input
			type="text" name="rentalRate"><br> Length:<input
			type="text" name="length"><br> Replacement Cost:<input
			type="text" name="replacementCost"><br> Rating:<input
			type="radio" name="rating" value="G">G <input type="radio"
			name="rating" value="PG">PG <input type="radio"
			name="rating" value="PG13">PG13 <input type="radio"
			name="rating" value="R">R <br>
		<input type="submit">
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