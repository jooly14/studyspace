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
//��Ĺ �������� �ڿ��� ã�� ���� InitialContext �ν��Ͻ� ����
InitialContext initialContext = new InitialContext();
//lookup() �޼ҵ�� JNDI �̸����� ��ϵ��ִ� ���� �ڿ� ã��
//@name : ���� �ڿ��� JNDI �̸�
//ã������ �ڿ��� JDBC DataSource�̹Ƿ� java:comp/env...
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