package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 3월 10일 과제
// http://localhost:8000/exweb/welcom.do?user=abc 로 요청을 보내면
//(파라미터와 요청주소를 구분하는 것 :  ?		파라미터와 파라미터 구분짓는 것 : &)
// 브라우저 화면에 큰 제목으로 abc님 환영합니다. 라고 출력되도록 구현
public class WelcomeServlet extends HttpServlet { // 서블릿을 상소감
//	@WebServlet("/welcome.do") //브라우저에서 괄호 안의 주소를 요청했을 때 실행되도록 연결해줌 // web.xml에 설정하면 안해도 됌
	@Override // 서비스라는 메소드 덮어쓰기함
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("WelcomeServlet 실행 ! ");
		
		req.setCharacterEncoding("UTF-8"); // 크롬이 보낸걸 어떻게 받아드릴지 인코딩
		
		String name = req.getParameter("user");
		
		resp.setContentType("text/html; charset=UTF-8"); 	// 크롬에게 어떻게 보낼지 인코딩
		
		PrintWriter out = resp.getWriter();
		out.println();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>3월 10일 과제</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>	"+name+" 님 환영합니다 !!</h1></b>");
		out.println("<p>	아이고 다 된 것인가 ? </p>");
		out.println("</body>");
		out.println("</html>");
	}
}
