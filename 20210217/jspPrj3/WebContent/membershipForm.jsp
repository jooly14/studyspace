<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ �Է� ��</title>
</head>
<body>
	<form action="chap08/processJoining.jsp" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="id" size="10"></td>
			<td>��й�ȣ</td>
			<td><input type="password" name="password" size="10"></td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input type="text" name="name" size="10"></td>
			<td>�̸���</td>
			<td><input type="text" name="email" size="10"></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="ȸ������"></td>
		</tr>
		</table>
		<%
		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date1 = form.format(date);
		%>
		<input type="hidden" name="date1" value="<%=date1%>">
	</form>
</body>
</html>