<%@page import="com.joo.dao.BDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String id = (String)session.getAttribute("logindata");
		String ip = request.getRemoteAddr();
		content = content.replace(System.getProperty("line.separator"), "<br>");
		BDao dao = new BDao();
		int result = dao.insert(id,title,content,ip);
		if(result>0){
			response.sendRedirect("bmain.jsp");
		}else{
	%>
			<script>
				alert("글 작성 실패");
				location.href ="bmain.jsp";
			</script>
	<%}%>
		
</body>
</html>