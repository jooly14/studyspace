<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- ���� ���̺�
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
<input type="submit" value="�α���">
<input type="button" value="ȸ������" onclick="reg()">
</form>
<%}else{ %>
	<div>
		<%=session.getAttribute("logindata")%>�� �ݰ����ϴ�
		<input type="button" value="�α׾ƿ�" onclick="location.href='llogout.jsp'">
	</div>
<%} %>		
<!-- ȸ������
�α���
�Խ��� �۾��� - �α����� ȸ���� ���� -->
<script>
	function reg(){
		location.href="lreg.jsp";
	}
</script>
