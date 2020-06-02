package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.vo.Student;

public class StudentMgr {
	//이름배열, 나이배열, 주소배열, 스캐너, 인덱스
	Student[] students = new Student[10];
	Scanner sc = new Scanner(System.in);
	int index;
	
	public void main() {
		while(true) {
			System.out.println("===== 학생 관리 프로그램 v1.1 =====");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 출력 (전체)");
			System.out.println("3. 학생 정보 출력 (1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}	
		}	
	}
	
	public void insertStudent() {
		System.out.println("\n===== 학생 정보 입력 =====");
		System.out.print("학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("학생 주소 입력 : ");
		String addr = sc.next();
		/*
		//기본 생성자를 이용해 stu라는 변수를 만들면, stu의 이름과 주소엔 null이 들어가 있음, 나이는 0이 들어가있을 거임
		
		Student stu = new Student();
		stu.setName(name);
		stu.setAge(age);
		stu.setAddr(addr);
		*/
		//매개변수 생성자를 이용해 Student클래스에 생성해둔 Student매개 클래스에 stu변수에 넣어주는 것
		Student stu = new Student(name,age,addr);
		
		students[index] = stu;
		index++;
	}
	
	public void printAllStudent() {
		System.out.println();
		System.out.println("===== 학생 전체 정보 출력 =====");
		System.out.println("이름\t나이\t주소");
		for(int i=0; i<index;i++) {
//			System.out.println(students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getAddr());
			System.out.println(students[i]);
		}	
	}
	
	public void printOneStudent() {
		System.out.println();
		System.out.println("===== 학생 1명 정보 출력 =====");
		System.out.print("검색할 이름을 입력해주세요 : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			System.out.println(students[searchIndex].getName()+"\t"+students[searchIndex].getAge()+"\t"+students[searchIndex].getAddr());
			System.out.println();
		}
	}
	
	public int searchStudent(String name) {
		for(int i=0;i<index;i++) {
			if(students[i].getName().equals(name)) {
				return i;
			}
		}
		System.out.println("이름을 찾을 수 없습니다");
		return -1;
	}
	
	public void modifyStudent() {
		System.out.println();
		System.out.println("===== 학생 정보 수정 =====");
		System.out.print("검생할 이름을 입력해주세요 : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			System.out.println("학생 이름 입력 : ");
			String modiName = sc.next();
			System.out.println("학생 나이 입력 : ");
			int modiAge = sc.nextInt();
			System.out.println("학생 주소 입력 : ");
			String modiAddr = sc.next();
			students[searchIndex].setName(modiName);
			students[searchIndex].setAge(modiAge);
			students[searchIndex].setAddr(modiAddr);
			System.out.println("수정이 완료되었습니다.");	
			System.out.println();	
		}

	}
	public void deleteStudent() {
		System.out.println("===== 학생 정보 삭제 =====");
		System.out.print("삭제할 학생 이름 입력 : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			for(int i=0; i<index-1; i++) {
				students[i] = students[i+1];
			}
			students[index-1] = null;
			index--;
		}
		
	}
}
	
	
	
	

