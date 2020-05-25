package member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member selectOneMember(Member m) {
		//커넥션 대신 세션을 쓰게 된다.
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = new MemberDao().selectOneMember(session, m);
		session.close();
		return member;
	}

	public int insertmember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().insertMember(session, m);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
