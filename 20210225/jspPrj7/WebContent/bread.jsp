<%@page import="com.joo.dto.BDto"%>
<%@page import="com.joo.dao.BDao"%>
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
	String idx = request.getParameter("idx");
	BDao dao = new BDao();
	
	if(session.getAttribute("hitip"+idx) == null){
		int result = dao.setHit(idx);
		session.setAttribute("hitip"+idx, request.getRemoteAddr());
	}
	
	BDto dto = dao.read(idx);
%>
<c:set var="dto" value="<%=dto%>" />
<table border="1">
	<tr>
		<td>[${dto.idx}] ${dto.title}</td>
		<td>�ۼ��� : ${dto.id}</td>
	</tr>
	<tr>
		<td>�ۼ��ð� : ${dto.regdate}</td>
		<td>��ȸ�� : ${dto.hit}</td>
	</tr>
	<tr>
		<%
			if(session.getAttribute("logindata")!=null){
		%>
		<td colspan="2"><input type="button" value="���ƿ�(${dto.good})" onclick="location.href='bgb.jsp?idx=${param.idx}&like=good'">
		<input type="button" value="�Ⱦ��(${dto.bad})" onclick="location.href='bgb.jsp?idx=${param.idx}&like=bad'"></td>
		<%}else{ %>
		<td colspan="2"><input type="button" value="���ƿ�(${dto.good})">
		<input type="button" value="�Ⱦ��(${dto.bad})"></td>
		<%} %>
	</tr>
	<tr>
		<td colspan="2">${dto.content}</td>
	</tr>
</table>
<input type="button" value="��������" onclick="location.href='bmain.jsp'">
</body>
</html>