<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>파일이름</td>
			<td>다운로드</td>
			<td>이름</td>
		</tr>
		<c:forEach var="d" items="${dtos}">
		<tr>
			<td>${d.idx}</td>
			<td>${d.filename}</td>
			<td><a href="download?filename=${d.filename}">다운로드</a></td>
			<td>${d.name}</td>
		</tr>
		</c:forEach>
	</table>
	<hr>
	<form method="post" action="upload" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="text" name="name" placeholder="이름">
		<input type="submit" value="파일 업로드">
	</form>
</body>
</html>