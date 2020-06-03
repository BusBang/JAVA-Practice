package kh.java.collection;

import java.util.HashMap;
import java.util.Set;

public class MapTest {
	public void test1() {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("one", 1); //input data
		hm.put("two", 2); //input data
		
		System.out.println(hm.get("one"));
		System.out.println(hm.get("two"));
		System.out.println(hm.get("three")); //null ���

		System.out.println("----------------");
		
		hm.put("three", 2); //input a data
		hm.put("two", 3); //input a data
		System.out.println(hm.get("one"));
		System.out.println(hm.get("two"));
		System.out.println(hm.get("three"));
		System.out.println("----------------");
		System.out.println(hm); //print HashMap
		System.out.println("----------------");
		hm.remove("two"); //remove a data
		System.out.println(hm);
		System.out.println("----------------");
		System.out.println(hm.containsKey("one")); //check a duplication
		System.out.println(hm.containsKey("two")); //print false 
		System.out.println(hm.containsKey("three"));
		System.out.println(hm.get("two"));
		System.out.println(hm.containsKey("two")); //print true 
		System.out.println("================");
		//��ü ��� ��� 1 - keySet(); ���� Ű�� ��ȯ���ش�.
		Set<String> key = hm.keySet(); 
		for(String start : key) { //Ű �� ���
			System.out.println(start);
		}
		System.out.println("--------------");
		for(String start : key) { //��� ���
			System.out.println(hm.get(start));
		}
		System.out.println("=======================");
		for(String start : key) { // Ű, ��� ���
			System.out.println("key : "+start+"\t��� : "+hm.get(start));
		}

	}

}