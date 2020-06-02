package kh.java.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import kh.java.test.TestClass;

public class Start {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		new TestClass().test1();
//		new TestClass().start();
//		try {
//			FileInputStream fis = new FileInputStream("test.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			new TestClass().test3(); // TestClass에서 Throws 명령을 수행했기 때문에 런 클래스에서 처리해주는 것이다.
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		new TestClass().test4()
		new TestClass().div(10, 0);
//	}
	}
}
