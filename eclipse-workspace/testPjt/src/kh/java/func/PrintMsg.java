package kh.java.func;

public class PrintMsg/*�������Ŭ������ main�� ����*/ {
	public void printHello() {
		System.out.println("Hello");
	}
	public void printHi() {
		System.out.println("Hi");
	}
	public void test() {
		System.out.println(1+1); //���� 2
		System.out.println(1.1+1.1); //�Ǽ� 2.2
		System.out.println('1'+'1'); //���� 11�� �ƴ� 98�� ���� ��? 
		//(�ƽ�Ű�ڵ忡�� 1�� 49. �׷��Ƿ� 49+49=98. �����ڵ� �� �κ��� �ƽ�Ű �ڵ�ǥ�� ���� ������ �ƽ�Ű�ڵ常 ���� ��. ���ڸ� ���ڷ� �ٲ����� �ٽ� ���ڷ� �ٲ����� ����)
		System.out.println("1"+" 1"); //���ڿ� 1 1 (���ڿ��� ���ϸ� �׳� �ٿ�������. ������ ������ ���鵵 ���ڷ� �ν��ؼ� ����
		
		System.out.println(1+1.1); //�Ǽ� 2.1 (����+�Ǽ�=�Ǽ�)
		System.out.println(1+'1'); //���� 50 (����+����=����)
		System.out.println(1.1+'1'); //�Ǽ� 2.1 (�Ǽ�+����=�Ǽ�. 1���� ����
		System.out.println("HI"+1); //���ڿ�HI1 (���ϱ��� ���, ���ڿ��� �켱 ������ ���Ƽ� �ٸ� �����͸� ���ڿ��� ��ȯ�Ͽ� ���ڿ�+���ڿ� ����)
	}

	
	

}

//�������Ŭ������ ��� �����Ұ�?
//import�� �Ѵ�! (���� ��Ű�� �ȿ� ������ ����Ʈ�� �� ���൵ ��. ���� ��Ű�� = ���� ����

