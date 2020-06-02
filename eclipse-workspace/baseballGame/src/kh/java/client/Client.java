package kh.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {
	
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	public void main() {
		String serverIP = "192.168.10.22";
		int portNumber = 60000;
		
		
		try {
			Socket socket = new Socket(serverIP, portNumber);
			System.out.println("Ŭ���̾�Ʈ ������ �����߽��ϴ�. ");
			System.out.println("�߱� ������ �����մϴ�.");
			//��Ʈ��//
			InputStream in = socket.getInputStream(); //�������� ���°�
			OutputStream out = socket.getOutputStream(); //���⼭ ������
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			while(true) {
				System.out.println("�� ���� �Է����ּ��� (ex: 1 4 6)");
				System.out.print("--->");
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				int num3 = sc.nextInt();
				
				//���� ������
				dos.writeInt(num1);
				dos.writeInt(num2);
				dos.writeInt(num3);
				//���� �޾ƿ���
				int strike =dis.readInt();
				int ball = dis.readInt();
				
				System.out.println(strike+"��Ʈ����ũ\t"+ball+"��");
				if(strike ==3) {
					System.out.println("�¸�!");
					break;
				}
			}
			dis.close();
			dos.close();
			socket.close();
			System.out.println("������ �����մϴ�...");
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
