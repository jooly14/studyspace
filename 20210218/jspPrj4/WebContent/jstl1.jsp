<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	<c:set var="val2" value="30" scope="page"/>
	${pageScope.val2}<br>
	<%
		Map<String,String> map1 = new HashMap<>();
	%>
	<c:set target="<%=map1 %>" property="prop1" value="hi" />
	<%=map1.get("prop1") %><br>
	
	<c:remove var="val2" />
	-- ${pageScope.val2} --<br>
</body>
</html>