<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Select an ID to Delete</h1><br>

<form action="deleteFilm.do">
<input type="text" name="id">
<input type="submit">



</form>



	<hr>
	<p>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Add a Film</a>
		<a href="DeleteFilm.jsp" class="btn btn-secondary" role="button">Delete a Film</a>
		<a href="LookupFilm.jsp" class="btn btn-secondary" role="button">Lookup another Film</a>
		<a href="AddFilm.jsp" class="btn btn-secondary" role="button">Update an existing Film</a>
	</p>
</body>
</html>