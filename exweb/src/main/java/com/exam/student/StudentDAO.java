package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

interface StudentDAO {
	
	public StudentVO select(String stu_no);
	
	//DB 테이블을 담은 list를 출력		
	public  List<StudentVO> selectList();
	
	//입력받은 StudentVO를 DB 테이블에 삽입 
	public int insert(StudentVO student) ;
	
	//입력받은 ID와 동일한 id값이 있는 행을 수정
	public int update(StudentVO student) ;

	//입력받은 ID와 동일한 id값이 있는 행을 테이블에서 삭제
	public int delete(String stu_no) ;

}//class끝
