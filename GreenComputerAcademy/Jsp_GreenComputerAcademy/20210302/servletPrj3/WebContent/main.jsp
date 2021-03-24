<%@page import="mvc.dto.MDto"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<td>번호</td>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
</tr>
<c:forEach var="v" items="${result}">
	<tr>
	 	<td>${v.idx}</td>
		<td>${v.id}</td>
		<td>${v.pw}</td>
		<td>${v.name}</td> 
	</tr>	
</c:forEach>
</table>
</body>
</html>