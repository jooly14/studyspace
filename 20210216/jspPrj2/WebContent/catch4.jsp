<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String imgName = request.getParameter("img");
	File file = new File(application.getRealPath("/img/")+imgName);
	
	if(file.exists()){
%>
		<img src="img/<%=imgName%>">
<%
	}else{
%>
		<h1>�̹����� �����ϴ�.</h1>
<%
	}
%>
</body>
</html>