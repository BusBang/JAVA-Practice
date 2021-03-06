package kh.java.test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImageStream {
	
	public void test() {
		BufferedReader br =null; //프로그램으로 읽어 올 때 씀 (보조 스트림)
		BufferedOutputStream bos = null; //이미지 내보낼 때의 보조스트림
		
		try {
			FileReader fr = new FileReader("quiz.txt"); //파일을 읽어오기 위한 주스트림 생성
			br = new BufferedReader(fr); //보조 스트림에 주 스트림을 매개변수로 넣기
			String str = br.readLine(); // 한 줄씩 읽기.. 파일이 한 줄이라 이렇게 해도 됨 (여러줄이면 while, null 사용)
			//str = {"AB 12 CD ... DC"} -> String Type, 16진수, 공백
			StringTokenizer sT = new StringTokenizer(str," "); //String 타입으로 분리, 16진수.
			ArrayList<Byte> al = new ArrayList<Byte>(); // Arraylist는 길이 제한이 없는 것이 장점
			while(sT.hasMoreTokens()) { //남아있는 토큰이 0이 될 때까지 계속 반복
				byte b = (byte)(Integer.parseInt(sT.nextToken(),16)); //16진수 Integer로 설정 -> Byte로 변환
				al.add(b); //바이트 만든 것을 ArrayList에 추가.
			}
			System.out.println(al.size());

			bos = new BufferedOutputStream(new FileOutputStream("test.gif")); //이미지 파일로 내보내기 위한 보조 스트림과 주 스트림
			//바이트 (in/output이면 바이트 스트링임)
			for(byte i : al) {
				bos.write(i); // al에 있는 걸 하나씩 꺼내서 써줌
			}
		
			System.out.println("파일전송 끝");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();;
		}finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
