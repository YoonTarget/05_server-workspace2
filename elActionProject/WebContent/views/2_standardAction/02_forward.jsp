<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- url로는 http://localhost:8003/ea/views/2_standardAction/02_forward.jsp -->
	
	<h1>여기는 02_forward.jsp 페이지야</h1>
	
	<jsp:forward page="footer.jsp"/>
	
	<!-- 이 페이지에 들어오자마자 footer.jsp에 있는 내용을 보여준다 -->
	
</body>
</html>