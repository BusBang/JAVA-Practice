package kh.java.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	Scanner sc = new Scanner(System.in);

	public void main() {
		// IP , PORT를 알아야함
		// IP주소는 내 컴퓨터 주소가 IP주소이기 때문에 PORT번호만 저장하면 된다.
		// PORT는 0~65535까지 있지만, 0~1000은 예약번호 사용하지 않는다.
		// 60000사용

		try {
			// 1. 서버의 소켓 객체 생성
			ServerSocket server = new ServerSocket(60000); // 소켓 번호의 매개변수로 값을 넣어준다.
			// 2. 서버의 접속 요청 기다림
			// 3. 요청이 들어오면 수락!
			// 4. 클라이언트 정보를 저장
			System.out.println("클라이언트를 기다린다.");
			Socket client = server.accept(); // 수락해서 클라이언트 정보를 저장
			System.out.println("클라이언트 접속");
			// 5. 클라이언트 정보를 통해서 OutputStream 생성
			OutputStream output = client.getOutputStream(); // 파일이 아닌 클라이언트와 소통하기 때문에 FOS를 쓰지 않는다!
			// 6. 클라이언트 정보를 통해서 InputStream 생성
			InputStream input = client.getInputStream(); // 서버와의 소통을 위한 인풋 스트림
			// 7. 보조 스트림 생성
			DataOutputStream dos = new DataOutputStream(output); // 보조스트림
			DataInputStream dis = new DataInputStream(input); // 보조스트림
			// 8. 메세지 전달
			while (true) {
				System.out.print("Server > ");
				String msg = sc.nextLine(); // 클라이언트에 메세지 전송
				if (msg.equals("exit")) {			
					break;
				}
				dos.writeUTF(msg); // 메세지 전송
				String clientMsg = dis.readUTF(); // 클라이언트에게 메세지 받아서 변수에 저장
				System.out.println("client > " + clientMsg);

				if (msg.equals("exit")||clientMsg.equals("exit")) {
					break;
				}
			}
			System.out.println("연결이 끊어졌습니다.");
			client.close();
			dis.close();
			dos.close();

			// 확인
			// netstat -nao | findstr :60000
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
