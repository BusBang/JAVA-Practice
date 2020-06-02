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
		BufferedReader br =null; //���α׷����� �о� �� �� �� (���� ��Ʈ��)
		BufferedOutputStream bos = null; //�̹��� ������ ���� ������Ʈ��
		
		try {
			FileReader fr = new FileReader("quiz.txt"); //������ �о���� ���� �ֽ�Ʈ�� ����
			br = new BufferedReader(fr); //���� ��Ʈ���� �� ��Ʈ���� �Ű������� �ֱ�
			String str = br.readLine(); // �� �پ� �б�.. ������ �� ���̶� �̷��� �ص� �� (�������̸� while, null ���)
			//str = {"AB 12 CD ... DC"} -> String Type, 16����, ����
			StringTokenizer sT = new StringTokenizer(str," "); //String Ÿ������ �и�, 16����.
			ArrayList<Byte> al = new ArrayList<Byte>(); // Arraylist�� ���� ������ ���� ���� ����
			while(sT.hasMoreTokens()) { //�����ִ� ��ū�� 0�� �� ������ ��� �ݺ�
				byte b = (byte)(Integer.parseInt(sT.nextToken(),16)); //16���� Integer�� ���� -> Byte�� ��ȯ
				al.add(b); //����Ʈ ���� ���� ArrayList�� �߰�.
			}
			System.out.println(al.size());

			bos = new BufferedOutputStream(new FileOutputStream("test.gif")); //�̹��� ���Ϸ� �������� ���� ���� ��Ʈ���� �� ��Ʈ��
			//����Ʈ (in/output�̸� ����Ʈ ��Ʈ����)
			for(byte i : al) {
				bos.write(i); // al�� �ִ� �� �ϳ��� ������ ����
			}
		
			System.out.println("�������� ��");

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
