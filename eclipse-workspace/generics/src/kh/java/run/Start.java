package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.AnimalMgr;
import kh.java.test.AnimalMgr2;
import kh.java.test.Bear;
//import kh.java.test.GenericEX;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GenericEX<T> ge = new GenericEX<T>();
//		ge.setData("test");
		Tiger t1 = new Tiger(1000); // 1. hp 1000�� Tiger ��ü�� �ּҰ� t1��
		AnimalMgr am1 = new AnimalMgr(t1); // 2.AnimalMgr �������� �Ű����� Ÿ���� Object. �������� ���ؼ� Tiger��ü�� �ּҰ� Object Ÿ�� ������ ����
		//AnimalMgr�� �����ڿ��� ObjectŸ���� data�� �Ű������� �־������
		//14�� �ٿ��� t1�� 1000�̶�� �����͸� �־���
		//�θ� Ÿ������ �� ĳ���� �Ǿ��ִ� ����
		AnimalMgr am2 = new AnimalMgr(new Bear(2000));
		//3. am1�� �ִ� data������ ���� ���������� �ϴµ� ? ������ Ÿ����? -> Object
		Object obj1 = am1.getData();
		Object obj2 = am2.getData();
		System.out.println(obj1); // �ּҰ��� ��� �ȴ�.		
		//GetData�� �ڷ����� Object. �ּҴ�? -> Tiger ��ü�� �ּҰ� �������.
		//�� �ּ��� ���� �ҷ����� ���� (Tiger)�� ��� �ٿ�ĳ�������ش�. --> �θ�Ÿ�� Object���� getHp()�޼ҵ尡 �������� �ʱ� ������.
		//�̷� �κ��� �������� �ذ����ִ� ���� ���׸���
		((Tiger)am1.getData()).getHp(); //�׷��� �θ� �ڽ����� �ٲ� (�ٿ�ĳ������ �� ��)
		((Bear) am2.getData()).getHp();
		
		//���׸� ����
		AnimalMgr2<Tiger> a1 = new AnimalMgr2<Tiger>(t); //a1���� t��� �Ǿ��ִ� ���� ��� Tiger Ÿ������ �ٲ�� ��
		AnimalMgr2<Bear> a2 = new AnimalMgr2<Bear>(b); //a2���� b��� �Ǿ��ִ� ���� ��� Bear Ÿ������ �ٲ�� ��
		
		a1.getData().getHp(); //�ٿ�ĳ������ �� �ʿ䰡 ����. �ֳ��ϸ� getDataŸ���� TigerŸ���̶�. 
		a2.getData().getHp(); //�ٿ�ĳ������ �� �ʿ䰡 ����. �ֳ��ϸ� getDataŸ���� BearŸ���̶�.
		
		AnimalMgr2<Animal> amm1 = new AnimalMgr2<Animal>(new Animal());
		AnimalMgr2<Tiger> amm2 = new AnimalMgr2<Tiger>(new Tiger());
		AnimalMgr2<Bear> amm3 = new AnimalMgr2<Bear>(new Bear()); //Bear�� ��� import�� ������ ��� �Ұ��� ��. AnimalMgr2�� ���ǿ� extends Animal�� �ɷ��ֱ� ����.


	}

}
