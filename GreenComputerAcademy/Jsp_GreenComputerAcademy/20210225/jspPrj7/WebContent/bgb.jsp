<%@page import="com.joo.dao.BDao"%>
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
	String like = request.getParameter("like");
	String idx = request.getParameter("idx");
	BDao dao = new BDao();
	int result  = 0;
	result = dao.chkGB(idx,like,(String)session.getAttribute("logindata"));
	if(result>0){
		%>
		<script>
			history.back();
		</script>
		<%
	}else{
		result = dao.updateGB(idx,like,(String)session.getAttribute("logindata"));
		if(result>0){
			response.sendRedirect("bread.jsp?idx="+idx);
		}else{
			out.print("오류");
		}
	}
%>
</body>
</html>