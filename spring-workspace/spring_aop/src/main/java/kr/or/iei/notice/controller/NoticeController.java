package kr.or.iei.notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeData;

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private NoticeService service;	
	
	@RequestMapping(value="/noticeWriteFrm.do")
	public String noticeWriteFrm(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		model.addAttribute("m", m);
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
	public String noticeUpdate(HttpServletRequest request, MultipartFile file, Notice n, String status, String oldFilename, String oldFilepath) {

		//파일 등록 됐을 때.
		System.out.println("파일이 없습니다.");
		System.out.println("status:"+status);
		if(n.getFilename() == null) {
			if(status.equals("stay")) {
				//파일이 등록되었고 파일이 그대로 있을 때.
				n.setFilename(oldFilename);
				n.setFilepath(oldFilepath);
			}			
		}
		int result = service.noticeUpdate(n);
		if(result>0) {
			System.out.println("수정완료");
			if(status.equals("delete")) {
				//파일이 없는데, 삭제 되었을 때
			}
		}else {
			System.out.println("수정실패");
		}
		
		
		System.out.println(n.getNoticeTitle());
		System.out.println(n.getNoticeWriter());
		System.out.println(n.getNoticeContent());		
		System.out.println(n.getFilename());
		System.out.println(n.getFilepath());
		System.out.println("status:"+status);
		System.out.println("파일이 있습니다.");
		
		return "redirect:/noticeDetail.do?noticeNo="+n.getNoticeNo();
	}
	@RequestMapping(value="/noticeFileDownload.do")
	public void noticeFileDownload(HttpServletResponse response, HttpServletRequest request, String filename, String filepath) {
		System.out.println(filename);
		System.out.println(filepath);
		String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/notice/"); 
		String fullFile = savePath + filepath;
		System.out.println(fullFile);
		
		try {
			FileInputStream fis = new FileInputStream(fullFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ServletOutputStream sos = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
			
			String resFilename="";
			//브라우저가 IE인지 확인
			boolean bool
			= request.getHeader("user-agent").indexOf("MSIE")!=-1 || request.getHeader("user-agent").indexOf("Trident")!=-1;
			System.out.println(request.getHeader("user-agent"));
			System.out.println("IE여부 : "+bool);
			if(bool) { //IE 경우
				resFilename = URLEncoder.encode(filename, "UTF-8");
				resFilename = resFilename.replaceAll("\\\\", "%20");
			} else {
				resFilename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
			}
			
			//파일 다운로드를 위한 HTTP Header 설정
			response.setContentType("application/octet-stream"); //실제 다운로드 명시
			response.setHeader("Content-Disposition", "attachment;filename="+resFilename); //파일명 설정
			
			//읽어올 데이터가 없을 때 까지 반복
			int read = -1;
			while((read = bis.read())!=-1) {
				bos.write(read);
			}
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
