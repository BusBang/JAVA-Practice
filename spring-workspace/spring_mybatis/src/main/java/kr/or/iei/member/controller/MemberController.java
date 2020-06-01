package kr.or.iei.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

@Controller
public class MemberController {
	
	//만들어진 memberService를 private service로 만든다. 객체를 계속 생성하지 않고 만들고 고대로 쓴다ㅡ
	@Autowired
	@Qualifier("memberService")
	private MemberService service;

	public MemberController() {
		super();
		System.out.println("MemberController 생성 완료");
	}
	/*
	@ResponseBody
	@RequestMapping(value="/selectAllMember.do", produces = "application/json; charset=utf-8")
	public String selectAllMember() {
		ArrayList<Member> memberList = service.selectAllMember();
		return new Gson().toJson(memberList);
	}
	
	@RequestMapping(value="/allMember.do")
	public String allMember() {
		return "member/allMember";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkId.do", produces = "text/html; charset=utf-8")
	public String checkId(String memberId) {
		Member member = service.checkId(memberId);
		//member null -> 사용 가능
		//member !null -> 사용 불가
		if(member == null) {
			return "0"; 			
		}else {
			return "1";
		}
	}
	*/
	@RequestMapping(value="/login.do")
	public String loginMember(HttpSession session, Member m) {
		
		//비즈니스 로직 호출 -- 계속해서 호출하던 것을 DI방식으로 한다
//		Member member = new MemberService().selectOneMember(m);
		Member member = service.selectOneMember(m);
		
		if(member != null) {
			session.setAttribute("member", member);
			return "member/loginSuccess";			
		}else {
			return "member/loginFailed";
		}
	}
	/*	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/join";
	}
	
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result > 0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFailed";
		}
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="mypage.do")
	public String mypage(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		model.addAttribute("m",m);
		return "member/mypage";
	}
	@RequestMapping(value="mUpdate.do")
	public String mUpdate(HttpSession session, Member m, Model model) {
		int result = service.updateMember(m);
		if(result >0) {
			Member member = service.selectOneMember(m);
			session.setAttribute("member", member);
			model.addAttribute("m", member);
			System.out.println("정보수정성공");
			return "member/mypage";
		}else {
			System.out.println("정보수정실패");
			return "redirect:/";
		}
	}
	@RequestMapping(value="mDelete.do")
	public String mDelete(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		int result = service.deleteMember(m);
		if(result > 0) {
			session.invalidate();
			System.out.println("탈퇴성공");
			return "redirect:/";
		}else {
			System.out.println("탈퇴실패");
			model.addAttribute("m",m);
			return "member/mypage";			
		}
	}
	*/
}
