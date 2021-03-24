<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//톰캣 서버에서 자원을 찾기 위해 InitialContext 인스턴스 생성
InitialContext initialContext = new InitialContext();
//lookup() 메소드로 JNDI 이름으로 등록돼있는 서버 자원 찾음
//@name : 서버 자원의 JNDI 이름
//찾으려는 자원이 JDBC DataSource이므로 java:comp/env...
DataSource ds = (DataSource) initialContext.lookup(
     "java:comp/env/jdbc/dbcp"
);

Connection con = ds.getConnection();
String sql = "SELECT count(*) FROM user2";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
if(rs.next()){
	out.println(rs.getInt(1));
}
%>

</body>
</html>