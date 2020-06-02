package kh.java.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
	public void bufferTest() {
		StringBuffer sb = new StringBuffer(); //java.lang.* 들은 자동으로 import되기 때문에 생략해도 된다.
		//저장된 문자열의 길이 출력
		System.out.println(sb.length());
		//현재 문자열 끝에 추가
		sb.append("안녕하세요");
		System.out.println(sb);
		System.out.println(sb.length());		
		sb.append(" Hello");
		System.out.println(sb);
		System.out.println(sb.length());
		sb.insert(3,  "ㅇㅇㅇ");
		//3+1번 자리에 문자열 삽입
		System.out.println(sb);
		sb.replace(1, 3, "hi");
		//1번부터 3번째 자리까지 hi로 대체.
		//시작번호 다음것부터 시작해서 끝번호는 포함
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.delete(2, 5);
		
		System.out.println(sb);

	}
	public void tokenTest() {
		String str = "방찬호/27/서울";
		StringTokenizer sT = new StringTokenizer(str,"/"); //str 변수를 /기준으로 분리
		/*
		System.out.println(sT.countTokens()); // countTokens 몇 개의 데이터인지 개수 반환
		System.out.println(sT.nextToken()); //3개 중 첫 번째 데이터를 가져옴 (문자열 리턴)
		System.out.println(sT.countTokens()); //데이터가 2개로 줄어듦
		System.out.println(sT.nextToken()); //2개 중 첫 번째 데이터를 가져옴
		System.out.println(sT.countTokens()); 
		System.out.println(sT.nextToken()); //1개 중 첫 번째 데이터를 가져옴
		System.out.println(sT.countTokens()); 
		 */
		//Boolean형 데이터를 반환하며, 남아있으면 true, 없으면 false를 반환
		while(sT.hasMoreTokens()) {
			System.out.println(sT.nextToken());
		}
	}
	public void exampleMethod() {
		int index=0;
		String str = "J a v a P r o g r a m";
		StringTokenizer strToken = new StringTokenizer(str, " ");
		char [] arr = new char [strToken.countTokens()];
		while(strToken.hasMoreTokens()) {
			arr [index++] = strToken.nextToken().charAt(0);
		}
		for(int i=0;i<arr.length;i++) {
			if((int)(arr[i])>96 && (int)(arr[i])<123) {
				arr[i] = (char)(arr[i]^32);
			}
			System.out.print(arr[i]);
		}
	}
	public void mathTest() {
		System.out.println(Math.abs(-20)); //절대값 리턴
		System.out.println(Math.ceil(3.14)); //올림
		System.out.println(Math.floor(3.14)); //내림
		System.out.println(Math.round(3.14)); //반올림
		System.out.println(Math.random()); //0.0~1.0 범위 난수값 리턴
		System.out.println(Math.max(1, 2)); //매개변수 중의 큰 수 리턴
		System.out.println(Math.min(1, 2)); //매개변수 중 작은 수 리턴
	}
	public void calendarTest() {
		Calendar today = Calendar.getInstance(); //객체가 만들어질 때의 시간임. 
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.DATE));
		today.set(Calendar.YEAR, 2050);
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.MONTH)+1); //컴퓨터는 월을 0부터 센다
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.AM_PM)); //오전이 0, 오후가1
		System.out.println(today.get(Calendar.HOUR));  //시
		System.out.println(today.get(Calendar.MINUTE)); //분
		System.out.println(today.get(Calendar.SECOND)); //초
		System.out.println(today.get(Calendar.MILLISECOND)); //밀리세컨드
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); //1이 일요일, 7이 토요일 

		//현재 시간을 표현하는 메소드
		System.out.println(today.getTimeInMillis()); //1970년 1월 1일 09시 00분 00초부터 지금까지의 시간을 millisecond 단위로 계산한 값
	}
	public void calendarTest2() {
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		day2.set(Calendar.YEAR, 2021);
		long day11 = day1.getTimeInMillis();
		long day22 = day2.getTimeInMillis();
		long day = day22 - day11;
		long date = day/(1000*86400); //86400초 =1일
		System.out.println(date);
	}
	public void salchisal() {
		StringBuffer str = new StringBuffer();
		str.append("살치살");
		System.out.println(str);
		str.reverse();
		System.out.println(str);
	}
	public void dateTest() {
		//Date
		Date date1 = new Date();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.YEAR, 2021);
		long testDate = today.getTimeInMillis();
		Date date2 = new Date(testDate);
		System.out.println(date1);
		System.out.println(date2);
	}
	public void dateFormat() {
		Date today = new Date();
		SimpleDateFormat SDF1 = new SimpleDateFormat("yyyy-MM-dd");
		String today1 = SDF1.format(today);
		System.out.println(today1);
		SimpleDateFormat SDF2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String today2 = SDF2.format(today);
		System.out.println(today2);
	}
	public void example1() {
		char [] yoil = {'일', '월', '화', '수','목', '금','토'};
		Calendar today = Calendar.getInstance();
		long todayYear = today.get(Calendar.YEAR);
		long todayMonth = today.get(Calendar.MONTH)+1;
		long todayDate = today.get(Calendar.DATE);
		int todayDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		System.out.println(todayYear+"년 "+todayMonth+"월 "+todayDate+"일 "+yoil[todayDayOfWeek-1]+"요일");
	}
	public void example2() {
		Calendar today=Calendar.getInstance();		
		Calendar Dday = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("=================D-Day 계산기 ==============");
		System.out.print("D-Day [년도] 입력 : ");
		int inputYear = sc.nextInt();
		System.out.print("D-Day [월] 입력 : ");
		int inputMonth = sc.nextInt();
		System.out.print("D-Day [일] 입력 : ");
		int inputDay = sc.nextInt();
		System.out.println();
		Dday.set(Calendar.YEAR,inputYear);
		Dday.set(Calendar.MONTH,inputMonth);
		Dday.set(Calendar.DATE,inputDay);
		
		System.out.println("오늘 날짜 : "+today.get(Calendar.YEAR)+"년 "+(today.get(Calendar.MONTH)+1)+"월 "+today.get(Calendar.DATE)+"일");
		System.out.println("D-day 날짜 : "+Dday.get(Calendar.YEAR)+"년 "+Dday.get(Calendar.MONTH)+"월 "+Dday.get(Calendar.DATE)+"일");
		
		Dday.set(Calendar.MONTH,inputMonth-1);
		
		long gapDate = (Dday.getTimeInMillis()/1000-today.getTimeInMillis()/1000)/(86400);
		if(gapDate>0) {
			System.out.println(gapDate+"일 만큼 남았습니다.");
		}else if(gapDate==0) {
			System.out.println("D-day입니다.");
		}else if(gapDate<0) {
			System.out.println((-1)*(gapDate)+"일 만큼 지났습니다.");
		}
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String str = sc.next();
		char [] arr = new char [str.length()];
		int test = 0;
		//set = 100;
		//문자열 길이측정 3
		//문자형 배열 생성하여 한 글자씩 입력
		//char[] arr = new char[3];
		//{'1', '0', '0'}
		//'1' -> 49, '0' -> 48
		//(arr[0]-48)*100 + (arr[1]-48)*10 + (arr[2]*1)
		for(int i=0; i<arr.length;i++) {
			if(str.charAt(i)<48 || str.charAt(i)>57) {
				System.out.println("숫자가 아닙니다. ");
				return;
			}else {
			arr[i] = str.charAt(i);
			}
		}
		for(int i= 0; i<arr.length ; i++ ) {
			test+=(arr[i]-48)*(Math.pow(10, arr.length-i-1));
		}
		System.out.println(test);	
	}
	public void testStrInt() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String str = sc.next();
		int number = Integer.parseInt(str);
		System.out.println(number);
	}
	
}
