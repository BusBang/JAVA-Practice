package kh.java.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamTest {

	Scanner sc = new Scanner(System.in);
	public void primaryStream() {
		FileWriter fw = null; //file writer used.
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		sc.nextLine();
		try {
			fw = new FileWriter(fileName);
			System.out.println("["+fileName+"] ���Ͽ� ����� ���� �Է�");
			System.out.println("����� exit");
			int lineNumber = 1;
			while(true) {
				System.out.print((lineNumber++)+" : ");
				String str = sc.nextLine()+"\r\n";
				if(str.equals("exit\r\n")) {
					break;
				}else {
					fw.write(str);
				}
			}	
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void subStream() {
		BufferedWriter bw = null;
		System.out.print("������ ���ϸ� �Է� : ");
		String fileName = sc.next();
		System.out.println();
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			System.out.println("["+fileName+"] ���Ͽ� ����� ���� �Է�");
			System.out.println("����� exit");
			int lineNumber = 1;
			while(true) {
				System.out.print((lineNumber++)+" : ");
				String str = sc.nextLine();
				if(str.equals("exit")) {
					break;
				}else {
					bw.write(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void reader() {
		System.out.print("�ҷ��� ���ϸ� �Է� : ");
		String loadFileName = sc.next();
		BufferedReader br = null; //���� ��Ʈ���̱� ������ �� ��Ʈ���� �������Ѵ�.
		try {
			FileReader fr = new FileReader(loadFileName);
			br= new BufferedReader(fr);
			int lineNumber = 1;
			while(true) {
				String str = br.readLine();
				if(str == null) {
					break;
				}
				System.out.println((lineNumber++)+" : "+str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e2) {
				e2.printStackTrace();

			}
		}	
	}
}
