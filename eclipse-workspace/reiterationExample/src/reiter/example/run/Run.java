package reiter.example.run;
import java.util.Scanner;
import java.util.Random;

public class Run {

	public static void main(String[] args) {
		/*
		//��ø for���� �̿��� ������ ��ü ��� (����)
		int i;
		int j;
		for(i=2;i<=9;i++) {
			for(j=1;j<=9;j++) {
				System.out.printf("%d*%d=%d	",i,j,i*j);
			}
			System.out.println();
		}
		
		
		
		//��ø for���� �̿��� ������ ��ü ��� (����)
		
		for(int j=1;j<=9;j++) {
			for(int i=2;i<=9;i++) {
				System.out.printf("%d*%d=%d\t",i,j,j*i);
			}
			System.out.println();
		}
				
		//����� Q1
		
		for(int i=1;i<=5;i++) {
			System.out.print("*");
		}
		
		
		//����� Q2
		
		for(int i=1;i<=5;i++) {
			System.out.print("*");
			System.out.println();
		}

		
		//����� Q3
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//����� Q4
		for(int i=1; i<=5;i++) {
			for(int j=1; j<=5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		//����� Q5
		for(int i=1; i<=5;i++) {
			for(int j=1; j<=5;j++) {
				System.out.print(j);
			}
			System.out.println();
		}		
		
		//����� Q6
		for(int i=1; i<=5;i++) {
			for(int j=i; j<=i+4; j++) {
					System.out.print(j);
			}System.out.println();
		}
		//����� Q7
		for(int i=5; i>=1;i--) {
			for(int j=i; j<=i+4;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
				
		//����� Q8
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//����� Q9
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}System.out.println();
		}
		
		//����� Q10
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}
		
			System.out.println();
		}
		//����� Q11
		for(int i=1;i<=5;i++) {
			for(int j=4;j>=i;j--) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
				
		//����� Q12
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print("*");
			}
			for(int j=5;j>=i;j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}
			for(int j=1;j<=i-1;j++) {
				System.out.print("");
			}
			System.out.println();
		}
		
		//����� Q13
		for(int i=1;i<=5;i++) {
			for(int j=5;j>=i;j--) {
				System.out.print("*");
			}
			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i+1;j++) {
				System.out.print("*");
			}
			for(int j=4;j>=i;j--) {
				System.out.print(" ");
			}
			System.out.println();
		}

		//����� Q12-2
		for(int i=1;i<=10;i++) {
			if(i<=6) {
				for(int j=1;j<=i-1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}else {
				for(int j=10;j>=i;j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		//����� Q13-2
		for(int i=1;i<=9;i++) {
			if(i<=4) {
				for(int j=0;j<=5-i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}else {
				for(int j=0;j<=i-5;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		//����� Q16
		for(int i=1; i<=5; i++) {
			for(int j=1;j<=5-i;j++){
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");	
			}
		System.out.println();
		}
		
		
		//����� Q17
		for(int i=1; i<=5; i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print(" ");
			}
			for(int j=9;j>=2*i-1;j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		//����� Q18
		for(int i=1; i<=9;i++) {
			if(i<=4) {
				for(int j=4;j>=i;j--) {
					System.out.print(" ");
				}
				for(int j=1;j<=2*i-1;j++) {
					System.out.print("*");
				}
			}else {
				for(int j=6;j<=i;j++) {
					System.out.print(" ");
				}
				for(int j=17;j>=2*i-1;j--) {
					System.out.print("*");
				}
			}System.out.println();
		}
		
		//����� Q19
		for(int i=1;i<=9;i++) {
			if(i<=5) {
				for(int j=1;j<=6-i;j++) {
					System.out.print("*");
				}
				for(int j=1;j<=2*i-1;j++) {
					System.out.print(" ");
				}
				for(int j=1;j<=6-i;j++) {
					System.out.print("*");
				}
			}else {
				for(int j=5;j<=i;j++) {
					System.out.print("*");
				}
				for(int j=17;j>=2*i-1;j--) {
					System.out.print(" ");
				}
				for(int j=5;j<=i;j++) {
					System.out.print("*");
				}
			}
			System.out.println();	
		}

		//����� Q20
		for(int i=1;i<=9;i++) {
			if(i<=5) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
				for(int j=9;j>=2*i-1;j--) {
					System.out.print(" ");
				}
				for(int j=1;j<=i;j++) {
					System.out.print("*");
				}
			}else {
				for(int j=9;j>=i;j--) {
					System.out.print("*");
				}
				for(int j=9;j<=2*i-1;j++) {
					System.out.print(" ");
				}
				for(int j=9;j>=i;j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		//����� Q21
		for(int i=1;i<=9;i++) {
			if(i<=5) {
				for(int j=1;j<=i;j++) {
					System.out.print(" ");
				}
				for(int j=9;j>=2*i-1;j--) {
					System.out.print("*");
				}
				for(int j=1;j<=i;j++) {
					System.out.print(" ");
				}
			}else {
				for(int j=9;j>=i;j--) {
					System.out.print(" ");
				}
				for(int j=9;j<=2*i-1;j++) {
					System.out.print("*");
				}
				for(int j=9;j>=i;j--) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		*/
		//random test
		Random r = new Random();
		int randomDice = r.nextInt(6)+1;
		
		int test = r.nextInt(6)+1+r.nextInt(6)+1+r.nextInt(6)+1;
		
		System.out.println(test);


		
		
	}	
}


