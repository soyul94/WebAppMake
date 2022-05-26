package com.exam.comm;
//모든 테이블에 공통으로 쓰여야하기 때문에 comm패키지에 생성

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil { //테이블별 mapper마다 다른 SqlSessionFactory을 사용할 필요가 없게해줌

	private static SqlSessionFactory sqlSessionFactory=null;
	// MybatisUtill이 웹프로그램 하나당 한번만 실행되어 하나를 공용으로 쓰게 하기 위해 static선언해줌 
	
	static {//초기화 블럭. MyBatisUtil가 생성될 때 한번만 실행되게 하기 위해 이거도 static선언 
		//파일이 없으면 에러가 나기 때문에 try-catch해줘야함
		try {
			String resource = "/mybatis/mybatis-config.xml"; //마이바티스 설정파일 위치 (귀찮으니 클래스패스 최상위에 만들기).
			InputStream inputStream = Resources.getResourceAsStream(resource); //마이바티스 설정파일을 읽을 수 있는 입력스트림
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//마이바티스 설정 파일의 내용대로 마이바티스 본체(SqlSessionFactory)를 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
