package or.kr.member.model.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import or.kr.member.model.dao.MemberDao;
import or.kr.member.model.vo.Member;

@Service("memberService")
public class MemberService {
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;
	
	public MemberService() {
		super();
		System.out.println("memberSerivce생성완료");
	}

	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	public Member selectOneMember(Member m) {
		return dao.selectOneMember(m);
	}

	public int updateMember(Member m) {
		return dao.updateMember(m);
	}

	public int deleteMember(String memberId) {
		return dao.deleteMember(memberId);
	}
}
