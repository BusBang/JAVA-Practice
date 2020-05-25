package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(SqlSession session, Member m) {
		return session.selectOne("member.selectOneMember", m);
	}

	public int insertMember(SqlSession session, Member m) {
		
		return session.insert("member.insertMember", m);
	}

}
