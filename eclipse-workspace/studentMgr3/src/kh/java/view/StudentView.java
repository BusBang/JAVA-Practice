package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.model.vo.Student;

public class StudentView {
	Scanner sc = new Scanner(System.in);
	public int mainMenu() { //뷰에서 응답을 받아서 컨트롤러로 되돌려줄것임.
		System.out.println("----- 학생 관리 프로그램 -----");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 전체 출력");
		System.out.println("3. 학생 1인 출력");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	public Student insertStudent() {
		System.out.println("----- 학생 정보 입력 -----");
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("주소 입력 : ");
		String addr = sc.next();
		Student insertS = new Student(name, age, addr); //리턴 타입은 1가지만 가능하다. 여러가지를 컨트롤러로 보내기 위해 Student타입으로 저장한다. 이 과정에서 vo.Student가 필요하다
		return insertS;

	}
	public void viewAllStudent(ArrayList<Student> stud) { //전체 출력을 위한 for문을 사용하기 위해 컨트롤러의 Student를 받아야한다.
		System.out.println("----- 학생 전체 출력 -----");
		System.out.println("이름\t나이\t주소"); 
		for(Student start : stud) {
			System.out.println(start);
		}
	}
	public String inputName() {
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public void viewOnStudent(Student s) {
		System.out.println("이름\t나이\t주소");
		System.out.println(s);		
	}
	public void printMsg(String msg) {
		System.out.println(msg);
		
	}
	public Student modifyStudent() {
		System.out.print("새 이름 입력 : ");
		String newName = sc.next();
		System.out.print("새 나이 입력 : ");
		int newAge = sc.nextInt();
		System.out.print("새 주소 입력 : ");
		String newAddr = sc.next();
		Student modifys = new Student(newName, newAge, newAddr);
		return modifys;
	}


	
}
