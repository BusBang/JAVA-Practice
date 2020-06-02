package kh.java.wrap;

public class Wrap {
	public void wrapTest() {
		//기본자료형
		//boolean, char, byte, short, int, long, float, double
		Boolean bool = new Boolean(true); //java.lang에 있기 때문에 import가 필요 없음
		Character ch = new Character('H');
		Byte bNum = new Byte((byte)1); //숫자는 그냥 하면, integer 형식을 갖기 때문에 형변환을 해서 넣어줘야 한다.
		Short sNum = new Short((short)2);
		Integer iNum = new Integer(4);
		Long lNum = new Long(8); //integer가 long보다 좁은 범위기 때문에 정확히는 8L을 쓰는 것이 맞지만, 자동으로 인식해준다.
		Float fNum = new Float(0.5f); // Float은 double보다 좁은 범위기 때문에 f를 써줘야한다.
		Double dNum = new Double(0.77); //	
		
		//정수 10을 Integer 클래스로 박싱
		Integer num =new Integer(10); 
		//언박싱
		int n = num.intValue();
		System.out.println(n);
		//박싱
		Double dd = new Double(3.14);
		//언 박싱
		double d = dd.doubleValue();
		System.out.println(d);
        //오토박싱
        Integer num1 = 100;
        //오토언박싱
        int n1 = num1;
        Double num2 = 3.14;
        double d2 = num2;
        
        //문자열 -> 기본자료형
        String data = "999";
        int num3 = Integer.parseInt(data);
        String data1 = "3.14";
        double num4 = Double.parseDouble(data1);
	       String data3 = "ABCD";
	       char ch1 = data3.charAt(0);
	       
	       //기본자료형 문자열로
	       int num5 = 999;
	       //Integer 사용법
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
