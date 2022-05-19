package com.exam.student;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.exam.member.MemberVO;

public class StudentDaoMybatis implements StudentDAO {
	
	SqlSessionFactory sqlSessionFactory=null;
	
	public StudentDaoMybatis() {
		try {
			String resource = "/mybatis/mybatis-config.xml";
			InputStream inputStream= Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public StudentVO select(String stu_no) {
		StudentVO vo=null;
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
			  vo = sqlSession.selectOne("com.exam.student.StudentDAO.selectStudent",stu_no);
		}
		return vo;
	}
	
	//DB 테이블을 담은 list를 출력
	@Override
	public List<StudentVO> selectList(){
		List<StudentVO> list= null;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
			  list = sqlSession.selectList("com.exam.student.StudentDAO.selectStudentList"); 
			}				
					
		return list;	
	}
	
	//입력받은 StudentVO를 DB 테이블에 삽입
	@Override
	public int insert(StudentVO student) {
		int result=0;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
			  result = sqlSession.insert("com.exam.student.StudentDAO.insertStudent",student);
			  sqlSession.commit();  
			}					
		return result;
		
	}
	
	//입력받은 ID와 동일한 id값이 있는 행을 수정
	@Override
	public int update(StudentVO student) {
		int result=0;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
			  result = sqlSession.update("com.exam.student.StudentDAO.updateStudent",student);
			  sqlSession.commit();  
			}					
		return result;
		
	}

	//입력받은 ID와 동일한 id값이 있는 행을 테이블에서 삭제
	@Override
	public int delete(String stu_no) {
		int result=0;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
			  result = sqlSession.delete("com.exam.student.StudentDAO.deleteStudent",stu_no);
			  sqlSession.commit();  
			}
		return result;
	}

}//class끝
