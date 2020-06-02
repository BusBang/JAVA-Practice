package kh.java.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ImageStreamPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void ISP() {
		
		BufferedReader br = null;
		BufferedOutputStream bos = null;
		
		try {
			System.out.print("파일 이름을 입력해주세요 : ");
			String inputName = sc.next();
			File inputFileName = new File(inputName); 
			br = new BufferedReader(new FileReader(inputFileName));
			String fileStr = br.readLine();
			StringTokenizer st = new StringTokenizer(fileStr, " ");
			ArrayList<Byte> al = new ArrayList<Byte>();
			
			while(st.hasMoreTokens()) {
				al.add((byte)(Integer.parseInt(st.nextToken(),16)));
			}
			System.out.println(al.size());
			System.out.print("저장할 파일 이름 입력 : ");
			String outputName = sc.next();
			bos = new BufferedOutputStream(new FileOutputStream(outputName));
			for(byte a : al) {
				bos.write(a);
			}
			File outputfile = new File(outputName);
			System.out.println("저장 경로 : "+outputfile.getAbsolutePath());
			System.out.println("파일 전송 끝 !");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e2) {
			e2.printStackTrace();
		}finally {
			try {
				bos.close();
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}		
	}

}
