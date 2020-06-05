package kr.or.iei.notice.model.vo;

import java.util.ArrayList;

public class NoticeData {
	ArrayList<Notice> Notice;
	private String pageNavi;
	
	public ArrayList<Notice> getNotice() {
		return Notice;
	}
	public NoticeData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeData(ArrayList<kr.or.iei.notice.model.vo.Notice> notice, String pageNavi) {
		super();
		Notice = notice;
		this.pageNavi = pageNavi;
	}
	public void setNotice(ArrayList<Notice> notice) {
		Notice = notice;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
