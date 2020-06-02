package kh.java.test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest { //�� ��Ʈ���� ���� ��Ʈ�� ���
	Scanner sc = new Scanner(System.in);
	
	public void primaryStream() { //�� ��Ʈ��
		FileOutputStream fos = null;
		System.out.println("������ ���ϸ� �Է� : ");
		String fileName = sc.next();
		sc.nextLine();
		try {
			fos = new FileOutputStream(fileName); //������ �����
			System.out.println("["+fileName+"] ���Ͽ� �Է��� ���� �Է�");
			System.out.println("����� exit �Է�");
			int lineNumber =1;
			while(true) {
				System.out.print((lineNumber++)+" : "); 
				String str = sc.nextLine()+"\r\n"; //�����쿡���� ����ó�� \r\n
				if(str.equals("exit\r\n")) {
					break;
				}else {
					fos.write(str.getBytes()); //fos.write�� ����Ʈ �������� �ޱ� ������ getBytes�� ���־�� �� ////����ؼ� �Է��� �ϴ� ��
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close(); //�ڿ� ��ȯ
			} catch (IOException e) {
				e.printStackTrace();
			} //�ڿ� ��ȯ
		}
	}
	public void subStream() {
		DataOutputStream dos = null;
		System.out.print("������ ���ϸ� �Է�");
		String fileName = sc.next();
		sc.nextLine();
		try {
			FileOutputStream fos = new FileOutputStream(fileName); //�� ��Ʈ���� ���� ������ش�.
			dos = new DataOutputStream(fos); //�Ű������� �� ��Ʈ���� �־��ش�
			System.out.println("["+fileName+"] ���Ͽ� �Է��� ���� �Է�");
			System.out.println("����� exit �Է�");
			int lineNumber =1;
			while(true) {
				System.out.print((lineNumber++)+" : "); 
				String input = sc.nextLine(); //�� ��Ʈ���� �ٸ��� �� �������� �� �������. (��?) 
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
