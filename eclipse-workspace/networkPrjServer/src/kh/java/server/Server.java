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
		// IP , PORT�� �˾ƾ���
		// IP�ּҴ� �� ��ǻ�� �ּҰ� IP�ּ��̱� ������ PORT��ȣ�� �����ϸ� �ȴ�.
		// PORT�� 0~65535���� ������, 0~1000�� �����ȣ ������� �ʴ´�.
		// 60000���

		try {
			// 1. ������ ���� ��ü ����
			ServerSocket server = new ServerSocket(60000); // ���� ��ȣ�� �Ű������� ���� �־��ش�.
			// 2. ������ ���� ��û ��ٸ�
			// 3. ��û�� ������ ����!
			// 4. Ŭ���̾�Ʈ ������ ����
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ���.");
			Socket client = server.accept(); // �����ؼ� Ŭ���̾�Ʈ ������ ����
			System.out.println("Ŭ���̾�Ʈ ����");
			// 5. Ŭ���̾�Ʈ ������ ���ؼ� OutputStream ����
			OutputStream output = client.getOutputStream(); // ������ �ƴ� Ŭ���̾�Ʈ�� �����ϱ� ������ FOS�� ���� �ʴ´�!
			// 6. Ŭ���̾�Ʈ ������ ���ؼ� InputStream ����
			InputStream input = client.getInputStream(); // �������� ������ ���� ��ǲ ��Ʈ��
			// 7. ���� ��Ʈ�� ����
			DataOutputStream dos = new DataOutputStream(output); // ������Ʈ��
			DataInputStream dis = new DataInputStream(input); // ������Ʈ��
			// 8. �޼��� ����
			while (true) {
				System.out.print("Server > ");
				String msg = sc.nextLine(); // Ŭ���̾�Ʈ�� �޼��� ����
				if (msg.equals("exit")) {			
					break;
				}
				dos.writeUTF(msg); // �޼��� ����
				String clientMsg = dis.readUTF(); // Ŭ���̾�Ʈ���� �޼��� �޾Ƽ� ������ ����
				System.out.println("client > " + clientMsg);

				if (msg.equals("exit")||clientMsg.equals("exit")) {
					break;
				}
			}
			System.out.println("������ ���������ϴ�.");
			client.close();
			dis.close();
			dos.close();

			// Ȯ��
			// netstat -nao | findstr :60000
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
