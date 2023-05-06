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
			type="text" name="rating"> <input type="submit">
	</form>

</body>
</html>