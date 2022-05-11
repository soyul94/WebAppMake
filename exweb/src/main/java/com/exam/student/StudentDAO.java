package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	
	String user = "web"; 		//DB사용자 ID				  
	String password = "web1234";//DB사용자 비밀번호
	
	//초기화 블럭 : 객체 생성시 한번만 작동함. 이렇게 말고 생성자 안에 추가해서 하는 방식도 있음.
	{
		try {
		Class.forName("oracle.jdbc.OracleDriver");	
		} 
		catch (ClassNotFoundException e){ 
		e.printStackTrace();		  
		}
	}
	
	public StudentVO select(String stu_no) {
		String num;	 String name;	int score;
		StudentVO student=new StudentVO();
		String select_SQL= "select STU_NO, STU_NAME, STU_SCORE from STUDENT where STU_NO=?";
		
		try(							   													
				Connection conn = DriverManager.getConnection(url, user, password); 										
				PreparedStatement pre_state = conn.prepareStatement(select_SQL);
				
			){	
				pre_state.setString(1, stu_no);	
				ResultSet result = pre_state.executeQuery(); 		
				while (result.next()) {				
					num	= result.getString("stu_no"); 
					name	= result.getString("stu_name");
					score 	= result.getInt("stu_score"); 
					student= new StudentVO(num,name,score);
				}													
			}
			catch(SQLException e) {																   
				e.printStackTrace();	
			}		
		
		return student;
	}
	
	//DB 테이블을 담은 list를 출력		
	public  ArrayList<StudentVO> selectList() {
		String stu_no;	String name;	int score;
		StudentVO student;
		String all_select_SQL= "select STU_NO, STU_NAME, STU_SCORE from STUDENT ORDER BY STU_NO DESC";
		ArrayList<StudentVO> list= new ArrayList<StudentVO>(); 
		
		try(							   													
			Connection conn = DriverManager.getConnection(url, user, password); 										
			PreparedStatement pre_state = conn.prepareStatement(all_select_SQL);																
			ResultSet result = pre_state.executeQuery(); 
		){	
				while (result.next()) {				
					stu_no	= result.getString("stu_no"); 
					name	= result.getString("stu_name");
					score 	= result.getInt("stu_score"); 
					student= new StudentVO(stu_no,name,score);
					list.add(student);
				}				
		}
		catch(SQLException e) {																   
			e.printStackTrace();	
		}		
		return list;	
	}
	
	//입력받은 MemberVO를 DB 테이블에 삽입 
	public int insert(StudentVO student) {
		String inset_SQL= "INSERT INTO STUDENT(STU_NO, STU_NAME, STU_SCORE) "
				 +"VALUES(?, ?, ? )";
		int num;	
		try(							   
			Connection conn = DriverManager.getConnection(url, user, password);										
			PreparedStatement pre_state = conn.prepareStatement(inset_SQL);																
		){	
			pre_state.setString(1, student.getStu_no());		
			pre_state.setString(2, student.getStu_name());			
			pre_state.setInt(3, student.getStu_score());		
				
			num = pre_state.executeUpdate(); 
		}
		catch(SQLException e) {			
			num=0;
			e.printStackTrace();	
		}
		return num;
	}
	
	//입력받은 ID와 동일한 id값이 있는 행을 수정
	public int update(String stu_score,String stu_no) {
		String update_SQL= "UPDATE STUDENT SET STU_SCORE = ? WHERE STU_NO = ? ";
		int num;	
		try(							   
			Connection conn = DriverManager.getConnection(url, user, password);										
			PreparedStatement pre_state = conn.prepareStatement(update_SQL);																
		){	
			pre_state.setString(1, stu_score);
			pre_state.setString(2, stu_no);
			num = pre_state.executeUpdate(); 	
		}
		catch(SQLException e) {			
			num=0;
			e.printStackTrace();	
		}
		return num;
	}
	
	public int updateAll(StudentVO student, String up_stu_no) {
		String updateAll_SQL= "UPDATE STUDENT SET STU_NO = ?, STU_SCORE = ?, STU_NAME = ? WHERE STU_NO = ? ";
		int num;	
		try(							   
			Connection conn = DriverManager.getConnection(url, user, password);										
			PreparedStatement pre_state = conn.prepareStatement(updateAll_SQL);																
		){	
			pre_state.setString(1, student.getStu_no());
			pre_state.setInt(2, student.getStu_score());
			pre_state.setString(3, student.getStu_name());
			pre_state.setString(4, up_stu_no);
			num = pre_state.executeUpdate(); 	
		}
		catch(SQLException e) {			
			num=0;
			e.printStackTrace();	
		}
		return num;
	}

	//입력받은 ID와 동일한 id값이 있는 행을 테이블에서 삭제
	public int delete(String stu_no) {
		String delete_SQL= "delete from STUDENT where STU_NO = ?";
		int num;
		try(							   
			Connection conn = DriverManager.getConnection(url, user, password);										
			PreparedStatement pre_state = conn.prepareStatement(delete_SQL);																
		){		
			pre_state.setString(1, stu_no);		
			num = pre_state.executeUpdate(); 			
		}
		catch(SQLException e) {	
			num=0;
			e.printStackTrace();	
		}
		return num;
	}

}//class끝
