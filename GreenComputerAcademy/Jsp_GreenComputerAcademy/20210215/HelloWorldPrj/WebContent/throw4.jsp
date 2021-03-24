<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	#container{
		border : 3px solid black;
		width : 300px;
		height : 200px;
		display: inline-block;
	}
	input{
		margin: 20px;
		width:260px;
	}
</style>
</head>
<body>
	<form action="catch4.jsp" method="post">
		<div id="container">
			<input type="text" name="img">
			<input type="submit" value="확인">
		</div>
	</form>
</body>
</html>