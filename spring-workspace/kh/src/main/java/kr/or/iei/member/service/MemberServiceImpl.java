package kr.or.iei.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.iei.member.dao.MemberDaoImpl;
import kr.or.iei.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl {
	@Autowired
	@Qualifier("memberDao")
	private MemberDaoImpl dao;
	
	public MemberVO selectOneMEmber(MemberVO member) {
		return dao.selectOneMember(member);
	}
}
