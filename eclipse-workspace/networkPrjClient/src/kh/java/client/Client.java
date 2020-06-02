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
		String serverIP = sc.nextLine(); //혁진 IP //168.192.10.20
		int portNumber = 60000; // 포트 정보
		try {
			//서버 접속 요청
			Socket socket = new Socket(serverIP, portNumber);
			//주 스트림 생성
			InputStream in = socket.getInputStream(); //서버에서 만들었던 것을 만듦
			OutputStream out = socket.getOutputStream();
			//보조 스트림 생성
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			while(true) {
				String serverMsg = dis.readUTF();
				
				System.out.println("server > "+serverMsg); //서버에게 메세지를 받는다
				if(serverMsg.equals("exit")) {
					break;
				}
				System.out.print("client > ");
		
				String msg = sc.nextLine();
				dos.writeUTF(msg); //서버에 메세지를 보냄
				if(serverMsg.equals("exit")||msg.equals("exit")) {
					break;
				}
			}
			System.out.println("연결이 끊어졌습니다.");
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
