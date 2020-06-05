package kh.or.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.or.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember",m);
	}

	public Member selectOne(Member m) {
		return sqlSession.selectOne("member.selectOne", m);
	}
	
}
