<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>

<style>
.center{
	text-align:center; 
	margin:auto;
	border-width:2px; 
	border-style:solid; border-color:gray; 
	border-collapse:collapse;
}
th{
	font-size:1.3em; 
	border:2px; 
	border-style:solid;
	border-color:gray; 
	width:150px; 
	padding:10px; 
	background-color:#eee;
}
td{
	font-size:1em; 
	border:2px; 
	border-style:solid; 
	border-color:gray; 
	width:150px; 
	padding:10px;
}
h2,p{
	text-align:center; 
}
input{
	margin:10px; 
	padding:5px;
}
#stu_no{
	border:0;
	background:#fff; 
	margin:0; 
	font-size:1em;
}
</style>
</head>

<body>
	<h2>STUDENT_TABLE</h2></b>
	<p>DB로부터 리스트를 받아와 출력하기</p>
	
	<figure>
		<figcaption>
			<form action='<c:url value="/student/form.do" />' method='get'>
			<input type='hidden' name='menu' value='insert'/>
			<input type='submit' value='학생 정보 입력'/>
			</form>
		</figcaption>
	
		<table class="center">
		<tr>
			<th>학번</th>
			<th>학생명</th>
			<th>점수</th>
		</tr>
		<c:forEach var="vo" items="${studentList}">
			<tr>
			<td>
			<form action="<c:url value="/student/detail.do"/>" method="get">
			<input type="hidden" name="stu_no" value="${vo.stu_no}"/>
			<input id="stu_no" type="submit" value="${vo.stu_no}"/>
			</form>
			</td>
			<td>${vo.stu_name}</td>
			<td>${vo.stu_score}</td>	
			</tr>
		</c:forEach>
		</table>
	</figure>
	<p>해당 학번을 클릭하면 상세 페이지로 이동</p>
</body>
</html>