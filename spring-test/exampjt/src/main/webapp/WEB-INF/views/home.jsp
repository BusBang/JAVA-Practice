<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<a href="/listView.do">list</a>
<P>  The time on the server is ${serverTime}. </P>
<pre>
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
--
@Service
@Aspect
public class MemberPwEncAdvice {
	@Autowired
	@Qualifier("SHA256Util")
	private SHA256Util enc;
	
	//service에 메소드이름이 member로 끝나고 매개변수가 Member m인것
	@Pointcut("execution(* kr.or.iei.member.model.service.MemberService.*Member(kr.or.iei.member.model.vo.Member))")
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
--
	@CrossOrigin(origins = {"http://192.168.10.179","http://192.168.10.188","http://localhost"})
	@ResponseBody
	@RequestMapping(value="/checkId.do", produces = "text/html; charset=utf-8")
	public String checkId(Member m) {
		Member member = dao.checkId(m);
		//member null -> 사용 가능
		//member !null -> 사용 불가
		if(member == null) {
			return "0"; 			
		}else {
			return "1";
		}
	}	
	
	<script>
	$(function() {
		$("input[name=memberId]").keyup(function (){
			var memberId = $("input[name=memberId]").val();
			$.ajax({
				url : "/checkId.do",
				data : {memberId : memberId},
				type : "get",
				success : function(data) {
					if(data == '0') {
						$("#chkId").html("사용가능");
					}else {
						$("#chkId").html("사용불가능");
					}
				},
				error : function() {
					console.log("실패");
				}
			})
		});
	});
</script>
</pre>

</body>
</html>
