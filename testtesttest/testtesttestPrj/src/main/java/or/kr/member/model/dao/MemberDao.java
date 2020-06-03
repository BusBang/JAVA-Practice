package or.kr.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.kr.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public MemberDao() {
		super();
		System.out.println("memberDao 생성 완료");
	}

	public int insertMember(Member m) {
		System.out.println(m.getMemberId());
		return sqlSession.insert("member.insertMember", m);
	}

	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}

	public int updateMember(Member m) {
		return sqlSession.update("member.updateMember", m);
	}
}
