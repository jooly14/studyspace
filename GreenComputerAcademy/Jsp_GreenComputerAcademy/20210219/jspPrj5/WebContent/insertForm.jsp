<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertProc.jsp" method="post" >
		<table>
			<tr>
				<td>아이디</td>			
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>			
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>			
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>			
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>	
</body>
</html>