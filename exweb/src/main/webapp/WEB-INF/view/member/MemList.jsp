<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style> .center{text-align:center;}</style>
</head>
<body>
	<h2>MEMBER_TABLE</h2></b>
	<p>DB로부터 리스트를 받아와 출력하기</p>
	
	<button onclick="location.href='${pageContext.request.contextPath}/member/addform.do'">회원추가</button>
	<br> <br>
	
	<table class="center">
	<tr>
		<th style="width:70px">ID</th>
		<th style="width:70px">PASSWORD</th>
		<th style="width:70px">NAME</th>
		<th style="width:70px">POINT</th>
		<th>DELETE</th>
	</tr>
		<c:forEach var="vo" items="${memList}" >
			<tr>
			<td>${vo.memId}</td>
			<td>${vo.memPW}</td>
			<td>${vo.memName}</td>
			<td>${vo.memPoint}</td>
			<td>
			<form action="${pageContext.request.contextPath}/member/delete.do" method='get'>
			<input type='hidden' name='memId' value="${vo.memId}">
			<input type='submit' value='삭제'/>
			</form>
			</td>
		</c:forEach>
	</tr>
	</table>
	<br>
</body>
</html>