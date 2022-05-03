package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청 받았을 때 실행되는 서블릿
@WebServlet("/req.do") //브라우저에서 괄호 안의 주소를 요청했을 때 실행되도록 연결해줌
public class ReqServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ReqServlet 실행");					
/*
	클라이언트(웹브라우저)가 보낸 모든 정보(내용)은 요청객체(HttpServletRequest)에 저장되어 있으므로 
	요청객체.gerXXX()메서드를 사용하여 필요한 정보를 읽어서 사용가능
*/		
						
		req.setCharacterEncoding("UTF-8");					//post방식으로 전송되는 한글파라미터 인코딩
		resp.setContentType("text/html; charset=UTF-8");	// 응답내용의 문자인코딩과 문서형식을 동시에 설정가능				
		PrintWriter out = resp.getWriter();
		                                              
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset=\"UTF-8\">         ");
		out.println("<title>req 객체의 정보 알아보기 </title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		out.println("<h1> HttpServletRequest req에 대하여 </h1>");
		out.println("<h1> req.getXXX()메소드는 Network -> Header의 정보를 볼 수 있다. </h1>");
		out.println("<h4>요청주소 : "+req.getRequestURI()+"<br> req.getRequestURI()메서드 사용</h4>"); 
		out.println("<h4>요청주소 : "+req.getRequestURL()+"<br> req.getRequestURL()메서드 사용</h4>"); 
		out.println("<h4>요청방식 : "+req.getMethod()+"<br> req.getMethod()메서드 사용</h4>"); //get인지 post인지
		out.println("<h4>프로토콜 : "+req.getProtocol()+"<br> req.getProtocol()메서드 사용</h4>"); // HTTP/1.1
		out.println("<h4>User-Ahent 헤더 : "+req.getHeader("User-Agent")+"<br> req.getHeader()메서드 사용</h4>"); 
										 // req.getHeader()메서드 : Network탭의 Header에서 Request Header의 View parsed의 정보를 볼 수 있다.
		
		// 근데 User-Agent가 뭔가요 ? 어떤 OS를 쓰고, 어떤 버전인지 웹브라우저의 정보는 어떤 것인지 등을 담고 있는 번호판 같은 개념
		// 궁금하다면 https://blog.naver.com/wishket/222284565707 들어가보기.
		
		//사용한 브라우저가 뭔지 알려주는 문구 출력
		String agent = req.getHeader("User-Agent");
		if(agent.contains("Edg/")||agent.contains("Edge/"))
			out.println("<h4>MS Edge 사용자</h4>");
		else if(agent.contains("Chrome/"))
			out.println("<h4>MS Google Ghrome 사용자</h4>");
		else if(agent.contains("Firefox/"))
			out.println("<h4>Friefow 사용자</h4>");
		else
			out.println("<h4>알 수 없는 사용자</h4>");
		
			
		out.println("</body>                          ");
		out.println("</html>                          ");
		//요청주소를 알려주는 메소드
		// req.getRequestURI() -> /exweb/req.do
		// req.getRequestURL() -> http://localhost:8000/exweb/req.do
		
	}
}
