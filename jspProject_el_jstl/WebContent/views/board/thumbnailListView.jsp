<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer {
        background-color: black;
        color: white;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
    }
    .list-area {
        width: 760px;
        margin: auto;
    }
    .thumbnail {
        border: 1px solid white;
        width: 220px;
        display: inline-block;
        margin: 14px;
    }
    .thumbnail:hover {
    	cursor: pointer;
    	opacity: 0.7;
    }
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"></jsp:include>

    <div class="outer">
        <br>
        <h2 align="center">사진게시판</h2>
        <br>

        <!-- 로그인 한 회원만 보여짐 -->
        <c:if test="${ not empty loginMember }">
	        <div style="width: 850px;" align="right">
	            <a href="enrollForm.th" class="btn btn-sm btn-secondary">글작성</a>
	        </div>
        </c:if>

        <div class="list-area">
            <!-- 썸네일 한 개 -->
            <c:forEach var="b" items="${ list }">
	            <div class="thumbnail" align="center">
	            	<input type="hidden" value="${ b.boardNo }">
	                <img src="${ b.titleImg }" width="200" height="150">
	                <p>
	                    NO.${ b.boardNo } ${ b.boardTitle } <br>
	                    조회수 : ${ b.count }
	                </p>
	            </div>
            </c:forEach>
        </div>

    </div>
    
    <script>
    	$(function() {
    		
    		$(".thumbnail").click(function() {
    			location.href = "detail.th?bno=" + $(this).children("input").val();
    		});
    		
    	});
    </script>

</body>
</html>