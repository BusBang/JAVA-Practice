package kh.or.iei.view;

import java.util.Scanner;

public class View {

	Scanner sc = new Scanner(System.in);

	public int main() {

		System.out.println("--------����Ʈ �Ŵ��� ���� -------");
		System.out.println("1. ȸ�� ���");
		System.out.println("2. ȸ�� ��ü ��ȸ");
		System.out.println("3. ȸ�� 1�� ��ȸ");
		System.out.println("4. ȸ�� ����");
		System.out.println("5. ȸ�� Ż��");
		System.out.println("0. ������");
		return sc.nextInt();
	}

}
