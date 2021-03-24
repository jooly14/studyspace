<%@page import="java.util.Date"%>
<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "가,나,다,라,마,바,사,아,자";
	StringTokenizer s = new StringTokenizer(str,",");
	while(s.hasMoreElements()){
		out.println(s.nextElement());
	}
%>
<br>
	<c:set var="arr" value="${'가,나,다,라,마,바,사,아,자'}" />
	<c:forTokens var="t" items="${arr}" delims=",">
		${t}<br>
	</c:forTokens>
<br>

	<c:url value="http://search.daum.net/search" var="searchUrl">
		<c:param name="w" value="blog" />
		<c:param name="q" value="공원" />
	</c:url>
	<c:url var="url2" value="./use_if_tag.jsp" />
	<ul>
		<li><a href="${searchUrl}">${searchUrl}</a></li>
		<li><c:url value="/use_if_tag.jsp" /></li>
		<li><a href="${url2}">${url2}</a></li>
	</ul>
	<c:out value="${10+20} ==" escapeXml="false"/>
	<br>
	<fmt:formatDate value="<%=new Date() %>" type="date" pattern="yyyy-MM-dd"/>
	
</body>
</html>