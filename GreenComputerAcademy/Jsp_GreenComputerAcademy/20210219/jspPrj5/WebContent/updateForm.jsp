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
	Statement stmt = null;
	String memId = request.getParameter("id");
	String sql = "select * from member where memberId = '"+memId+"'";
	try{
		conn = DriverManager.getConnection(url,dbId, dbPw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()){
%>
	<form action="updateProc.jsp" method="post" >
		<table>
			<tr>
				<td>아이디</td>			
				<td><input type="text" name="id" value='<%=rs.getString("memberId")%>'></td>
			</tr>
			<tr>
				<td>비밀번호</td>			
				<td><input type="password" name="pw" value='<%=rs.getString("password")%>'></td>
			</tr>
			<tr>
				<td>이름</td>			
				<td><input type="text" name="name" value='<%=rs.getString("name")%>'></td>
			</tr>
			<tr>
				<td>이메일</td>			
				<td><input type="text" name="email" value='<%=rs.getString("email")%>'></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
		<input type="hidden" name="oldId" value="<%=memId%>">
	</form>	
			
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
	
</body>
</html>