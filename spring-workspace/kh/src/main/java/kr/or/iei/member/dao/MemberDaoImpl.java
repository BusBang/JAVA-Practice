package kr.or.iei.member.dao;

import org.springframework.stereotype.Repository;

import kr.or.iei.member.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{
	
	public MemberVO selectOneMember(MemberVO member) {
		if(member.getId().equals("user01") && member.getPw().equals("1234")) {
			return member;
		}else {
			return null;
		}
	}
}
