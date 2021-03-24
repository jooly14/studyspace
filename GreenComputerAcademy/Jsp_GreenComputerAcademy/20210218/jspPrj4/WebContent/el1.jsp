<%@page import="jspPrj4.Member"%>
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
	<%
		Member m = new Member();
		m.setName("name1");
	%>
	<c:set var="m" value="<%=m %>" />
	<c:set var="name" value="#{m.name}" />
	<%m.setName("name2"); %>
	${name}<br>
	<%m.setName("name3"); %>
	${name}
</body>
</html>