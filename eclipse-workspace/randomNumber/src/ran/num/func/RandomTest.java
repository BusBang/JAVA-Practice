package ran.num.func;
import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	
	
	public void random1() {
		
		Random r = new Random();
		System.out.println(r.nextInt());
		
		//0���� 10�� ������ ���� ���� ����
		//0, 1, ..., 8, 9, 10
		int randomNumber1 = r.nextInt(10);
		System.out.println(randomNumber1);
		
		//0���� 31���� ���� �� ���� ���� ����
	}
	public void randomexample1() {

		Scanner sc1 = new Scanner(System.in);
		Random r = new Random();


		//0~9���� ���� �� ����
		int rand1 = r.nextInt(9);
		System.out.println("0~9������ ���� �� :" +rand1);

		//1~10���� ���� �� ����	
		System.out.println("1~10������ ���� �� :"+rand1 + 9);
		
		// ���� + ���۰�

		//20~35���� ���� �� ����
		int rand4= r.nextInt(16);
		int rand5 =r.nextInt(2);

		System.out.println("20~35������ ���� �� :" +(rand4) +20);
		
		System.out.println("0�Ǵ� 1"+rand4);
		
	}
	public void example2() {

		Scanner sc1 = new Scanner(System.in);
		Random r = new Random();
		int randomNumber = r.nextInt(2)+1;
		
		System.out.println("==== ���� �� �� ���߱� ====");
		int inputNumber = 0;

		while(true) {
			System.out.print("���ڸ� �Է����ּ���!");
			 inputNumber = sc1.nextInt();
			 
			if(inputNumber == 1 || inputNumber == 2) {
				if(inputNumber == randomNumber) {
					System.out.println("����!");
				}else {
					System.out.println("��!");	
				}
				System.out.print("��  �� �� [y/n] ?");
				char select = sc1.next().charAt(0);
				if(select == 'n') {
					break;
				}
			 }else {
				 System.out.println("1 �Ǵ� 2�� �־��ּ���");

			 }


		}
	}
	
	public void example3() {
		Scanner sc1 = new Scanner(System.in);
		Random r = new Random();
		System.out.println("=== ���������� ���� ===");
		System.out.print("���ڸ� �����ϼ��� (1.����/2.����/3.��):" );
		int select = sc1.nextInt();
		int computer = r.nextInt(3)+1;
		String user ="";
		String com ="";
		
		if(select==1) {
			user = "����";
		}else if(select==2) {
			user = "����";
		}else if(select==3) {
			user = "��";
		}
		
		if(computer==1) {
			com = "����";
		}else if(computer==2) {
			com = "����";
		}else if(computer==3) {
			com = "��";
		}
		System.out.println("=================");
		System.out.println("����� "+user+"�� �½��ϴ�");
		System.out.println("��ǻ�ʹ� "+com+"�� �½��ϴ�");
		System.out.println("=================");
		
		if(select == computer) {
			System.out.println("�����ϴ�");
		}else if(user.equals("����")&&com.equals("����") || "����".equals(user) && "��".equals(com) || user.equals("��") && "����".equals(com)) {
			System.out.println("����� �����ϴ٤Ф�");			
		}else {
			System.out.println("����� �̰���ϴ�^.^");			
		}
		//����.equlas("��Ʈ��")�� ����� �ڷᰪ�� ���ϴ� ���� �ƴ϶� ���� ���� ã�Ƽ� �����ش�.
		//�ݴ�� "��Ʈ��".equals(com)������ �յڰ� �ٲ� �ȴ�
		
		//����/����, ����/��, ��/����
		//1/2, 2/3, 3/1
		//������-��ǻ�ͼ��� = -1 or 2
		// if(select-computer==-1 || select-computer==2) { sout"�����ϴ�"};

		
	}
	public void example4() {
		
		Scanner sc4 = new Scanner(System.in);
		Random r = new Random();
		
		int gameNumber =0;
		int inGame =0;
		int answer = r.nextInt(99)+1;
		int situation=0;
		int highScore = 0;
		int count = 1;
		
			//Up & Down Game
		while(true) {

			System.out.println("===Up & Down Game===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			int selectInGame = sc4.nextInt();
			
			if(selectInGame>3 || selectInGame<1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			if(selectInGame==3) { 					//End Game
				System.out.println("������ �����մϴ�");
				break;
			}
			
			switch(selectInGame) {
			case 1 :
				System.out.println("===Game Start===");
				while(true) {

					System.out.print(count+"ȸ�� ��ȣ �Է�:");
					int userInput = sc4.nextInt();
					
					if(userInput<1 || userInput>99 ){
						System.out.println("<<������ �´� ���ڸ� �־��ּ���>>");
						count++;
					}else if(userInput>answer) {
						System.out.println("<<DOWN>>");
						count++;
					}else if(userInput<answer) {
						System.out.println("<<UP>>");
						count++;
					}else {
						System.out.println("<<<����>>>");
						System.out.println("�� "+count+"ȸ �ɷȽ��ϴ�.");
						if(count<highScore || highScore==0) {
							highScore = count;
						}
						count = 1;
						break;
					}
				}
			break;
			case 2:
				if(highScore==0) {
					System.out.println("���� �ְ� ����� �����ϴ�. ���Ӱ� �����غ�����!");
				} else {
					System.out.println("���� �ְ� �����"+highScore+"ȸ �Դϴ�.");				
				}
				break;
			}
		
		}
		
		//Baskin Robbins 31 Game
		
		int userWin = 0;
		int userLose = 0;
		int userDraw = 0;
		int mainCount = 0;
		
		while(true) {
			System.out.println("===Baskin Robbins 31===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			int selectInGame = sc4.nextInt();
			
			if(selectInGame>3 || selectInGame<1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			if(selectInGame==3) { 					//End Game
				System.out.println("������ �����մϴ�");
				break;
			}
			
			switch(selectInGame) {
				
			case 1:
				System.out.println("<< Game Start >>");
				while(true) {
					System.out.println("<< Your Turn >>");
					System.out.print("Input Number :");
					int userCount = sc4.nextInt();
					if(userCount<1||userCount>3) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}else {
						for(int i=1;i<=userCount; i++) {
							System.out.println((++mainCount)+"!");
							if(mainCount>=31) {
								System.out.println("����� �����ϴ٤� ��");
								userLose++;
								break;								
							}
						}
						if(mainCount<31) {
							System.out.println("<< Computer Turn >>");
							int comCount = r.nextInt(3)+1;
							for(int i=1; i<=comCount; i++) {
								System.out.println((++mainCount)+"!");
								if(mainCount>=31) {
									System.out.println("����� �̰���ϴ�!!!");
									userWin++;
									break;			
								}
							
							}
						}
					}
					if(mainCount>=31) {
						mainCount=0;
						break;
					}
				}	
			break;
			
			case 2:
				System.out.println("<< ����� ���� >>");
				System.out.println("WIN :"+userWin);
				System.out.println("LOSE :"+userLose);
				System.out.println("DRAW :"+userDraw);
			break;
			}
		}


		//Dice Game
		
		int myMoney = 10000;
		int diceWin = 0;
		int diceLose =0;
		int diceDraw =0;
			
		while(true) {

			System.out.println("=== Dice Game ===");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			int selectInGame = sc4.nextInt();
			
			if(selectInGame>3 || selectInGame<1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			if(selectInGame==3) { 					//End Game
				System.out.println("������ �����մϴ�");
				break;
			}
			switch(selectInGame) {
			case 1 :
				while(true) {
					int dice1 = r.nextInt(6)+1;
					int dice2 = r.nextInt(6)+1;
					int dice3 = r.nextInt(6)+1;
					int diceSum = dice1+dice2+dice3;
					
					System.out.println("=== Game Start ===");
					System.out.println("ù ��° �ֻ��� �� : "+dice1);
					System.out.println("�� ��° �ֻ��� �� : "+dice2);
					System.out.println("�� ��° �ֻ��� �� : "+dice3);
					System.out.println("�� �ֻ��� �� �� : "+diceSum);
					System.out.print("���� �Ͻðڽ��ϱ�? [y/n] :");
					char yesOrNo = sc4.next().charAt(0);
					if(yesOrNo=='y') {
						System.out.printf("�󸶸� �����Ͻðڽ��ϱ�? (���� �� ������ : %d)",myMoney);
						int betMoney = sc4.nextInt();
						int comDice1 = r.nextInt(6)+1;
						int comDice2 = r.nextInt(6)+1;
						int comDice3 = r.nextInt(6)+1;		
						int comSum = comDice1 + comDice2 + comDice3;
						if(betMoney<=myMoney) {
							System.out.println("��ǻ�� ù ��° �ֻ��� �� : "+comDice1);
							System.out.println("��ǻ�� �� ��° �ֻ��� �� : "+comDice2);
							System.out.println("��ǻ�� �� ��° �ֻ��� �� : "+comDice3);
							System.out.println("��ǻ�� �ֻ��� �� �� : "+comSum);
							System.out.println("");
							System.out.println("<<���>>");
							if(diceSum>comSum) {
								System.out.println("�¸� !!!!!");
								System.out.println("+"+betMoney+"��!!!");
								myMoney += betMoney;
								diceWin++;
								System.out.println("���� �ִ� ��"+myMoney);
							}else if(diceSum==comSum) {
								System.out.println("�����ϴ� !!!!");
								System.out.println("������ �ݾ��� �״�� �����޽��ϴ�.");
								diceDraw++;
								System.out.println("���� �ִ� ��"+myMoney);
							}else {
								System.out.println("�����ϴ� �� ��");
								System.out.println("-"+betMoney+"���� ��");
								myMoney -= betMoney;
								diceLose++;
								System.out.println("���� �ִ� ��"+myMoney);
							}
							System.out.print("�� �� �� �Ͻðڽ��ϱ�? [y/n] :");
							char yesOrNoInGame = sc4.next().charAt(0);
							if(yesOrNoInGame=='y') {
								continue;							
							}else {
								break;
							}	
						}else {
							System.out.println("�����ϰ� �ִ� ������ �����ϴ�");
						}
					}else {
						break;
					}
				}
			break;
			case 2 : //����
				System.out.println("<<<< ����� ���� >>>>");
				System.out.println("Win : "+diceWin);
				System.out.println("Lose : "+diceLose);
				System.out.println("Draw : "+diceDraw);
				System.out.println("�� ������ : "+myMoney);
			}
			
		}			
		
		
	}
	


	
				


}