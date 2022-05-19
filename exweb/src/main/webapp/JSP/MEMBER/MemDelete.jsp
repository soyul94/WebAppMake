<%@page import="com.exam.member.MemberDAOJdbc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
        MemberDAOJdbc memberDao = new MemberDAOJdbc();
        %>    
    
<%
        String memId=request.getParameter("memId");
        int num= memberDao.deleteMember(memId);
        %>

<c:redirect url="./MemList.jsp"/>
