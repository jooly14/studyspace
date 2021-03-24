<%@page import="java.util.Collection"%>
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
	Collection<Part> parts = request.getParts();
	String filename ="";
	for(Part part : parts){
		if(part.getName().equals("txt")) continue;
		filename = part.getSubmittedFileName();
		if(part.getSize()>0){
			part.write(request.getServletContext().getRealPath("/upload/"+filename));
		}
		part.delete();
	}
%>
${param.txt}<br>
<img src="upload/<%=filename%>">
</body>
</html>