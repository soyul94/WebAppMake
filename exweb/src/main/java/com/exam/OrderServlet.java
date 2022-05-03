package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("OrderServlet 실행 !");
		
		req.setCharacterEncoding("UTF-8");//post방식으로 전송되는 한글파라미터 인코딩
		resp.setContentType("text/html; charset=UTF-8");	// 응답내용의 문자인코딩과 문서형식을 동시에 설정가능		
		
		String user = req.getParameter("user");		//파라미터 값이 1개 일 때. (메소드 반환이 단일 스트링임)
		String[] order =req.getParameterValues("ord");	//파라미터 값이 다수 일 때. (메소드 반환이 스트링 배열임)
		String[] food_num = {"p001","p002","p003","p101","p102"};
		String[] food = {"피자" ,"햄버거" ,"돈까스","딸기주스","키위주스"};
		int order_cnt=0;	//order.length
		
		PrintWriter out = resp.getWriter();		
		out.println("<!DOCTYPE html>                  ");
		out.println("<html>                           ");
		out.println("<head>                           ");
		out.println("<meta charset=\"UTF-8\">         ");
		out.println("<title>주문 받기</title> ");
		out.println("</head>                          ");
		out.println("<body>                           ");
		
		if(user==null||user.length()==0)		// user는 입력을 하지 않으면 빈배열이 들어가 null이 아니라 문자열 길이를 조건으로 넣음
			out.println("<h3>	주문이 실패했습니다. 다시 해주세요.</h3>");
		else {
			if(order!=null) 
			{
				order_cnt=order.length;
				out.println("<h4>"+user+"님이 주문하신 음식 목록.</h4>");
				out.println("<ul>");
				
				for(int i=0;i<order_cnt;i++)
					for(int x=0;x<food_num.length;x++)
						if(order[i].equals(food_num[x])) out.println("<li><h4>"+food[x]+"</h4></li>");
					
	/*			for(int i=0;i<order.length;i++) {
					switch(order[i]) {
					case "p001" : out.println("<li><h4>피자</h4></li>"); 		break;
					case "p002" : out.println("<li><h4>햄버거</h4></li>");	break;
					case "p003" : out.println("<li><h4>돈까스</h4></li>");	break;
					case "p101" : out.println("<li><h4>딸기주스</h4></li>");	break;
					case "p102" : out.println("<li><h4>키위주스</h4></li>");	break;
					default : 
					}
				}*/
				out.println("</ul>");				
			} 			
			out.println("<h4>"+user+"님은 총 "+order_cnt+"개의 음식을 주문했습니다.</h4>");	
		}					
		out.println("<h3>	안녕히가세요 !           </h3>");
		out.println("</body>                          ");
		out.println("</html>                          ");
			
	}
				
}


