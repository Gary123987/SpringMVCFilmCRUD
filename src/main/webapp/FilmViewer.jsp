
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Viewer</title>
</head>
<body>

	${film }

	<div class="filmdetail">
		<img
			src="https://thumbs.dreamstime.com/b/movie-slate-film-reel-wood-clapper-wooden-backgorund-36502412.jpg"
			width="300" height="200" alt="stock cinema photo" />
		<p>
			Title: <strong>${film.title }</strong> 
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
			<%-- <p>Language: ${film.language }</p> --%>
			<li>Special Features: ${film.features }</li>
		</ul>
	</div>
	
	<p>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add a Film</a>
		<a href="DeleteFilm.jsp" class="btn btn-secondary" role="button">Delete a Film</a>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Update an existing Film</a>


	<c:forEach items="${films}" var="film">
    ${film.title}<br>
	</c:forEach>


</body>
</html>