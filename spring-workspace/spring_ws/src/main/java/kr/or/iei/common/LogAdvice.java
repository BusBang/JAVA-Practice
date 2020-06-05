package kr.or.iei.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import kr.or.iei.member.model.vo.Member;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* kr.or.iei..*Service.*(kr.or.iei.member.model.vo.Member))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {	//이친구는 무조건 ProceedingJoinPoint를 써야한다.
		String methodName = pjp.getSignature().getName();
		//StopWatch 객체 생성
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();	//stopwatch 시작
		
		//proceed() : 실제 비즈니스 메소드를 수행하고, 리턴 값을 obj에 저장할 것.
		Object obj = pjp.proceed();	
		stopWatch.stop();	//stopwatch 정지
		System.out.println(methodName+"메소드 수행 시간 : "+stopWatch.getTotalTimeMillis()+"(ms)초");
		return obj;
	}
	
	//오류 발생
//	@AfterThrowing(pointcut = "allPointcut()", throwing = "exceptObj")
//	public void afterThrowingAdvice(JoinPoint jp, Exception exceptObj) {
//		String methodName = jp.getSignature().getName();
//		System.out.println(methodName+"메소드 호출");
//		System.out.println("예외메세지 : "+exceptObj);
//	}
	
	//비즈니스 로직이 끝난 후 적용
//	@AfterReturning(pointcut = "allPointcut()", returning = "returnObj")
//	public void afterReturningAdvice(JoinPoint jp, Object returnObj) {
//		String methodName = jp.getSignature().getName();
//		System.out.println(methodName+" 메소드 오출");
//		if(returnObj instanceof Member) {
//			Member m = (Member)returnObj;
//			System.out.println("["+m.getMemberName()+"] 님이 로그인하였습니다. ");
//		}
//	}
	
	//비즈니스 로직 전 수행
//	@Before("allPointcut()")
//	public void printLog(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//		Member m = (Member)args[0];	//PointCut에서 Member타입만 정의했기 때문에 모든 것이 Member로 나온다.
//		System.out.println("메소드 명 : "+methodName);
//		System.out.println("매개 변수 : "+m);
//		System.out.println("아이디 : "+m.getMemberId());
//	}
}
