package kh.java.test;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	
	Scanner sc =new Scanner(System.in);
	
	public void fileTest() {
		System.out.print("파일명을 입력하세요. ");
		String fileName = sc.next();
		File file = new File(fileName);
		if(file.exists()) {
			System.out.println("파일 이름 : "+file.getName());
			System.out.println("파일 크기 : "+file.length()+"bytes");
			System.out.println("파일 상대 경로 : "+file.getPath()); //프로젝트 기준의 경로
			System.out.println("파일 절대 경로 : "+file.getAbsolutePath());
		}else {
			System.out.println("해당 파일 없음");
		}
		
	}

}
