package kh.java.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ListTest {
	public void listTest() {
		String [] arr = new String[3];
		arr [0] = "Hello";
//		arr [1] = "Hi";
		arr [2] = "�ȳ��ϼ���";
//		arr [3] = "�߰���"; �迭�� ũ�⸦ �Ѿ�� ������ ���� �߻�
		System.out.println("[�迭 ���]");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		ArrayList<String> al = new ArrayList<String>(); //ArrayList is not must required array's length
		al.add("Hello"); // input "Hello" at 1st cell -> variable.add(InputData)
		al.add("Hi"); // 2nd cell
		al.add("�ȳ��ϼ���"); //3rd cell;
		al.add("�߰���"); // Add 4th cell. 
		System.out.println("<ArrayList ���> - 1")
		;
		for(int i=0;i<al.size();i++) { //length => size()
			System.out.println(al.get(i)); // output data -> get(index)
		}
		al.remove(1);
		
		System.out.println("<ArrayList ���> - 2")
		;
		for(int i=0;i<al.size();i++) { //length => size()
			System.out.println(al.get(i)); // output data -> get(index)
		}
		al.add(1, "hi");
		System.out.println("<ArrayList ���> - 3");
		for(int i=0;i<al.size();i++) { //length => size()
			System.out.println(al.get(i)); // output data -> get(index)
		}
		al.set(1, "HIHIHIHIHIHIIHI");
		System.out.println("<ArrayList ���> - 4"
				+ "");
		for(int i=0;i<al.size();i++) { //length => size()
			System.out.println(al.get(i)); // output data -> get(index)
		}
		al.clear();
		System.out.println("<ArrayList ���> - 5");
		for(int i=0;i<al.size();i++) { //length => size()
			System.out.println(al.get(i)); // output data -> get(index)
		}

		//input data : variable.add(index, data);
		//output data : variable.get(index);
		//remove data : variable.remove(index);
		//modify data : variable.set(index, data);
		//all delete data : variable.clear();	
	}
	public void listTest2() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(50);
		al.add(40);
		al.add(30);
		al.add(20);
		Collections.sort(al); //Sort A to Z
		System.out.println("<Array List> - 1");
		for(int i=0;i<al.size();i++) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		
		Collections.reverse(al); //Reverse ArrayList
		System.out.println("<Array List> - 2");
		for(int i=0;i<al.size();i++) {
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		
	}
	public void listTest3() {
		ArrayList<Integer> alal = new ArrayList<Integer>();
		alal.add(10);
		alal.add(20);
		alal.add(150);
		alal.add(30);
		alal.set(2, 1234);
		for(int i=0; i<alal.size();i++) {
			System.out.println(alal.get(i));
		}
		
	}
	
}
