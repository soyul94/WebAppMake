package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/form.do")
public class StuFormServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("StuFormServlet 실행 !");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String menu=req.getParameter("menu");
		String stu_no=req.getParameter("stu_no");
		
		req.setAttribute("menu", menu);
		req.setAttribute("stu_no", stu_no);
		
		req.getRequestDispatcher("/WEB-INF/view/student/StudentForm.jsp").forward(req, resp);

/*
		PrintWriter out = resp.getWriter();	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>여기는 StuFormServlet !</title>");
		//style시트
		out.println("<style>");
		out.println("input{margin:5px; padding:5px;}");
		out.println("</style>");//style시트 끝
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>STUDENT_TABLE</h2></b>");
		if(menu.equals("insert")) {
		out.println("<p>DB에 인스턴스 추가하기</p>");		
		//form태그	
		out.println("<form action='" + req.getContextPath() + "/student/list.do'>"); 
		out.println("<input type=\"submit\" value='목록가기'/>");
		out.println("</form>");
		out.println("<form action='./add.do' method='post'>"); 
		out.println("학번 : <input type = 'text' name='stu_no'/><br>");
		out.println("이름 : <input type = 'text' name='stu_name'/><br>");
		out.println("점수 : <input type = 'text' name='stu_score'/><br>");
		out.println("<input type=\"submit\" value='등록'/>");
		out.println("</form>");
		}
		else if(menu.equals("update")) {
		out.println("<p>DB에 인스턴스 변경하기</p>");		
		//form태그	
		out.println("<form action='" + req.getContextPath() + "/student/list.do'>"); 
		out.println("<input type=\"submit\" value='목록가기'/>");
		out.println("<h4>"+stu_no+ "님의 변경된 점수를 입력해주세요</h4>");
		out.println("</form>");
		out.println("<form action='" + req.getContextPath() + "/student/update.do' method='post'>"); 
		out.println("<input type='hidden' name='stu_no' value='" + stu_no + "'/>");
		out.println("점수 : <input type = 'text' name='stu_score'/><br>");
		out.println("<input type=\"submit\" value='변경'/>");
		out.println("</form>");	
		}
			
		out.println("</body>");
		out.println("</html>");
*/		
	}
	

}
