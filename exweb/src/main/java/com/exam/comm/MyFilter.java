package com.exam.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//다수의 서블릿의 실행 전후에 공통적으로 수행해야 하는 작업을 구현
//예를 들어 파라미터의 인코딩 같은 작업 !

//필터를 등록하는 방법
//	- web.xml에 <filter>를 사용하여 등록 (시스템 전체에 적용되는 것이기 때문에 xml에 직접 등록하는 경우가 많음)
//	- 필터 클래스에 @WebFilter라는 어노테이션을 사용하여 등록

public class MyFilter implements Filter {
	private String charSet;

	@Override //필터 객체가 처음 생성된 후 1회만 실행 -> 보통 필터 초기화 작업 구현
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter.init() 실행");
		charSet = filterConfig.getInitParameter("CharEncoding");
	}

	@Override //필터와 연결된 주소로 요청이 올 때마다 1번씩 반복적으로 실행
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter.doFilter() 진입");
		request.setCharacterEncoding(charSet); 	//UTF-8을 web.xml에 InitParameter로 등록 
												//이렇게 init로 등록해두면 나중에 다른 인코딩을 쓰고 싶다면 init만 변경하면 되므로 편리함.
		
		chain.doFilter(request, response); //이후 실행될 다른 필터 또는 서블릿을 실행.-> 요청의 차단과 수행을 결정할 수 있도록 해줌
	
		System.out.println("MyFilter.doFilter() 서블릿 실행 후");
	}

	@Override //필터 객체가 소멸되기 전에 1회만 실행 -> 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현
	public void destroy() {
		System.out.println("MyFilter.destroy() 실행");
	}	
}
