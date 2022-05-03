package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8000/exweb/add.do?x=123&y=456 로 요청을 보내면
//(파라미터와 요청주소를 구분하는 것 :  ?		파라미터와 파라미터 구분짓는 것 : &)
//브라우저 화면에 더한 값이 출력되도록 구현
@WebServlet("/add.do")
public class AddInt extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("AddInt 실행 ! ");
		resp.setContentType("text/html; charset=UTF-8");	
		
		String num1 = req.getParameter("X"); //파라미터 값은 항상 문자열이다
		String num2 = req.getParameter("Y");
		String oper = req.getParameter("op");
		
		PrintWriter out = resp.getWriter();
		out.println();
		
		int NUM1 = 0;
		int NUM2 = 0;
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">"); 
		out.println("<title>파라미터 2개 입력받기!!</title>");
		out.println("</head>");
		out.println("<body>");
		
		if(num1==null || num2==null || oper==null) {
			NUM1 = 0;
			NUM2 = 0;
				
			out.println("<h1>	합연산과 곱연산</h1></b>");
			out.println("<h3>	아직 입력된 파라미터 값이 없어요</h3>");
			out.println("<p>	주소창에 ?와 함께 원하는 값과 +과 *를 골라 입력해주세요 </p>");			
		}
		else{
			NUM1 = Integer.parseInt(num1);
			NUM2 = Integer.parseInt(num2);
			
			switch(oper.charAt(0)) {
			case '+' : 	// 주소창에 직접 +를 입력하면 인식이 되지 않음. +는 주소창에서 의미있는 기호기 때문에. 그러나 input태그에 입력하면 알아서 변환해줘서 작동함.
				out.println("<h1>	합연산</h1></b>"); // ctrl+1누르면 이 부분을 어떻게 고칠지 체안해줌
				//out.println("<h3>	"+ num1+"+"+num2+"="+(num1+num2)+"</h3>"); 
				out.println("<h3>	"+ NUM1+"+"+NUM2+"="+(NUM1+NUM2)+"</h3>"); // 처음 화면을 띄우면 파라미터 값이 없기 때문에 NULL이 나옴
				out.println("<p>	원하는 결과 값이 나오셨나요 ??</p>");
				break;
			case '*' : 
				out.println("<h1>	곱연산</h1></b>"); // ctrl+1누르면 이 부분을 어떻게 고칠지 체안해줌
				//out.println("<h3>	"+ num1+"*"+num2+"="+(num1*num2)+"</h3>"); 
				out.println("<h3>	"+ NUM1+"*"+NUM2+"="+(NUM1*NUM2)+"</h3>"); // 처음 화면을 띄우면 파라미터 값이 없기 때문에 NULL이 나옴
				out.println("<p>	원하는 결과 값이 나오셨나요 ??</p>");
				break;
			default :
				out.println("<h3>	계산할 수 없는 기호가 입력되었습니다. 다시 입력해주세요.</h3>");
			}
			
		}
		
		out.println("</body>");
		out.println("</html>");
		/*
		PrintWriter out = resp.getWriter();
		out.println();
		
		if(num1 == null || num2 == null) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">"); 
			out.println("<title>파라미터 2개 입력받기!!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>	합연산</h1></b>");
			out.println("<h3>	아직 입력된 파라미터 값이 없어요</h3>");
			out.println("<p>	내가 지금 제대로 하고 있는걸까</p>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">"); 
			out.println("<title>파라미터 2개 입력받기!!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>	합연산</h1></b>");
			out.println("<h3>	"+ num1+"+"+num2+"="+(num1+num2)+"</h3>");
			out.println("<h3>	"+ NUM1+"+"+NUM2+"="+(NUM1+NUM2)+"</h3>"); // 처음 화면을 띄우면 파라미터 값이 없기 때문에 NULL이 나옴
			out.println("<p>	내가 지금 제대로 하고 있는걸까</p>");
			out.println("</body>");
			out.println("</html>");
			
		}*/
		
	}

}
