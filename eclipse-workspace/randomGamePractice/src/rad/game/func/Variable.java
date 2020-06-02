package rad.game.func;

import java.util.Scanner;
import java.util.Random;

public class Variable {
	public void RandomGame() {
	
		Scanner sc4 = new Scanner(System.in);
		Random r = new Random();
	
		while(true)
		{
			System.out.println("========== ���� �ǽ� ���� ���� ���� =========");
			System.out.println("1. �ǽ����� : Up And Down");
			System.out.println("2. �ǽ����� : BaskinRobbins 31");
			System.out.println("3. �ǽ����� : Dice");
			System.out.println("4. ���α׷� ����");
			System.out.print("���� >>");
			int gameSelect = sc4.nextInt();
			if(gameSelect <1 || gameSelect >4) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}else if(gameSelect == 4) {
				System.out.println("������ �����մϴ�");
				break;
			}else {
				switch(gameSelect) {
				case 1 :// Up & Down Game
					int highScore = 0;
					int count = 1;
					int answer = r.nextInt(99) + 1;
					
					while (true) {
						System.out.println("===Up & Down Game===");
						System.out.println("1. Game Start");
						System.out.println("2. Game Score");
						System.out.println("3. End Game");
						int selectInGame = sc4.nextInt();
	
						if (selectInGame > 3 || selectInGame < 1) {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("������ �����մϴ�");
							break;
						}
	
						switch (selectInGame) {
						case 1:
							System.out.println("===Game Start===");
							while (true) {
								System.out.print(count + "ȸ�� ��ȣ �Է�:");
								int userInput = sc4.nextInt();
	
								if (userInput < 1 || userInput > 99) {
									System.out.println("<<������ �´� ���ڸ� �־��ּ���>>");
									count++;
								} else if (userInput > answer) {
									System.out.println("<<DOWN>>");
									count++;
								} else if (userInput < answer) {
									System.out.println("<<UP>>");
									count++;
								} else {
									System.out.println("<<<����>>>");
									System.out.println("�� " + count + "ȸ �ɷȽ��ϴ�.");
									if (count < highScore || highScore == 0) {
										highScore = count;
									}
									count = 1;
									break;
								}
							}
							break;
						case 2:
							if (highScore == 0) {
								System.out.println("���� �ְ� ����� �����ϴ�. ���Ӱ� �����غ�����!");
							} else {
								System.out.println("���� �ְ� �����" + highScore + "ȸ �Դϴ�.");
							}
							break;
						}
					}				
					break;
				
				case 2 : // Baskin Robbins 31 Game
	
					int userWin = 0;
					int userLose = 0;
					int userDraw = 0;
					int mainCount = 0;
	
					while (true) {
						System.out.println("===Baskin Robbins 31===");
						System.out.println("1. Game Start");
						System.out.println("2. Game Score");
						System.out.println("3. End Game");
						int selectInGame = sc4.nextInt();
	
						if (selectInGame > 3 || selectInGame < 1) {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("������ �����մϴ�");
							break;
						}
	
						switch (selectInGame) {
						case 1:
							System.out.println("<< Game Start >>");
							while (true) {
								System.out.println("<< Your Turn >>");
								System.out.print("Input Number :");
								int userCount = sc4.nextInt();
								if (userCount < 1 || userCount > 3) {
									System.out.println("�߸� �Է��ϼ̽��ϴ�");
								} else {
									for (int i = 1; i <= userCount; i++) {
										System.out.println((++mainCount) + "!");
										if (mainCount >= 31) {
											System.out.println("����� �����ϴ٤� ��");
											userLose++;
											break;
										}
									}
									if (mainCount < 31) {
										System.out.println("<< Computer Turn >>");
										int comCount = r.nextInt(3) + 1;
										for (int i = 1; i <= comCount; i++) {
											System.out.println((++mainCount) + "!");
											if (mainCount >= 31) {
												System.out.println("����� �̰���ϴ�!!!");
												userWin++;
												break;
											}
										}
									}
								}
								if (mainCount >= 31) {
									mainCount = 0;
									break;
								}
							}
							break;
	
						case 2:
							System.out.println("<< ����� ���� >>");
							System.out.println("WIN :" + userWin);
							System.out.println("LOSE :" + userLose);
							System.out.println("DRAW :" + userDraw);
							break;
						}
					}	
					break;
				case 3 :
					// Dice Game
	
					int myMoney = 10000;
					int diceWin = 0;
					int diceLose = 0;
					int diceDraw = 0;
	
					while (true) {
	
						System.out.println("=== Dice Game ===");
						System.out.println("1. Game Start");
						System.out.println("2. Game Score");
						System.out.println("3. End Game");
						int selectInGame = sc4.nextInt();
	
						if (selectInGame > 3 || selectInGame < 1) {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("������ �����մϴ�");
							break;
						}
						switch (selectInGame) {
						case 1:
							while (true) {
								int dice1 = r.nextInt(6) + 1;
								int dice2 = r.nextInt(6) + 1;
								int dice3 = r.nextInt(6) + 1;
								int diceSum = dice1 + dice2 + dice3;
	
								System.out.println("=== Game Start ===");
								System.out.println("ù ��° �ֻ��� �� : " + dice1);
								System.out.println("�� ��° �ֻ��� �� : " + dice2);
								System.out.println("�� ��° �ֻ��� �� : " + dice3);
								System.out.println("�� �ֻ��� �� �� : " + diceSum);
								System.out.print("���� �Ͻðڽ��ϱ�? [y/n] :");
								char yesOrNo = sc4.next().charAt(0);
								if (yesOrNo == 'y') {
									System.out.printf("�󸶸� �����Ͻðڽ��ϱ�? (���� �� ������ : %d)", myMoney);
									int betMoney = sc4.nextInt();
									int comDice1 = r.nextInt(6) + 1;
									int comDice2 = r.nextInt(6) + 1;
									int comDice3 = r.nextInt(6) + 1;
									int comSum = comDice1 + comDice2 + comDice3;
									if (betMoney <= myMoney) {
										System.out.println("��ǻ�� ù ��° �ֻ��� �� : " + comDice1);
										System.out.println("��ǻ�� �� ��° �ֻ��� �� : " + comDice2);
										System.out.println("��ǻ�� �� ��° �ֻ��� �� : " + comDice3);
										System.out.println("��ǻ�� �ֻ��� �� �� : " + comSum);
										System.out.println("");
										System.out.println("<<���>>");
										if (diceSum > comSum) {
											System.out.println("�¸� !!!!!");
											System.out.println("+" + betMoney + "��!!!");
											myMoney += betMoney;
											diceWin++;
											System.out.println("���� �ִ� ��" + myMoney);
										} else if (diceSum == comSum) {
											System.out.println("�����ϴ� !!!!");
											System.out.println("������ �ݾ��� �״�� �����޽��ϴ�.");
											diceDraw++;
											System.out.println("���� �ִ� ��" + myMoney);
										} else {
											System.out.println("�����ϴ� �� ��");
											System.out.println("-" + betMoney + "���� ��");
											myMoney -= betMoney;
											diceLose++;
											System.out.println("���� �ִ� ��" + myMoney);
										}
										System.out.print("�� �� �� �Ͻðڽ��ϱ�? [y/n] :");
										char yesOrNoInGame = sc4.next().charAt(0);
										if (yesOrNoInGame == 'y') {
											continue;
										} else {
											break;
										}
									} else {
										System.out.println("�����ϰ� �ִ� ������ �����ϴ�");
									}
								} else {
									break;
								}
							}
							break;
						case 2: // ����
							System.out.println("<<<< ����� ���� >>>>");
							System.out.println("Win : " + diceWin);
							System.out.println("Lose : " + diceLose);
							System.out.println("Draw : " + diceDraw);
							System.out.println("�� ������ : " + myMoney);
						}
					}	
					break;
				}
			}
		}
	}
}
