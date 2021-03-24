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
	
	/* id : khw
		pw : green501
	*/
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("khw")&&pw.equals("green501")){
			session.setAttribute("id", id);
			response.sendRedirect("login.jsp");			
		}else{
			response.sendRedirect("login.jsp");			
		}
	%>
</body>
</html>