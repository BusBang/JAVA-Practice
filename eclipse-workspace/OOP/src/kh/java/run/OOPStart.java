package kh.java.run;
import kh.java.vo.TV;
import java.util.Scanner;

public class OOPStart {

	public static void main(String[] args) {
		TV tv = new TV(); //�̰� �޼ҵ��ΰ� Ŭ�����ΰ�?
		// JVM�� �ڵ����� ������ִ� ������. �޼ҵ带 �ڵ����� ������ذ���
		// 
		//
		TV tv1= new TV(100, true, 200, 300);
		System.out.println(tv.getInch());
		System.out.println(tv1.getInch());
/*
		
		Scanner sc = new Scanner(System.in);
//		TV tv1 = new TV(); //tv, tv1�� Instance��� �θ���. TV ��ü�� ��.
		while(true) {
//			System.out.println("======TV ��û ���̵�======");
//			System.out.println("1. ���� on/off");
//			System.out.println("2. ���� ä�� �� ���� Ȯ��");
//			System.out.println("3. ä�� ����");
//			System.out.println("4. ä�� ����");
//			System.out.println("5. ���� ����");
//			System.out.println("6. ���� ����");
//			System.out.print("���� >> ");
			tv.tvState();
			int select  = sc.nextInt();
			switch(select) {
			case 1:
				if(tv.getPower()) {
					tv.setPower(true);
					System.out.println("������ �������ϴ�");
				}else {
					tv.setPower(false);
					System.out.println("������ �������ϴ�");
				}
				break;
			case 2:
				if(tv.getPower()) {
					System.out.println("���� ä�� : "+tv.getChannel());
					System.out.println("���� ���� : "+tv.getVolume());
				}else {
					System.out.println("������ ���ּ���.");
				}
				break;
			case 3:
				if(tv.getPower()) {
					tv.channelUp();
				}else {
					System.out.println("������ ���ּ���.");
				}
				break;
			case 4:
				if(tv.getPower()==true&&tv.getChannel()>1) {
					tv.channelDown();
				}else if(tv.getPower()==true&&tv.getChannel()==1){
					System.out.println("ä���� �� ������ �� �����ϴ�.");
				}else {
					System.out.println("������ ���ּ���.");
				}
				break;
				
			case 5:
				if(tv.getPower()) {
					tv.volumeUp();
				}else {
					System.out.println("������ ���ּ���.");
				}
				break;
			case 6:
				if(tv.getPower()==true&&tv.getVolume()>0) {
					tv.volumeDown();
				}else if(tv.getPower()==true&&tv.getVolume()==0){
					System.out.println("������ -���� ���� �� �����ϴ�.");
				}else {
					System.out.println("������ ���ּ���.");
				}
				break;
			case 7:
				if(tv.getPower()) {
					tv.channelMove();
//					System.out.print("ä���� �Է����ּ��� : ");
//					int aimedChannel = sc.nextInt();
//					tv.channelMoving(aimedChannel);
//					System.out.println(tv.channel+"�� ä�η� �̵��Ͽ����ϴ�.");
				}else {
					System.out.println("������ ���ּ���");
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
