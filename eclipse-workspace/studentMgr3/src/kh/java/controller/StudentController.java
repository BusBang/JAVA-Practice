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
			case 1: //�л� ���
				insertStudent();
				break;
			case 2 : //�л� ��ü ���
				view.viewAllStudent(students); //���� �����͸� ��ǲ�ϴ� ���� �ƴ϶� �ٷ� ��¸� �� ���̱� ������ view�� �Ѿ��
				break;
			case 3 : //�л� 1�� ���
				viewOneStudent();
				break;
			case 4 : //�л� ���� ����
				modifyStudent();
				break;
			case 5 : //�л� ���� ����
				deleteStudent();
				break;
			case 0 : //���α׷� ����
				view.printMsg("�����մϴ�.");
				return;
			default : System.out.println("�߸� �����Ͽ����ϴ�. ");			
			}
			
		}
	}

	public void deleteStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex !=-1) {
			students.remove(searchIndex);
			view.printMsg("�л� ���� ������ �Ϸ�Ǿ����ϴ�. ");
		}else {
			view.printMsg("�ش� �л��� �������� �ʽ��ϴ�. ");
		}
		
	}

	public void modifyStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex !=-1) {
			Student modiStu = view.modifyStudent();
			students.set(searchIndex, modiStu);
			view.printMsg("������ �Ϸ�Ǿ����ϴ�.");
		}else {
			view.printMsg("�׷� �л��� �����ϴ�.");
		}
		// TODO Auto-generated method stub
		
	}

	public void viewOneStudent() {
		String getName = view.inputName();
		int searchIndex = searchStudent(getName);
		if(searchIndex!=-1) {
			view.viewOnStudent(students.get(searchIndex)); //searchIndex�� �ش��ϴ� students�� �������� ����
		}else {
			view.printMsg("�л��� �������� �ʽ��ϴ�."); //��¿� �޼ҵ�
		}		
	}


	public void insertStudent() {
		Student s = view.insertStudent(); //�信�� ���� Student Ÿ���� Student s�� ����. add(s)
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
