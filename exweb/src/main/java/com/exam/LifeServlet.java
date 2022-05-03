package com.exam;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
서블릿 클래스는 Servlet인터페이스를 직접 구현하거나( implements Servlet),
Servlet인터페이스를 구현해 놓은 HttpServlet클래스를 상속하여 작성.

서블릿의 생명주기(servlet life cycle): 서블릿 객체가 생성부터 소멸되기까지 자동으로 실행되는 메서드들

톰캣은 처음 서블릿 주소로 요청을 받으면, 실행할 서블릿 객체(인스턴스)가 존재하는지 찾아본다.
이때  객체가 존제하지 않으면 객체를 생성 후 init() service()를 실행, 객체가 존제하면 service()를 실행
*/
public class LifeServlet extends HttpServlet {
	
	@Override	//서블릿 객체가 처음 생성된 후, 초기화 작업을 위하여 실행
	public void init() throws ServletException {
		System.out.println("LifeServlet : init() 실행 !");
		
		//현재 서블릿의 설정정보 가져오기. ServletContfig객체는 xml에 있는 서블릿의 설정정보를 담고 있는 객체이다
		ServletConfig config = getServletConfig(); //이렇게 객체를 생성하지 않아도 ServletConfig의 메소드들을 호출할 수 있다.
		System.out.println(config.getServletName());//web.xml에 등록된 서블릿의 이름을 get함
		//web.xml에 <init-param>로 설정한 서블릿 초기화 파라미터 값 읽기.
		//						초기화 파라이터를 사용하면, 자바 코드의 변경 및 재컴파일 없이 값 변경가능.
		System.out.println(config.getInitParameter("id"));
	}
	
	@Override	//서블릿의 주소와 일치하는 요청이 올때마다 1번씩 실행
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeServlet : service() 실행 !");
	}
	
	@Override	//서블릿 객체가 소멸하기 전에 1회만 실행. 서블릿에서 사용하던 자원을 반남하는 작업을 수행 ex) close()작업들
	public void destroy() {
		System.out.println("LifeServlet : destroy() 실행 !"); //실제로 확인은 불가함
	}


}
