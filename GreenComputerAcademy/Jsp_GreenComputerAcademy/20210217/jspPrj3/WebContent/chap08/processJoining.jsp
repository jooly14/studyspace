<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String date1 = request.getParameter("date1");
	SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Date date2 = form.parse(date1);
%>
<jsp:useBean id="memberInfo" class="bean.member.MemberInfo" />
<jsp:setProperty name="memberInfo" property="*" />
<jsp:setProperty name="memberInfo" property="registerDate" value="<%=date2%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>가입</title>
</head>
<body>
	<table width="400" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty name="memberInfo" property="id" /></td>
			<td>비밀번호</td>
			<td><jsp:getProperty name="memberInfo" property="password" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><jsp:getProperty name="memberInfo" property="name" /></td>
			<td>이메일</td>
			<td><jsp:getProperty name="memberInfo" property="email" /></td>
		</tr>
			<tr>
			<td>가입날짜</td>
			<td colspan="3"><jsp:getProperty name="memberInfo" property="registerDate" /></td>
		</tr>
	</table>	
</body>
</html>