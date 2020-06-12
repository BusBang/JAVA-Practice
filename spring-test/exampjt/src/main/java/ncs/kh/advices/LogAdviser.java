package ncs.kh.advices;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.Signature;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdviser {

	@Pointcut("execution(* ncs.kh.dao.MembersDAO.*(..))")
	public void printLog() {
		System.out.println("asdfasdf");
	}
	@Before("printLog()")

	public void before(JoinPoint jp) {
		System.out.println("asdfsadf");
		Signature p = jp.getSignature();
		String methodName = p.getName();
		System.out.println(methodName);

	}

}
