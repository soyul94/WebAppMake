package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹애플리케이션 서버 (톰캣)을 통해서 실행되는 자바 클래스를
//작성하기 위해서는 톰캣이 불러올 수 있는 형식에 맞추기 위해서 일반적으로 HttpServlet클래스를 상속
// 상속이란 ? 그 클래스의 내용을 그대로 포함하겠다는 의미
// 톰캣이 실행하는 자바 클래스를 Servlet 서블릿이라 함.


//서블릿 클래스와 요청 주소를 연결하는 방법
// 1. web.xml 파일에 등록
// 2. @WebServlet 을 클래스에 사용-> 서블릿 30부터 지원하는 기능.(톰캣 6이하는 사용불가)
public class HelloServlet extends HttpServlet{
	// estends 해줬기 때문에 여기에는 해당 클래스를 다 포함하고 있는 것.
	
	// 현재 서블릿클래스에 맞는 요청이 올때마다 한번씩 실행
							//요청객체 : 클라이언트(웹브라우저)가 보낸 모든 정보를 담고 있다.
							//응답객체 : 클라이언트에게 응답으로 보낼 정보들을 저장할 수 있다.
	
	@Override             	//요청객채 :                //응답객체
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" HelloServlet 실행 ! ");
		
		// 출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
		resp.setCharacterEncoding("UTF-8"); //응답객체의 인코딩도 변경
		// 응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌		
		resp.setContentType("text/html"); //동영상이나 이미지 등으로도 가능
		// 응답내용의 문자인코딩과 문서형식을 동시에 설정가능	
		//resp.setContentType("text/html; charset=UTF-8");	
		
		// 응답객체에 응답내용을 쓸 수 있는 출력스트림(파이프) 가져오기
		PrintWriter out = resp.getWriter();
		// 응답객체에 출력한 내용이 클라이언트(웹브라우저)에게 전송된다.
		//out.println("Hi Servlet....."); //응답객체에 프린트할 수 있는 메소드
		out.println();
		//out.println("ByeBye");
		//위의 함수에 html을 출력하도록하면 이제 원하는 웹을 꾸밀 수 있게 되는 것
		
		
		// html이외의 것들은 없어야 html로 들어감
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); // 스트링 안에 ""를 넣고 싶으면 \" 역슬레시 붙여서 넣으면 스트링배열로 인식함
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>	hello HTML                         </h1>");
		out.println("<h3>	안녕하세요! 적당히 바람이 시원해</h3>");
		out.println("</body>");
		out.println("</html>");
	}	                                                   

}

























