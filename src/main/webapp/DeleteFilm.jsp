<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Film</title>
</head>
<body>
	<h1>Enter Film ID to Delete</h1>

	<form action="deleteFilm.do">
		Film ID: <input type="text" name="id"> <input type="submit">
	</form>
	<hr>
	<p>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add
			Film</a> | <a href="DeleteFilm.jsp" class="btn btn-secondary"
			role="button">Delete Film</a> | <a href="LookupFilm.jsp"
			class="btn btn-secondary" role="button">Lookup Film</a>
	</p>
</body>
</html>