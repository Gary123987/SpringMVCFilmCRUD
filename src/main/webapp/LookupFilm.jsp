<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="FilmLookup.do">
Please enter the ID you wish to lookup:<br>
<input type="text" name="FilmID">
<input type="submit" value="submit">
</form>

<form action="FilmLookup2.do">
Please enter a keyword or phrase to search by:<br>
<input type="text" name="keyword">
<input type="submit">
</form>





	<hr>
	<p>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add a Film</a>
		<a href="DeleteFilm.jsp" class="btn btn-secondary" role="button">Delete a Film</a>
		<a href="LookupFilm.jsp" class="btn btn-secondary" role="button">Lookup another Film</a>
	</p>
</body>
</html>