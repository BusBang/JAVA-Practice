package kr.or.iei.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

//Scan과 Task Annotation을 선언해 준다
@Component
public class ScheduledTest {
	
	@Autowired
	private MemberService service;
	
	@Scheduled(cron="10 * * * * *")
	public void scheduleTest2() {
		System.out.println("cron='10 * * * * *' : 매 분 10초마다 동작 !!!");
		Member m = new Member();
		m.setMemberId("0816");
		m.setMemberPw("0816");
		Member member = service.selectOneMember(m);
		System.out.println("memberName : "+member.getMemberName());
	}
	
	@Scheduled(fixedDelay = 5000)
	public void scheduleTest3() {
		System.out.println("fixedDelay : 5초마다 동작");
	}
}
