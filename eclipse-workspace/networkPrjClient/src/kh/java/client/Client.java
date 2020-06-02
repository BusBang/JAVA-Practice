package kh.java.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<<Input a Server IP>>"); 
		String serverIP = sc.nextLine(); //���� IP //168.192.10.20
		int portNumber = 60000; // ��Ʈ ����
		try {
			//���� ���� ��û
			Socket socket = new Socket(serverIP, portNumber);
			//�� ��Ʈ�� ����
			InputStream in = socket.getInputStream(); //�������� ������� ���� ����
			OutputStream out = socket.getOutputStream();
			//���� ��Ʈ�� ����
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			while(true) {
				String serverMsg = dis.readUTF();
				
				System.out.println("server > "+serverMsg); //�������� �޼����� �޴´�
				if(serverMsg.equals("exit")) {
					break;
				}
				System.out.print("client > ");
		
				String msg = sc.nextLine();
				dos.writeUTF(msg); //������ �޼����� ����
				if(serverMsg.equals("exit")||msg.equals("exit")) {
					break;
				}
			}
			System.out.println("������ ���������ϴ�.");
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
