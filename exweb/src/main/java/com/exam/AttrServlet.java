package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
  자바웹 애플리케이션에서 데이터를 저장할 수 있는 객체
- HttpServletRequest(요청객체) : 1개의 요청을 처리하는 동안에만 유지(서비스 요청마다 객체를 생성)
- HttpSesstion (세션객체) : 클라이언트(웹브라우저)마다 1개씩 객체를 생성 ->로그인 정보 저장등에 이용된다. 한페이지마다 계속 로그인하라고 할 수는 없지 않는가 ?
						 사용자별로 독립적으로 유지해야하는 데이터 저장
						 일정시간동안 요청이 없는 세션객체는 삭제 가능
- ServletContext (서블릿 컨텍스트) : 웹 애플리케이션 전체에 1개만 존재(서버 종료시 까지 유지). 모든 사용자가 공유하는 데이터를 저장
*/
@WebServlet("/attr.do") 
public class AttrServlet extends HttpServlet {
	@Override	//요청이 들어올 때마다 1씩 증가하는 수가 출력되도록 페이지 작성
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AttrServlet 실행");					
		int cnt=0;

		//요청객체에 "cnt"라는 이름으로 저장되어 있는 속성값 읽어오기
		AtomicInteger reqCnt = (AtomicInteger) req.getAttribute("cnt");
		if(reqCnt==null) {// 요청객체의 "cnt"에 저장되어 있는 값이 없는 경우
			reqCnt =  new AtomicInteger(0); //0을 저장한 정수객체 생성
		}
		reqCnt.incrementAndGet(); //정수객체의 값을 1증가
		//요청객체에 "cnt"라는 이름으로 정수값을 저장
		req.setAttribute("cnt", reqCnt);
		
		HttpSession session= req.getSession(); //현재 요청이 속한 세션 가져오기
		//세션객체에 "cnt"라는 이름으로 저장되어 있는 속성값 읽어오기
		AtomicInteger ssCnt = (AtomicInteger) session.getAttribute("cnt");
		if(ssCnt==null) {// 세션객체의 "cnt"에 저장되어 있는 값이 없는 경우
			ssCnt =  new AtomicInteger(0); //0을 저장한 정수객체 생성
		}
		ssCnt.incrementAndGet(); //정수객체의 값을 1증가
		//세션객체에 "cnt"라는 이름으로 정수값을 저장
		session.setAttribute("cnt", ssCnt);
		
		ServletContext context= req.getServletContext(); //현재 요청이 속한 서블릿콘텍스트 가져오기
		//서블릿콘텍스트 객체에 "cnt"라는 이름으로 저장되어 있는 속성값 읽어오기
		AtomicInteger conCnt = (AtomicInteger) context.getAttribute("cnt");
		if(conCnt==null) {// 서블릿콘텍스트 객체의 "cnt"에 저장되어 있는 값이 없는 경우
			conCnt =  new AtomicInteger(0); //0을 저장한 정수객체 생성
		}
		conCnt.incrementAndGet(); //정수객체의 값을 1증가
		//서블릿콘텍스트 객체에 "cnt"라는 이름으로 정수값을 저장
		context.setAttribute("cnt", conCnt);
	
		
		resp.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = resp.getWriter();		                                              
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset=\"UTF-8\">         ");
		out.println("<title>AttServlet</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("<h1>service에서 가져온 cnt : " + cnt + "</h1>");
		out.println("<h1>요청객체에서   가져온 cnt : " + reqCnt + "</h1>");
		out.println("<h1>세션객체에서   가져온 cnt : " + ssCnt + "</h1>");
		out.println("새로고침 때 마다 1씩 증가함.");//그러나 한 브라우저 내의 요청횟수만 카운트 된다. 각각 다른 브라우저로 열면 각 브라우저의 요청 횟수에 따름
		out.println("<h1>서블릿컨텍스트에서   가져온 cnt : " + conCnt + "</h1>");
		out.println("<h3>요청이 들어올 때마다 1씩 증가하는 수가 출력되도록 페이지</h3>");
		out.println("</body>                          ");
		out.println("</html>                          ");
		
	}
}
