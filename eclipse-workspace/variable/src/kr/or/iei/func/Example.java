package kr.or.iei.func;
import java.util.Scanner;
public class Example {
	public void exam1() {
		int num1;
		num1 = 100;
		char ch1 = '1';
		long lNum = 10000L;
		float fNum = 3.14f;
		final double PI = 3.14;
		System.out.println(num1);
		System.out.println("정수 출력 : "+(num1+num1));
		System.out.println("문자 출력 : "+(ch1+ch1));
		System.out.println("long 출력"+lNum);
		System.out.println("float 출력"+fNum);
		System.out.println(PI);
		num1 =200;
		System.out.println(num1);
		System.out.println("정수 출력 : "+(num1+num1));
//		/* ctrl + /
//		상수는 바꿀 수 없어 오류가 발생한다
//		PI = 2.24;
//		System.out.println(PI);
//		*/		
	}
	
	public void exam2() {
		//변수 4개 생성
		//이름저장할 변수 -> String
		String name = "방찬호";
		//나이 -> int
		int age = 27;
		//주소 -> String
		String address = "영등포구 양평동";
		//성별(남/녀) -> char
		char sex = '남';	
		//각 변수 선언 후 본인 정보 입력 후 출력
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println("주소 :"+address);
		System.out.println("성별 :"+sex);
	}
	
	public void testMethod() {
		int num = 2147483647;
		int result = num + 1;
		System.out.println(result);
	}
	
	public void testMethod2() {
		int num = 2147483647;
		long result = (long)num + 1;
		System.out.println(result);
	}
	
	
	public void exam4() {
		int num=10;
		System.out.println("정수형 변수 num안에 들어있는 값은 "+num+"입니다.");
		System.out.printf("정수형 변수 num안에 들어있는 값은 %d입니다.\n",num);
	}
	
	public void exam5() {
		int num1=10;
		int num2=20;
		//System.out.println과 System.out.printf로
		//10+20=30 입니다. 출력
		System.out.println(num1+"+"+num2+"="+(num1+num2)+"입니다.");
		System.out.printf("%d+%d=%d입니다.\n", num1,num2,num1+num2);
		
		double d =1.126123123123;
		System.out.println(d);
		System.out.printf("%.2f",d);
		//소수점 2번째 자리까지 표기 (반올림)
		
	}
	//따옴표와 나누기를 어떻게 쓸 수 있을까? --> 이스케이프 문자를 활용해서 	
	
	public void testMethod3() {
		int one = 100;
		long two = 999900000000L;
		float three = 486.520f;
		double four = 5697.890123;
		char five = 'A';
		String six = "Hello JAVA";
		boolean seven = true;
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(seven);	
	}
	
	public void testMethod4() {
		String nameHead = "이름";
		String ageHead = "나이";
		String genderHead = "성별";
		String addressHead = "주소";
		String numberHead = "전화번호";
		String emailHead = "이메일";
		
		String name1 = "방찬호";
		int age1 = 27;
		char gender1 = '남';
		String address1 = "서울시";
		String number1 = "010-2522-8575";
		String email1 = "bang8255@naver.com";
		
		String name2 = "김태훈";
		int age2 = 26;
		char gender2 = '남';
		String address2 = "시흥시";
		String number2 = "010-9901-8058";
		String email2 = "dighfkql@naver.com";
		
		String name3 = "박서현";
		int age3 = 25;
		char gender3 = '여';
		String address3 = "서울시";
		String number3 = "010-5063-****";
		String email3 = "pspp2@naver.com";
		
		System.out.printf("%s\t%s\t%s\t%s\t%s\t\t%s\n",nameHead,ageHead,genderHead,addressHead,numberHead,emailHead);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name1,age1,gender1,address1,number1,email1);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name2,age2,gender2,address2,number2,email2);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name3,age3,gender3,address3,number3,email3);
	}
	
	public void scan() {
		Scanner sc = new Scanner(System.in);//사용준비
		//정수형 입력받는 방법
		System.out.print("정수 입력 : ");
		int inputNumber; //정수 변수 선언, 넣기
		inputNumber = sc.nextInt(); // 사용자가 입력한 값 넣기 / 입력대기. 콘솔에 입력 후 엔터를 누르면 inputNumber와 system out에 넣어줌.
		//sc.nextInt(); --> 입력을 기다리고 엔터를 누르면 출력 후 종료됨. 그래서 제일 위에 쓰면 안 됨.
		//Console 창이 돌아가고 있는지를 확인해 제대로 돌아가는지 확인
		System.out.println("사용자가 입력한 값 : "+inputNumber);
		
		//실수형 입력받는 방법
		System.out.println("실수 입력 : "); //println을 썼기 때문에 아랫줄에서 값을 받음
		double dNumber = sc.nextDouble();
		System.out.println("사용자가 입력한 값: "+dNumber);
		
		//문자열 입력받는 방법 - 두 가지의 차이점을 알고 있어야 함
		System.out.println("첫 번째 문자열 입력: ");
		String str1 = sc.next();
		System.out.println("str1 : "+str1);
		sc.nextLine(); //위 코드에서 끝나면 엔터가 한 번 남아있기 때문에, sc.nextLine()으로 엔터를 먹어줘야 함
		//sc.nextLine()을 쓰기 전에 엔터를 없애는 용도로 한 번 더 추가해 줘야한다. 버퍼 비우기 용
		//버퍼가 없는 제일 처음으로 사용하였을 땐, 입력 없이 사용하면 된다

		System.out.println("두 번째 문자열 입력: ");
		String str2 = sc.nextLine();
		System.out.println("str2 : "+str2);
		//첫 번째의 경우, 띄어쓰기를 하면 짤린다.
		//sc.next();은 띄어쓰기를 인지하지 못하기 때문에 띄어쓰기가 없는 것만 받음
		//두 번째의 경우, 띄어쓰기까지 인지함.
		//sc.nextLine(); 띄어쓰기를 포함하는 경우에 사용하면 좋음
		
		//문자 입력 받는 방법
		System.out.println("문자 입력 :");
		char ch = sc.next().charAt(0); //문자를 읽는 방법은 존재하지 않고, 문자열로 받아와서 첫 번째 글자만 떼오는 방법. 두 번째 글자의 경우 1로 바꾸면 됨
		System.out.println("입력한 문자는 :"+ch);
		//더 나아가서 위에 ("str2 : "+str2.charAt(1)); 로 변경하게 되면 두 번째 글자만 나옴.
		//데이터 형식이 char로 변환된 과정을 볼 수 있는 것임.
	}
	
	public void question1() {
		Scanner q1 = new Scanner(System.in);

		System.out.print("본인 이름 :");
		String inputName = q1.nextLine();
		System.out.println("본인 이름 :"+inputName);
		
		System.out.print("본인 나이 :");
		int inputAge = q1.nextInt();
		System.out.println("본인 나이 :"+inputAge);
		
		q1.nextLine();
		System.out.print("본인 주소 :");
		String address = q1.nextLine();
		System.out.println("본인 주소 :"+address);
		
		System.out.print("본인 키 :");
		double inputHeight = q1.nextDouble();
		System.out.println("본인 키 :"+(int)inputHeight);

		System.out.print("본인 몸무게 :");
		double weight = q1.nextDouble();
		System.out.println("본인 몸무게 :"+weight);
		
		System.out.print("본인 성별 :");
		char gender = q1.next().charAt(0);
		System.out.println("본인 성별 :"+gender);
		System.out.printf("%s,%d,%s,%d,%.1f,%c",inputName,inputAge,address,(int)inputHeight,weight,gender);
	}
	public void question2() {
		Scanner q2 = new Scanner(System.in);
		
		System.out.print("국어점수 입력 :");
		int kor = q2.nextInt();
		System.out.println("국어점수 입력 :"+kor);
		
		System.out.print("수학점수 입력 :");
		int mat = q2.nextInt();
		System.out.println("수학점수 입력 :"+mat);
		
		System.out.print("영어점수 입력 :");
		int eng = q2.nextInt();
		System.out.println("영어점수 입력 :"+eng);
		
		System.out.printf("당신 성적의 총 합은 %d점이고 평균은 %.2f입니다.",kor+mat+eng,(double)(kor+mat+eng)/3);
	}

}
