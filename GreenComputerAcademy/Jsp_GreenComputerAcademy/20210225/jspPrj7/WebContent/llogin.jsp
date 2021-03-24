<%@page import="com.joo.dao.DaoLo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	DaoLo dao = new DaoLo();
	int result = dao.chkLogin(id,pw);
	if(result>0){
		session.setAttribute("logindata", id);
		response.sendRedirect("bmain.jsp");
	}else{
%>  
	<script>
		alert("로그인 정보틀림");
		location.href="bmain.jsp";
	</script>
	<%
	}
	 %>
</body>
</html>