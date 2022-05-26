<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 추가</title>
<style> .center{text-align:center;}</style>
</head>
<body>

<jsp:include page="/WEB-INF/view/member/MemberMenu.jsp" />

<h2>MEMBER_TABLE</h2>
<p>DB에 인스턴스 변경하기</p>	

<form action="${pageContext.request.contextPath}/member/edit.do" method="post">
ID&emsp;&emsp;&emsp;&emsp;&emsp;: 	<input type="text" name="memId" value="${memVo.memId}" readonly="readonly"/><br>
<%-- PASSWORD&emsp;: 					<input type="password" name="memPW" value="${memVo.memPW}"/><br> --%>
NAME&emsp;&emsp;&emsp;: 			<input type="text" name="memName" value="${memVo.memName}"/><br>
POINT&emsp;&emsp;&emsp;: 			<input type="text" name="memPoint" value="${memVo.memPoint}"/><br>
<input type="submit" value="변경"/>											<%--requestScope는 생략가능 --%>
</form>
<%-- <button onclick="location.href='${pageContext.request.contextPath}/member/list.do'">목록가기</button> --%>
<button onclick="location.href='<c:url value="/member/list.do"/>'">목록가기</button>
</body>
</html>

<%-- HTML주석 <!--  -->은 브라우저로 전송이 되며 보이지만 않는 것 --%>
<%--JSP주석 <%-%>은 브라우저로 아예 전송이 되지 않는 것--%>