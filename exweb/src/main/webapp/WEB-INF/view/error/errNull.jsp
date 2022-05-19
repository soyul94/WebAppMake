<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
    <!-- isErrorPage="true" : 해당 jsp 파일이 오류페이지라는 것을 알려주며 오류가 발생한 이유를 출력할 수 있음 -->
    <!-- page 디렉티브의 isErrorPage속성을 true로 설정하면, 현제 jsp파일이 에러 발생시 실행되는 jsp파일이라는 것을 의미하고
    	 jsp의 exception 기본객체에서 발생한 에러정보에 접근이 가능하다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NULL</title>
</head>
<body>
<h1>넌 내게 NULL을 줬어</h1>
<h1>java.lang.NullPointerException 발생</h1>
<p>내부 서버 오류</p>
<%=exception %>  <%-- 예외 객체를 이름 그대로 출력하면 에러 발생 이유가 출력되고, 이 객체에는 여러 메소드가 있다. --%>
${pageContext.exception}
<%--EL에서는 기본객체를 바로 접근할 수 없기 떄문에 pageContext를 거쳐서 이용해야한다. --%>
</body>
</html>