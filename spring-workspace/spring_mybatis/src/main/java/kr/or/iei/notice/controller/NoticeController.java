package kr.or.iei.notice.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeData;

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private NoticeService service;	
	
	@RequestMapping(value="/noticeWriteFrm.do")
	public String noticeWriteFrm() {
		return "notice/noticeFrm";
	}
	
	
	
	@RequestMapping(value="/noticeWrite.do")
	public String noticeWrite(HttpServletRequest request, MultipartFile file, Notice n) {
		if(!file.isEmpty()) {
			System.out.println(n.getNoticeTitle());
			System.out.println(n.getNoticeWriter());
			System.out.println(n.getNoticeContent());
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/notice/");
			//업로드한 파일의 실제 파일명
			String originalFilename = file.getOriginalFilename();
			//확장자를제외한파일명
			String onlyFilename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
			//확장자 -> .txt
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String filepath = onlyFilename+"_"+getCurrentTime()+extension;
			String fullpath = savePath + filepath;
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fullpath)));
				bos.write(bytes);
				bos.close();
				n.setFilename(originalFilename);
				n.setFilepath(filepath);
				
				System.out.println("파일 업로드 완료");				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		}
		int result = service.insertNotice(n);
		if(result > 0) {
			System.out.println("게시글 등록 완료");
		}else {
			System.out.println("게시글 등록 실패");
		}
		return "redirect:/";
	}
	
	public long getCurrentTime() {
		Calendar today = Calendar.getInstance();
		/*
		 * Date today = new Date(); String currentTime =
		 * today.getYear()+""+today.getMonth()+""+today.getDay()+""+today.getHours()+""+
		 * today.getMinutes()+""+today.getSeconds();
		 */
		return today.getTimeInMillis();
	}
	
	
	@RequestMapping(value="/noticeList.do")
	public String noticeList(Model model, int reqPage) {		
		NoticeData nd = service.selectNoticePage(reqPage);
		model.addAttribute("list", nd.getNotice());
		model.addAttribute("pageNavi", nd.getPageNavi());
		return "notice/noticeAllPage";
	}
	
	@RequestMapping(value="/noticeDetail.do")
	public String noticeDetail(Model model, int noticeNo) {
		Notice n = service.selectOneNotice(noticeNo);
		model.addAttribute("n", n);
		return "notice/noticeDetail";
	}
	
	@RequestMapping(value="/noticeDelete.do")
	public String noticeDelete(int noticeNo) {
		int result = service.noticeDelete(noticeNo);
		if(result > 0) {
			System.out.println("삭제 성공");
			return "redirect:/noticeList.do?reqPage=1";
		}else {
			System.out.println("삭제 실패");
			return "redirect:/noticeDetail.do?noticeNo="+noticeNo;
		}
	}
	@RequestMapping(value="/noticeUpdateFrm.do")
	public String noticeUpdateFrm(int noticeNo, Model model) {
		Notice n = service.selectOneNotice(noticeNo);
		model.addAttribute("n", n);
		return "notice/noticeUpdateFrm";
	}
	@RequestMapping(value="/noticeUpdate.do")
	public String noticeUpdate(Notice n) {
		int result = service.noticeUpdate(n);
		if(result>0) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
		return "redirect:/noticeList.do?reqPage=1";
	}
	
}
