package kr.or.iei.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kr.or.iei.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
		
	public MemberDao() {
		super();
		System.out.println("memberDao 생성 완료");
	}

	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}
	
	public int insertMember(Member m) {
		return sqlSession.update("member.insertMember", m);
	}

	public int updateMember(Member m) {
		return sqlSession.update("member.mUpdate",m);
	}

	public int deleteMember(Member m) {
		return sqlSession.delete("member.deleteMember", m);
	}

	public Member checkId(Member m) {
		return sqlSession.selectOne("member.selectOneMember", m);
	}

	public List selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}
	
}
