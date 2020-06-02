package kh.java.controller;

import java.util.ArrayList;

import kh.java.model.vo.Student;
import kh.java.view.StudentView;

public class StudentController {
	StudentView view = new StudentView();
	ArrayList<Student> students = new ArrayList<Student>();
	
	public void main() {
		while(true) {
			int select = view.mainMenu();
			switch(select) {
			case 1: //학생 등록
				insertStudent();
				break;
			case 2 : //학생 전체 출력
				view.viewAllStudent(students); //따로 데이터를 인풋하는 것이 아니라 바로 출력만 할 것이기 때문에 view로 넘어간다
				break;
			case 3 : //학생 1명 출력
				viewOneStudent();
				break;
			case 4 : //학생 정보 수정
				modifyStudent();
				break;
			case 5 : //학생 정보 삭제
				deleteStudent();
				break;
			case 0 : //프로그램 종료
				view.printMsg("종료합니다.");
				return;
			default : System.out.println("잘못 선택하였습니다. ");			
			}
			
		}
	}

	public void deleteStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex !=-1) {
			students.remove(searchIndex);
			view.printMsg("학생 정보 삭제가 완료되었습니다. ");
		}else {
			view.printMsg("해당 학생은 존재하지 않습니다. ");
		}
		
	}

	public void modifyStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex !=-1) {
			Student modiStu = view.modifyStudent();
			students.set(searchIndex, modiStu);
			view.printMsg("수정이 완료되었습니다.");
		}else {
			view.printMsg("그런 학생은 없습니다.");
		}
		// TODO Auto-generated method stub
		
	}

	public void viewOneStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex!=-1) {
			view.viewOnStudent(students.get(searchIndex)); //searchIndex에 해당하는 students의 정보들을 보냄
		}else {
			view.printMsg("학생이 존재하지 않습니다."); //출력용 메소드
		}		
	}


	public void insertStudent() {
		Student s = view.insertStudent(); //뷰에서 받은 Student 타입을 Student s로 저장. add(s)
		students.add(s);
	}
	public int searchStudent(String name) {
		for (int i=0;i<students.size();i++) {
			if(students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
}
