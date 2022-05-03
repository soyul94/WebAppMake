package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/add.do")
public class StuAddServlet extends HttpServlet { 
	StudentDAO studentDao = new StudentDAO(); 
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("StuAddServlet 실행 ! ");		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩	
		resp.setContentType("text/html; charset=UTF-8");
		
		StudentVO vo= new StudentVO();
		vo.setStu_no(req.getParameter("stu_no"));
		vo.setStu_name(req.getParameter("stu_name"));
		vo.setStu_score(Integer.parseInt(req.getParameter("stu_score")));
		int num= studentDao.insert(vo);
		
		
		//resp.sedRedirect("이동할 주소") : 명령을 사용하여 웹브라우저에게 특정 주소로 이동하라는 명령을 담은 응답을 전송
		resp.sendRedirect(req.getContextPath()+"/student/list.do");

/*		
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>학생 추가</title>");
		out.println("<style>");
		out.println("input{margin:10px; padding:5px;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>STUDENT_TABLE</h2></b>");
		out.println("<p>DB에 인스턴스 추가한 결과</p>");	
		
		out.println(num+"명의 학생이 추가되었습니다.<br>");
		out.println("<form action='" + req.getContextPath() + "/student/list.do'>"); 
		out.println("<input type=\"submit\" value='목록가기'/>");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
*/
	}

}
