package kh.java.test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest { //주 스트림과 보조 스트림 사용
	Scanner sc = new Scanner(System.in);
	
	public void primaryStream() { //주 스트림
		FileOutputStream fos = null;
		System.out.println("저장할 파일명 입력 : ");
		String fileName = sc.next();
		sc.nextLine();
		try {
			fos = new FileOutputStream(fileName); //파일을 만든거
			System.out.println("["+fileName+"] 파일에 입력할 내용 입력");
			System.out.println("종료는 exit 입력");
			int lineNumber =1;
			while(true) {
				System.out.print((lineNumber++)+" : "); 
				String str = sc.nextLine()+"\r\n"; //윈도우에서의 개행처리 \r\n
				if(str.equals("exit\r\n")) {
					break;
				}else {
					fos.write(str.getBytes()); //fos.write는 바이트 형식으로 받기 때문에 getBytes를 해주어야 함 ////계속해서 입력을 하는 것
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close(); //자원 반환
			} catch (IOException e) {
				e.printStackTrace();
			} //자원 반환
		}
	}
	public void subStream() {
		DataOutputStream dos = null;
		System.out.print("저장할 파일명 입력");
		String fileName = sc.next();
		sc.nextLine();
		try {
			FileOutputStream fos = new FileOutputStream(fileName); //주 스트림을 먼저 만들어준다.
			dos = new DataOutputStream(fos); //매개변수에 주 스트림을 넣어준다
			System.out.println("["+fileName+"] 파일에 입력할 내용 입력");
			System.out.println("종료는 exit 입력");
			int lineNumber =1;
			while(true) {
				System.out.print((lineNumber++)+" : "); 
				String input = sc.nextLine(); //주 스트림과 다르게 역 슬래쉬를 다 지워줬다. (왜?) 
				if(input.equals("exit")) {
					break;
				}else {
					dos.writeChars(input);	
				}
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
