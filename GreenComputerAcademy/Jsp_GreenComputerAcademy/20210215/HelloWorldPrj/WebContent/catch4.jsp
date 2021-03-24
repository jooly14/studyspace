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
	File file = new File(request.getSession().getServletContext().getRealPath("/")+"img"+File.separator+imgName);
	
	if(file.exists()){
		out.println(request.getSession().getServletContext().getRealPath("/")+"img"+File.separator+imgName);
	}else{
		out.println(2);
	}
	%>
</body>
</html>