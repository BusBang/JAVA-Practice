package kh.java.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialTest {
	public void main() {
		ObjectOutputStream oos = null; //객체를 내보내는 보조스트림
		try {
			FileOutputStream fos =new FileOutputStream("C:\\Users\\user1\\Desktop\\object.txt");
			oos = new ObjectOutputStream(fos);
			ArrayList<User> list = new ArrayList<User>();
			User user1 = new User("test1", "1234", 1234, new Score(100,100,100));
			User user2 = new User("test2", "2345", 2345, new Score(100,100,100));
			User user3 = new User("test3", "3456", 6543, new Score(100,100,100));
			list.add(user1);
			list.add(user2);
			list.add(user3);
			oos.writeObject(list);
			System.out.println("저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (FileNotFoundException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
	public void readObject() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\user1\\Desktop\\object.txt");
			ois = new ObjectInputStream(fis);
			ArrayList<User> list = (ArrayList<User>)ois.readObject(); //ois.reedObject를 어레이리스트로 형변환 해준후 넣어준다.
			System.out.println(list.get(0).getScore());
			System.out.println(list.get(1).getId());
			System.out.println(list.get(2).getId());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
