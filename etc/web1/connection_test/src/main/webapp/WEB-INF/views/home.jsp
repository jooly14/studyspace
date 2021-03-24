<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8">	
 <title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<table border = "1">
<tr>
<td>아이디</td>
<td>비밀번호</td>
</tr>
<c:forEach var = "dto" items ="${list}">
<tr>
	<td>${dto.id}</td>
	<td>${dto.pw}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
