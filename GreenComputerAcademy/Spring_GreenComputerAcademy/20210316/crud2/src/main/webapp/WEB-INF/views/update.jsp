<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="doUpdate" method="post">
	<table>
		<tr>
			<td>번호</td>
			<td>${dto.num}</td>
			<input type="hidden" name="num" value="${dto.num}">
		</tr>
		<tr>
			<td>아이디</td>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${dto.pw}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content">${dto.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
</body>
</html>