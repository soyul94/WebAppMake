<%@page import="java.util.ArrayList"%>
<%@page import="com.exam.member.MemberDAOJdbc"%>
<%@page import="com.exam.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!MemberDAOJdbc memberDao = new MemberDAOJdbc();%> <%--s ervice가 몇번이 실행되던 1번만 생성되어야 하기 때문에 service 밖에 있어야한다. --%>

<%
ArrayList< MemberVO > list = memberDao.selectMemberList(); //테이블을 읽는 것은 요청이 올 때마다 실행.
%>		

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

<button onclick="location.href='./MemAddForm.jsp'">회원추가</button>
<br> <br>

<table class="center">
<tr>
<th style="width:70px">ID</th>
<th style="width:70px">PASSWORD</th>
<th style="width:70px">NAME</th>
<th style="width:70px">POINT</th>
<th>DELETE</th>
</tr>
<%
for(MemberVO e: list) {
%><%--for(inti i=0; i<list.size(); i++) MemberVO vo=list[i];--%>
	<tr>
	<td><%=e.getMemId()%></td>
	<td><%=e.getMemPW()%></td>
	<td><%=e.getMemName()%></td>
	<td><%=e.getMemPoint()%></td>
	<td>
	<form action="<%=request.getContextPath()%>/JSP/MEMBER/MemDelete.jsp" method='get'>
	<input type='hidden' name='memId' value="<%=e.getMemId()%>">
	<input type='submit' value='삭제'/>
	</form>
	</td>
	</tr>
<%
}
%>
</table>
<br>

</body>
</html>