package kh.java.vo;
import java.util.Scanner;


public class TV {
	//ũ��, ����, ä��, ��������
	//����, ä��, �������
	
	//�⺻ ������2
	public TV () {}
	
	//�Ű����� �ִ� ������3
	public TV(int inch, boolean power, int channel, int volume) {
		this.inch=inch;
		this.power=power;
		this.channel=channel;
		this.volume=volume;
	}
	//����1
	private int inch = 500;
	private boolean power = false;
	private int channel = 1;
	private int volume = 0;
	Scanner sc = new Scanner(System.in);
	//����4
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
	//����5
	//setter�� �׻� ���̵�. //�Ű������� ������ Ÿ�԰� ����
	public void setPower(boolean power) {
		this.power = power;
	}
	//set�� ���� �ް� �����ִ� ���� �־�� �Ѵ�.
	//�׷��� �Ű������� ������ �־�� ��.
	//this�� ���ؼ� ���� ������ �θ� (������ ������ �ƴϸ� this�� ���� �ʱ� ��)
	//���� ������ �����ϱ� ���� this��� Ű���带 ���� ��.
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
		//���� ���
		power = !power;
		return power;
	}
	public void channelUp() {
		System.out.println("ä�ι�ȣ ����");
		channel++;
	}
	public void channelDown() {
		System.out.println("ä�ι�ȣ ����");
		channel--;
	}
	public void volumeUp() {
		System.out.println("���� ����");
		volume++;
	}
	public void volumeDown() {
		System.out.println("���� ����");
		volume--;
	}
	public void tvState() {
		System.out.println("======TV ��û ���̵�======");
		System.out.println("1. ���� on/off");
		System.out.println("2. ���� ä�� �� ���� Ȯ��");
		System.out.println("3. ä�� ����");
		System.out.println("4. ä�� ����");
		System.out.println("5. ���� ����");
		System.out.println("6. ���� ����");
		System.out.println("7. ä�� �̵�");
		System.out.print("���� >> ");
	}
	public void channelMove() {
		System.out.print("�̵��� ä���� �Է����ּ��� : ");
		int select = sc.nextInt();
		channel = select;
		System.out.println(channel+"�� ä�η� �̵��Ͽ����ϴ�.");
	}
	public int channelMoving(int sel) {
		channel = sel;
		return channel;
	}

}
