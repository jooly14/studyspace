<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	label{
		display : inline-block;
		width : 100px;
		text-align:center;
		font-weight: bold;
	}
	#wrap{
		border : 3px solid;
		width: 300px;
		height: 300px;
		text-align: center;
		display: flex;
		
		align-content: space-around;
		flex-flow: row wrap;
	}
	
	select{
		width:177px;
	}
	input[type="submit"]{
		width: 100px;
		margin-left:100px;
	}
</style>
</head>
<body>
		<form action="catch3.jsp" method="post">
	<div id="wrap">
		<label for="garo">����</label> <input type="text" name="garo"><br>
		<label for="sero">����</label> <input type="text" name="sero"><br>
		<label for="color">����</label> <select name="color">
			<option value="red">��</option>
			<option value="orange">��</option>
			<option value="yellow">��</option>
			<option value="green">��</option>
			<option value="blue">��</option>
			<option value="darkblue">��</option>
			<option value="purple">��</option>
		</select><br>
		<label for="xy">���� x,y</label> <input type="text" name="xy"><br>
		<label for="cnt">����</label> <input type="text" name="cnt"><br>
		<input type="submit">
</div>
		</form>
</body>
</html>