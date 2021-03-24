<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="doUpdate" method="post">
<table>
	<tr>
		<td>글번호</td>
		<td>${dto.idx}<input type="hidden" name="idx" value="${dto.idx}"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" value="${dto.title}"></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${dto.writer}</td>
	</tr>
	<tr>
		<td>작성시간</td>
		<td>${dto.regdate}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${dto.hit}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" rows="5" cols="20">${dto.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정"></td>
	</tr>
</table>
</form>
<a href="main">목록</a>
</body>
</html>