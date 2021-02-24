<%@page import="com.joo.dao.DaoLo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="com.joo.dto.DtoLo">
	<jsp:setProperty name="dto" property="*" />
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DaoLo dao = new DaoLo();
		int chk = dao.idChk(dto.getId());
		if(chk==0){
			int result = dao.insertUser(dto);
			if(result>0){
				response.sendRedirect("lmain.jsp");
			}else{
		%>
			<script>
				alert("문제 발생");
				location.href="lmain.jsp";
			</script>	
		<%} 
		}else{
		%>
			<script>
				alert("이미 있는 아이디 입니다.");
				history.go(-1);
			</script>	
		<% 
		}
		
		%>
		

</body>
</html>