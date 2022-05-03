package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 받았을 때 실행되는 서블릿
@WebServlet("/bye.do") //브라우저에서 괄호 안의 주소를 요청했을 때 실행되도록 연결해줌
public class ByeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByServlet 실행");					//커서를 두고 Ctrl+Alt+아래방향키 누르면 커서가 위치한 문장 전체를 아래에 복사해줌
		
		//resp.setCharacterEncoding("UTF-8");
		//resp.setContentType("text/html");
		resp.setContentType("text/html; charset=UTF-8");	// 응답내용의 문자인코딩과 문서형식을 동시에 설정가능				
		PrintWriter out = resp.getWriter();
		
		//웹브라우저 http://localhost:8000/exweb/bye.do 로 요청을 보내면,
		//브라우저 화면에 ByeBye 라고 출력되도록
		//out.println();
		//out.println("ByeBye");
		                                              
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset=\"UTF-8\">         ");
		out.println("<title>Insert title here</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("<h1>	Bye HTML             </h1>");
		out.println("<h3>	안녕히가세요 !           </h3>");
		out.println("</body>                          ");
		out.println("</html>                          ");
		
	}
}
