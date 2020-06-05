package kh.or.notice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.or.notice.model.service.NoticeService;
import kh.or.notice.model.vo.Notice;
import kh.or.notice.model.vo.NoticeData;

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private NoticeService service;
	
	@RequestMapping(value = "/noticeList.do")
	public String noticeList(Model model, int reqPage) {
		NoticeData nd = service.selectAllNotice(reqPage);
		model.addAttribute("list", nd.getNotice());
		model.addAttribute("pageNavi", nd.getPageNavi());
		return "notice/noticeList";
	}
	@RequestMapping(value = "/noticeWriteFrm.do")
	public String noticeWriteFrm () {
		return "notice/noticeWriteFrm";
	}
	@RequestMapping(value = "/noticeWrite.do")
	public String noticeWrite (Notice n) {
		int result = service.insertNotice(n);
		if(result >0) {
			System.out.println("작성완료");
		}else {
			System.out.println("작성실패");
		}
		return "redirect:/noticeList.do?reqPage=1";
	}
	@RequestMapping(value = "/noticeDetail.do")
	public String noticeDatail(Notice n, Model model) {
		Notice notice = service.selectOne(n);
		model.addAttribute("notice", notice);
		return "notice/noticeDetail";
	}
}
