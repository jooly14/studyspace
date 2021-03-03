<%@page import="com.joo.dao.DaoGB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="gdto" class="com.joo.dto.DtoGB" />
<jsp:setProperty property="*" name="gdto"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DaoGB dao = new DaoGB();
	/* String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String content = request.getParameter("content");
	int result = dao.insertList(id,pw,content); */
	int result = dao.insertList(gdto);
	response.sendRedirect("guestbookList.jsp");
%>
</body>
</html>