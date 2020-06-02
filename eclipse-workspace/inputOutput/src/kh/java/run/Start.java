package kh.java.run;

import kh.java.serial.SerialTest;
import kh.java.test.ByteStreamTest;
import kh.java.test.CharStreamTest;
import kh.java.test.FileTest;
import kh.java.test.ImageStream;
import kh.java.test.ImageStreamPractice;
import kh.java.test.VocaGame;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new ByteStreamTest().subStream();
//		new CharStreamTest().primaryStream();
//		new CharStreamTest().reader();
//		new ImageStream().test();
//		new FileTest().fileTest();
//		new ImageStreamPractice().ISP();
//		new VocaGame().main();
		new SerialTest().main();
		new SerialTest().readObject();
	}

}
