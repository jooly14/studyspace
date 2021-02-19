<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="dbconnect.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Statement stmt = null;
	int result = 0;
	String memId = request.getParameter("id");
	String sql = "delete from member where memberId = '"+memId+"'";
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
		삭제에 실패했습니다.<br>
		<button onclick='location.href ="viewMemberList.jsp" '>홈으로</button>
		<%
	}
%>
</body>
</html>