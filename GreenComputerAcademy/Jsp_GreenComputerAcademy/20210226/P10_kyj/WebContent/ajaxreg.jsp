<%@page import="com.joo.dao.ADao"%>
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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	ADao dao = new ADao();
	int result = dao.insert(id,pw,name);
	if(result>0){
		out.println("회원가입 성공");
	}else{
		out.println("회원가입 실패");
	}
%>
<br>
<input type="button" value="회원가입 폼으로" onclick="location.href='ajax.jsp'">

</body>
</html>