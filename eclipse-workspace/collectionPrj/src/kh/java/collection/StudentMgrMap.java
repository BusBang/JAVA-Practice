package kh.java.collection;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.collection.vo.Student;

public class StudentMgrMap {
	HashMap<String, Student> students = new HashMap<String, Student>();
	Scanner sc = new Scanner(System.in);
	
	public void main() {
		while(true) {
			System.out.println("\n ========학생 관리 프로그램=========");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생 전체 출력");
			System.out.println("3. 학생 1명 정보 출력");
			System.out.println("4. 정보 수정");
			System.out.println("5. 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3 :
				printOneStudent();			
				break;
			case 4:
				modifyStudent();
				break;
			case 5 :
				deleteStudent();
				break;
			case 0 :
				return;
				default : System.out.println("잘못 입력하셨습니다");
			}
		}
		
	}

	private void printOneStudent() {
		System.out.println("-------학생 1명 출력-------");
		System.out.print("조회할 학생 이름 입력 : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.println("이름\t나이\t주소");
			System.out.println(students.get(name)); //toString이 되어있기 때문에 출력이 가능한 것
		}else {
			System.out.println("해당 이름을 가진 학생은 존재하지 않습니다. ");
		}
		
		
	}

	private void deleteStudent() {
		System.out.println("-------학생 1명 출력-------");
		System.out.print("삭제할 학생 이름 입력 : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.println("정말로 삭제하시겠습니까? [y/n]");
			char choice = sc.next().charAt(0);
			if(choice=='y') {
				students.remove(name);
				System.out.println("삭제하였습니다. ");
			}else {
				System.out.println("삭제 명령을 취소합니다. ");
				return;
			}
			
		}else {
			System.out.println("없는 이름입니다. 다시 입력해주세요. ");
		}
	}

	private void modifyStudent() {
		System.out.println("-------학생 1명 출력-------");
		System.out.print("수정할 학생 이름 입력 : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.print("새 이름 입력 : ");
			String newName = sc.next();
			System.out.print("새 나이 입력 : ");
			int newAge = sc.nextInt();
			System.out.print("새 주소 입력 : ");
			String newAddr = sc.next();
			students.remove(name);
			students.put(name, new Student(newName, newAge, newAddr));
		}else {
			System.out.println("없는 이름입니다. 다시 입력해주세요.");
		}
	}

	private void printAllStudent() {
		System.out.println("-------학생 전체 출력-------");
		System.out.println("이름\t나이\t주소");
		Set<String> studentKeys = students.keySet();
		for(String sk : studentKeys) {
			System.out.println(students.get(sk));
		}
	}

	private void insertStudent() {
		System.out.println("-------학생 정보 등록-------");
		String name = "";
		while(true) {
			System.out.print("이름 입력 : ");
			name = sc.next();
			if(students.containsKey(name)) {
				System.out.println("중복된 이름입니다. 다시 입력해주세요.");
			}else {
				break;
			}
		}
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("주소 입력 : ");
		String addr = sc.next();
		Student ns = new Student(name, age, addr);
		students.put(name, ns);
	}

}
