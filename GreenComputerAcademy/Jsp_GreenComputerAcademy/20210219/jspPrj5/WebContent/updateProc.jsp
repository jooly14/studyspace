<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="dbconnect.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	Statement stmt = null;
	int result = 0;
	String sql = "update member set memberId = '"+request.getParameter("id")+"',password = '"+request.getParameter("pw")+"',name = '"+request.getParameter("name")+"',email = '"+request.getParameter("email")+"' where memberId = '"+request.getParameter("oldId")+"'";
	try{
		conn = DriverManager.getConnection(url,dbId, dbPw);
		stmt = conn.createStatement();
		result = stmt.executeUpdate(sql);
	}catch(SQLException e){
		out.println(e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	if(result>0){
		response.sendRedirect("viewMemberList.jsp");
	}else{
		%>
		수정 실패했습니다.<br>
		<button onclick='location.href ="viewMemberList.jsp" '>홈으로</button>
		<%
	}
%>
</body>
</html>