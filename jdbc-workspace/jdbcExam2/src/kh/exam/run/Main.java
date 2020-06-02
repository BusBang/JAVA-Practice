package kh.exam.run;

import java.util.*;

import kh.exam.controller.JDBCTest;

public class Main {

	public static void main(String[] args) {

		JDBCTest jdbc = new JDBCTest();

		List<HashMap<String, Object>> memoList = jdbc.testSelect();

		System.out.println("==================================");
		System.out.println("NO \t NAME \t MSG \t WRITEDAY");
		System.out.println("==================================");

		if (memoList != null) {

			for (HashMap<String, Object> memo : memoList) {
				System.out.println(memo.get("no") + "\t" + memo.get("name") + "\t" + memo.get("msg") + "\t"
						+ memo.get("writeday"));
			}
		}

		else
			System.out.println("== 입력된 데이터가 없습니다 ==");

	}

}