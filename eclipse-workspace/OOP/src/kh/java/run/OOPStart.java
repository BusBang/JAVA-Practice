package kh.java.run;
import kh.java.vo.TV;
import java.util.Scanner;

public class OOPStart {

	public static void main(String[] args) {
		TV tv = new TV(); //이건 메소드인가 클래스인가?
		// JVM이 자동으로 만들어주는 생성자. 메소드를 자동으로 만들어준것임
		// 
		//
		TV tv1= new TV(100, true, 200, 300);
		System.out.println(tv.getInch());
		System.out.println(tv1.getInch());
/*
		
		Scanner sc = new Scanner(System.in);
//		TV tv1 = new TV(); //tv, tv1은 Instance라고 부른다. TV 객체긴 함.
		while(true) {
//			System.out.println("======TV 시청 가이드======");
//			System.out.println("1. 전원 on/off");
//			System.out.println("2. 현재 채널 및 볼륨 확인");
//			System.out.println("3. 채널 증가");
//			System.out.println("4. 채널 감소");
//			System.out.println("5. 볼륨 증가");
//			System.out.println("6. 볼륨 감소");
//			System.out.print("선택 >> ");
			tv.tvState();
			int select  = sc.nextInt();
			switch(select) {
			case 1:
				if(tv.getPower()) {
					tv.setPower(true);
					System.out.println("전원이 켜졌습니다");
				}else {
					tv.setPower(false);
					System.out.println("전원이 꺼졌습니다");
				}
				break;
			case 2:
				if(tv.getPower()) {
					System.out.println("현재 채널 : "+tv.getChannel());
					System.out.println("현재 볼륨 : "+tv.getVolume());
				}else {
					System.out.println("전원을 켜주세요.");
				}
				break;
			case 3:
				if(tv.getPower()) {
					tv.channelUp();
				}else {
					System.out.println("전원을 켜주세요.");
				}
				break;
			case 4:
				if(tv.getPower()==true&&tv.getChannel()>1) {
					tv.channelDown();
				}else if(tv.getPower()==true&&tv.getChannel()==1){
					System.out.println("채널은 더 내려갈 수 없습니다.");
				}else {
					System.out.println("전원을 켜주세요.");
				}
				break;
				
			case 5:
				if(tv.getPower()) {
					tv.volumeUp();
				}else {
					System.out.println("전원을 켜주세요.");
				}
				break;
			case 6:
				if(tv.getPower()==true&&tv.getVolume()>0) {
					tv.volumeDown();
				}else if(tv.getPower()==true&&tv.getVolume()==0){
					System.out.println("볼륨은 -값을 가질 수 없습니다.");
				}else {
					System.out.println("전원을 켜주세요.");
				}
				break;
			case 7:
				if(tv.getPower()) {
					tv.channelMove();
//					System.out.print("채널을 입력해주세요 : ");
//					int aimedChannel = sc.nextInt();
//					tv.channelMoving(aimedChannel);
//					System.out.println(tv.channel+"번 채널로 이동하였습니다.");
				}else {
					System.out.println("전원을 켜주세요");
				}
				break;
			}
			
		}
//		System.out.println(tv.inch);
//		System.out.println(tv.channel);
//		System.out.println(tv.volume);
//		System.out.println(tv.power);
		
//		tv.power();
//		System.out.println(tv.power);
//		tv.volumeUp();
//		System.out.println(tv.volume);
//		System.out.println(tv1.volume);
		
		
*/		
		
		
		

	}

}
