package kh.java; //패키지 이름

public class HelloJava /* 클래스이름 */ {

	public static void main/* 메소드 */(String[] args) {
		if (true) {
			System.out.println("들여쓰기 연습은 { 를 친다음에 바로 엔터를 치면 자동으로 구분이 된다");
		}

		System.out.println("HelloWorld"); // HelloWorld Message Print Out
		System.out.println("안녕");

		/*
		 * 주석연습 System.out.println("HelloWorld"); //HelloWorld Message Print Out
		 * System.out.println("안녕");
		 */

		// Ctrl+Shift+F : 자동으로 들여쓰기 맞춰주는 이클립스 기능
		System.out.println("HelloWorld"); // HelloWorld Message Print Out
		System.out.println("안녕");
		System.out.println("HelloWorld"); // HelloWorld Message Print Out
		System.out.println("안녕");

		// TODO Auto-generated method stub

	}

}

// 프로젝트 이름, 메소드 이름은 카멜 표기법을 쓴다.
// 프로젝트 이름 : fisrtProject
// 메인메소드 이름 : main

// 패키지 이름은 모두 소문자, 단어와 단어 사이를 .으로 권고 --> kh.java

// 클래스이름은 파스칼 표기법을 사용. HelloJava

/* 들여쓰기 방식 3가지 - GNU, K&R, BSD */
/* 중괄호가 하나 나오면 한 칸 들여쓴다. */
/*
 * 이클립스에서 지원하는 방식은 K&R GNU는 아예 엔터를 치고 새롭게 중괄호를 씀
 */
/*
 * GNU if(true) { System.out.println("안녕") }
 */


//실행클래스와 기능제공 클래스
/* 1. 실행클래스
 * 메인메소드(실행메소드)를 가지고 있는 클래스. (main이 대표적인 실행 클래스. 메인 메소드를 갖고 있는 클래스)
 * 메인메소드가 프로젝트당 1개 -> 실행클래스도 프로젝트당 1개 존재
 * 실행클래스의 메인 메소드에서는 기능 제공 크래스에서 작성한 기능을 실행하는 용도로만 사용. 기능은 구현하지 않음
 * 
 * 2. 기능제공클래스
*/
