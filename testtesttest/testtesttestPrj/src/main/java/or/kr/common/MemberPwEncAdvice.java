package or.kr.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import or.kr.member.model.vo.Member;

@Service
@Aspect
public class MemberPwEncAdvice {
	@Autowired
	@Qualifier("SHA256Util")
	private SHA256Util enc;
	
	//service에 메소드이름이 member로 끝나고 매개변수가 Member m인것
	@Pointcut("execution(* or.kr.member.model.service.MemberService.*Member(or.kr.member.model.vo.Member))")
	public void encPwPointcut() {
	}
	
	@Before("encPwPointcut()")
	public void passwordEnc(JoinPoint jp) throws Exception{
		String methodName = jp.getSignature().getName();
		System.out.println("PwEncAdivce 적용 메소드 이름 : "+methodName);
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		if(m.getMemberPw() != null) {
			String encPw = enc.encData(m.getMemberPw());
			m.setMemberPw(encPw);
		}
	}
	
}
