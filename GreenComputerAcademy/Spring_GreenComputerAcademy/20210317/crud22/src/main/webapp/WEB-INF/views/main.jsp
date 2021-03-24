<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.ldata}">
		<form action="login" method="post">
			아이디<input type="text" name="id"><br>
			비밀번호<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
		<input type="submit" value="회원가입" onclick="location.href='signup'"><br>
	</c:when>
	<c:otherwise>
		${sessionScope.ldata.id}님 반갑습니다.<br>
		<a id="deleteId" href="deleteId">탈퇴</a><br>
		<a href="logout">로그아웃</a><br>
	</c:otherwise>
</c:choose>
	<hr>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="dtos" items="${dtos}">
		<tr>
			<td>${dtos.idx}</td>
			<td><a href="read?idx=${dtos.idx}">${dtos.title}</a></td>
			<td>${dtos.writer}</td>
			<td>${dtos.regdate}</td>
			<td>${dtos.hit}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
	<c:if test="${start >= 5}">
		<a href="main?page=${start-1}">이전</a>
	</c:if>
	<c:forEach var="i" begin="${start}" end="${end}">
		<a style="color:${i==page?'orange':'black'}" href="main?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${end < totalpage}">
		<a href="main?page=${end+1}">다음</a>
	</c:if>
</div>
		<hr>
<c:if test="${!empty sessionScope.ldata}">
		<div>
			<a href="insert">글쓰기</a>
		</div>
</c:if>
<div id="modal1" style="position:fixed; top:0; left:0; width:100%; height:100vh; background-color:rgba(0,0,0,.8);display:none">
	<div>
		<form id="fmmodal" action="deleteId" method="post">
			<input id="pwchk" type="password" name="pw" placeholder="탈퇴하려면 비밀번호 입력"><br>
			<input id="delBtn" type="submit" value="탈퇴">
			<input id="cancel" type="button" value="취소"><br>
			<span id="pwwrong" style="display:none;color:white">비밀번호가 일치하지않습니다.</span>
		</form>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
<script>
	$(function(){
		$("#deleteId").click(function(e){
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