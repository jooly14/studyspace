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
	PreparedStatement stmt = null;	
	int result = 0;
	String sql = "insert into member values(?,?,?,?)";
	try{
		conn = DriverManager.getConnection(url,dbId, dbPw);
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,request.getParameter("id"));		
		stmt.setString(2,request.getParameter("pw"));		
		stmt.setString(3,request.getParameter("name"));		
		stmt.setString(4,request.getParameter("email"));		
		result = stmt.executeUpdate();
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
		입력에 실패했습니다.<br>
		<button onclick='location.href ="viewMemberList.jsp" '>홈으로</button>
		<%
	}
%>
</body>
</html>