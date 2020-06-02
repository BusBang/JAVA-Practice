package kh.java.run;

import java.util.Timer;

import kh.java.test.Test1;

public class Start {

	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
		System.out.println(t1); //t1���� toString�� �����Ǿ� �ִ� ���̴�.
		System.out.println(t1.toString());
		
		//Test1Ŭ������ clone()�޼ҵ��� ����Ÿ���� Object��.
		//�������� �θ�Ÿ�� ���۷��� �ڽ�Ÿ�� ��ü�� ����
		Test1 t2 = (Test1)t1.clone(); //�׳� �ϸ� Object���� Test1�� ������ �ؼ� ������ �߻���. (Test1). �ٿ�ĳ������ �̿��� �־��ش�.
		System.out.println(t1);
		System.out.println(t2);
		//clone ����
		//1) Test1�� implements Cloneable�� ���ش�
		//2) public Object clone() {}�� ������ش�.
		//3) ������ ���� = (����ȯ)��������.clone();�� �������ش�.
		
		
		//kh.java.test. : ��Ű�� �̸�
		//Test1 : Ŭ���� �̸�
		//@ : �ǹ̾��� (������)
		//7852e922 : �ν��Ͻ� �ĺ���
		
		//String �� �񱳽� ����ߴ� equals
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		if(str1.equals(str2)) {
			System.out.println("�����ϴ�. ");
		}else {
			System.out.println("�ٸ��ϴ�. ");
		}
		//equlas�� �Ⱦ��� �ٸ��ϴٰ� ���.
		//new String�� �� ���� "Hello"�� ���� �����ϴٰ� ���

		


	}

}
