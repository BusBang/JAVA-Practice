package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.crying();
		
		Tiger t = new Tiger();
		t.crying(); //����߱� ������ ũ���׵� ���� ����
		t.hunting();
		
		Animal at = new Tiger(); //��ӹ޾ұ� ������ ���������� �̷� �͵� ������
		//�θ�Ÿ���� �ڽ�Ÿ���� �޾��� �� ����
		//�θ� ���� �ǹ�. �ڽ��� �θ� ū �ǹ�(�����ϰ� �ֱ� ������)
		at.crying();
//		at.hunting(); //������ �� �Ұ���? -������ �ִϸ� Ÿ������ �߱� ������.
//		Upcasting : �ڽ��� �θ�Ÿ������ ����Ǿ��ֱ� ������. -> ����ȯ�� ������Ѵ�.
		((Tiger)at).hunting();
		//�ִϸ�Ÿ���� at�� Ÿ�̰�Ÿ������ �ٲ��� ������ ������ ����
		
		


	}

}
