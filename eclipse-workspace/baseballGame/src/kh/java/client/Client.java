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
			System.out.println("클라이언트 소켓을 생성했습니다. ");
			System.out.println("야구 게임을 시작합니다.");
			//스트림//
			InputStream in = socket.getInputStream(); //서버에서 들어온거
			OutputStream out = socket.getOutputStream(); //여기서 나간거
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			while(true) {
				System.out.println("세 수를 입력해주세요 (ex: 1 4 6)");
				System.out.print("--->");
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				int num3 = sc.nextInt();
				
				//숫자 보내기
				dos.writeInt(num1);
				dos.writeInt(num2);
				dos.writeInt(num3);
				//숫자 받아오기
				int strike =dis.readInt();
				int ball = dis.readInt();
				
				System.out.println(strike+"스트라이크\t"+ball+"볼");
				if(strike ==3) {
					System.out.println("승리!");
					break;
				}
			}
			dis.close();
			dos.close();
			socket.close();
			System.out.println("게임을 종료합니다...");
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
