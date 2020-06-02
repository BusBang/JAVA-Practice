package kh.or.iei.view;

import java.util.Scanner;

public class View {

	Scanner sc = new Scanner(System.in);

	public int main() {

		System.out.println("--------포인트 매니저 연습 -------");
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 1명 조회");
		System.out.println("4. 회원 수정");
		System.out.println("5. 회원 탈퇴");
		System.out.println("0. 나가기");
		return sc.nextInt();
	}

}
