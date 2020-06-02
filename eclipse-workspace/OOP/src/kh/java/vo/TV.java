package kh.java.vo;
import java.util.Scanner;


public class TV {
	//크기, 전원, 채널, 볼륨변수
	//전원, 채널, 볼륨기능
	
	//기본 생성자2
	public TV () {}
	
	//매개변수 있는 생성자3
	public TV(int inch, boolean power, int channel, int volume) {
		this.inch=inch;
		this.power=power;
		this.channel=channel;
		this.volume=volume;
	}
	//변수1
	private int inch = 500;
	private boolean power = false;
	private int channel = 1;
	private int volume = 0;
	Scanner sc = new Scanner(System.in);
	//겟터4
	public boolean getPower() {
		return power;
	}
	public int getChannel() {
		return channel;
	}
	public int getInch() {
		return inch;
	}
	public int getVolume() {
		return volume;
	}
	//셋터5
	//setter는 항상 보이드. //매개변수가 데이터 타입과 같음
	public void setPower(boolean power) {
		this.power = power;
	}
	//set은 값은 받고 돌려주는 것이 있어야 한다.
	//그래서 매개변수가 무조건 있어야 함.
	//this를 통해서 전역 변수를 부름 (동일한 변수가 아니면 this를 쓰지 않긴 함)
	//전역 변수를 수정하기 위해 this라는 키워드를 쓰는 것.
	public void setInch(int inch) {
		this.inch = inch;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	
	
	public boolean power() { 
		//전원 기능
		power = !power;
		return power;
	}
	public void channelUp() {
		System.out.println("채널번호 증가");
		channel++;
	}
	public void channelDown() {
		System.out.println("채널번호 감소");
		channel--;
	}
	public void volumeUp() {
		System.out.println("볼륨 증가");
		volume++;
	}
	public void volumeDown() {
		System.out.println("볼륨 감소");
		volume--;
	}
	public void tvState() {
		System.out.println("======TV 시청 가이드======");
		System.out.println("1. 전원 on/off");
		System.out.println("2. 현재 채널 및 볼륨 확인");
		System.out.println("3. 채널 증가");
		System.out.println("4. 채널 감소");
		System.out.println("5. 볼륨 증가");
		System.out.println("6. 볼륨 감소");
		System.out.println("7. 채널 이동");
		System.out.print("선택 >> ");
	}
	public void channelMove() {
		System.out.print("이동할 채널을 입력해주세요 : ");
		int select = sc.nextInt();
		channel = select;
		System.out.println(channel+"번 채널로 이동하였습니다.");
	}
	public int channelMoving(int sel) {
		channel = sel;
		return channel;
	}

}
