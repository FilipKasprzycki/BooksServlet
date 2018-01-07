<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<title>Edit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<style>
.outer {
	display: table;
	position: absolute;
	height: 100%;
	width: 100%;
}

.middle {
	display: table-cell;
	vertical-align: middle;
}

.inner {
	margin-left: auto;
	margin-right: auto;
	width: 700px; /*whatever width you want*/
}
</style>


<body>
	<div class="outer">
		<div class="middle">
			<div class="inner">

				<form method="post" action="edit">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Title</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="title"
								value="${ book.title }">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Author</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="author"
								value="${ book.author }">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Pages</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" name="pages"
								value="${ book.pages }">
						</div>
					</div>
					
					<input type="hidden" name="id" value="${ book.id }" />
					
					<div class="form-group row">
						<div class="col-sm-10">
							<a class="btn btn-default" href="index">Back</a>
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>
