package kakao200509;

import java.util.Scanner;


public class Kakao1 {

	public static void main(String[] args) {
		String answer = "";
		int leftPosi=-1; //-1 = *
		int rightPosi=-1; // -1 = #
		Scanner sc = new Scanner(System.in);
		System.out.println("numbers 배열 크기 : ");
		int numberSize = sc.nextInt();
		int [] numbers = new int[numberSize]; 
		
		for(int i = 0; i<numberSize ; i++ ) {
			System.out.print("넘버"+i+" : ");	
			numbers[i] = sc.nextInt();
		}
		System.out.print("무슨손잡이 : ");
		String hand = sc.next();
		
		for(int i=0; i<numbers.length ; i++) {
			if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
				answer += "L";
				leftPosi = numbers[i];
			} else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9) {
				answer += "R";
				rightPosi = numbers[i];				
			}else if(numbers[i]==2 || numbers[i]==5) {
				if(hand.equals("right") ) {
					//오른손잡이일때,
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "R";
						rightPosi = numbers[i];							
					}else if(leftPosi==-1){
						answer += "R";
						rightPosi = numbers[i];							
					}else if(rightPosi==-1) {
						answer += "L";
						leftPosi = numbers[i];								
					}else {
						if(rightPosi-leftPosi==2) {
							answer += "R";
							rightPosi = numbers[i];						
						}else if(numbers[i]-leftPosi<rightPosi-numbers[i]){
							answer += "L";
							leftPosi = numbers[i];								
						}else {
							answer += "R";
							rightPosi = numbers[i];									
						}
					}
				} else {
					//왼손잡이일때.
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "L";
						leftPosi = numbers[i];								
					}else if(leftPosi==-1){
						answer += "R";
						rightPosi = numbers[i];							
					}else if(rightPosi==-1) {
						answer += "L";
						leftPosi = numbers[i];								
					}else {
						if(rightPosi-leftPosi==2) {
							answer += "L";
							leftPosi = numbers[i];						
						}else if(numbers[i]-leftPosi<rightPosi-numbers[i]){
							answer += "L";
							leftPosi = numbers[i];								
						}else {
							answer += "R";
							rightPosi = numbers[i];									
						}
					}					
				}
			}else if(numbers[i]==8) {
				if(hand.equals("right")) {
					//오른손잡이일때
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "R";
						rightPosi = numbers[i];							
					}else if(leftPosi==-1 && rightPosi!=1){
						answer += "R";
						rightPosi = numbers[i];							
					}else if(rightPosi==-1 && leftPosi!=1) {
						answer += "L";
						leftPosi = numbers[i];								
					}else {
						if(rightPosi-leftPosi==2) {
							answer += "R";
							rightPosi = numbers[i];						
						}else if(numbers[i]-leftPosi<rightPosi-numbers[i]){
							answer += "L";
							leftPosi = numbers[i];								
						}else {
							answer += "R";
							rightPosi = numbers[i];									
						}
					}	
				}else {
					//왼손잡이일때.
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "L";
						leftPosi = numbers[i];								
					}else if(leftPosi==-1 && rightPosi!=1){
						answer += "R";
						rightPosi = numbers[i];							
					}else if(rightPosi==-1 && leftPosi!=1) {
						answer += "L";
						leftPosi = numbers[i];								
					}else {
						if(rightPosi-leftPosi==2) {
							answer += "L";
							leftPosi = numbers[i];						
						}else if(numbers[i]-leftPosi<rightPosi-numbers[i]){
							answer += "L";
							leftPosi = numbers[i];								
						}else {
							answer += "R";
							rightPosi = numbers[i];									
						}
					}	
				}
			}else if(numbers[i]==0) {
				if(hand.equals("right")) {
					//오른손잡이일때
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "R";
						rightPosi = numbers[i];							
					}else if(leftPosi==-1){
						answer += "L";
						leftPosi = numbers[i];												
					}else if(rightPosi==-1) {
						answer += "R";
						rightPosi = numbers[i];									
					}else {
						if(rightPosi-leftPosi>0) {
							answer += "R";
							rightPosi = numbers[i];						
						}else {
							answer += "L";
							leftPosi = numbers[i];									
						}
					}	
				}else {
					//왼손잡이일때.
					if(leftPosi==-1 && rightPosi==-1) {
						//* # 일때
						answer += "L";
						leftPosi = numbers[i];								
					}else if(leftPosi==-1){
						answer += "L";
						leftPosi = numbers[i];							
					}else if(rightPosi==-1) {
						answer += "R";
						rightPosi = numbers[i];							
					}else {
						if(rightPosi-leftPosi<0) {
							answer += "R";
							rightPosi = numbers[i];						
						}else {
							answer += "L";
							leftPosi = numbers[i];									
						}
					}	
				}				
				
			}
		}
		System.out.println("result");
		System.out.println(answer);
	}

}
