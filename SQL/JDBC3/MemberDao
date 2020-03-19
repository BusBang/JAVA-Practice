package kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.java.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values (?,?,?,?,?,?,?,sysdate)";
		try {
			//드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//Statement 생성
			pstmt = conn.prepareStatement(query);
			//위치홀더 값 대체
			pstmt.setString(1,m.getMemberId());
			pstmt.setString(2,m.getMemberPw());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4,m.getGender());
			pstmt.setInt(5,m.getAge());
			pstmt.setString(6,m.getPhone());
			pstmt.setString(7,m.getHobby());
			//쿼리문 전송 및 결과 받기
			result = pstmt.executeUpdate();
			//결과 처리
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Member> printAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member order by member_id";
		ArrayList <Member> mList = new ArrayList<Member>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString(1));
				m.setMemberPw(rset.getString(2));
				m.setMemberName(rset.getString(3));
				m.setGender(rset.getString(4));
				m.setAge(rset.getInt(5));
				m.setPhone(rset.getString(6));
				m.setHobby(rset.getString(7));
				m.setEnrollDate(rset.getDate(8));
				mList.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;	
	}

	public boolean dupliId(String dupliId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean cc = true;
		
		String query = "select * from member where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dupliId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				cc = false; //중복임.
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return cc;
	}

	public ArrayList<Member> searchId(String inputId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_id = ?";
		ArrayList <Member> mList = new ArrayList<Member>();	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString(1));
				m.setMemberPw(rset.getString(2));
				m.setMemberName(rset.getString(3));
				m.setGender(rset.getString(4));
				m.setAge(rset.getInt(5));
				m.setPhone(rset.getString(6));
				m.setHobby(rset.getString(7));
				m.setEnrollDate(rset.getDate(8));
				mList.add(m);
			}			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mList;
	}

	public ArrayList<Member> searchName(String inputName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> mList = new ArrayList<Member>();
		String query = "select * from member where member_name like ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%'+inputName+'%');
			rset = pstmt.executeQuery();
			if(rset != null) {
				while(rset.next()) {
					Member m = new Member();
					m.setMemberId(rset.getString(1));
					m.setMemberPw(rset.getString(2));
					m.setMemberName(rset.getString(3));
					m.setGender(rset.getString(4));
					m.setAge(rset.getInt(5));
					m.setPhone(rset.getString(6));
					m.setHobby(rset.getString(7));
					m.setEnrollDate(rset.getDate(8));
					mList.add(m);				
				}				
			}			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
		return mList;
	}

	public int deleteMember(String inputId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "delete from member where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int modifyMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = "update member set member_pw = ?, phone=?, hobby=? where member_id = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getHobby());
			pstmt.setString(4, member.getMemberId());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
