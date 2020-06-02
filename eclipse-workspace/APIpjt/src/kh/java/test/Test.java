package kh.java.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
	public void bufferTest() {
		StringBuffer sb = new StringBuffer(); //java.lang.* ���� �ڵ����� import�Ǳ� ������ �����ص� �ȴ�.
		//����� ���ڿ��� ���� ���
		System.out.println(sb.length());
		//���� ���ڿ� ���� �߰�
		sb.append("�ȳ��ϼ���");
		System.out.println(sb);
		System.out.println(sb.length());		
		sb.append(" Hello");
		System.out.println(sb);
		System.out.println(sb.length());
		sb.insert(3,  "������");
		//3+1�� �ڸ��� ���ڿ� ����
		System.out.println(sb);
		sb.replace(1, 3, "hi");
		//1������ 3��° �ڸ����� hi�� ��ü.
		//���۹�ȣ �����ͺ��� �����ؼ� ����ȣ�� ����
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.delete(2, 5);
		
		System.out.println(sb);

	}
	public void tokenTest() {
		String str = "����ȣ/27/����";
		StringTokenizer sT = new StringTokenizer(str,"/"); //str ������ /�������� �и�
		/*
		System.out.println(sT.countTokens()); // countTokens �� ���� ���������� ���� ��ȯ
		System.out.println(sT.nextToken()); //3�� �� ù ��° �����͸� ������ (���ڿ� ����)
		System.out.println(sT.countTokens()); //�����Ͱ� 2���� �پ��
		System.out.println(sT.nextToken()); //2�� �� ù ��° �����͸� ������
		System.out.println(sT.countTokens()); 
		System.out.println(sT.nextToken()); //1�� �� ù ��° �����͸� ������
		System.out.println(sT.countTokens()); 
		 */
		//Boolean�� �����͸� ��ȯ�ϸ�, ���������� true, ������ false�� ��ȯ
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
		System.out.println(Math.abs(-20)); //���밪 ����
		System.out.println(Math.ceil(3.14)); //�ø�
		System.out.println(Math.floor(3.14)); //����
		System.out.println(Math.round(3.14)); //�ݿø�
		System.out.println(Math.random()); //0.0~1.0 ���� ������ ����
		System.out.println(Math.max(1, 2)); //�Ű����� ���� ū �� ����
		System.out.println(Math.min(1, 2)); //�Ű����� �� ���� �� ����
	}
	public void calendarTest() {
		Calendar today = Calendar.getInstance(); //��ü�� ������� ���� �ð���. 
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.DATE));
		today.set(Calendar.YEAR, 2050);
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.MONTH)+1); //��ǻ�ʹ� ���� 0���� ����
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.AM_PM)); //������ 0, ���İ�1
		System.out.println(today.get(Calendar.HOUR));  //��
		System.out.println(today.get(Calendar.MINUTE)); //��
		System.out.println(today.get(Calendar.SECOND)); //��
		System.out.println(today.get(Calendar.MILLISECOND)); //�и�������
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); //1�� �Ͽ���, 7�� ����� 

		//���� �ð��� ǥ���ϴ� �޼ҵ�
		System.out.println(today.getTimeInMillis()); //1970�� 1�� 1�� 09�� 00�� 00�ʺ��� ���ݱ����� �ð��� millisecond ������ ����� ��
	}
	public void calendarTest2() {
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		day2.set(Calendar.YEAR, 2021);
		long day11 = day1.getTimeInMillis();
		long day22 = day2.getTimeInMillis();
		long day = day22 - day11;
		long date = day/(1000*86400); //86400�� =1��
		System.out.println(date);
	}
	public void salchisal() {
		StringBuffer str = new StringBuffer();
		str.append("��ġ��");
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
		char [] yoil = {'��', '��', 'ȭ', '��','��', '��','��'};
		Calendar today = Calendar.getInstance();
		long todayYear = today.get(Calendar.YEAR);
		long todayMonth = today.get(Calendar.MONTH)+1;
		long todayDate = today.get(Calendar.DATE);
		int todayDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		System.out.println(todayYear+"�� "+todayMonth+"�� "+todayDate+"�� "+yoil[todayDayOfWeek-1]+"����");
	}
	public void example2() {
		Calendar today=Calendar.getInstance();		
		Calendar Dday = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("=================D-Day ���� ==============");
		System.out.print("D-Day [�⵵] �Է� : ");
		int inputYear = sc.nextInt();
		System.out.print("D-Day [��] �Է� : ");
		int inputMonth = sc.nextInt();
		System.out.print("D-Day [��] �Է� : ");
		int inputDay = sc.nextInt();
		System.out.println();
		Dday.set(Calendar.YEAR,inputYear);
		Dday.set(Calendar.MONTH,inputMonth);
		Dday.set(Calendar.DATE,inputDay);
		
		System.out.println("���� ��¥ : "+today.get(Calendar.YEAR)+"�� "+(today.get(Calendar.MONTH)+1)+"�� "+today.get(Calendar.DATE)+"��");
		System.out.println("D-day ��¥ : "+Dday.get(Calendar.YEAR)+"�� "+Dday.get(Calendar.MONTH)+"�� "+Dday.get(Calendar.DATE)+"��");
		
		Dday.set(Calendar.MONTH,inputMonth-1);
		
		long gapDate = (Dday.getTimeInMillis()/1000-today.getTimeInMillis()/1000)/(86400);
		if(gapDate>0) {
			System.out.println(gapDate+"�� ��ŭ ���ҽ��ϴ�.");
		}else if(gapDate==0) {
			System.out.println("D-day�Դϴ�.");
		}else if(gapDate<0) {
			System.out.println((-1)*(gapDate)+"�� ��ŭ �������ϴ�.");
		}
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է� : ");
		String str = sc.next();
		char [] arr = new char [str.length()];
		int test = 0;
		//set = 100;
		//���ڿ� �������� 3
		//������ �迭 �����Ͽ� �� ���ھ� �Է�
		//char[] arr = new char[3];
		//{'1', '0', '0'}
		//'1' -> 49, '0' -> 48
		//(arr[0]-48)*100 + (arr[1]-48)*10 + (arr[2]*1)
		for(int i=0; i<arr.length;i++) {
			if(str.charAt(i)<48 || str.charAt(i)>57) {
				System.out.println("���ڰ� �ƴմϴ�. ");
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
		System.out.print("�Է� : ");
		String str = sc.next();
		int number = Integer.parseInt(str);
		System.out.println(number);
	}
	
}
