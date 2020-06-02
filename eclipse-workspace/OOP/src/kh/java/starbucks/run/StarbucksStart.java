package kh.java.starbucks.run;
import kh.java.starbucks.func.StarbucksFunc;
import java.util.Scanner;

public class StarbucksStart {

	public static void main(String[] args) {
		
		StarbucksFunc sb = new StarbucksFunc();
		Scanner sc = new Scanner(System.in);
		
//		StarbucksFunc testtest = new StarbucksFunc();
//		testtest.test1();
		System.out.println("*******************************");
		System.out.println("********** ��Ÿ���� ���� ***********");
		System.out.println("*******************************");
		System.out.println();
		
		while(true) {
			sb.mainManu();
			int selectMain = sc.nextInt();
			switch(selectMain) {
			case 1 :
				sb.myStatus();
				break;
			case 2 :
				sb.enterStarbucks(); //��Ÿ���� ����
				
				switch(sb.coupon) {
				case 0 : //���� ���� ��
					sb.manu(); //�޴��� ����
					System.out.print("���� >> ");
					int selectCoffee = sc.nextInt(); //�޴� ����	
					//���˻�
					if(sb.coffeePrice[selectCoffee-1]>sb.myMoney) {
						sb.noMoney(selectCoffee);
						break;
					}
					
					//ice/hot����
					System.out.println("<<ice/Hot�� �������ּ���>>");
					System.out.println("(1. ice /2. Hot)");
					System.out.print("���� >> ");
					int selectIce = sc.nextInt();
					sb.selectIce(selectIce);
					
					sb.makeCoffee(selectCoffee); //Ŀ�� ����
					
					if(sb.grade) {
						sb.starUpGold(selectCoffee);					
					}else{
						sb.starUpGreen(selectCoffee);
					}
					sb.makeCoupon();
					
					break;
				case 1 : //���� ���� ��
					System.out.println("���� ������ "+sb.coupon+"�� �ֽ��ϴ�. ");
					System.out.println("������ ����Ͻø� � ����� ���������� ���� �� �ֽ��ϴ�.");
					System.out.println("������ ���� ���� ���� �������� �ʽ��ϴ�.");
					System.out.println("������ ����Ͻðڽ��ϱ�? (1.Yes 2.No)");
					System.out.println("���� >> ");
					int couponUse = sc.nextInt();
					sb.usingCoupon(couponUse);
					
					switch(couponUse) {
					case 1 : //���� ����ϱ� 
						sb.manu(); //�޴��� ����
						System.out.print("���� >> ");
						int selectCoffee1 = sc.nextInt(); //�޴� ����	
						//���˻�
						if(sb.coffeePrice[selectCoffee1-1]>sb.myMoney && sb.usingCoupon ==false) {
							sb.noMoney(selectCoffee1);
							break;
						}
						sb.myMoney += sb.coffeePrice[selectCoffee1-1]; //�޴���ŭ �� �߰� (���ſ��� ����)
						
						//ice/hot����
						System.out.println("<<ice/Hot�� �������ּ���>>");
						System.out.println("(1. ice /2. Hot)");
						System.out.print("���� >> ");
						int selectIce1 = sc.nextInt();
						sb.selectIce(selectIce1);
						
						sb.makeCoffee(selectCoffee1); //Ŀ�� ����
						
						if(sb.grade) {
							sb.starUpGold(selectCoffee1);					
						}else{
							sb.starUpGreen(selectCoffee1);
						}
						sb.coupon--; //���� -1
						sb.usingCoupon=false; //���� �̻�� ���·� ��ȯ
						
						break;
					case 2 : //���� �̻��
						
						sb.manu(); //�޴��� ����
						System.out.print("���� >> ");
						int selectCoffee11 = sc.nextInt(); //�޴� ����	
						//���˻�
						if(sb.coffeePrice[selectCoffee11-1]>sb.myMoney && sb.usingCoupon ==false) {
							sb.noMoney(selectCoffee11);
							break;
						}
						
						//ice/hot����
						System.out.println("<<ice/Hot�� �������ּ���>>");
						System.out.println("(1. ice /2. Hot)");
						System.out.print("���� >> ");
						int selectIce11 = sc.nextInt();
						sb.selectIce(selectIce11);
						
						sb.makeCoffee(selectCoffee11); //Ŀ�� ����
						
						if(sb.grade) {
							sb.starUpGold(selectCoffee11);					
						}else{
							sb.starUpGreen(selectCoffee11);
						}
						break;
					}
					break;
				}			
				break;
			case 3 :
				sb.working();
				break;
			case 4 :
				System.out.println("������ �����ϼ̽��ϴ�");
				return;
			}

		}

		

	}

}
