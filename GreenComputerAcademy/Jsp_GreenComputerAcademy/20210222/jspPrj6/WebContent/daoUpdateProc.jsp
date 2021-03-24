<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.joo.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String idx = request.getParameter("idx");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	DaoTest dao = new DaoTest();
	int result = dao.updateDao(idx,id,pw);
	if(result>0){
		out.println("수정됨");
	}else{
		out.println("수정 안됨");	
	}
%>
</body>
</html>