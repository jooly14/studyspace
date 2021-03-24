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
		<label for="garo">가로</label> <input type="text" name="garo"><br>
		<label for="sero">세로</label> <input type="text" name="sero"><br>
		<label for="color">색상</label> <select name="color">
			<option value="red">빨</option>
			<option value="orange">주</option>
			<option value="yellow">노</option>
			<option value="green">초</option>
			<option value="blue">파</option>
			<option value="darkblue">남</option>
			<option value="purple">보</option>
		</select><br>
		<label for="xy">시작 x,y</label> <input type="text" name="xy"><br>
		<label for="cnt">개수</label> <input type="text" name="cnt"><br>
		<input type="submit">
</div>
		</form>
</body>
</html>