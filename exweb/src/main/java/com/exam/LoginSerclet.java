package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	http:localhost:8000/exweb/login.do?id=아이디&pw=비밀번호 로 요청을 보내면
   
    아이디가 user 이고
		비밀번호가 1234이면 사용자화면 출력
		비밀번호가 1234가 아니면, 로그인 실패 출력
	아이디가 admin이고
		비밀번호가 qwer이면 관리자 화면 출력
		비밀번호가 qwer가 아니면, 로그인 실패 출력
	이 외의 아이디면, 등록되지 않은 사용자 출력
*/
@WebServlet("/login.do")
public class LoginSerclet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("LoginSerclet 실행 !");
		resp.setContentType("text/html; charset=UTF-8");
		
		String ID = req.getParameter("ID"); //파라미터 값은 항상 문자열이다
		String Password = req.getParameter("PW");
		
		PrintWriter out = resp.getWriter();
		out.println();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>로그인창</title>");		
		out.println("</head>");
		out.println("<body>");
			
		if(ID==null||Password==null)
			out.println("<h1>주소창에 아이디와 비밀번호를 입력해주세요.</h1></b>");
		else {
			switch(ID) {
			case "user" 	:
				if(Password.equals("1234")) {
					out.println("<h1>사용자 화면</h1></b>");	
				} 
				else {
					out.println("<h1>로그인 실패</h1></b>");	
					out.println("<h3>비밀번호를 다시 입력해주세요.</h3></b>");
				}break;
			case "admin"	:
				if(Password.equals("qwer")) {
					out.println("<h1>관리자 화면</h1></b>");	
				} 
				else {
					out.println("<h1>로그인 실패</h1></b>");	
					out.println("<h3>비밀번호를 다시 입력해주세요.</h3></b>");
				}break;
			default 		:
				out.println("<h1>등록되지 않은 사용자 입니다.</h1></b>");
			}
			
		}
		
		out.println("</body>");
		out.println("</html>");
				
	}
}
