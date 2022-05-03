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
@WebServlet("/student/list.do")
public class StuListServlet extends HttpServlet { 
	StudentDAO studentDao = new StudentDAO(); //service가 몇번이 실행되던 1번만 생성되어야 하기 때문에 service 밖에 있어야한다.
			
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("StuListServlet 실행 ! ");
		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩	
		resp.setContentType("text/html; charset=UTF-8");
		
		ArrayList<StudentVO> list = studentDao.selectList(); //테이블을 읽는 것은 요청이 올 때마다 실행.
		req.setAttribute("studentList", list);
		
		req.getRequestDispatcher("/WEB-INF/view/student/StudentList.jsp").forward(req, resp);
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
		out.println("#stu_no{border:0;background:#fff; margin:0; font-size:1em;}");
		out.println("</style>");//style시트 끝
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>STUDENT_TABLE</h2></b>");
		out.println("<p>DB로부터 리스트를 받아와 출력하기</p>");	
		//table시작
		out.println("<figure>");
		out.println("<figcaption>");
		out.println("<form action='./form.do' method='get'>"); 
		out.println("<input type='hidden' name='menu' value='insert'/>");
		out.println("<input type='submit' value='학생 정보 입력'/>");
		out.println("</form>"); 
		//out.println("<button onclick='location.href=\"./form.do\"'>학생 정보 입력</button>");
		out.println("</figcaption>");
		out.println("<table class=\"center\">");
		out.println("<tr>");
		out.println("<th>학번</th>");	
		out.println("<th>학생명</th>"); 
		out.println("<th>점수</th>"); 
		out.println("</tr>");
		for(StudentVO e: list) {
		//for(int i=0;i<list.size();i++) {
			out.println("<tr>");
			out.println("<td>");
			out.println("<form action='./detail.do' method='get'>"); 
			out.println("<input type='hidden' name='stu_no' value='"+ e.getStu_no()+"'/>");
			out.println("<input id='stu_no' type='submit' value='"+e.getStu_no()+"'/>");
			out.println("</form>");
			out.println("</td>");
			out.println("<td>"+e.getStu_name()+"</td>");
			out.println("<td>"+e.getStu_score()+"</td>");	
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</figure>");
		out.println("<p>해당 학번을 클릭하면 상세 페이지로 이동</p>");
		out.println("</body>");
		out.println("</html>");
*/
	}

}
