package kh.java.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBConnect {
	
	public Member idSearch(String memberId) {
		Connection conn = null;
		Statement stmt =  null;
		ResultSet rset = null;
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		Member member = null; // Member 클래스에서 가져옴
		
		String query = "select * from member where member_id ='"+memberId+"'";
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//3. statement 객체 생성
			stmt = conn.createStatement();
			//4. 쿼리문 결과 받기
			rset = stmt.executeQuery(query);
			//5. 결과 처리
			if(rset.next()) { //memberid는 결과값이 1개이기 때문에 while을 쓰지 않아도 됨
				member = new Member();
				
				String id = rset.getString("member_id");
				member.setMemberId(id);
				String pw = rset.getString("member_pw");
				member.setMemberPw(pw);
				String name = rset.getString("member_name");
				member.setMemberName(name);
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setPhone(rset.getString("phone"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrollDate(rset.getDate("enroll_Date"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//6. 자워납ㄴ환
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return member;
	}

	public ArrayList<Member> nameSearch(String memberName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_name = '"+memberName+"'";
		//글자의 일부를 포함한 사람들을 출력하고 싶으면 like '%'를 쓴다.
//		String query = "select * from member where member_name like '%"memberName+"%'";
		
		ArrayList<Member> memberList = new ArrayList<Member>();
//		memberList = null;
		Member member = null;
		//1.드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//스테이트 먼트 객체 생성
			stmt = conn.createStatement();
			//쿼리문 받기
			rset = stmt.executeQuery(query);
			//결과처리
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setHobby(rset.getString("hobby"));
				member.setPhone(rset.getString("phone"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				memberList.add(member);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return memberList;
	}

	public int insertMember(Member memberInput) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query 
		= "insert into member values('"+memberInput.getMemberId()+"','"
				+memberInput.getMemberPw()+"','"+memberInput.getMemberName()+"','"
				+memberInput.getGender()+"',"+memberInput.getAge()+",'"
				+memberInput.getPhone()+"','"+memberInput.getHobby()+"',sysdate)";
		
		//INSERT INTO MEMBER VALUES ('아이디','비밀번호','이름','성별',나이,'전화번호','취미',SYSDATE);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;	//받은 값이 0이면 비정상 처리, 0이 아니면 정상처리
	}

	public ArrayList<Member> allSearch() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from member";
		ArrayList<Member> allMember = new ArrayList<Member>();
		Member member = new Member();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setAge(rset.getInt("age"));
				member.setGender(rset.getString("gender"));
				member.setHobby(rset.getString("hobby"));
				member.setPhone(rset.getString("phone"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				allMember.add(member);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMember;
	}

	public int modifyMember(String inputId, String newPw, String newPhone, String newHobby) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = 
				"update member "
				+ "set member_pw = '"+newPw+"', phone ='"+newPhone+"', hobby='"+newHobby+"' "
						+ "where member_id ='"+inputId+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);	
			if(result >0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String inputId) {
		Connection conn = null;
		Statement stmt = null;
		int result =  0;
		String query = "delete from member where member_id = '"+inputId+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc", "1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0 ) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				}
		}		
		return result;
	}
}
