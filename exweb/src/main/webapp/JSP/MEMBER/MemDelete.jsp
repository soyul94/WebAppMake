<%@page import="com.exam.member.MemberDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% MemberDAO memberDao = new MemberDAO(); %>    
    
<%
String memId=request.getParameter("memId");
int num= memberDao.delete(memId);
%>

<c:redirect url="./MemList.jsp"/>
