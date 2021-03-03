<%@page import="com.joo.dao.DaoGB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DaoGB dao = new DaoGB();
	String idx = request.getParameter("idx");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String content = request.getParameter("content");
	int chk = dao.chkBeforeDelete(pw, idx);
	if(chk>0){
		int result = dao.updateList(idx,id,content);
		%>
		<script>
			opener.parent.location.reload();
			window.close();
		</script>
		<%
		/* response.sendRedirect("guestbookList.jsp"); */
	}else{
		response.sendRedirect("guestbookUpdate.jsp?chk=false&key="+idx);
	}
%>
</body>
</html>