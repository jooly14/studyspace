<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("id")==null){
%>
<form action="loginProc.jsp" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
<%
	}else{
%>
 <table>
      <tr>
         <td><%= session.getAttribute("id") %>님 환영합니다.<br>
         	${id}님 환영합니다.
         </td>         
      </tr>      
      <tr>         
         <td>
            <input type="button" value="로그아웃" onclick="location.href='logoutProc.jsp'">
         </td>
      </tr>
   </table>
<%	} %>
</body>
</html>