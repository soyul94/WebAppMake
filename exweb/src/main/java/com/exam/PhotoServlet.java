package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*	
	정수와 정수가 동일한가 비교할 때는 123==456
	문자열과 문자열이 동일한가 비교할 때는 "abc".equals("def") 혹은 변수명.equals("def")
	왜냐하면 자바에서 문자열은 객체이기 때문이다. 변수가 아님 !
	equals는 String 클래스 내부에 있는 메소드이다
*/
@WebServlet("/photo.do")
public class PhotoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginSerclet 실행 !");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩
		String name = req.getParameter("img"); //파라미터 값은 항상 문자열이다
		
		PrintWriter out = resp.getWriter();
		out.println();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>동물사진 띄우기</title>");		
		out.println("</head>");
		out.println("<body>");
			
		if(name==null)
			out.println("<h1>주소창에 원하는 동물을 입력해 주세요.</h1></b>");
		else {
			switch(name) {
			case "bear" :
				out.println("<h1>"+name+"</h1></b>");
				out.println("<img src = 'https://picsum.photos/id/1020/200/300'>"); // 웹브라우져 페이지에 이미지 삽입하기.
				break;																// <img src = "그림파일 위치">
			case "eagle" :															// 큰따옴표가 겹쳐서 인식오류가 생기기 때문에 작은 따옴표로 쓰거나 역슬래시\를 앞에 붙여서 구별해줌
				out.println("<h1>"+name+"</h1></b>");								// "<img src = 'https://picsum.photos/id/1020/200/300'>"
				out.println("<img src = 'https://picsum.photos/id/1024/200/300'>"); // "<img src = \"https://picsum.photos/id/1020/200/300">"
				break;
			case "dog" :
				out.println("<h1>"+name+"</h1></b>");
				out.println("<img src = 'https://picsum.photos/id/1025/200/300'>"); 
				break;
			default :
				out.println("<h1>죄송합니다.</b>사진이 없는 동물 입니다.</h1></b>");
			}				
		}
		
		out.println("</body>");
		out.println("</html>");
	}
}

