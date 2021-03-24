<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.ldata}">
		<form action="login" method="post">
			아이디<input type="text" name="id"><br>
			비밀번호<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
	</c:when>
	<c:otherwise>
		${sessionScope.ldata}님 반갑습니다.<br>
		<a href="logout">로그아웃</a><br>
	</c:otherwise>
</c:choose>
	<hr>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="dtos" items="${dtos}">
		<tr>
			<td>${dtos.idx}</td>
			<td><a href="read?idx=${dtos.idx}">${dtos.title}</a></td>
			<td>${dtos.writer}</td>
			<td>${dtos.regdate}</td>
			<td>${dtos.hit}</td>
		</tr>
		</c:forEach>
	</table>
		<hr>
		<div>
			<a href="insert">글쓰기</a>
		</div>
</body>
</html>