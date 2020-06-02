package example.java;
import java.util.Scanner;

public class ExampleVariable {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("이름 입력 :");
		String name = sc1.next();
		
		System.out.print("나이 입력 :");
		int age = sc1.nextInt();
		
		sc1.nextLine();
		System.out.print("주소 입력 :");
		String address = sc1.nextLine();
		
		System.out.print("키 입력 :");
		double height = sc1.nextDouble();
		
		System.out.print("몸무게 입력 :");
		double weight = sc1.nextDouble();
		
		System.out.print("성별 입력 :");
		char sex = sc1.next().charAt(0);
		
		System.out.printf("이름:%s, 나이:%d, 주소:%s, 키:%d, 몸무게:%.1f, 성별:%c",
							name,age,address,(int)height,weight,sex);	
	}
	
	public void exam2() {
		System.out.println("이름\t나이\t성별\t지역\t전화번호\t\t이메일");
		String name = "방찬호";
		int age = 27;
		char sex = '남';
		String address = "서울시";
		String phone = "010-2522-8575";
		String mail = "bang8255@naver.com";
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s",name, age, sex, address, phone, mail);
		
	}

}
