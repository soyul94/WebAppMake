package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹브라우저에서 "http://localhost:8000/exweb/student/list.do"로 접속하면 학생목록이 출력되도록 구현
@WebServlet("/member/delete.do")
public class MemDelServlet extends HttpServlet { 
	MemberDAO memberDao = new MemberDAO(); //service가 몇번이 실행되던 1번만 생성되어야 하기 때문에 service 밖에 있어야한다.
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 "member/list.do"로 요청을 보내면 웹브라우저에 회원목록이 출력되도록 구현
		System.out.println("MemAddServlet 실행 ! ");		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩	
		resp.setContentType("text/html; charset=UTF-8");
		
		String memId=req.getParameter("memId");
		int num= memberDao.delete(memId);
		
		//resp.sedRedirect("이동할 주소") : 명령을 사용하여 웹브라우저에게 특정 주소로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/member/list.do");
		
/*		
		PrintWriter out = resp.getWriter();	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>회원 삭제</title>");
		out.println("<style> .center{text-align:center;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>MEMBER_TABLE</h2></b>");
		out.println("<p>DB에 인스턴스 삭제한 결과</p>");	
		
		out.println(num+"명의 회원이 삭제되었습니다.<br>");
		out.println("<button onclick=\"location.href='./list.do'\">목록가기</button>");
		
		out.println("</body>");
		out.println("</html>");
*/
	}

}
