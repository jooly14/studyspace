<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	*{
		margin:0;
		padding:0;
		box-sizing: border-box;
	}
	#wrap{
		width:100%;
		height:100vh;
		border 3px solid black;
	}
	.pop_content{
		width:300px;
		height:300px;
		background-color: orange;
		position: absolute;
		top:25%;
		left:25%;
		 display:none; 
	}
	.pop_close{
		position:absolute;
		right:0;
		
	}
	.chk{
		position:absolute;
		bottom:0;
	}
</style>
</head>
<body>
	<div id="wrap">
		<p></p>
		<button class="delcookie">쿠키삭제</button>
		<div class="pop_content">
			레이어 팝업
			<button class="pop_close">X</button>
			<div class="chk">
				<input type="checkbox" id="howlong">
				<label for="howlong">24시간 보지않기</label>
			</div>
		</div>			
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
	<script>
		$(function(){
			$("#wrap p").text("현재쿠키값: "+$.cookie('pop1'));
			if($.cookie("pop1")==undefined){
				$(".pop_content").fadeIn();
				$(".pop_content").draggable();
			}
			$(".pop_close").click(function(){
				console.log();
				if($("#howlong").is(":checked")){
					$.cookie("pop1","true",{expires:1});
				}
				$(this).parent().fadeOut();
			});
			$(".delcookie").click(function(){
				$.removeCookie("pop1");
			});
		
		});
	</script>        
</body>
</html>