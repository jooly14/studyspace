<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ajax</title>
<style>
	form{
		width:300px;
		margin:0 auto;
		border : 1px solid black;
	}
	form .inner{
		display: flex;
		flex-flow: row wrap;
		justify-content: space-around;
	}
	.inner label{
		width:30%;
	}
	input , label{
		margin: 5px 0;
	}
	#result{
		width:100%;
	}
</style>
</head>
<body>
<form action="ajaxreg.jsp" method="post">
	<div class="inner">
	<label>아이디</label><input type="text" name="id" id="aja">
	<span id="result"></span>
	<label>비밀번호</label><input type="password" name="pw">
	<label>이름</label><input type="text" name="name">
	<input type="submit" value="가입">
	</div>
</form>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#aja").keyup(function(){
			var params = "id="+$("#aja").val();
			$.ajax({
				type:"post",
				url:"ajaxproc.jsp",
				data:params,
				dataType:"json",
				success:function(args){
					$("#result").html("<b>"+args.result+"</b>"+"/<b>"+args.result2+"</b>");
				},
				error:function(args){
					$("#result").text(args.responseText+" 에러!");
				}
			});
		});
	});

</script>
</body>
</html>