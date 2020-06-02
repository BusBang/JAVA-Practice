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
		System.out.println(data.add(10)); //�ߺ� : false
		System.out.println(data.add(null));
		System.out.println(data.add(null)); //�ߺ� : false
		System.out.println(data.size());
		//iterator : �ݺ���
		System.out.println("----- Iterator ------");
		Iterator iter = data.iterator(); //tokenizer�� �����ϸ� �ȴ�? --> �ϳ��� �߶� ��������
		while(iter.hasNext()) {
			System.out.println(iter.next()); //HashSet�� ������ ���������� �ʾƼ� ��ü �˰����� ������ ��µȴ�.
		}
		System.out.println("----- for each -----");
		for(Integer num : data) {
			System.out.println(num);
		}
		System.out.println("---- ArrayList ----");
		ArrayList<Integer> al = new ArrayList<Integer>(data); //hashset���� ���� ��ü data�� arraylist�� �ִ´�
		for(Integer num : al) {
			System.out.println(num);
		}
		System.out.println("ArrayList�� ����");
		Collections.sort(al);
		for(Integer num : al) {
			System.out.println(num);
		}	
	}
	public void lotto() {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		while(lotto.size()<6) {
			System.out.print("���ڸ� �Է��ϼ��� :");
			int num = sc.nextInt();
			if(!lotto.add(num)) { //if false
				System.out.println("���� �ߺ�");
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>(lotto);
		Collections.sort(al);
		for(Integer num : al) {
			System.out.println(num);
		}	
	}

}
