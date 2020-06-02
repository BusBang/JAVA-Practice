package kh.java.collection;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.collection.vo.Student;

public class StudentMgr {
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<Student>();
	
	public class studentMGR {
		
	}
	
	public void main() {
		while(true) {
			System.out.println("\n ======== 학생 관리 프로그램 =========");
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
				printOntStudent();			
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
	private void deleteStudent() {
		System.out.println("\n===== 학생 정보 삭제 =====");
		System.out.print("삭제할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = sc.nextInt();
		if(searchIndex == -1) {
			System.out.println("학생 정보가 없습니다.");
		}else {
			students.remove(searchIndex);
		}
	}
	private void printAllStudent() {
		if(students.isEmpty()) {
			System.out.println("출력할 학생 정보가 없습니다. ");
		}else {
			System.out.println("\n===== 학생 정보 출력 1인 =====");
			System.out.println("이름\t나이\t주소");
			//배열이나 컬렉션과 같은 데이터의 전부를 돌고 하나씩 꺼낼 것. for its문 ?
			for(Student s : students) {
				System.out.println(s);
			}
//			for(int i=0; i<students.size();i++) {
//				System.out.println(students.get(i));
//			}
		}
	}
	private void modifyStudent() {
		System.out.println("\n======= 학생 정보 수정 =======");
		System.out.print("수정할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex ==-1) {
			System.out.println("존재하지 않는 학생입니다. ");
		}else {
			System.out.print("새 이름 입력 : ");
			String newName = sc.next();
			System.out.print("새 나이 입력 : ");
			int newAge = sc.nextInt();
			System.out.print("새 주소 입력 : ");
			String newAddr = sc.next();
			students.get(searchIndex).setName(newName);
			students.get(searchIndex).setAge(newAge);
			students.get(searchIndex).setAddr(newAddr);	
		}
		
	}
	public void insertStudent() {
		System.out.println("\n======= 학생 정보 입력 =======");
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("주소 입력 : ");
		String addr = sc.next();
		Student s = new Student(name, age, addr);
		students.add(s);		
	}
	public void printOntStudent() {
		System.out.println("\n===== 학생 정보 출력 1인 =====");
		System.out.print("조회할 학생 이름 입력 : ");
		String name =sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex ==-1) {
			System.out.println("존재하지 않는 학생입니다. ");
		}else {
			System.out.println("이름\t나이\t주소");
			System.out.println(students.get(searchIndex));
		}
	}
	public int searchStudent(String name) {
		for(int i=0;i<students.size(); i++) {
			if(students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	

}
