package kh.java.starbucks.func;


public class StarbucksFunc {
	
	public boolean grade=false; //false :green true : gold
	public boolean usingCoupon=false; //�̻���� false
	boolean iceOrHot=false; //ice�� false
	public int myMoney=100000;
	int gradeLimit;
	int star;
	public int coupon;
	int countBuyCoffee = 0;
	public String [] coffeeManu = {"�Ƹ޸�ī��","ī���","ī���ī","�ڸ���Ϻ�Ƽ","ļ��� ��Ű�߶�","<�����> ����ġ�� ȭ��Ʈ ��ī","<�����>��� ������ ��"}; 
	public int [] coffeePrice = {4100,4600,5100,5300,5600,6100,6100}; 
	public String [] IceOrHot = {"Ice","Hot"};
	
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void test1() {
		System.out.println("ù ��° ���");
		delay(1*1000);
		System.out.println("�� ��° ���");
	}
	public void mainManu() {
		System.out.println();
		System.out.println("<<�������� ����ּ���>>");
		System.out.println("1. �� ���� ����");
		System.out.println("2. ��Ÿ���� ����");
		System.out.println("3. �� ���� ����");
		System.out.println("4. ���� ����");	
	}
	public void myStatus() {
		System.out.println();
		System.out.println("<< �� ���� ���� >>");
		if(countBuyCoffee>=5) {
			grade=true;
		}else {
			grade=false;
		}
		if(grade) {
			System.out.println("��� : ��� ����");
		}else {
			System.out.println("��� : �׸� ����");					
		}
		System.out.println("������ : "+myMoney);
		System.out.println("�� ���� Ŀ�� ���� : "+countBuyCoffee);
		System.out.println("���� �� ���� : "+star);
		System.out.println("���� ���� ���� : "+coupon);
		if(grade==false) {
			System.out.println("-----------<< �˸� >>---------");
			System.out.println("�׸� ������ ���� ������ �Ұ����մϴ�.");
			System.out.println("Ŀ�� 5�� ���Ž�, ��� ������� �ö󰩴ϴ�.");
			System.out.println("----------------------------");
		}
	}

	
	public void starUpGreen(int selectCoffee) {
		switch(selectCoffee) {
		case 1 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();

			}				
				break;
		case 2 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}				
				break;
		case 3 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}				
				break;
		case 4 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}				
				break;
		case 5 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}							
				break;	
		case 6 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}		
				break;
		case 7 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(countBuyCoffee==5) {
				goldMSG();
			}		
				break;
		}
	}
	public void starUpGold(int selectCoffee) {
		switch(selectCoffee) {
		case 1 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star++;
			}
				break;
		case 2 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star++;
			}
				break;
		case 3 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star++;
			}
				break;
		case 4 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star++;
			}
				break;
		case 5 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star++;
			}
				break;		
		case 6 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star+=2;
			}
				break;
		case 7 :

			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("���� �� �� ���޵Ǿ����ϴ�!");
			star+=2;
			}

			break;
		}
	}
	public void working() {
		System.out.println();
		System.out.println("���� ���� ���ؼ� ���� �ؾ���!");
		System.out.println();
		System.out.println("<<���ϴ� ��>>>");
		System.out.print("��..");
		delay(1*700);
		System.out.print("��..");
		delay(1*700);
		System.out.print("��..");
		delay(1*700);
		System.out.print("��..");
		delay(1*700);
		System.out.print("!!");
		delay(1*500);
		System.out.println();
		System.out.println("30,000���� �������ϴ�!!!");
		System.out.println();
		myMoney += 30000;
	}
	public void enterStarbucks() {
		System.out.println();
		System.out.println("<<��Ÿ���� �����մϴ�>>");
		System.out.print("��");
		delay(1*150);
		System.out.print("��");
		delay(1*150);
		System.out.print("��");
		delay(1*150);
		System.out.print("��");
		delay(1*150);
		System.out.print("��");
		delay(1*150);
		System.out.print("��");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.println("�����Ͽ����ϴ�!");
	}
	public void manu() {
		System.out.println();
		System.out.println("<<Ŀ�Ǹ� �������ּ���>>");
		System.out.println("------------<<�޴���>>-------------");
		System.out.println("1. �Ƹ޸�ī�� (4,100��)");
		System.out.println("2. ī��� (4,600��)");
		System.out.println("3. ī���ī (5,100��)");
		System.out.println("4. �ڸ���Ϻ�Ƽ (5,300��)");
		System.out.println("5. ļ��� ��Ű�߶� (5,600��)");
		System.out.println("6. <�����> ���� ġ�� ȭ��Ʈ ��ī (6,100��)");
		System.out.println("7. <�����> ��� ������ �� (6,100��)");
		System.out.println("---------------------------------");	
		if(usingCoupon) {
			System.out.println("<<�˸� : ���� ����� ���� ���޵��� �ʽ��ϴ�>>");
		}else {
			if(grade==true) {
				System.out.println("<<�˸� : ����� �޴��� ���� 2�� ���޵˴ϴ�>>");			
			}else {
				System.out.println("<< ����� �׸� �����Դϴ� >>");
				System.out.println("<< ��� ���� ���� : Ŀ�� 5�� ����>>");
			}
		}
	}
	public void selectIce(int selIceHot) {
		if(selIceHot==1) {
			iceOrHot = false; //false = ice
		}else {
			iceOrHot = true; //true = hot
		}
	}
	public void makeCoffee(int manuNumb) {
		System.out.println("<<Ŀ�� ������>>");
		System.out.print("��");
		delay(1*500);
		System.out.print("��");
		delay(1*500);
		System.out.print("��");
		delay(1*500);
		System.out.print("...");
		delay(1*500);
		System.out.println();
		int iceHotChoice = 0;
		if(iceOrHot) { //ice 1 hot 2
			iceHotChoice=1;
		}else {
			iceHotChoice=0;
		}
		System.out.println("�ֹ��Ͻ� "+IceOrHot[iceHotChoice]+coffeeManu[manuNumb-1]+"�� ���Խ��ϴ�!!!");
		
	}
	public void makeCoupon() {
		if(star>=12) {
			star = star-12;
			coupon++;
			System.out.println("������ ���޵Ǿ����ϴ�! Ȯ���غ�����!");
		}
	}
	public void goldMSG() {
				System.out.println("<<����>>");
				System.out.println("��� ������ �±��ϼ̽��ϴ�!");
				System.out.println("�� �� �� �� �� �� !");
				grade=true;
	}
	public void usingCoupon(int use) {
		if(use==1) { //use = 1 yes
			usingCoupon=true;
			System.out.println("������ ����մϴ�. ");
			System.out.println("��� �޴��� ����� ���� �����ϸ�, ���� �������� �ʽ��ϴ�.");
		}else if(use==2) { //use =2 No.
			usingCoupon=false;			
			System.out.println("������ ������� �ʽ��ϴ�.");
		}
	}
	public void noMoney(int money) { //�� �˻�
			System.out.println("���� �ִ� ������ Ŀ�ǰ� ��� ������ �� �����ϴ�.");
			System.out.println("�����Ϸ��� Ŀ�� ���� : "+coffeePrice[money-1]);
			System.out.println("�����ϴ� �� : "+myMoney);
			System.out.println("���� �� ������ּ���");
	}

	

	

}
