<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("logindata")!=null){
%>
	<script>
		alert("잘못된 접근입니다.");
		history.back();
	</script>
<%} %>		
회원가입 페이지<br>
<form action="lgegproc.jsp" name="frm" method="post">
<table border="1">
   <tr>
      <td>아이디</td>
      <td><input type="text" name="id"></td>      
   </tr>
   <tr>
      <td>비밀번호</td>      
      <td><input type="text" name="pw"></td>
   </tr>
   <tr>
      <td>비밀번호 확인</td>      
      <td><input type="text" name="repw"></td>
   </tr>
   <tr>
      <td>이름</td>      
      <td><input type="text" name="name"></td>
   </tr>
   <tr>
      <td>이메일</td>      
      <td>
         <input type="text" id="email1">@
         <select id="email2">
            <option>nate.com</option>
            <option selected>google.com</option>
            <option>naver.com</option>
            <option>kakao.com</option>
            <option>daum.net</option>
         </select>
         <input type="hidden" name="email">
      </td>
   </tr>
   <tr>
      <td>전화번호</td>      
      <td><input type="text" name="tel"></td>
   </tr>
   <tr>
      <td>주소</td>      
      <td>
      <input type="text" name="addr">
      <input type="button" value="주소찾기" onclick="addAddr()">
      <!--  <input type="hidden" name="addr">
         <input type="text" id="sample6_postcode" placeholder="우편번호" readonly>
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample6_address" placeholder="주소" readonly><br>
		<input type="text" id="sample6_detailAddress" placeholder="상세주소">
		<input type="text" id="sample6_extraAddress" placeholder="참고항목">

		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script> -->
      </td>
   </tr>
   <tr>
      <td>생일</td>      
      <td><input type="date" name="birth"></td>
   </tr>
   <tr>
      <td>성별</td>      
      <td>
         남<input type="radio" name="gender" value="m">
         여<input type="radio" name="gender" value="f" checked>
      </td>
   </tr>
   <tr>
      <td>국적</td>
      <td>
         <select name="nation">
            <option value="ko">한국</option>
            <option value="us">미국</option>
            <option value="ch">중국</option>
            <option value="jp">일본</option>
            <option value="uk">영국</option>
         </select>
      </td>      
   </tr>
   <tr>
      <td>관심사</td>
      <td>
         운동<input type="checkbox" name="interest" value="workout">
         음악<input type="checkbox" name="interest" value="music">
         커피<input type="checkbox" name="interest" value="coffee">
         게임<input type="checkbox" name="interest" value="game">
         독서<input type="checkbox" name="interest" value="reading">         
         여행<input type="checkbox" name="interest" value="trip">
      </td>
   </tr>
   <tr>
      <td>비밀번호 찾기 질문</td>      
      <td>
         질문1<select name="findpw1">
               <option value="fp1">내가 졸업한 초등학교</option>
               <option value="fp2">아버지의 성함</option>
               <option value="fp3">추억의 장소</option>
               <option value="fp4">베프이름</option>
               <option value="fp5">학창시절 별명</option>
            </select>
         답1<input type="text" name="findas1"><br>
         질문2<select name="findpw2">
               <option value="fp1">어머니의 성함</option>
               <option value="fp2">좋아하는 음식</option>
               <option value="fp3">고향</option>
               <option value="fp4">보물1호</option>
               <option value="fp5">좋아하는 색깔</option>
            </select>
         답2<input type="text" name="findas2"><br>
         질문3<select name="findpw3">
               <option value="fp1">친할아버지 성함</option>
               <option value="fp2">친할머니 성함</option>
               <option value="fp3">외할아버지 성함</option>
               <option value="fp4">외할머니 성함</option>
               <option value="fp5">첫사랑 이름</option>
            </select>
         답3<input type="text" name="findas3"><br>
         
      </td>
   </tr>
</table>
<input type="button" onclick="sendinfo()" value="회원가입">
<input type="reset" value="재설정">
</form>

<script>
	document.getElementsByName("id")[0].focus();
   function sendinfo(){
      var email1 = document.getElementById("email1").value;
      var selop = document.getElementById("email2");
      var email2 = selop.options[selop.selectedIndex].value;
      frm.email.value=email1+"@"+email2;
      //var addr = document.getElementById("sample6_address").value + document.getElementById("sample6_detailAddress").value + document.getElementById("sample6_extraAddress").value;
      //frm.addr.value=addr;
      frm.submit();//input type="submit"을 함수로 만듬
   }
   function addAddr(){
		window.open("laddr.jsp","_blank","width=300, height=300, menubar=no, status=no, toolbar=no");	   
   }
</script>
</body>
</html>