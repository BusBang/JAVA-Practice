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
				System.out.println("���� ������ �����߽��ϴ�. "); 
				System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...");
				// ���� ���� �̱�
				while (true) {
					int num = r.nextInt(10);
					if (!numb.contains(num)) {
						numb.add(num);
					}
					if (numb.size() == 3) {
						break;
					}
				}

				System.out.println("���� ���� ->" + numb.get(0) + " " + numb.get(1) + " " + numb.get(2));
				Socket client = server.accept();
				System.out.println("<�˸�> Ŭ���̾�Ʈ ����");
				System.out.println("���� �� " + (++count) + "�� Ŭ���̾�Ʈ ����");
				System.out.println("<<�߱����� ����>>");

				OutputStream output = client.getOutputStream(); // Ŭ���̾�Ʈ���� �����°�
				InputStream input = client.getInputStream(); // Ŭ���̾�Ʈ���� �޴°�

				DataOutputStream dos = new DataOutputStream(output);
				DataInputStream dis = new DataInputStream(input);
				// ���� �ޱ�
				while (true) {
					ArrayList<Integer> cNumb = new ArrayList<>();
					cNumb.add(dis.readInt());
					cNumb.add(dis.readInt());
					cNumb.add(dis.readInt());

					System.out.println("Ŭ���̾�Ʈ�� �Է��� �� ->" + cNumb.get(0) + " " + cNumb.get(1) + " " + cNumb.get(2));

					for (int i = 0; i < cNumb.size(); i++) {
						if (cNumb.contains(numb.get(i)) && cNumb.get(i) == numb.get(i)) {
							strike++;
						} else if (cNumb.contains(numb.get(i)) && cNumb.get(i) != numb.get(i)) {
							ball++;
						}
					}

					System.out.println(strike + " ��Ʈ����ũ " + ball + "��");
					dos.writeInt(strike);
					dos.writeInt(ball);
					if (strike == 3) {
						System.out.println("��Ʈ����ũ 3ȸ �޼� !");
						System.out.println("<<�¸�>>");
						System.out.println("������ �����մϴ�");
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
