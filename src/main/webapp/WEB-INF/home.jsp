<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Spring MVC site</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>MVCFilmSite</h1>
	<p>What would you like to do?</p>
	<a href="AddFilm.jsp" class="btn btn-primary" role="button">Add
		Film </a>
	<br><br>
	<a href="DeleteFilm.jsp" class="btn btn-primary" role="button">Delete
		Film</a>
	<br><br>
	<a href="LookupFilm.jsp" class="btn btn-primary" role="button">Lookup
		Film</a>
	<br>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>