<%@page import="com.exam.member.MemberVO"%>
<%@page import="com.exam.member.MemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% MemberDAO memberDao = new MemberDAO(); %>


<% 
request.setCharacterEncoding("UTF-8"); //이거 없으면 한글 전송 안돼용 !
MemberVO vo= new MemberVO(); 
vo.setMemId(request.getParameter("memId"));
vo.setMemPW(request.getParameter("memPW"));
vo.setMemName(request.getParameter("memName"));
vo.setMemPoint(Integer.parseInt(request.getParameter("memPoint")));
int num= memberDao.insert(vo);
%>

<c:redirect url="./MemList.jsp"/>





		
		
		
		