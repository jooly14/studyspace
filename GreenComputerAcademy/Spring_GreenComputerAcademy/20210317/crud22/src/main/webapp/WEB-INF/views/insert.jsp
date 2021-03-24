<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="doInsert" method="post">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td><input type="text" name="writer" readonly value="${sessionScope.ldata.id}"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="5" cols="20" name="content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등록"></td>
	</tr>
</table>
</form>
</body>
</html>