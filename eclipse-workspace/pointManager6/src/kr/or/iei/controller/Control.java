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
				System.out.println("프로그램을 종료합니다");
				return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private void delUser() {
		String inputName = pv.inputName();
		if(hm.containsKey(inputName)) {
			hm.remove(inputName);
		}else {
			pv.printMsg("그런 이름은 없습니다");
		}
	}

	private void modiUser() {
		String inputName=pv.inputName();
		if(hm.containsKey(inputName)) {
			Grade modiGrade = pv.modiUser();
			if(modiGrade==null) {
				System.out.println("잘못입력하셨습니다.");
				return;
			}
			hm.remove(inputName);
			hm.put(modiGrade.getName(), modiGrade);
			pv.printMsg("수정이 완료되었습니다. ");
		}else {
			pv.printMsg("그런 이름은 없습니다. ");
		}
	}

	private void viewOneUser() {
		String getName = pv.inputName();
		if(hm.containsKey(getName)) {
			pv.ViewOneUser(hm.get(getName));
		}else {
			pv.printMsg("그런 이름은 없습니다.");
		}
	}

	private void insertUser() {
		Grade g = pv.insertUser();
		if(g==null) {
			pv.printMsg("없는 등급을 입력하였습니다.");
		}else {
			hm.put(g.getName(), g);

		}
	}	
	
}
