<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--mvc패턴  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	<!--VIEW 역할(html)-->	
<%pageContext.setAttribute("result", "hello");%>
	<%=request.getAttribute("result") %>입니다<br>
	${result}<br>
	${requestScope.result}<br>
	${list[0]}<br>
	${list[1]}<br>
	${notice.id}<br>
	${notice.title}<br>
	${param.n ge 3}<br>
	empty ${empty param.n?"값이 비었다":param.n}<br>
	${header["accept-language"]}<br>
	${pageContext.request.method}
	
</body>
</html>