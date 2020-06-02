package kr.or.iei.controller;

import java.util.HashMap;

import kr.or.iei.point.Grade;
import kr.or.iei.view.PointView;

public class Control {
	
	PointView pv = new PointView();
	HashMap<String, Grade> hm = new HashMap<String, Grade>();
	
	public void main() {
		while(true) {
			int selectMain = pv.mainMenu();
			switch(selectMain) {
			case 1 :
				insertUser();
				break;
			case 2 : 
				pv.viewAllUser(hm);
				break;
			case 3 :
				viewOneUser();
				break;
			case 4 : 
				modiUser();
				break;
			case 5 : 
				delUser();
				break;
			case 0 : 
				System.out.println("���α׷��� �����մϴ�");
				return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	private void delUser() {
		String inputName = pv.inputName();
		if(hm.containsKey(inputName)) {
			hm.remove(inputName);
		}else {
			pv.printMsg("�׷� �̸��� �����ϴ�");
		}
	}

	private void modiUser() {
		String inputName=pv.inputName();
		if(hm.containsKey(inputName)) {
			Grade modiGrade = pv.modiUser();
			if(modiGrade==null) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				return;
			}
			hm.remove(inputName);
			hm.put(modiGrade.getName(), modiGrade);
			pv.printMsg("������ �Ϸ�Ǿ����ϴ�. ");
		}else {
			pv.printMsg("�׷� �̸��� �����ϴ�. ");
		}
	}

	private void viewOneUser() {
		String getName = pv.inputName();
		if(hm.containsKey(getName)) {
			pv.ViewOneUser(hm.get(getName));
		}else {
			pv.printMsg("�׷� �̸��� �����ϴ�.");
		}
	}

	private void insertUser() {
		Grade g = pv.insertUser();
		if(g==null) {
			pv.printMsg("���� ����� �Է��Ͽ����ϴ�.");
		}else {
			hm.put(g.getName(), g);

		}
	}	
	
}
