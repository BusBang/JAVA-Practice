package kh.java.func;
import java.util.Scanner;
import java.util.Random;

public class BR {
	Scanner sc= new Scanner(System.in);
	Random r = new Random();
	int win = 0;
	int lose = 0;

	public void main() {
		while(true) {
			System.out.println("====== 베스킨 라빈스 ======");
			System.out.println("1. GAME START");
			System.out.println("2. GAME SCORE");
			System.out.println("3. END GAME");
			System.out.print("선택 >>");
			int sel = sc.nextInt();
			switch(sel) {
			case 1 :
				startGame();
				break;
			case 2 :
				score();
				break;
			case 3 :
				return;
			}
		}
	}
	public void startGame() {
		int count = 0;
		System.out.println("<<<Game Start>>>");
		while(true) {
			System.out.print("<<<Your Turn>>>");
			int userNum = sc.nextInt();
			countBR(userNum, count);
			if(count == 31) {
				System.out.println("패배");
				return;
			}		
			System.out.println("<<<Computer Turn>>>");
			int comNum = r.nextInt(3)+1;
			countBR(comNum, count);
			if(count == 31) {
					System.out.println("승리");
					return;
			}
		}
	}

	public void countBR(int count, int printNum) {
		for(int i=0;i<count;i++) {
			System.out.println(++printNum+"!");
		}
	
	}
	
	
	
	public void score() {
		
	}
	
}
