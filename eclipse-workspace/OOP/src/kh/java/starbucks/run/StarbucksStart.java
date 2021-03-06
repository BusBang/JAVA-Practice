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
		System.out.println("********** 스타벅스 게임 ***********");
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
				sb.enterStarbucks(); //스타벅스 입장
				
				switch(sb.coupon) {
				case 0 : //쿠폰 없을 때
					sb.manu(); //메뉴판 보기
					System.out.print("선택 >> ");
					int selectCoffee = sc.nextInt(); //메뉴 선택	
					//돈검사
					if(sb.coffeePrice[selectCoffee-1]>sb.myMoney) {
						sb.noMoney(selectCoffee);
						break;
					}
					
					//ice/hot선택
					System.out.println("<<ice/Hot을 선택해주세요>>");
					System.out.println("(1. ice /2. Hot)");
					System.out.print("선택 >> ");
					int selectIce = sc.nextInt();
					sb.selectIce(selectIce);
					
					sb.makeCoffee(selectCoffee); //커피 제조
					
					if(sb.grade) {
						sb.starUpGold(selectCoffee);					
					}else{
						sb.starUpGreen(selectCoffee);
					}
					sb.makeCoupon();
					
					break;
				case 1 : //쿠폰 있을 때
					System.out.println("현재 쿠폰이 "+sb.coupon+"장 있습니다. ");
					System.out.println("쿠폰을 사용하시면 어떤 음료든 무제한으로 마실 수 있습니다.");
					System.out.println("하지만 쿠폰 사용시 별은 적립되지 않습니다.");
					System.out.println("쿠폰을 사용하시겠습니까? (1.Yes 2.No)");
					System.out.println("선택 >> ");
					int couponUse = sc.nextInt();
					sb.usingCoupon(couponUse);
					
					switch(couponUse) {
					case 1 : //쿠폰 사용하기 
						sb.manu(); //메뉴판 보기
						System.out.print("선택 >> ");
						int selectCoffee1 = sc.nextInt(); //메뉴 선택	
						//돈검사
						if(sb.coffeePrice[selectCoffee1-1]>sb.myMoney && sb.usingCoupon ==false) {
							sb.noMoney(selectCoffee1);
							break;
						}
						sb.myMoney += sb.coffeePrice[selectCoffee1-1]; //메뉴만큼 돈 추가 (구매오류 방지)
						
						//ice/hot선택
						System.out.println("<<ice/Hot을 선택해주세요>>");
						System.out.println("(1. ice /2. Hot)");
						System.out.print("선택 >> ");
						int selectIce1 = sc.nextInt();
						sb.selectIce(selectIce1);
						
						sb.makeCoffee(selectCoffee1); //커피 제조
						
						if(sb.grade) {
							sb.starUpGold(selectCoffee1);					
						}else{
							sb.starUpGreen(selectCoffee1);
						}
						sb.coupon--; //쿠폰 -1
						sb.usingCoupon=false; //쿠폰 미사용 상태로 전환
						
						break;
					case 2 : //쿠폰 미사용
						
						sb.manu(); //메뉴판 보기
						System.out.print("선택 >> ");
						int selectCoffee11 = sc.nextInt(); //메뉴 선택	
						//돈검사
						if(sb.coffeePrice[selectCoffee11-1]>sb.myMoney && sb.usingCoupon ==false) {
							sb.noMoney(selectCoffee11);
							break;
						}
						
						//ice/hot선택
						System.out.println("<<ice/Hot을 선택해주세요>>");
						System.out.println("(1. ice /2. Hot)");
						System.out.print("선택 >> ");
						int selectIce11 = sc.nextInt();
						sb.selectIce(selectIce11);
						
						sb.makeCoffee(selectCoffee11); //커피 제조
						
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
				System.out.println("게임을 종료하셨습니다");
				return;
			}

		}

		

	}

}
