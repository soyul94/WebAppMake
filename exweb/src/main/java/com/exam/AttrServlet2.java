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
user=XXX 파라미터를 한번이라도 받은 경우, 그 브라우저에는 "사용자 : XXX님"라고 출력
user=XXX 파라이터를 한번도 받지 못한 경우, 그 브라우저에는 "사용자 : 알 수 없는 사용자" 라고 출력

user=XXX 파라이터를 이용하여 접속한 적이 있는 사용자들의 수를 "누적 사용자 수 : 00명"으로 출력 (context객체에 저장)

*/
@WebServlet("/count.do") 
public class AttrServlet2 extends HttpServlet {
	@Override	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AttrServlet2 실행");	
		
		ServletContext context= req.getServletContext();
		AtomicInteger userCnt = (AtomicInteger)context.getAttribute("cnt");
		if(userCnt==null) {
			userCnt=new AtomicInteger(0);
			context.setAttribute("cnt", userCnt);
		}
		
		HttpSession session= req.getSession();
		String user= req.getParameter("user");
		if(user!=null&&user.length()>0) {
			userCnt.incrementAndGet();
			context.setAttribute("cnt", userCnt);
			session.setAttribute("user", user);
			//context.setAttribute("cnt", session.get);
		}	
		String name = (String) session.getAttribute("user"); //세션에서 저장된게 뭐가 나올지 모르기 때문에 확신이 있는 타입으로 강제 형변환이 필요.
		if(name==null) {
			name="알 수 없는 사용자";
		}
		
	
		resp.setContentType("text/html; charset=UTF-8");	
		PrintWriter out = resp.getWriter();		                                              
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset=\"UTF-8\">         ");
		out.println("<title>AttServlet_2</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
			
			out.println("<h1>현재 사용자  : " + name + " </h1>");
			out.println("<h1>누적 사용자  : " + userCnt + "</h1>");
		
		out.println("</body>                          ");
		out.println("</html>                          ");
		
	}
}
