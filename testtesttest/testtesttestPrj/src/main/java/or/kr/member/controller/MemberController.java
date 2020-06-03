package or.kr.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import or.kr.member.model.service.MemberService;
import or.kr.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberService")
	private MemberService service;
		
	public MemberController() {
		super();
		System.out.println("MemberController 생성완료");
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	
	@RequestMapping(value="/join.do")
	public String join(Member m, Model model) {
		int result = service.insertMember(m);
		if(result>0) {
			System.out.println("가입성공");
		}else {
			System.out.println("가입실패");
		}
		model.addAttribute("result", result);
		return "member/joinResult";
	}
	@RequestMapping(value="/goToMain.do")
	public String goToMain() {
		return "redirect:/";
	}
	@RequestMapping(value="/login.do")
	public String login(HttpSession session, Member m) {
		Member member = service.selectOneMember(m);
		if(member != null) {
			session.setAttribute("member", member);			
		}
		return "member/loginResult";
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}z
	@RequestMapping(value="/myPage.do")
	public String myPage() {
		return "member/myPage";
	}
	@RequestMapping(value="/updateMember.do")
	public String updateMember(Member m, HttpSession session) {
		int result = service.updateMember(m);
		if(result>0) {
			System.out.println("수정 성공");
			m.setMemberPw("");
			Member member = service.selectOneMember(m);
			session.setAttribute("member", member);
		}else {
			System.out.println("수정 실패");
		}
		return "redirect:/";
	}
	
}
