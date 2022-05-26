package com.exam.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.member.MemberVO;

//다수의 서블릿의 실행 전후에 공통적으로 수행해야 하는 작업을 구현
//예를 들어 파라미터의 인코딩 같은 작업 !

//필터를 등록하는 방법
//	- web.xml에 <filter>를 사용하여 등록 (시스템 전체에 적용되는 것이기 때문에 xml에 직접 등록하는 경우가 많음)
//	- 필터 클래스에 @WebFilter라는 어노테이션을 사용하여 등록

public class LoginFilter implements Filter {
//Member와 관련된 서블릿들이 실행될 때 로그인 유무를 확인하도록 해주는 필터
	
	//로그인 확인을 적용하지 않을 페이지의 목록을 미리 만들어둠.
	private ArrayList<String> requestUriList=new ArrayList<String>();
	
	@Override //필터 객체가 처음 생성된 후 1회만 실행 -> 보통 필터 초기화 작업 구현
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter.init() 실행");
		
		//로그인 확인을 적용하지 않을 페이지의 목록을 미리 만들어둠.
		requestUriList.add("/member/login.do");
		requestUriList.add("/member/add.do");
	
	}

	@Override //필터와 연결된 주소로 요청이 올 때마다 1번씩 반복적으로 실행
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter.doFilter() 진입");
		
		//HttpServletRequest은 ServletRequest을 상속하여 만들어진 클래스이고 HttpServletResponse은 ServletResponse을 상속하여 만들어진 클래스이다.
		//현 필터로 들어오는 request와 response는 확실하게 HttpServletRequest와 ServletRequest가 들어온다는 것을 알기 때문에(업캐스팅 발)
		//다운캐스팅이 가능하다.
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp= (HttpServletResponse) response;
		
		//현재 요청된 주소를 확인하는 메소드
		System.out.println(req.getRequestURI()); //서블릿 요청 주소 출력 : exweb/mamber/*
		System.out.println(req.getRequestURL()); //http부터 쓰여진 주소 출력
		
		String requestUri = req.getRequestURI();
		requestUri = requestUri.substring(req.getContextPath().length());
		if( !requestUriList.contains(requestUri) ) {
			HttpSession session = req.getSession();
			MemberVO vo= (MemberVO)session.getAttribute("loginUser");// 로그인한 사용자정보를 가져오기
			//getAttribute() 메소드를 이용해서 꺼낸 값의 형태는 미정이므로 컴터가 알 수 있게 강제형변환을 해줘야한다.
			
			if(vo==null) { //로그인이 되지 않았을 때 강제로 로그인 페이지로 이동시킴
				resp.sendRedirect(req.getContextPath()+"/member/login.do");
				return;
			}
		}
		
		System.out.println("LoginFilter.doFilter() 서블릿 실행 후");
		
		chain.doFilter(request, response);
	}

	@Override //필터 객체가 소멸되기 전에 1회만 실행 -> 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현
	public void destroy() {
		System.out.println("LoginFilter.destroy() 실행");
	}	
}
