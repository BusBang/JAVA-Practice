package kh.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnect {

	public int modifyMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "update member set member_pw=?, phone=?, hobby=? where member_id=?";
		// ?의 위치를 위치홀더라고 함
		try {
			// 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			// preparedstatement 객체 생성
			pstmt = conn.prepareStatement(query);
			// 위치홀더에 값을 기입해 쿼리문 완성
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getHobby());
			pstmt.setString(4, m.getMemberId());
			// 쿼리 실행. query를 넣지 않는다.
			result = pstmt.executeUpdate();
			// 결과 처리
			if (result > 0) {
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

	public ArrayList<Member> searchID(String inputId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member = new Member();
		String query = "select * from member where member_id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member.setMemberId(rset.getString(1));
				member.setMemberPw(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4));
				member.setAge(rset.getInt(5));
				member.setPhone(rset.getString(6));
				member.setHobby(rset.getString(7));
				member.setEnrollDate(rset.getDate(8));
				memberList.add(member);
			} else {
				System.out.println("그런 아이디는 없습니다.");
			}
		} catch (ClassNotFoundException | SQLException e) {
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
		return memberList;
	}

	public ArrayList<Member> searchAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		String query = "select * from member order by member_id asc";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPw(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4));
				member.setAge(rset.getInt(5));
				member.setPhone(rset.getString(6));
				member.setHobby(rset.getString(7));
				member.setEnrollDate(rset.getDate(8));
				memberList.add(member);
			}
		} catch (ClassNotFoundException | SQLException e) {
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
		return memberList;
	}

	public ArrayList<Member> searchName(String inputName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		String query = "select * from member where member_name like ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%'+inputName+'%');
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPw(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setGender(rset.getString(4));
				member.setAge(rset.getInt(5));
				member.setPhone(rset.getString(6));
				member.setHobby(rset.getString(7));
				member.setEnrollDate(rset.getDate(8));
				memberList.add(member);
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
		return memberList;
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
			if(result!=0) {
				conn.commit();
			} else {
				System.out.println("존재하지 않는 이름입니다. ");
				conn.rollback();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		return result;
	}

	public int insertMember(Member inputMember) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values (?,?,?,?,?,?,?,sysdate)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputMember.getMemberId());
			pstmt.setString(2, inputMember.getMemberPw());
			pstmt.setString(3, inputMember.getMemberName());
			pstmt.setString(4, inputMember.getGender());
			pstmt.setInt(5, inputMember.getAge());
			pstmt.setString(6, inputMember.getPhone());
			pstmt.setString(7, inputMember.getHobby());
			result = pstmt.executeUpdate();
			if(result >0) {
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
