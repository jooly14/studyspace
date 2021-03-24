<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="controller?cmd=signupproc" method="post">
		id<input type="text" name="id" placeholder="${result.id}"><br>
		pw<input type="password" name="pw"><br>
		name<input type="text" name="name" value="${result.name}"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>