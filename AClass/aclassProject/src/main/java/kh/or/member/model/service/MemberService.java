package kh.or.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kh.or.member.model.dao.MemberDao;
import kh.or.member.model.vo.Member;

@Service("memberService")
public class MemberService {
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;

	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	public Member selectOne(Member m) {
		return dao.selectOne(m);
	}
	
	
}
