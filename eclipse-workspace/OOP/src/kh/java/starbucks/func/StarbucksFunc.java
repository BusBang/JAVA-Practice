package kh.java.starbucks.func;


public class StarbucksFunc {
	
	public boolean grade=false; //false :green true : gold
	public boolean usingCoupon=false; //미사용이 false
	boolean iceOrHot=false; //ice가 false
	public int myMoney=100000;
	int gradeLimit;
	int star;
	public int coupon;
	int countBuyCoffee = 0;
	public String [] coffeeManu = {"아메리카노","카페라떼","카페모카","자몽허니블랙티","캬라멜 마키야또","<스페셜> 해피치즈 화이트 모카","<스페셜>골든 세서미 라떼"}; 
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
		System.out.println("첫 번째 출력");
		delay(1*1000);
		System.out.println("두 번째 출력");
	}
	public void mainManu() {
		System.out.println();
		System.out.println("<<선택지를 골라주세요>>");
		System.out.println("1. 내 상태 보기");
		System.out.println("2. 스타벅스 가기");
		System.out.println("3. 돈 벌러 가기");
		System.out.println("4. 게임 종료");	
	}
	public void myStatus() {
		System.out.println();
		System.out.println("<< 내 상태 보기 >>");
		if(countBuyCoffee>=5) {
			grade=true;
		}else {
			grade=false;
		}
		if(grade) {
			System.out.println("등급 : 골드 레벨");
		}else {
			System.out.println("등급 : 그린 레벨");					
		}
		System.out.println("소지금 : "+myMoney);
		System.out.println("총 구매 커피 개수 : "+countBuyCoffee);
		System.out.println("현재 별 개수 : "+star);
		System.out.println("현재 쿠폰 개수 : "+coupon);
		if(grade==false) {
			System.out.println("-----------<< 알림 >>---------");
			System.out.println("그린 레벨은 쿠폰 지급이 불가능합니다.");
			System.out.println("커피 5잔 구매시, 골드 등급으로 올라갑니다.");
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
			System.out.println("별이 한 개 지급되었습니다!");
			star++;
			}
				break;
		case 2 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 한 개 지급되었습니다!");
			star++;
			}
				break;
		case 3 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 한 개 지급되었습니다!");
			star++;
			}
				break;
		case 4 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 한 개 지급되었습니다!");
			star++;
			}
				break;
		case 5 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 한 개 지급되었습니다!");
			star++;
			}
				break;		
		case 6 :
			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 두 개 지급되었습니다!");
			star+=2;
			}
				break;
		case 7 :

			myMoney = myMoney-coffeePrice[selectCoffee-1];
			countBuyCoffee++;
			if(usingCoupon==false) {
			System.out.println("별이 두 개 지급되었습니다!");
			star+=2;
			}

			break;
		}
	}
	public void working() {
		System.out.println();
		System.out.println("돈을 벌기 위해선 일을 해야지!");
		System.out.println();
		System.out.println("<<일하는 중>>>");
		System.out.print("일..");
		delay(1*700);
		System.out.print("하..");
		delay(1*700);
		System.out.print("는..");
		delay(1*700);
		System.out.print("중..");
		delay(1*700);
		System.out.print("!!");
		delay(1*500);
		System.out.println();
		System.out.println("30,000원을 벌었습니다!!!");
		System.out.println();
		myMoney += 30000;
	}
	public void enterStarbucks() {
		System.out.println();
		System.out.println("<<스타벅스 입장합니다>>");
		System.out.print("입");
		delay(1*150);
		System.out.print("장");
		delay(1*150);
		System.out.print("중");
		delay(1*150);
		System.out.print("입");
		delay(1*150);
		System.out.print("니");
		delay(1*150);
		System.out.print("다");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.print(".");
		delay(1*150);
		System.out.println("입장하였습니다!");
	}
	public void manu() {
		System.out.println();
		System.out.println("<<커피를 선택해주세요>>");
		System.out.println("------------<<메뉴판>>-------------");
		System.out.println("1. 아메리카노 (4,100원)");
		System.out.println("2. 카페라떼 (4,600원)");
		System.out.println("3. 카페모카 (5,100원)");
		System.out.println("4. 자몽허니블랙티 (5,300원)");
		System.out.println("5. 캬라멜 마키야또 (5,600원)");
		System.out.println("6. <스페셜> 해피 치즈 화이트 모카 (6,100원)");
		System.out.println("7. <스페셜> 골든 세서미 라떼 (6,100원)");
		System.out.println("---------------------------------");	
		if(usingCoupon) {
			System.out.println("<<알림 : 쿠폰 사용은 별이 지급되지 않습니다>>");
		}else {
			if(grade==true) {
				System.out.println("<<알림 : 스페셜 메뉴는 별이 2개 지급됩니다>>");			
			}else {
				System.out.println("<< 당신은 그린 레벨입니다 >>");
				System.out.println("<< 골드 레벨 조건 : 커피 5번 구매>>");
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
		System.out.println("<<커피 제조중>>");
		System.out.print("제");
		delay(1*500);
		System.out.print("조");
		delay(1*500);
		System.out.print("중");
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
		System.out.println("주문하신 "+IceOrHot[iceHotChoice]+coffeeManu[manuNumb-1]+"가 나왔습니다!!!");
		
	}
	public void makeCoupon() {
		if(star>=12) {
			star = star-12;
			coupon++;
			System.out.println("쿠폰이 지급되었습니다! 확인해보세요!");
		}
	}
	public void goldMSG() {
				System.out.println("<<경축>>");
				System.out.println("골드 레벨로 승급하셨습니다!");
				System.out.println("축 하 드 립 니 다 !");
				grade=true;
	}
	public void usingCoupon(int use) {
		if(use==1) { //use = 1 yes
			usingCoupon=true;
			System.out.println("쿠폰을 사용합니다. ");
			System.out.println("모든 메뉴가 무료로 구매 가능하며, 별은 적립되지 않습니다.");
		}else if(use==2) { //use =2 No.
			usingCoupon=false;			
			System.out.println("쿠폰을 사용하지 않습니다.");
		}
	}
	public void noMoney(int money) { //돈 검사
			System.out.println("갖고 있는 돈보다 커피가 비싸 구매할 수 없습니다.");
			System.out.println("구매하려는 커피 가격 : "+coffeePrice[money-1]);
			System.out.println("보유하는 돈 : "+myMoney);
			System.out.println("돈을 더 벌어와주세요");
	}

	

	

}
