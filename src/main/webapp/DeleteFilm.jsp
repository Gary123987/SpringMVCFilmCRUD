<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Film</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Enter Film ID to Delete</h1>

	<form action="deleteFilm.do">
		Film ID: <input type="text" name="id"> <input type="submit"
			class="btn btn-dark">
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