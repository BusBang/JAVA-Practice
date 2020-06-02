package kh.java.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.java.member.model.dao.MemberDao;
import kh.java.member.vo.Member;

public class MemberService {

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.insertMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		ArrayList<Member> list = dao.selectAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Member selectOne(String inputName) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.selectOne(conn, inputName);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member SearchId(String inputId) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		Member m = dao.SearchId(conn, inputId);
		JDBCTemplate.close(conn);
		return m;
	}

	public int modifyMember(Member m, Member m2) {
		Connection conn = JDBCTemplate.getConnection();
		MemberDao dao = new MemberDao();
		int result = dao.modifyMember(conn, m, m2);
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
