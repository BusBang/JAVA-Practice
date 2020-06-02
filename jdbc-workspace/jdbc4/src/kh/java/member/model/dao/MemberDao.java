package kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.java.member.common.JDBCTemplate;
import kh.java.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into member values (?,?,?,?,?,?,?,sysdate)";

		try {
			// Statement 생성
			pstmt = conn.prepareStatement(query);
			// 위치홀더 값 대체
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getHobby());
			// 쿼리문 전송 및 결과 받기
			result = pstmt.executeUpdate();
			// 결과 처리
//			if (result > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> printAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member order by member_id";
		ArrayList<Member> mList = new ArrayList<Member>();

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}

	public boolean dupliId(Connection conn,String dupliId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean cc = true;

		String query = "select * from member where member_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dupliId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				cc = false; // 중복임.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return cc;
	}

	public ArrayList<Member> searchId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_id = ?";
		ArrayList<Member> mList = new ArrayList<Member>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}

	public ArrayList<Member> searchName(Connection conn, String inputName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Member> mList = new ArrayList<Member>();
		String query = "select * from member where member_name like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%' + inputName + '%');
			rset = pstmt.executeQuery();
			if (rset != null) {
				while (rset.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}

	public int deleteMember(Connection conn, String inputId) {
//		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;

		int result = 0;
		String query = "delete from member where member_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			result = pstmt.executeUpdate();
//			커밋과 롤백은 트랜잭션이 끝나는 시점에서 진행되어야 한다.
//			if (result > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int modifyMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = "update member set member_pw = ?, phone=?, hobby=? where member_id = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getHobby());
			pstmt.setString(4, member.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertDelMember(Connection conn, String inputId) {
//		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;

		String query = "insert into del_member values (del_seq.nextval, ?, sysdate)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			result = pstmt.executeUpdate();
//			if(result > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			JDBCTemplate.close(pstmt);
//			JDBCTemplate.close(conn);
//		}
		return result;
	}
}
