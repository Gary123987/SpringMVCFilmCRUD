<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookup Film</title>
</head>
<body>
	<h1>Film Lookup</h1>
	<form action="FilmLookup.do">
		Please enter Film ID you wish to lookup:<br> <input type="text"
			name="FilmID"> <input type="submit">
	</form>

	<form action="FilmLookup2.do">
		Please enter a keyword or phrase to search by:<br> <input
			type="text" name="keyword"> <input type="submit">
	</form>

	<hr>
	<p>
				<a href="home.do"><img src="https://images.freeimages.com/clg/istock/previews/1056/105623323-home-sign-icon-main-page-button-navigation.jpg" width="40" height="40" alt="home icon"></a> | <a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add
			Film</a> | <a href="DeleteFilm.jsp" class="btn btn-secondary" role="button">Delete
			Film</a> | <a href="LookupFilm.jsp" class="btn btn-secondary" role="button">Lookup
			Film</a>
	</p>
</body>
</html>