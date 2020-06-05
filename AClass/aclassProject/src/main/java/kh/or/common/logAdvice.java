package kh.or.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import kh.or.notice.model.vo.Notice;

@Service
@Aspect
public class logAdvice {
	
	@Pointcut("execution(* kh.or.notice.model.service.NoticeService.selectOne(..))")
	public void allPointcut() {		
		System.out.println("생성됐다");
	}
	@Before("allPointcut()")
	public void dddd () {
		System.out.println("asdfasdf");
	}
	@AfterReturning(pointcut= "allPointcut()", returning = "returnObj")
	public void noticeContentUpdate(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("메소드 이름 : "+methodName);
		Object obj = returnObj;
		System.out.println(obj);
		Notice notice = (Notice)obj;
		System.out.println(notice);
		System.out.println(notice.getNoticeContent());
		String noticeContent = notice.getNoticeContent();
		String noticeContentUpdate = noticeContent.replaceAll("\r\n", "<br>");
		System.out.println(noticeContentUpdate);
		notice.setNoticeContent(noticeContentUpdate);
	}
}
