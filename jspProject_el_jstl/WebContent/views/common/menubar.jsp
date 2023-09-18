<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	String contextPath = request.getContextPath(); // /jsp

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menubar.jsp</title>
<style>
    .login-area>* {float: right;}
    .login-area a {
        text-decoration: none;
        color: black;
        font-size: 12px;
    }
    .nav-area {background-color: black;}
    .menu {
        display: table-cell;
        width: 150px;
        height: 50px;
    }
    .menu a {
        text-decoration: none;
        color: white;
        font-size: 20px;
        font-weight: bold;
        display: block;
        width: 100%;
        height: 100%;
        line-height: 50px;
    }
    .menu a:hover {
        background-color: darkgray;
    }
    h1 {
        cursor: pointer;
    }
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<c:set var="contextPath" value="/jsp"/>
	<c:set var="contextPath" value="<%= request.getContextPath() %>" scope="request"/>
	
	<c:if test="${ not empty alertMsg }">
		<script>
			alert("${ alertMsg }");
		</script>
		
		<c:remove var="alertMsg"/>
	</c:if>
	
    <h1 align="center" onclick="home();">Welcome to Target's World</h1>

    <div class="login-area">
    
    <c:choose>
    
    	<c:when test="${ empty loginMember }">
	
	        <!-- case1. 로그인 전 -->
	        <form action="${ contextPath }/login.me" method="post">
	            <table>
	                <tr>
	                    <th>아이디</th>
	                    <td><input type="text" name="userId" required></td>
	                </tr>
	                <tr>
	                    <th>비밀번호</th>
	                    <td><input type="password" name="userPwd" required></td>
	                </tr>
	                <tr>
	                    <th colspan="2">
	                        <button type="submit">로그인</button>
	                        <button type="button" onclick="enrollPage();">회원가입</button>
	                    </th>
	                </tr>
	            </table>
	
	            <script>
	
	                function enrollPage() {
	
	                    // location.href = "<%= contextPath %>/views/member/memberEnrollForm.jsp";
	                    // 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약
	                    
	                    // 단순한 페이지 요청도 servlet 호출해서 servlet 거쳐갈 것!! (즉, url에는 서블릿 매핑값만 노출)
	                    location.href="<%= contextPath %>/enrollForm.me";
	
	                };
	                
	                function home() {
	
	                    location.href = "<%= contextPath %>";
	
	                };
	
	            </script>
	
	        </form>
        
        </c:when>
        
    	<c:otherwise>

	        <!-- case2. 로그인 후 -->
	        <div>
	            <b>${ loginMember.userName } 님</b>의 방문을 환영합니다. <br><br>
	            <div align="center">
	                <a href="<%= contextPath %>/myPage.me">마이페이지</a>
	                <a href="${ contextPath }/logout.me">로그아웃</a>
	            </div>
	        </div>

    	</c:otherwise>
    
    </c:choose>
    
    </div>
    
    <br clear="both">
    <br>
    
    <div class="nav-area" align="center">
        <div class="menu"><a href="<%= contextPath %>">HOME</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.no">공지사항</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.bo?cpage=1">일반게시판</a></div>
        <div class="menu"><a href="<%= contextPath %>/list.th">사진게시판</a></div>
    </div>

</body>
</html>