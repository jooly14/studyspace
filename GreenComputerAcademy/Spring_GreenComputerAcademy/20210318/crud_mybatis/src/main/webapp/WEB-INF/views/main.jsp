<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dto" items="${dtos}">
	${dto.idx}/${dto.id}/${dto.pw}/${dto.content}<br>
</c:forEach>
<hr>
<form action="insert" method="post">
	<input type="text" name="id" placeholder="���̵�"><br>
	<input type="password" name="pw" placeholder="��й�ȣ"><br>
	<textarea name="content" placeholder="����"></textarea><br>
	<input type="submit" value="�Է�">
</form>
</body>
</html>