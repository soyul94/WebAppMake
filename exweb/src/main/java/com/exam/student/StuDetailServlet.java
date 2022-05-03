package com.exam.student;
// 220414 과제 : 학생추가, 학생삭제 기능을 추가.
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 정보를 보여주는 서블릿 작성
@WebServlet("/student/detail.do")
public class StuDetailServlet extends HttpServlet { 
	StudentDAO studentDao = new StudentDAO(); //service가 몇번이 실행되던 1번만 생성되어야 하기 때문에 service 밖에 있어야한다.
			
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("StuDetailServlet 실행 ! ");
		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩	
		resp.setContentType("text/html; charset=UTF-8");
		
		String stu_no = req.getParameter("stu_no");
		StudentVO student= studentDao.select(stu_no); //테이블을 읽는 것은 요청이 올 때마다 실행.
		req.setAttribute("student", student);
		req.getRequestDispatcher("/WEB-INF/view/student/StudentDetail.jsp").forward(req, resp);

/*		
		PrintWriter out = resp.getWriter();	
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>학생 목록</title>");
		//style시트
		out.println("<style>");
		out.println(".center{text-align:center; margin:auto;");
		out.println("		 border-width:2px; border-style:solid; border-color:gray;  border-collapse:collapse;}");
		out.println("th{font-size:1.3em; border:2px; border-style:solid; border-color:gray; width:150px; padding:10px; background-color:#eee;}");
		out.println("td{font-size:1em; border:2px; border-style:solid; border-color:gray; width:150px; padding:10px;}");
		out.println("h2,p{text-align:center; }");
		out.println("input{margin:10px; padding:5px;}");
		out.println("</style>");//style시트 끝
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>STUDENT_TABLE</h2></b>");
		out.println("<p>DB로부터 리스트를 받아와 출력하기</p>");	
		//table시작
		out.println("<figure>");
		out.println("<figcaption>");
		out.println("<form action='./list.do' method='get'>"); 
		//out.println("<input type='hidden' name='menu' value='insert'/>");
		out.println("<input type='submit' value='목록가기'/>");
		out.println("</form>"); 
		//out.println("<button onclick='location.href=\"./form.do\"'>학생 정보 입력</button>");
		out.println("</figcaption>");
		out.println("<table class=\"center\">");
		out.println("<tr>");
		out.println("<th>학번</th>");	
		out.println("<th>학생명</th>"); 
		out.println("<th>점수</th>"); 
		out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+student.getStu_no()+"</td>");
			out.println("<td>"+student.getStu_name()+"</td>");
			out.println("<td>"+student.getStu_score()+"</td>");	
			out.println("</tr>");
		out.println("</table>");
		out.println("</figure>");
		out.println("<div style='display:flex;'>");
		//정보 업데이트 버튼
		out.println("<form action='./form.do' method='get'>"); 
		out.println("<input type='hidden' name='menu' value='update'/>");
		out.println("<input type='hidden' name='stu_no' value='" + student.getStu_no() + "'/>");
		out.println("<input type='submit' value='학생 점수 변경'/>");
		out.println("</form>");
		//정보 삭제 버튼
		out.println("<form action='./delete.do' method='get'>"); 
		out.println("<input type='hidden' name='stu_no' value='" + student.getStu_no() + "'/>");
		out.println("<input type='submit' value='학생 정보 삭제'/>");
		out.println("</form>"); 
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
*/
	}

}
