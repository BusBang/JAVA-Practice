package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Drink;
import kh.java.vo.Goods;
import kh.java.vo.InstantFood;
import kh.java.vo.Medicine;
import kh.java.vo.Snack;

public class ConMgr {
	Scanner sc = new Scanner(System.in);
	
	Drink [] d = new Drink[10];
	int dIndex;
	Snack [] s = new Snack[10];
	int sIndex;
	Medicine [] m = new Medicine[10];
	int mIndex;
	InstantFood [] i = new InstantFood[10];
	int iIndex;
	Goods [] etc = new Goods[10];
	int eIndex;
	//장바구니
	Goods [] cart = new Goods[10];
	int cIndex;
	
	//값 생성자를 위한 생성자
	public ConMgr() {
		d[dIndex++] = new Drink("스프라이트", 2000, 100, false, 550, 180);
		d[dIndex++] = new Drink("코카콜라", 1900, 150, false, 550, 200);
		d[dIndex++] = new Drink("클라우드", 3000, 50, true, 350, 350);
		
		i[iIndex++] = new InstantFood("혜자도시락", 4000, 5, false, "2020-02-12", 550);
		i[iIndex++] = new InstantFood("창렬도시락", 15000, 15, false, "2020-02-15", 350);
		i[iIndex++] = new InstantFood("삼각김밥", 1000, 50, false, "2020-02-20", 300);
		
		m[mIndex++] = new Medicine("타이레놀", 3000, 5, false, "2020-09-30");
		m[mIndex++] = new Medicine("부루펜", 2000, 7, false, "2020-09-30");
		m[mIndex++] = new Medicine("게보린", 4000, 10, false, "2020-07-30");
		
		s[sIndex++] = new Snack("꼬북칩", 1000, 200, false, 300, 200);
		s[sIndex++] = new Snack("콘칩", 800, 100, false, 250, 150);
		s[sIndex++] = new Snack("떡볶이", 1500, 150, false, 150, 80);
		s[sIndex++] = new Snack("맛동산", 2500, 50, false, 400, 30);
		s[sIndex++] = new Snack("뿌셔뿌셔", 1000, 230, false, 150, 120);

		etc[eIndex++] = new Goods("황사마스크", 1500, 500, false);
		etc[eIndex++] = new Goods("우산", 5500, 50, false);
		etc[eIndex++] = new Goods("면도기", 3000, 10, false);
		etc[eIndex++] = new Goods("수건", 4000, 10, false);
	}
	
	public void main() {
		while(true) {
			System.out.println("====== GS25 ======");
			System.out.println("당신은 누구입니까 ? ");
			System.out.println("1. 직원");
			System.out.println("2. 손님");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			System.out.println();
			switch(select) {
			case 1 :
				host();
				break;
			case 2 :
				customer();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	public void host() {
		System.out.println("------<직원 메뉴>------");
		System.out.println("1. 제품 등록");
		System.out.println("2. 재고 현황 보기");
		System.out.println("3. 재고 변경");
		System.out.println("4. 제품 삭제");
		System.out.println("0. 뒤로가기");
		System.out.print("선택 >> ");
		int selectHost = sc.nextInt();
		switch(selectHost) {
		case 1:
			insertProduct();
			break;
		case 2:
			printArr(d,dIndex);
			printSnack();
			printArr(i,iIndex);
			printMedicine();
			printETC();
			break;
		case 3 :
			updateProduct();
			break;
		case 4 :
			deleteProduct();
			break;
		case 0 :
			System.out.println("뒤로갑니다.");
			return;
			default : System.out.println("잘못 선택하셨습니다. 다시 입력해주세요.");
		}
	}
	//Delete Product : Case 4
	private void deleteProduct() {
		while(true) {
			System.out.println("------<제품 등록>------");
			System.out.println("1. 음료 삭제");
			System.out.println("2. 과자 삭제");
			System.out.println("3. 즉석 식품 삭제");
			System.out.println("4. 의약품 삭제");
			System.out.println("5. 기타 상품 삭제");
			System.out.println("0. 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1 :
				printDrink();
				dIndex = deleteProduct(d,dIndex);
				break;
			case 2 :
				printSnack();
				sIndex = deleteProduct(s,sIndex);
				break;
			case 3 :
				printInstantFood();
				iIndex = deleteProduct(i,iIndex);
				break;
			case 4 :
				printMedicine();
				mIndex = deleteProduct(m,mIndex);
				break;
			case 5 :
				printETC();
				eIndex = deleteProduct(etc,eIndex);

				break;
			case 0 : 
				System.out.println("돌아갑니다.");
				return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			
			}	
		}
	}
	//deleteProduct : case 4 (Overloading)
	private int deleteProduct(Goods[] category, int categoryIndex) {
		System.out.print("삭제할 제품의 No를 입력하세요. >>");
		int number = sc.nextInt()-1;
		System.out.println("["+category[number].getName()+"] 제품을 선택하셨습니다.");
		System.out.print("해당 제품을 정말로 삭제하시겠습니까? [y/n]");
		char real = sc.next().charAt(0);
		if(real=='y') {
			for(int k=number;k<categoryIndex-1;k++) {
				category[k] = category[k+1];
			}
			category[categoryIndex-1]=null;
			categoryIndex--;
		}else {
			System.out.println("삭제 작업 취소");
		}
		return categoryIndex;
	}

	//InsertProduct : case 1
	public void insertProduct() {
		while(true) {
			System.out.println("------<제품 등록>------");
			System.out.println("1. 음료 등록");
			System.out.println("2. 과자 등록");
			System.out.println("3. 즉석 식품 등록");
			System.out.println("4. 의약품 등록");
			System.out.println("5. 기타 상품 등록");
			System.out.println("0. 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			if(select==0) {
				return;
			}else if(0<select && select<6) {
				System.out.print("상품명을 입력하세요 : ");
				String name = sc.next();
				System.out.print("상품 가격을 입력하세요 : ");
				int price = sc.nextInt();
				System.out.print("상품 수량을 입력하세요 : ");
				int stock = sc.nextInt();
				System.out.print("주료/담배입니까? [y/n]");
				char ch = sc.next().charAt(0);
				boolean adult = (ch=='y')?true:false;
				switch(select) {
				case 1: //음료 카테고리
					System.out.print("음료의 용량을 입력하세요 (ml) :");
					int amount = sc.nextInt();
					System.out.print("음료의 칼로리를 입력하세요 (kcal) :");
					int kcal = sc.nextInt();
					d[dIndex++] = new Drink(name,price,stock,adult,amount,kcal);
					break;
				case 2 : //과자 카테고리
					System.out.print("과자의 칼로리를 입력하세요 (kcal) :");
					int weight = sc.nextInt();
					System.out.print("과자의 중량을 입력하세요 (kcal) :");
					int sKcal = sc.nextInt();
					s[sIndex++]= new Snack(name, price, stock, adult, sKcal, weight);
					break;
				case 3 : //즉석 식품 등록 
					System.out.print("즉석식품의 유통기한을 입력하세요 (2020-02-02) : ");
					String iExpired = sc.next();
					System.out.print("즉석식품의 칼로리를 입력하세요 (kcal) : ");
					int iKcal = sc.nextInt();
					i[iIndex++] = new InstantFood(name, price, stock, adult, iExpired, iKcal);
					break;
				case 4 : //의약품 등록
					System.out.print("의약품의 유통기한을 입력하세요 (2020-02-02) : ");
					String mExpired = sc.next();
					m[mIndex++] = new Medicine(name, price, stock, adult, mExpired);
					break; 
				case 5 : //기타 상품 등록
					etc[eIndex++] = new Goods(name, price, stock, adult);
					break;
				}
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	//PrintGoods : case 2
	public void printArr(Goods[] product, int index) {
		for(int k=0; k<index; k++) {
			System.out.println((k+1)+"\t"+product[k]);
		}
	}
	
	public void printDrink() {
		System.out.println("------<음료>------");
		System.out.println("NO\t제품명\t가격\t재고\t성인여부\t용량\t칼로리");
		for(int i=0;i<dIndex;i++) {
			System.out.println((i+1)+"\t"+d[i]);
		}
	}
	public void printInstantFood() {
		System.out.println("----<즉석 식품>----");
		System.out.println("NO\t제품명\t가격\t재고\t성인여부\t유통기한\t칼로리");
		for(int j=0;j<iIndex;j++) {
			System.out.println((j+1)+"\t"+i[j].getName()+"\t"+i[j].getPrice()+"\t"+i[j].getStock()
									+"\t"+(i[j].getAdult()?"O":"X")+"\t"+i[j].getExpired()+"\t"+i[j].getKcal());
		}
	}
	public void printMedicine() {
		System.out.println("-----<의약품>-----");
		System.out.println("NO\t제품명\t가격\t재고\t성인여부\t유통기한");
		for(int i=0;i<mIndex;i++) {
			System.out.println((i+1)+"\t"+m[i].getName()+"\t"+m[i].getPrice()+"\t"+m[i].getStock()
									+"\t"+(m[i].getAdult()?"O":"X")+"\t"+m[i].getExpired());
		}
	}
	public void printSnack() {
		System.out.println("------<과자>------");
		System.out.println("NO\t제품명\t가격\t재고\t성인여부\t용량\t칼로리");
		for(int i=0;i<sIndex;i++) {
			System.out.println((i+1)+"\t"+s[i].getName()+"\t"+s[i].getPrice()+"\t"+s[i].getStock()
									+"\t"+(s[i].getAdult()?"O":"X")+"\t"+s[i].getWeight()+"\t"+s[i].getKcal());
		}
	}
	public void printETC() {
		System.out.println("------<기타>------");
		System.out.println("NO\t제품명\t가격\t재고\t성인여부");
		for(int i=0;i<eIndex;i++) {
			System.out.println((i+1)+"\t"+etc[i].getName()+"\t"+etc[i].getPrice()+"\t"+etc[i].getStock()
									+"\t"+(etc[i].getAdult()?"O":"X"));
		}
	}
	
	//UpdateProduct : case 3
	public void updateProduct() {
		while(true) {
			System.out.println("------<재고 변경>------");
			System.out.println("1. 음료 재고 변경");
			System.out.println("2. 과자 재고 변경");
			System.out.println("3. 즉석 식품 재고 변경");
			System.out.println("4. 의약품 재고 변경");
			System.out.println("5. 기타 상품 재고 변경");
			System.out.println("0. 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt(); //다형성 이용
			switch(select) {
			case 1:
				printDrink();
				updateProduct(d);
				break;
			case 2:
				printSnack();
				updateProduct(s);
				break;
			case 3:
				printInstantFood();
				updateProduct(i);
				break;
			case 4:
				printMedicine();
				updateProduct(m);
				break;
			case 5:
				printETC();
				updateProduct(etc);
				break;
			case 0:
				System.out.println("이전으로 되돌아갑니다.");
				return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
			
		}
	}
	
	//UpdateProduct : case 3 (Overloading)
	public void updateProduct(Goods[] category) {
		System.out.print("재고를 변경할 상품의 No를 선택해 주세요 >");
		int index = sc.nextInt()-1;
		System.out.println(category[index].getName()+"제품을 선택하셨습니다.");
		System.out.println("현재 재고는 "+category[index].getStock()+"개 입니다.");
		System.out.print("몇 개로 바꾸시겠습니까? >");
		int modiNumber = sc.nextInt();
		category[index].setStock(modiNumber);
		System.out.println("재고 변경이 완료되었습니다.");
	}

	public void customer() {
		System.out.println("어서오세요 ~~~");
		while(true) {
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 장바구니 보기");
			System.out.println("0. 뒤로가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1: 
				buyProduct();
				break;
			case 2 :
				cartList();
				break;
			case 0 :
				System.out.println("메인 화면으로 돌아갑니다.");
				return;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	//장바구니 보기 : case 2
	private void cartList() {
		System.out.println("------<장바구니>------");
		System.out.println("제품명\t가격\t수량\t합계");
		int totalPrice = 0; 
		for(int i=0;i<cIndex;i++) {
			System.out.println(cart[i].getName()+"\t"+cart[i].getPrice()+"\t"+cart[i].getStock()+"\t"+cart[i].getStock()*cart[i].getPrice());
			totalPrice += cart[i].getStock()*cart[i].getPrice();
		}
		System.out.println("--------------------");
		System.out.println("총 금액은 "+totalPrice+"원 입니다. ");
	}

	//buyProduct : case 1 
	private void buyProduct() {
		while(true) {
			System.out.println("------<쇼핑하기>------");
			System.out.println("1. 음료");
			System.out.println("2. 과자");
			System.out.println("3. 즉석 식품");
			System.out.println("4. 의약품");
			System.out.println("5. 기타 상품");
			System.out.println("0. 돌아가기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				printDrink();
				buyProduct(d);
				break;
			case 2:
				printSnack();
				buyProduct(s);
				break;
			case 3:
				printInstantFood();
				buyProduct(i);
				break;
			case 4 :
				printMedicine();
				buyProduct(m);
				break;
			case 5 :
				printETC();
				buyProduct(etc);
				break;
			case 0 :
				return;
				default : System.out.println("이전 화면으로 돌아갑니다..");
			}
		}
		
	}
	//buyProduct : case 1 (OverLoading)
	public void buyProduct(Goods[] product) {
		System.out.print("구매할 제품 번호 입력 : ");
		int index = sc.nextInt()-1;
		System.out.print("구매할 수량을 입력해주세요 : ");
		int count = sc.nextInt();
		if(count>product[index].getStock()) {
			System.out.println("재고가 부족합니다. ");
			System.out.println("이전 메뉴로 돌아갑니다. ");
			return;
		}else {
			System.out.println("["+product[index].getName()+"] 제품을 "+count+"개 선택하셨습니다. ");
			System.out.print("장바구니에 담으시겠습니까? [y/n]");
			char choice = sc.next().charAt(0);
			if(choice=='y') {
				//cart의 매개변수 - 가격, 재고, 상품 이름, 성인인증 필요 유무
				int price = product[index].getPrice();
				int stock = count;
				String name = product[index].getName();
				boolean adult = product[index].getAdult();
				cart[cIndex++] = new Goods(name,price,stock,adult);
				product[index].setStock(product[index].getStock()-count);				
			}else {
				System.out.println("취소하였습니다. ");
				System.out.println("이전으로 되돌아갑니다. ");
			}
		}
	}
}
