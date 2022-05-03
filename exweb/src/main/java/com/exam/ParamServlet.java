package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 웹브라우저에서 요청을 보낼 때, 추가적인 정보를 전송가능
 요청주소? 파라미터명 = 파라미터 값
 http://localhost:8000/exweb/param.do?a=123
 
 이 때 모든 파라미터 값은 문자열이다.
*/

public class ParamServlet extends HttpServlet { //web.xml에 클래스 선언하고 param.do와 매핑시킴
	@Override //덮어쓰기 한다는 것.
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ParamServlet 실행 ! ");
		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩
		
		//  서블릿에서 요청객체.getParameter("파라미터명") 명령으로 파라미터값을 읽어서 사용 가능
		String aval = req.getParameter("a");		//파라미터 값이 1개 일 때. (메소드 반환이 단일 스트링임)
		String[] bval =req.getParameterValues("b");	//파라미터 값이 다수 일 때. (메소드 반환이 스트링 배열임)
		
		resp.setContentType("text/html; charset=UTF-8");	
		
		PrintWriter out = resp.getWriter();
		out.println();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>파라미터 입력 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>	파라미터 테스트</h1></b>");
		out.println("<h3>	"+ aval +"</h3>"); // 처음 화면을 띄우면 파라미터 값이 없기 때문에 NULL이 나옴
		out.println("<p>	내가 지금 제대로 하고 있는걸까</p><br>");
		
		out.println("<h3>	배열로 받은 파라미터 출력</h3></b>");		
		
		if(bval==null)
			out.println("<h3>	배열이 입력되지 않았습니다.</h3></b>");			
		else {
			out.println("<br>");
			for(int i=0;i<bval.length;i++)
				out.println("<h4>	"+ bval[i] +"</h4>");
			
			for(String i : bval)	//for-each문
				out.println("<h4>	"+ i +"</h4>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
	// 3월 10일 과제
	// http://localhost:8000/exweb/welcom.do?user=abc 로 요청을 보내면
	// 브라우저 화면에 큰 제목으로 abc님 환영합니다. 라고 출력되도록 구현
}
