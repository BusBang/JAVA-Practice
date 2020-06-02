package kh.java.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		String query = "insert into member values(?,?,?,?,?,?,?,sysdate)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getHobby());
			result = pstmt.executeUpdate();
			//commit 작업이 이제 service에서 이뤄진다.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member";
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Member selectOne(Connection conn, String inputName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where member_name = ?";
		Member m = null;

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public Member SearchId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id = ?";
		Member m = null;
		try {
			
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, inputId);
		rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setGender(rset.getString("gender"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrollDate(rset.getDate("enroll_date"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);			
		}
		return m;
	}

	public int modifyMember(Connection conn, Member m, Member m2) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_pw = ?, member_name = ?, gender=?, age=?, phone=?, hobby=? where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m2.getMemberPw());
			pstmt.setString(2, m2.getMemberName());
			pstmt.setString(3, m2.getGender());
			pstmt.setInt(4, m2.getAge());
			pstmt.setString(5, m2.getPhone());
			pstmt.setString(6, m2.getHobby());
			pstmt.setString(7, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
