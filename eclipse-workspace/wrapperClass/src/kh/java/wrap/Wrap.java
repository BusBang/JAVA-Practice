package kh.java.wrap;

public class Wrap {
	public void wrapTest() {
		//�⺻�ڷ���
		//boolean, char, byte, short, int, long, float, double
		Boolean bool = new Boolean(true); //java.lang�� �ֱ� ������ import�� �ʿ� ����
		Character ch = new Character('H');
		Byte bNum = new Byte((byte)1); //���ڴ� �׳� �ϸ�, integer ������ ���� ������ ����ȯ�� �ؼ� �־���� �Ѵ�.
		Short sNum = new Short((short)2);
		Integer iNum = new Integer(4);
		Long lNum = new Long(8); //integer�� long���� ���� ������ ������ ��Ȯ���� 8L�� ���� ���� ������, �ڵ����� �ν����ش�.
		Float fNum = new Float(0.5f); // Float�� double���� ���� ������ ������ f�� ������Ѵ�.
		Double dNum = new Double(0.77); //	
		
		//���� 10�� Integer Ŭ������ �ڽ�
		Integer num =new Integer(10); 
		//��ڽ�
		int n = num.intValue();
		System.out.println(n);
		//�ڽ�
		Double dd = new Double(3.14);
		//�� �ڽ�
		double d = dd.doubleValue();
		System.out.println(d);
        //����ڽ�
        Integer num1 = 100;
        //�����ڽ�
        int n1 = num1;
        Double num2 = 3.14;
        double d2 = num2;
        
        //���ڿ� -> �⺻�ڷ���
        String data = "999";
        int num3 = Integer.parseInt(data);
        String data1 = "3.14";
        double num4 = Double.parseDouble(data1);
	       String data3 = "ABCD";
	       char ch1 = data3.charAt(0);
	       
	       //�⺻�ڷ��� ���ڿ���
	       int num5 = 999;
	       //Integer ����
	       String data4 = Integer.valueOf(num5).toString();
	       //String
	       String data5 = String.valueOf(num5);
	       
	       double num6 = 3.14;
	       String data6 = Double.valueOf(num6).toString();
	       String data7 = String.valueOf(num6);
	        
	       Character ch2 = 'a';
	       String data8 = Character.valueOf(ch2).toString();
	       String data9 = String.valueOf(ch2);

	}
	

}
