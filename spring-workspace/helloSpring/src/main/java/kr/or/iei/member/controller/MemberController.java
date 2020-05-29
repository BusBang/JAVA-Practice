package kr.or.iei.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.iei.member.model.vo.Member;

@Controller
public class MemberController {
	@RequestMapping(value="/login.do")
	public String loginMember(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		System.out.println(memberId);
		System.out.println(memberPw);
		return null;
	}
	public MemberController() {
		super();
		System.out.println("MemberController 생성 완료");
	}
}
