package kr.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	public MemberDao () {
		super();
		System.out.println("dao 생성확인");
	}
	public int insertMember(Member m) {
		return sqlSession.insert("member.insertMember", m);
	}

	public ArrayList<Member> select() {
		List list = sqlSession.selectList("member.listMember");
		return (ArrayList<Member>)list;
	}
}
