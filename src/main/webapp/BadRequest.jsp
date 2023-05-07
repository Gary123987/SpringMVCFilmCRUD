<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Viewer</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div>
		<img
			src="https://thumbs.dreamstime.com/b/movie-slate-film-reel-wood-clapper-wooden-backgorund-36502412.jpg"
			width="300" height="200" alt="stock cinema photo" />
		<p>
					<h2>Invalid request. Please try again.</h2>

	</div>

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