<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>글번호</td>
		<td>${dto.idx}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${dto.title}</td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${dto.writer}</td>
	</tr>
	<tr>
		<td>작성시간</td>
		<td>${dto.regdate}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${dto.hit}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea rows="5" cols="20" readonly>${dto.content}</textarea></td>
	</tr>
</table>
<a href="main">목록</a>
<c:if test="${sessionScope.ldata.id eq dto.writer}">
	<a href="update?idx=${dto.idx}">수정</a>
	<a href="delete" id="deleteB">삭제</a>
	<div id="modal1" style="position:fixed; top:0; left:0; width:100%; height:100vh; background-color:rgba(0,0,0,.8);display:none">
		<div>
			<form id="fmmodal" action="delete" method="post">
				<input type="hidden" name="idx" value="${dto.idx}">
				<input id="pwchk" type="password" placeholder="삭제하려면 비밀번호 입력"><br>
				<input id="delBtn" type="submit" value="삭제">
				<input id="cancel" type="button" value="취소"><br>
				<span id="pwwrong" style="display:none;color:white">비밀번호가 일치하지않습니다.</span>
			</form>
		</div>
	</div>
</c:if>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script>
	$(function(){
		$("#deleteB").click(function(e){
			e.preventDefault();
			$("#modal1").fadeIn();
		});
		$("#delBtn").click(function(e){
			e.preventDefault();
			if($("#pwchk").val()=="${sessionScope.ldata.pw}"){
				$("#fmmodal").submit();
			}else{
				$("#pwwrong").css("display","inline-block");
			}
		});
		$("#cancel").click(function(e){
			e.preventDefault();
			$("#modal1").fadeOut();
		});
	});
</script>
</body>
</html>