<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
	form{
		width:600px;
		display: flex;
		flex-flow: row wrap;
		justify-content: space-between;
		margin:0 auto;
	}
	textarea, input[type="submit"]{
		width:100%;
	}
	input[type="text"]{
		width:80%;
	}
	
</style>
</head>
<body>
<%
		if(session.getAttribute("logindata")==null){
%>
		<script>
			alert("잘못된 접근입니다.");
			location.href = "bmain.jsp";
		</script>
<%}%>
			
	<form name="frm" action="bwriteproc.jsp" method="post">
		글제목  <input type="text" name="title">
		<textarea name="content" rows="10"></textarea><br>
		<input type="button" value="작성" onclick="btnclick()">
	</form>
	<script>
		function btnclick(){
			/* var txt = document.getElementsByName('content')[0].value;
			txt = txt.replaceAll("\n","<br/>");
			frm.content.value = txt; */
			frm.submit();
		}
	</script>
</body>
</html>