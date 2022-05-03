<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.exam.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP practice</title>
<style>
body{
	padding : 10px;
}
h1,h2{
background-color: #bbb;
}
h3{
background-color: #eee;
}

.bold{
font-weight: bolder;
}
</style>
</head>
<body>
<%@ include file="./menu.jsp" %>
<br>
<h1>JSP(Java Server Page)</h1>
HTML 문서 내에 JAVA 코드를 삽입 but HTML의 탈을 쓴 Servlet이다.<br>
hello.jsp 파일을 요청하면, 톰캣은 hello.jsp 파일을 Servlet으로 변환하여 실행. <br>
<dl>
	<dt><h2>JSP 구성요소</h2></dt>
		<dd><h3>- 디렉티브 :</h3> &#60;%@ 디렉티브명 속성명="속성값" 속성명 ="속성값" %&#62; -> 이때 속성은 여러개 나열가능<br>
		&emsp;page(현재 JSP페이지에 대한 설정),<br> 
		&emsp;include(다른 jsp파일을 포함시킴(공통부분을 반복적으로 사용할 때를 대비)),<br> 
		&emsp;taglib(태그 라이브러리 사용)<br>	
		</dd>
		<dd>
		<h3>- 스크립트요소</h3>
		&emsp;<span class="bold">스크립트트릿 :</span> &#60;% 자바코드 %&#62; 서블릿의 sevice() 메서드 내부에 작성될 내용을 작성<br>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;변수 선언 없이 사용 가능한 JSP 기본객체들을 사용가능<br>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(request:요청객체, response:응답객체, session:세션객체, application:서블릿 컨텍스트 객체, <br>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;out:응답객체의 출력 스트림, config:ServletConfig객체, pageContext:현재 jsp파일에 대한 모든 정보를 포함, <br>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;page:현재JSP객체, exception:발생한 예외객체)<br>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;어떻게 ? 서블릿 파일로 변환되면서 기본으로 다 선언되기 때문에 jsp파일에서 그냥 쓸 수 있음.<br>
		
		&emsp;<span class="bold">표현식 :</span> &#60;%= 변수명 %&#62; 하면 &#60;% out.println(변수명)%&#62; 과 동일한 결과가 나옴 즉, 현재위치에 결과값을 출력할 자바코드<br> 
		&emsp;<span class="bold">선언부 :</span> &#60;%! 자바코드 %&#62; 서블릿의 service() 외부에 작성할 자바코드<br> 
		&emsp;<span class="bold">주석 :</span> &#60;%-- 내용 --%&#62;<br> 
		<%
			// 서블릿의 sevice() 메서드 내부에 작성하는 것처럼 자유롭게 코드 작성
			String local = "지역변수"; 
			System.out.println(local);
			out.println("브라우저에 출력할 내용");
			out.println(session==request.getSession());
			out.println(application==request.getServletContext());
			out.println(config==getServletConfig());
			pageContext.setAttribute("pa","pv"); // 현재 JSP파일에서만 사용가능한 데이터 저장
			//pageContext에는 다른 jsp 기본객체들이 모두 저장되어 있다.
			out.println(request==pageContext.getRequest());
			out.println(response==pageContext.getResponse());
			out.println(session==pageContext.getSession());
			out.println(application==pageContext.getServletContext());
			out.println(page==this);
		%>
		표현식 사용 : <%=local %>
		선언부 사용 : <%=global%><%!String global="전역변수"; %>
		</dd>
		<dd>
		<h3>- 액션태그 :</h3> 자주 사용하는 자바코드를 대체할 수 있는 태그. 현재는 잘 쓰지 않음<br>
		&#60;%<br>
			&emsp;MemberVO j= (MemberVO)pageContext.getAttribute("j");<br>
			&emsp;&emsp;if(j==null){<br>
			&emsp;&emsp;&emsp;j=new MemberVO();<br>
			&emsp;pageContext.setAttribute("j", j);<br>
			&emsp;}<br>
			&emsp;j.setMemId("d001");<br>
			&emsp;out.print(j.getMemId());<br>
		%&#62;의 결과 값 :  
		<%
			MemberVO j= (MemberVO)pageContext.getAttribute("j");
			if(j==null){
				j=new MemberVO();
				pageContext.setAttribute("j", j);
			}
			j.setMemId("d001");
			out.print(j.getMemId());
		%><br>
		위와 동일한 동작을 하는 액션태그<br>
		&emsp;&emsp;&emsp; ->page 안에 m이라는 class객체를 이용한다. 없으면 m으로 생성한다.<br>
		&#60;jsp:useBean id="m" class="com.exam.member.MemberVO" scope="page">&#60;/jsp:useBean> <br>
		&#60;jsp:setProperty property="memId" name="m" value="c001"/>&emsp;&emsp;value말고 param을 사용하면 파라미터 값 줄 수 있음 <br>
		&#60;jsp:getProperty property="memId" name="m"/> => 
		<jsp:useBean id="m" class="com.exam.member.MemberVO" scope="page"></jsp:useBean> 
		<jsp:setProperty property="memId" name="m" value="c001"/> <%--value말고 param을 사용하면 파라미터 값 줄 수 있음 --%>
		<jsp:getProperty property="memId" name="m"/><br>
		&emsp;태그를 알기보다 forward, include, rediredct 의 수행 구분을 잘 구별해야한다. <br>
		<br>
		&emsp;forward : 현재 서블릿(JSP) 실행을 중단하고 다른 서블릿(JSP)를 실행<br>
		&emsp;&emsp;request.getRequestDispatcher("./menu.jsp").forward(request, response);<br>
		&emsp;&emsp;&#60;jsp:forward page="./menu.jsp">&#60;jsp:param/>&#60;/jsp:forward><br>
		&emsp;include : 다른 서블릿(SJP)의 실행 결과를 현재 위치에 포함<br>
		&emsp;&emsp;request.getRequestDispatcher("./menu.jsp").include(request, response);<br>
		&emsp;&emsp;&#60;jsp:include page="./menu.jsp">&#60;jsp:param/>&#60;/jsp:include><br>
		</dd>
		<dd>
		<h3>- EL(Expression Language) :</h3>JSP 표현식과 유사하며 가장 많이씀.<br>
		<span class="bold">형식: &#36;{내용 or 파라미터명} &emsp;ex) &#36;{123} &#36;{'문자열'} &#36;{연산식}</span><br>
		&emsp;단, EL에 쓰여지는 파라이터명은 pageContext, request, session, application에 저장된 속성을 의미<br><br>
		<%
			String s = "콤비네이션 피자";
			pageContext.setAttribute("pcs",s);	
			int[] arr = {3, 6, 9};
			pageContext.setAttribute("ar",arr);
			HashMap map= new HashMap();
			map.put("k","v");
			pageContext.setAttribute("ma",map);
		%>
		<%=s %> ${pcs}<br>
		배열의 1번 칸의 값 : <%=arr[1]%> ${ar[1]}<br>		<%--이전 버전들에는 이런 형식으로 불러왔음 --%>
		hashMap의 'k'라는 이름의 값 : <%=map.get("k")%> ${ma.get("k")} ${ma.k} ${ma["k"]}<br> 
		객체의 getXxx() 속성값 : <%=j.getMemId() %>  ${j.getMemId()} ${j.memId} ${j["memId"]}<br>
		<%
			pageContext.setAttribute("pa",12);
			request.setAttribute("ra",34);
			session.setAttribute("sa",56);
			application.setAttribute("aa",78);
		%>
		pageContext.setAttribute("pa",12); = <%=pageContext.getAttribute("pa")%> ${pageScope.pa} ${pageScope['pa']} ${pa}<br>
		request.setAttribute("ra",34); = <%=request.getAttribute("ra")%> ${requestScope.ra} ${requestScope['ra']} ${ra}<br>
		session.setAttribute("sa",56); = <%=session.getAttribute("sa")%> ${sessionScope.sa} ${sessionScope['sa']} ${sa}<br>
		application.setAttribute("aa",78); = <%=application.getAttribute("aa")%> ${applicationScope.aa} ${applicationScope['aa']} ${aa}<br>
		<br>
		xxxScope을 생략하면 pageScope > requestScope > sessionScope > applicationScope 순서로 탐색하여 먼저 발견되는 속성값을 사용.<br>
		<br>
		EL의 장점 : null 상태인 값을 이용하여도 에러가 발생하지 않고 그냥 화면에 출력이 없엄.<br>
		EL에서 별도의 변수언선 없이 사용 가능한 기본객체 (JSP 기본객체와 다르다. 얘네는 EL에서 사용불가)<br>
		<br>
		request.setParameter("x") = <%=request.getParameter("x") %> ${param.x} ${param['x']}<br>
		request.setParameterValues("x") = <%--<%=request.getParameterValues("x")[0] --%> ${paramValues.x[1]} ${paramValues['x'][0]}<br>
		헤더값 : <%=request.getHeader("User-Agent") %><br> 
		&emsp;&emsp;&emsp; ${header['User-Agent']}<br> <%--${header.User-Agent}는 속성명에 -있어서 사용불가 --%>
		헤더값이 여러개인 경우 : headerVaules 사용<br>
		쿠키값 : 이름 <%=request.getCookies()[0].getName()%> 값 <%=request.getCookies()[0].getValue()%> <br>
		&emsp;&emsp;&emsp;&emsp;이름 ${cookie.JSESSIONID.name} 값 ${cookie.JSESSIONID.value}<br>
		쿠키는 n개의 객체 배열로 저장되어 있기 때문에 [n]번째 객체라는 걸 지정한 뒤 값을 불러야함. <br>
		초기화파라미터값(web.xml에 설정하는 init) : <%=config.getInitParameter("x")%> ${InitParam.x}<br>
		EL에서 JSP 기본객체를 사용하고 싶은 경우, pageContest를 통해서 사용-> &#36;{ pageContext.기본객체.XXX }<br>
		<%=request.getContextPath() %> = ${pageContext.request.contextPath}<br>
		</dd>
		<dd>
		<h3>- 커스텀 태그 JSTL(JSP Standard Tag Library) : </h3> 
		액션태그에서 제공하는 자바코드 외에 다른 자바코드들을 임의로 태그화 한 것. <br>
		이미 많은 커스텀 태그 라이브러리들이 생성되어 있고 그중 가장 많이 사용 되는 것이 <span class="bold">JSTL(JSP Standard Tag Library)이다.</span><br>
		프로젝트에 JSTL라이브러리 추가 한 뒤 현재 JSP파일에서 사용하고 싶은 태그라이브러리를 <span class="bold">taglib디렉티브로 import.</span><br>
		<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %><%--prefix는 접두어로 자유롭게 가능하나 보통 core태그는 c를 씀 --%>
		<% 
			int score = 80;
			pageContext.setAttribute("score", score);
		%>
		<c:if test="${score>60}">통과</c:if><br>
		<%-- test에는 조건식이 들어가는데 <%=%>도 가능하나 최근에는 보통 EL형식을 주로 쓴다. 그리고 else가 존재하지 않음--%>
		<c:choose>
			<c:when test="${score>90}">최우수<br></c:when>
			<c:when test="${score>80}">우수<br></c:when>
			<c:otherwise>보통<br></c:otherwise>
		</c:choose><%--c:if는 else기능이 없어서 c:choose가 생김 --%>
		<c:forEach var="num" begin="1" end="10" step="2"> <%--var라는 변수를 begin부터 시작해서 end까지 step씩 증가시킨다 --%>
			${num} <%--이건 왜 그냥 EL이 사용되는거지 ? pageContext에 저장될 것으로 추정 --%>
			${pageScope.num}
			<%=pageContext.getAttribute("num")%>
		</c:forEach><br>
		<% out.print("JAVA for-each문으로 출력 : "); for(int no:arr) out.print(no+"  "); %><br>
		<c:out value="c:forEach 태그로 출력 : "/><c:forEach var="no" items="${ar}"> ${no} <c:out value="  "/></c:forEach><br>
		<c:out value="c:forEach 태그의 varStatus 사용 : "/><br>
		<c:forEach var="no" items="${ar}" varStatus="st"> ${st.index }. ${no} == ${st.current} ${st.first} ${st.last}<br><c:out value="  "/>
		</c:forEach><br>
		<c:out value="varStatus의 필드 : c:forEach태그의 설정값과 속성값등 정보를 포함한 객체이다."/><br>
		<c:out value=" current(현재값), index(0부터 몇번쨰 반복인지), 
									   count(1부터 몇번째 반복인지), first(첫번째 반복인지), last(마지막 반복인지),
									   begin(c:forEach태그의 begin속성값), end(c:forEach태그의 end 속성값), step(c:forEach태그의 step속성값)
									   "/><br>
		c:forTokens태그로 문자열 쪼개기 : <c:forTokens var="tok" items="${'a,b,c,d'}" delims=","> [${tok}]</c:forTokens><br>							   
		<%-- c:fortokens - 자주 쓰이지 않는 태그이다 --%>
		<br>
		&#60;c:set scope="" var="" value=""/> : scope(변수의 종속범위:pageContext,request,session,servletContext), var(변수명), value(변수값)<br>
		&emsp;&emsp;&emsp;&emsp; 만일 scope을 지정하지 않는다면 pageContext가 기본이다
		&#60;c:remove scope="" var="" value=""/> : c:set한 변수를 삭제함. 만일 scope를 지정하지 않는다면 모든 객체를 돌아다니며 다 지운다<br>
		&#60;c:out value=""/> : value값을 출력한다. 이때 value값에 태그라던가 특수문자가 있어도 그대로 출력한다. 즉, escapeXml을 함.<br>
		(EL을 쓰면 HTML의 태그가 변환되지 않아 태그가 해석되어 출력)<br>
		주소처리 : <a href="./menu.jsp">menu.jsp로 이동</a><br>
		주소처리 : <a href="<%=request.getContextPath() %>/JSP/menu.jsp">menu.jsp로 이동</a><br>
		주소처리 : <a href="${pageContext.request.contextPath}/JSP/menu.jsp">menu.jsp로 이동</a><br>
		주소처리 : <a href="<c:url value="/JSP/menu.jsp"/>">menu.jsp로 이동</a><br>
		<c:url value="/JSP/menu.jsp"/><%--경로가 /로 시작하면 contextPath를 앞에 자동으로 붙여준다 --%>
		: 이때 contextPath는 프로젝트 파일 경로는 찾아주지 못한다. 현재 프로젝트 기준으로 webapp까지만 찾아줌.<br>
		<c:import url="menu.jsp"/> : 다른 서블릿 또는 jsp를 실행한 결과를 포함 이 때 프로젝트 외부의 사이트 내용도 포함 가능하다는게 차이점이다. <br>
		<c:import url="http://google.com"/> 
		<%@ include file="menu.jsp" %> : JSP파일의 내용을 이곳에 복사한 후 하나의 서블릿으로 변환<br>
		<jsp:include page="menu.jsp"/> : 다른 서블릿 또는 JSP를 실행한 결과(출력내용)를 이곳에 포함<br>
		<br>
		&#60;% response.sendRedirect(request.getContextPath()+"/JSP/menu.jsp"); %>와 &#60;c:redirect url="./menu.jsp"/>의 결과는 같다. <br>
		두 태그 모두 &#60;c:param태그를 사용하여 주소처리 태그들에 파라미터 추가 가능하다. <br>
		<br>
		예외처리 &#60;c:catch var="e">: <c:catch var="e"><% int x = 5/0; %></c:catch> var에 발생한 오류를 저장한다. -> e.message = ${e.message}<br>
		</dd>
		<dd>
		
		<h3>국제화/포맷팅</h3> : 주로 날짜와 시간에 사용한다.<br>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		fmt:formatDate태그 : 자바의 Date객체를 원하는 형태의 문자로 변환해줌 <br>
		<% pageContext.setAttribute("d", new Date()); %>
		현재 시간 : ${d} 이걸 포맷팅 하면-> <fmt:formatDate value="${d}" pattern="yyyy년 MM월 dd일 ....HH시 mm분 ss초"/><br>
		fmt:parseDate태그 : 날짜 시간 문자열을 자바 Date 객체로 변환 -> <fmt:parseDate value="2022/06/15 09:43:22" pattern="yyyy/MM/dd hh:mm:ss" var="d2" /> ${d2}<br>
		<% pageContext.setAttribute("n",1234.56); %>
		fmt:formatNumber태그 : 숫자값을 문자열로 변환 #또는 0사용 ${n} -> 
		<fmt:formatNumber value="${n}" pattern="###,###.###" /> <fmt:formatNumber value="${n}" pattern="000,000.000" /><br>
		fmt:parseNumber태그 : 숫자 문자열을 숫자값으로 변환 12,345.67 ->
		<fmt:parseNumber value="12,345.67" pattern="###,###.###" var="n2" /> ${n2} <br>
		<br>
		JSTL 국제화 태그들이 사용할 로케일 지정(미지정시 Accept-Language 요청 헤더 값 사용)<br>
		"언어코드_국가코드" 또는 "언어코드-국가코드" 또는 "언어코드" 또는 "국가코드"<br>
		<fmt:setLocale value="en_US"/>
		<br>
		fmt:setBundle태그 : 메시지를 저장한 properties파일명이 "클래스패스/폴더명/번들명_언어_국가.properties"인 경우 basename은 "폴더명.번들명"<br>
		한국 브라우저에서 요청을 보냈기 때문에  : <fmt:setBundle basename="msg" var="mb" />
		<fmt:message bundle="${mb}" key="str" /><br>
		<br>
		</dd>
		<dd>
		<h3>function 태그</h3>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<br> ${fn:length("aBcD")} <%="aBcD".length() %>
		<br> ${fn:contains("aBcD","Bc")} <%="aBcD".contains("Bc") %>    
		<br> ${fn:containsIgnoreCase("aBcD","bC")}  <%="aBcD".toLowerCase().contains("bC".toLowerCase()) %>
		<br> ${fn:startsWith("aBcD","aB")} <%="aBcD".startsWith("aB") %>
		<br> ${fn:endsWith("aBcD","cD")} <%="aBcD".endsWith("cD") %>
		<br> ${fn:escapeXml("<h1>제목</h1>")} <c:out value="<h1>제목</h1>" />
		<br> ${fn:indexOf("aBcD","Bc")} <%="aBcD".indexOf("Bc") %>
		<br> ${fn:join(ar,"::")} <%=String.join("::", "3,6,9".split(",") )%>
		<br> ${(fn:split("a,B:c,D",",:"))[2]} <%="a,B:c,D".split("[,:]")[2] %>
		<br> ${fn:replace("aBcDBc","Bc","efg")} <%="aBcDBc".replace("Bc","efg") %>
		<br> ${fn:substring("aBcD", 1, 2)} <%="aBcD".substring(1,2) %>
		<br> ${fn:substringAfter("aBcD", "Bc")}
		<br> ${fn:substringBefore("aBcD", "Bc")}
		<br> ${fn:toLowerCase("aBcD")} <%="aBcD".toLowerCase() %>
		<br> ${fn:toUpperCase("aBcD")} <%="aBcD".toUpperCase() %>
		<br> [${fn:trim("   aB cD  ")}] [<%="   aB cD  ".trim() %>]
		
		</dd>

</dl>

</body>
</html>