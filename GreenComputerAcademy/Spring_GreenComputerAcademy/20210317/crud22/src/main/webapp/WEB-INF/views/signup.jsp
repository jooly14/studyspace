<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form id="fm1" action="doSignup" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"><span style="display:none;color:red;">사용할 수 없는 아이디</span></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="가입"></td>
	</tr>
</table>
</form>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
	<script>
		$(function(){
			$("input[name=id]").keyup(function(){
				$.ajax({
				    type : "POST",
				    url : "idchk", 
				    data : "id="+$(this).val(),
				    dataType:"json",
				    error : function(error) {
				    	console.log("error");
				    },
				    success : function(data) {
						if(data.exist=="t"){
							$("span").css("display","inline-block");
						}else{
							$("span").css("display","none");
						}
				    }
				}); 
			});
		});         	
		$("input[type=submit]").click(function(e){
			e.preventDefault();
			if($("span").css("display")=="none"){
				$("#fm1").submit();
			}else{
				alert("사용할 수 없는 아이디입니다");
				$("input[name=id]").select();
				$("input[name=id]").focus();
			}
		});
	</script>
</body>
</html>