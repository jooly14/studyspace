<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
MEMBER 테이블의 내용
<table border="1">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>

<%
	Statement stmt = null;
	String sql = "select * from member";
	try{
		conn = DriverManager.getConnection(url,dbId, dbPw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
%>
			<tr>
				<td><%=rs.getString("memberId") %></td>
				<td><%=rs.getString("password") %></td>
				<td><%=rs.getString("name") %></td>
				<td><%=rs.getString("email") %></td>
				<td><input type="button" value="수정" onclick="location.href='updateForm.jsp?id=<%=rs.getString("memberId")%>'"></td>
				<td><input type="button" value="삭제" onclick="location.href='delete.jsp?id=<%=rs.getString("memberId")%>'"></td>
			</tr>
<%			
		}
	}catch(SQLException e){
		out.println(e.getMessage());
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
	}
%>
</table>
<br>
<input type="button" value="글쓰기" onclick="location.href='insertForm.jsp'">

</body>
</html>