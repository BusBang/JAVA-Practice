package kh.java.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {

	Random r = new Random();
	int count;
	int strike;
	int ball;

	public void main() {
		ArrayList<Integer> numb = new ArrayList<>();


		try {
			ServerSocket server = new ServerSocket(60000);
			
			while (true) {
				System.out.println("서버 소켓을 생성했습니다. "); 
				System.out.println("클라이언트의 접속을 기다립니다...");
				// 서버 숫자 뽑기
				while (true) {
					int num = r.nextInt(10);
					if (!numb.contains(num)) {
						numb.add(num);
					}
					if (numb.size() == 3) {
						break;
					}
				}

				System.out.println("서버 숫자 ->" + numb.get(0) + " " + numb.get(1) + " " + numb.get(2));
				Socket client = server.accept();
				System.out.println("<알림> 클라이언트 접속");
				System.out.println("현재 총 " + (++count) + "명 클라이언트 접속");
				System.out.println("<<야구게임 시작>>");

				OutputStream output = client.getOutputStream(); // 클라이언트에게 보내는거
				InputStream input = client.getInputStream(); // 클라이언트에게 받는거

				DataOutputStream dos = new DataOutputStream(output);
				DataInputStream dis = new DataInputStream(input);
				// 숫자 받기
				while (true) {
					ArrayList<Integer> cNumb = new ArrayList<>();
					cNumb.add(dis.readInt());
					cNumb.add(dis.readInt());
					cNumb.add(dis.readInt());

					System.out.println("클라이언트가 입력한 수 ->" + cNumb.get(0) + " " + cNumb.get(1) + " " + cNumb.get(2));

					for (int i = 0; i < cNumb.size(); i++) {
						if (cNumb.contains(numb.get(i)) && cNumb.get(i) == numb.get(i)) {
							strike++;
						} else if (cNumb.contains(numb.get(i)) && cNumb.get(i) != numb.get(i)) {
							ball++;
						}
					}

					System.out.println(strike + " 스트라이크 " + ball + "볼");
					dos.writeInt(strike);
					dos.writeInt(ball);
					if (strike == 3) {
						System.out.println("스트라이크 3회 달성 !");
						System.out.println("<<승리>>");
						System.out.println("게임을 종료합니다");
						strike = 0;
						ball = 0;
						client.close();
						dos.close();
						dis.close();
						break;
					}
					strike = 0;
					ball = 0;
				}
				count = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
