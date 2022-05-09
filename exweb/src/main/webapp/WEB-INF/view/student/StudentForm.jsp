<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기는 StuFormServlet !</title>
<style>
h2,p{
	margin: 5px 15px;
}
input{margin:5px; padding:5px;}
</style>
</head>

<body>
	<h2>STUDENT_TABLE</h2></b>
	<%-- <c:out value="${menu}" /> --%>
	<c:choose>
		<c:when test="${menu eq 'insert'}">
			<p>DB에 인스턴스 추가하기</p>		
			<form action='<c:url value="/student/list.do" />'>
				<input type="submit" value='목록가기'/>
			</form>
			<form action='<c:url value="/student/add.do" />' method='post'>
				학번 : <input type = 'text' name='stu_no'/><br>
				이름 : <input type = 'text' name='stu_name'/><br>
				점수 : <input type = 'text' name='stu_score'/><br>
				<input type="submit" value='등록'/>
			</form>
		</c:when>
		<c:when test="${menu=='update'}">
			<p>DB에 인스턴스 변경하기</p>		
			<form action='<c:url value="/student/list.do" />'>
				<input type="submit" value='목록가기'/>
			</form>
			<h4>${stu_no} 님의 변경된 점수를 입력해주세요</h4>
			<form action='<c:url value="/student/update.do" />' method='post'> 
				<input type='hidden' name='stu_no' value='${stu_no}'/>
				점수 : <input type = 'text' name='stu_score'/><br>
				<input type="submit" value='변경'/>
			</form>	
		</c:when>
	</c:choose>

</body>
</html>