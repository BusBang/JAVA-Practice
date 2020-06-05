package kh.or.member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.or.member.model.service.MemberService;
import kh.or.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService service;
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm () {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="/join.do")
	public String joinMember(Member m) {
		int result = service.insertMember(m);
		if(result > 0) {
			System.out.println("회원 가입 성공");
		}else {
			System.out.println("회원 가입 실패");			
		}
		return "redirect:/";
	}
	@RequestMapping(value="/login.do")
	public String login(HttpSession session, Member m) {
		Member member = service.selectOne(m);
		session.setAttribute("member", member);
		return "member/mainPage";
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
