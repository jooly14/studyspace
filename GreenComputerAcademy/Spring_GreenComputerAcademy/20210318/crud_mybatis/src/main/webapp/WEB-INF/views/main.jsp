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
	<input type="text" name="id" placeholder="아이디"><br>
	<input type="password" name="pw" placeholder="비밀번호"><br>
	<textarea name="content" placeholder="내용"></textarea><br>
	<input type="submit" value="입력">
</form>
</body>
</html>