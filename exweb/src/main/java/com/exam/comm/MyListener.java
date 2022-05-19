package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;

//(이벤트)Listener : 웹 애플리케이션에 특정 사건(이벤트)이 발생했을 때 자동으로 실행되는 메소드를 포함한 클래스
//리스너가 감지하는 사건 : 

//리스너를 등록하는 방법 : 
//- web.xml에 <listener>를 사용하여 등록 (시스템 전체에 적용되는 것이기 때문에 xml에 직접 등록하는 경우가 많음)
//- 리스너 클래스에 @WebListener라는 어노테이션을 사용하여 등록

//리스너의 종류 : 
// ServletContextListener, ServletContextAttributeListener,
// SessionListener, SessionAttributeListener,
// RequestListener, RequestAttributeListener,  기타 등등

//XxxxAttributeListener은 setAttribute 되는 것을 감지해서 실행

public class MyListener implements ServletContextListener{
						//ServletContextListener : ServletContext 객체의 생성과 소멸 시에 자동실행. 
						// 						   웹 애플리케이션이 처음 실행될 때와 종료될 때 자동 실행 
	
	//웹 애플리케이션이 처음 시작될 때 실행
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener.contextInitialized() 실행");
	// jdbc의 드라이버는 웹애플리케이션 전체를 통들어서 한번이면 충분하기 때문에 listener로 하면 여러 DAO가 있어도 1회만 실행
		ServletContext sc = sce.getServletContext();
		String jdbcDriver = sc.getInitParameter("jdbcDriver");
		try {
			Class.forName(jdbcDriver);	//web.xml에 드라이버 이름 등록
		} 
		catch (ClassNotFoundException e){ 
			e.printStackTrace();		  
		}		
	}
	
	//웹 애플리케이션이 종료될 때 실행
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener.contextDestroyed() 실행");
		
	}

}
