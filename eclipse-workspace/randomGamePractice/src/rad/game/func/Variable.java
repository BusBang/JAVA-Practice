package rad.game.func;

import java.util.Scanner;
import java.util.Random;

public class Variable {
	public void RandomGame() {
	
		Scanner sc4 = new Scanner(System.in);
		Random r = new Random();
	
		while(true)
		{
			System.out.println("========== 난수 실습 문제 실행 파일 =========");
			System.out.println("1. 실습문제 : Up And Down");
			System.out.println("2. 실습문제 : BaskinRobbins 31");
			System.out.println("3. 실습문제 : Dice");
			System.out.println("4. 프로그램 종료");
			System.out.print("선택 >>");
			int gameSelect = sc4.nextInt();
			if(gameSelect <1 || gameSelect >4) {
				System.out.println("잘못 입력하셨습니다.");
			}else if(gameSelect == 4) {
				System.out.println("파일을 종료합니다");
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
							System.out.println("잘못 입력하셨습니다");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("게임을 종료합니다");
							break;
						}
	
						switch (selectInGame) {
						case 1:
							System.out.println("===Game Start===");
							while (true) {
								System.out.print(count + "회차 번호 입력:");
								int userInput = sc4.nextInt();
	
								if (userInput < 1 || userInput > 99) {
									System.out.println("<<범위에 맞는 숫자를 넣어주세요>>");
									count++;
								} else if (userInput > answer) {
									System.out.println("<<DOWN>>");
									count++;
								} else if (userInput < answer) {
									System.out.println("<<UP>>");
									count++;
								} else {
									System.out.println("<<<정답>>>");
									System.out.println("총 " + count + "회 걸렸습니다.");
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
								System.out.println("현재 최고 기록이 없습니다. 새롭게 갱신해보세요!");
							} else {
								System.out.println("현재 최고 기록은" + highScore + "회 입니다.");
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
							System.out.println("잘못 입력하셨습니다");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("게임을 종료합니다");
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
									System.out.println("잘못 입력하셨습니다");
								} else {
									for (int i = 1; i <= userCount; i++) {
										System.out.println((++mainCount) + "!");
										if (mainCount >= 31) {
											System.out.println("당신이 졌습니다ㅠ ㅠ");
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
												System.out.println("당신이 이겼습니다!!!");
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
							System.out.println("<< 당신의 전적 >>");
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
							System.out.println("잘못 입력하셨습니다");
						}
						if (selectInGame == 3) { // End Game
							System.out.println("게임을 종료합니다");
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
								System.out.println("첫 번째 주사위 값 : " + dice1);
								System.out.println("두 번째 주사위 값 : " + dice2);
								System.out.println("세 번째 주사위 값 : " + dice3);
								System.out.println("내 주사위 총 합 : " + diceSum);
								System.out.print("배팅 하시겠습니까? [y/n] :");
								char yesOrNo = sc4.next().charAt(0);
								if (yesOrNo == 'y') {
									System.out.printf("얼마를 배팅하시겠습니까? (현재 내 소지금 : %d)", myMoney);
									int betMoney = sc4.nextInt();
									int comDice1 = r.nextInt(6) + 1;
									int comDice2 = r.nextInt(6) + 1;
									int comDice3 = r.nextInt(6) + 1;
									int comSum = comDice1 + comDice2 + comDice3;
									if (betMoney <= myMoney) {
										System.out.println("컴퓨터 첫 번째 주사위 값 : " + comDice1);
										System.out.println("컴퓨터 두 번째 주사위 값 : " + comDice2);
										System.out.println("컴퓨터 세 번째 주사위 값 : " + comDice3);
										System.out.println("컴퓨터 주사위 총 합 : " + comSum);
										System.out.println("");
										System.out.println("<<결과>>");
										if (diceSum > comSum) {
											System.out.println("승리 !!!!!");
											System.out.println("+" + betMoney + "원!!!");
											myMoney += betMoney;
											diceWin++;
											System.out.println("갖고 있는 돈" + myMoney);
										} else if (diceSum == comSum) {
											System.out.println("비겼습니다 !!!!");
											System.out.println("배팅한 금액을 그대로 돌려받습니다.");
											diceDraw++;
											System.out.println("갖고 있는 돈" + myMoney);
										} else {
											System.out.println("졌습니다 ㅠ ㅠ");
											System.out.println("-" + betMoney + "원ㅠ ㅠ");
											myMoney -= betMoney;
											diceLose++;
											System.out.println("갖고 있는 돈" + myMoney);
										}
										System.out.print("한 번 더 하시겠습니까? [y/n] :");
										char yesOrNoInGame = sc4.next().charAt(0);
										if (yesOrNoInGame == 'y') {
											continue;
										} else {
											break;
										}
									} else {
										System.out.println("보유하고 있는 돈보다 적습니다");
									}
								} else {
									break;
								}
							}
							break;
						case 2: // 전적
							System.out.println("<<<< 당신의 전적 >>>>");
							System.out.println("Win : " + diceWin);
							System.out.println("Lose : " + diceLose);
							System.out.println("Draw : " + diceDraw);
							System.out.println("내 소지금 : " + myMoney);
						}
					}	
					break;
				}
			}
		}
	}
}
