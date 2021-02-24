<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- 유저 테이블
CREATE TABLE USER(
   idx INT PRIMARY KEY AUTO_INCREMENT, 
   id VARCHAR(50) UNIQUE NOT NULL,
   pw VARCHAR(100) NOT NULL,
   NAME VARCHAR(50) NOT NULL,
   email VARCHAR(100) NOT NULL,
   tel VARCHAR(20) NOT NULL,
   addr VARCHAR(200) NOT NULL,
   birth DATE NOT NULL,
   gender CHAR(1) NOT NULL,
   nation VARCHAR(10) NOT NULL, 
   interest1 VARCHAR(50),
   interest2 VARCHAR(50),
   interest3 VARCHAR(50),
   findpw1 VARCHAR(200) NOT NULL,
   findpw2 VARCHAR(200) NOT NULL,
   findpw3 VARCHAR(200) NOT NULL,
   findas1 VARCHAR(200) NOT NULL,
   findas2 VARCHAR(200) NOT NULL,
   findas3 VARCHAR(200) NOT NULL,
   regdate DATE
);
  -->


<%
	if(session.getAttribute("logindata")==null){
%>
<form action="llogin.jsp">
ID<input type="text" name="id">
&nbsp;&nbsp;&nbsp;&nbsp;
PW<input type="password" name="pw">
<input type="submit" value="로그인">
<input type="button" value="회원가입" onclick="reg()">
</form>
<%}else{ %>
	<div>
		<%=session.getAttribute("logindata")%>님 반갑습니다
		<input type="button" value="로그아웃" onclick="location.href='llogout.jsp'">
	</div>
<%} %>		
<!-- 회원가입
로그인
게시판 글쓰기 - 로그인한 회원만 가능 -->
<script>
	function reg(){
		location.href="lreg.jsp";
	}
</script>
