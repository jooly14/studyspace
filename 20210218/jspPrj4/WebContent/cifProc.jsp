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
<%-- <%
	String str= request.getParameter("id");
	if(str.equals("khw")){
		out.println("김현우");
	}else{
		out.println("뉴규?");
	}
%> --%>
<c:set var="id" value="${param.id}"/>
<c:if test="${id eq 'khw'}">
	김현우
</c:if>
<c:if test="${id ne 'khw'}">
	뉴규?
</c:if>
</body>
</html>