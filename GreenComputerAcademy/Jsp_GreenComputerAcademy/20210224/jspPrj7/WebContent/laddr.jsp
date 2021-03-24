<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   주소를 입력하세요 <br>
   <input type="text" id="popaddr">
   <input type="button" value="확인" onclick="findaddr()"><br>
   ----------------------------<br>
   <span id="txt"></span>
   <input id="usebtn" type="button" value="사용" style="display:none" onclick="usedate()">
   
   <script>
   	document.getElementById("popaddr").focus();
      function findaddr(){
         var tmp = document.getElementById("popaddr").value;
         document.getElementById("txt").innerHTML=tmp;
         document.getElementById("usebtn").style.display="inline-block";
      }
      function usedate(){
    	  window.opener.document.frm.addr.value = document.getElementById("txt").innerText;
    	  window.close();
      }
   </script>
</body>
</html>
