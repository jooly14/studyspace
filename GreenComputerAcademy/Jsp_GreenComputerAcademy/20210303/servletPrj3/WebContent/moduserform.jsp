<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="controller?cmd=moduser" method="post">
		<input type="hidden" name="idx" value="${result.idx}">
		기존 pw<input type="password" name="oldpw"><br>
		pw<input type="password" name="pw"><br>
		name<input type="text" name="name" value="${result.name}"><br>
		<input type="submit" value="회원정보 수정">
	</form>
</body>
</html>