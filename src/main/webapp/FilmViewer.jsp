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
			<c:choose>

				<c:when test="${films.size() > 0 }">
					<c:forEach var="film" items="${films}">
			Title: <strong>${film.title }</strong>
						<br>Cast: 
			<c:if test="${empty film.actors }">
							<em>None</em>
						</c:if>
						<c:forEach var="actor" items="${film.actors }" varStatus="loop">
							<em> ${actor}<c:if test="${!loop.last }">, </c:if></em>
						</c:forEach>
						<br>${film.desc }
		<ul>
							<li><em>Film ID: <strong>${film.filmId }</strong></em></li>
							<li>Release Year: ${film.releaseYear }</li>
							<li>Rating: ${film.rating }</li>
							<li>Runtime: ${film.length } minutes</li>
							<li>Rental Duration: ${film.rentDur} weeks</li>
							<li>Rental Rate: <fmt:formatNumber type="currency"
									value="${film.rate }" /></li>
							<li>Replacement Cost: <fmt:formatNumber type="currency"
									value="${film.repCost }" /></li>
							<li>Language ID: ${film.langId }</li>
							<li>Language: ${film.language }</li>
							<li>Category: ${film.category }</li>
							<li>Special Features: ${film.features }</li>
							<li><a
								href="updateFilm.do?filmID=<c:out value="${film.filmId}" />"
								class="btn btn-primary" role="button">Update this Film</a></li>
						</ul>
						<hr>
					</c:forEach>
				</c:when>

				<c:when test="${not empty film }">
			Title: <strong>${film.title }</strong>
					<br>Cast:
			<c:if test="${empty film.actors }">
						<em>None</em>
					</c:if>
					<c:forEach var="actor" items="${film.actors }" varStatus="loop">
						<em> ${actor}<c:if test="${!loop.last }">, </c:if></em>
					</c:forEach>
					<br>${film.desc }
		<ul>
						<li><em>Film ID: <strong>${film.filmId }</strong></em></li>
						<li>Release Year: ${film.releaseYear }</li>
						<li>Rating: ${film.rating }</li>
						<li>Runtime: ${film.length } minutes</li>
						<li>Rental Duration: ${film.rentDur} weeks</li>
						<li>Rental Rate: <fmt:formatNumber type="currency"
								value="${film.rate }" /></li>
						<li>Replacement Cost: <fmt:formatNumber type="currency"
								value="${film.repCost }" /></li>
						<li>Language ID: ${film.langId }</li>
						<li>Language: ${film.language }</li>
						<li>Category: ${film.category }</li>
						<li>Special Features: ${film.features }</li>
						<li><a
							href="updateFilm.do?filmID=<c:out value="${film.filmId}" />"
							class="btn btn-primary" role="button">Update Film</a></li>
					</ul>
				</c:when>

				<c:otherwise>
					<h2>No film found in database.</h2>
				</c:otherwise>

			</c:choose>
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