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
	//��ٱ���
	Goods [] cart = new Goods[10];
	int cIndex;
	
	//�� �����ڸ� ���� ������
	public ConMgr() {
		d[dIndex++] = new Drink("��������Ʈ", 2000, 100, false, 550, 180);
		d[dIndex++] = new Drink("��ī�ݶ�", 1900, 150, false, 550, 200);
		d[dIndex++] = new Drink("Ŭ����", 3000, 50, true, 350, 350);
		
		i[iIndex++] = new InstantFood("���ڵ��ö�", 4000, 5, false, "2020-02-12", 550);
		i[iIndex++] = new InstantFood("â�ĵ��ö�", 15000, 15, false, "2020-02-15", 350);
		i[iIndex++] = new InstantFood("�ﰢ���", 1000, 50, false, "2020-02-20", 300);
		
		m[mIndex++] = new Medicine("Ÿ�̷���", 3000, 5, false, "2020-09-30");
		m[mIndex++] = new Medicine("�η���", 2000, 7, false, "2020-09-30");
		m[mIndex++] = new Medicine("�Ժ���", 4000, 10, false, "2020-07-30");
		
		s[sIndex++] = new Snack("����Ĩ", 1000, 200, false, 300, 200);
		s[sIndex++] = new Snack("��Ĩ", 800, 100, false, 250, 150);
		s[sIndex++] = new Snack("������", 1500, 150, false, 150, 80);
		s[sIndex++] = new Snack("������", 2500, 50, false, 400, 30);
		s[sIndex++] = new Snack("�ѼŻѼ�", 1000, 230, false, 150, 120);

		etc[eIndex++] = new Goods("Ȳ�縶��ũ", 1500, 500, false);
		etc[eIndex++] = new Goods("���", 5500, 50, false);
		etc[eIndex++] = new Goods("�鵵��", 3000, 10, false);
		etc[eIndex++] = new Goods("����", 4000, 10, false);
	}
	
	public void main() {
		while(true) {
			System.out.println("====== GS25 ======");
			System.out.println("����� �����Դϱ� ? ");
			System.out.println("1. ����");
			System.out.println("2. �մ�");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
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
				System.out.println("���α׷��� �����մϴ�.");
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	public void host() {
		System.out.println("------<���� �޴�>------");
		System.out.println("1. ��ǰ ���");
		System.out.println("2. ��� ��Ȳ ����");
		System.out.println("3. ��� ����");
		System.out.println("4. ��ǰ ����");
		System.out.println("0. �ڷΰ���");
		System.out.print("���� >> ");
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
			System.out.println("�ڷΰ��ϴ�.");
			return;
			default : System.out.println("�߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		}
	}
	//Delete Product : Case 4
	private void deleteProduct() {
		while(true) {
			System.out.println("------<��ǰ ���>------");
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ����");
			System.out.println("3. �Ｎ ��ǰ ����");
			System.out.println("4. �Ǿ�ǰ ����");
			System.out.println("5. ��Ÿ ��ǰ ����");
			System.out.println("0. ���ư���");
			System.out.print("���� >> ");
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
				System.out.println("���ư��ϴ�.");
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			
			}	
		}
	}
	//deleteProduct : case 4 (Overloading)
	private int deleteProduct(Goods[] category, int categoryIndex) {
		System.out.print("������ ��ǰ�� No�� �Է��ϼ���. >>");
		int number = sc.nextInt()-1;
		System.out.println("["+category[number].getName()+"] ��ǰ�� �����ϼ̽��ϴ�.");
		System.out.print("�ش� ��ǰ�� ������ �����Ͻðڽ��ϱ�? [y/n]");
		char real = sc.next().charAt(0);
		if(real=='y') {
			for(int k=number;k<categoryIndex-1;k++) {
				category[k] = category[k+1];
			}
			category[categoryIndex-1]=null;
			categoryIndex--;
		}else {
			System.out.println("���� �۾� ���");
		}
		return categoryIndex;
	}

	//InsertProduct : case 1
	public void insertProduct() {
		while(true) {
			System.out.println("------<��ǰ ���>------");
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ���");
			System.out.println("3. �Ｎ ��ǰ ���");
			System.out.println("4. �Ǿ�ǰ ���");
			System.out.println("5. ��Ÿ ��ǰ ���");
			System.out.println("0. ���ư���");
			System.out.print("���� >> ");
			int select = sc.nextInt();
			if(select==0) {
				return;
			}else if(0<select && select<6) {
				System.out.print("��ǰ���� �Է��ϼ��� : ");
				String name = sc.next();
				System.out.print("��ǰ ������ �Է��ϼ��� : ");
				int price = sc.nextInt();
				System.out.print("��ǰ ������ �Է��ϼ��� : ");
				int stock = sc.nextInt();
				System.out.print("�ַ�/����Դϱ�? [y/n]");
				char ch = sc.next().charAt(0);
				boolean adult = (ch=='y')?true:false;
				switch(select) {
				case 1: //���� ī�װ�
					System.out.print("������ �뷮�� �Է��ϼ��� (ml) :");
					int amount = sc.nextInt();
					System.out.print("������ Į�θ��� �Է��ϼ��� (kcal) :");
					int kcal = sc.nextInt();
					d[dIndex++] = new Drink(name,price,stock,adult,amount,kcal);
					break;
				case 2 : //���� ī�װ�
					System.out.print("������ Į�θ��� �Է��ϼ��� (kcal) :");
					int weight = sc.nextInt();
					System.out.print("������ �߷��� �Է��ϼ��� (kcal) :");
					int sKcal = sc.nextInt();
					s[sIndex++]= new Snack(name, price, stock, adult, sKcal, weight);
					break;
				case 3 : //�Ｎ ��ǰ ��� 
					System.out.print("�Ｎ��ǰ�� ��������� �Է��ϼ��� (2020-02-02) : ");
					String iExpired = sc.next();
					System.out.print("�Ｎ��ǰ�� Į�θ��� �Է��ϼ��� (kcal) : ");
					int iKcal = sc.nextInt();
					i[iIndex++] = new InstantFood(name, price, stock, adult, iExpired, iKcal);
					break;
				case 4 : //�Ǿ�ǰ ���
					System.out.print("�Ǿ�ǰ�� ��������� �Է��ϼ��� (2020-02-02) : ");
					String mExpired = sc.next();
					m[mIndex++] = new Medicine(name, price, stock, adult, mExpired);
					break; 
				case 5 : //��Ÿ ��ǰ ���
					etc[eIndex++] = new Goods(name, price, stock, adult);
					break;
				}
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
		System.out.println("------<����>------");
		System.out.println("NO\t��ǰ��\t����\t���\t���ο���\t�뷮\tĮ�θ�");
		for(int i=0;i<dIndex;i++) {
			System.out.println((i+1)+"\t"+d[i]);
		}
	}
	public void printInstantFood() {
		System.out.println("----<�Ｎ ��ǰ>----");
		System.out.println("NO\t��ǰ��\t����\t���\t���ο���\t�������\tĮ�θ�");
		for(int j=0;j<iIndex;j++) {
			System.out.println((j+1)+"\t"+i[j].getName()+"\t"+i[j].getPrice()+"\t"+i[j].getStock()
									+"\t"+(i[j].getAdult()?"O":"X")+"\t"+i[j].getExpired()+"\t"+i[j].getKcal());
		}
	}
	public void printMedicine() {
		System.out.println("-----<�Ǿ�ǰ>-----");
		System.out.println("NO\t��ǰ��\t����\t���\t���ο���\t�������");
		for(int i=0;i<mIndex;i++) {
			System.out.println((i+1)+"\t"+m[i].getName()+"\t"+m[i].getPrice()+"\t"+m[i].getStock()
									+"\t"+(m[i].getAdult()?"O":"X")+"\t"+m[i].getExpired());
		}
	}
	public void printSnack() {
		System.out.println("------<����>------");
		System.out.println("NO\t��ǰ��\t����\t���\t���ο���\t�뷮\tĮ�θ�");
		for(int i=0;i<sIndex;i++) {
			System.out.println((i+1)+"\t"+s[i].getName()+"\t"+s[i].getPrice()+"\t"+s[i].getStock()
									+"\t"+(s[i].getAdult()?"O":"X")+"\t"+s[i].getWeight()+"\t"+s[i].getKcal());
		}
	}
	public void printETC() {
		System.out.println("------<��Ÿ>------");
		System.out.println("NO\t��ǰ��\t����\t���\t���ο���");
		for(int i=0;i<eIndex;i++) {
			System.out.println((i+1)+"\t"+etc[i].getName()+"\t"+etc[i].getPrice()+"\t"+etc[i].getStock()
									+"\t"+(etc[i].getAdult()?"O":"X"));
		}
	}
	
	//UpdateProduct : case 3
	public void updateProduct() {
		while(true) {
			System.out.println("------<��� ����>------");
			System.out.println("1. ���� ��� ����");
			System.out.println("2. ���� ��� ����");
			System.out.println("3. �Ｎ ��ǰ ��� ����");
			System.out.println("4. �Ǿ�ǰ ��� ����");
			System.out.println("5. ��Ÿ ��ǰ ��� ����");
			System.out.println("0. ���ư���");
			System.out.print("���� >> ");
			int select = sc.nextInt(); //������ �̿�
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
				System.out.println("�������� �ǵ��ư��ϴ�.");
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
			
		}
	}
	
	//UpdateProduct : case 3 (Overloading)
	public void updateProduct(Goods[] category) {
		System.out.print("��� ������ ��ǰ�� No�� ������ �ּ��� >");
		int index = sc.nextInt()-1;
		System.out.println(category[index].getName()+"��ǰ�� �����ϼ̽��ϴ�.");
		System.out.println("���� ���� "+category[index].getStock()+"�� �Դϴ�.");
		System.out.print("�� ���� �ٲٽðڽ��ϱ�? >");
		int modiNumber = sc.nextInt();
		category[index].setStock(modiNumber);
		System.out.println("��� ������ �Ϸ�Ǿ����ϴ�.");
	}

	public void customer() {
		System.out.println("������� ~~~");
		while(true) {
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ��� ����");
			System.out.println("0. �ڷΰ���");
			System.out.print("���� >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1: 
				buyProduct();
				break;
			case 2 :
				cartList();
				break;
			case 0 :
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}
	//��ٱ��� ���� : case 2
	private void cartList() {
		System.out.println("------<��ٱ���>------");
		System.out.println("��ǰ��\t����\t����\t�հ�");
		int totalPrice = 0; 
		for(int i=0;i<cIndex;i++) {
			System.out.println(cart[i].getName()+"\t"+cart[i].getPrice()+"\t"+cart[i].getStock()+"\t"+cart[i].getStock()*cart[i].getPrice());
			totalPrice += cart[i].getStock()*cart[i].getPrice();
		}
		System.out.println("--------------------");
		System.out.println("�� �ݾ��� "+totalPrice+"�� �Դϴ�. ");
	}

	//buyProduct : case 1 
	private void buyProduct() {
		while(true) {
			System.out.println("------<�����ϱ�>------");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. �Ｎ ��ǰ");
			System.out.println("4. �Ǿ�ǰ");
			System.out.println("5. ��Ÿ ��ǰ");
			System.out.println("0. ���ư���");
			System.out.print("���� >> ");
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
				default : System.out.println("���� ȭ������ ���ư��ϴ�..");
			}
		}
		
	}
	//buyProduct : case 1 (OverLoading)
	public void buyProduct(Goods[] product) {
		System.out.print("������ ��ǰ ��ȣ �Է� : ");
		int index = sc.nextInt()-1;
		System.out.print("������ ������ �Է����ּ��� : ");
		int count = sc.nextInt();
		if(count>product[index].getStock()) {
			System.out.println("��� �����մϴ�. ");
			System.out.println("���� �޴��� ���ư��ϴ�. ");
			return;
		}else {
			System.out.println("["+product[index].getName()+"] ��ǰ�� "+count+"�� �����ϼ̽��ϴ�. ");
			System.out.print("��ٱ��Ͽ� �����ðڽ��ϱ�? [y/n]");
			char choice = sc.next().charAt(0);
			if(choice=='y') {
				//cart�� �Ű����� - ����, ���, ��ǰ �̸�, �������� �ʿ� ����
				int price = product[index].getPrice();
				int stock = count;
				String name = product[index].getName();
				boolean adult = product[index].getAdult();
				cart[cIndex++] = new Goods(name,price,stock,adult);
				product[index].setStock(product[index].getStock()-count);				
			}else {
				System.out.println("����Ͽ����ϴ�. ");
				System.out.println("�������� �ǵ��ư��ϴ�. ");
			}
		}
	}
}
