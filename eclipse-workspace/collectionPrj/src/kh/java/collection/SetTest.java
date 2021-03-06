package kh.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {
	public void test1() {
		HashSet<Integer> data = new HashSet<Integer>();
		System.out.println(data.add(10));
		System.out.println(data.add(20));
		System.out.println(data.add(30));
		System.out.println(data.add(10)); //중복 : false
		System.out.println(data.add(null));
		System.out.println(data.add(null)); //중복 : false
		System.out.println(data.size());
		//iterator : 반복자
		System.out.println("----- Iterator ------");
		Iterator iter = data.iterator(); //tokenizer를 생각하면 된다? --> 하나씩 잘라서 보관해줌
		while(iter.hasNext()) {
			System.out.println(iter.next()); //HashSet은 순서를 정렬해주지 않아서 자체 알고리즘의 순서로 출력된다.
		}
		System.out.println("----- for each -----");
		for(Integer num : data) {
			System.out.println(num);
		}
		System.out.println("---- ArrayList ----");
		ArrayList<Integer> al = new ArrayList<Integer>(data); //hashset에서 만든 객체 data를 arraylist에 넣는다
		for(Integer num : al) {
			System.out.println(num);
		}
		System.out.println("ArrayList로 정렬");
		Collections.sort(al);
		for(Integer num : al) {
			System.out.println(num);
		}	
	}
	public void lotto() {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		while(lotto.size()<6) {
			System.out.print("숫자를 입력하세요 :");
			int num = sc.nextInt();
			if(!lotto.add(num)) { //if false
				System.out.println("숫자 중복");
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>(lotto);
		Collections.sort(al);
		for(Integer num : al) {
			System.out.println(num);
		}	
	}

}
