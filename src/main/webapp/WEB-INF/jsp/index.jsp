<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>Books</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>


<body>
	<div class="container" style="margin-top: 15px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Pages</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ books }" var="book">
				<tr>
					<td>${ book.id }</td>
					<td>${ book.title }</td>
					<td>${ book.author }</td>
					<td>${ book.pages }</td>
					<td>
						<a class="btn btn-warning" href="edit?id=${ book.id }">Edit</a>	
						<a class="btn btn-danger" href="remove?id=${ book.id }">Remove</a>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<a class="btn btn-success" href="add">Add</a>
	</div>
</body>
</html>
