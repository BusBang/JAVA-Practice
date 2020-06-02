package kakao200509;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Kakao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 500;
		int num2 = 300;
		
		
		String numString = Integer.toString(num1);
//		System.out.println(numString.length());
		// + * -
		
		ArrayList <String> arr = new ArrayList<String>();
		ArrayList <String> arr1 = new ArrayList<String>();
		ArrayList <String> arr2 = new ArrayList<String>();
		
		int index = 0;	//*
		int index1 = 0;	//-
		int index2 = 0;	//+
		
		String input = "100-200*300-500+20";
		StringTokenizer st = new StringTokenizer(input, "*");
		index = st.countTokens()-1;
		while(st.hasMoreTokens()) {
			arr.add(st.nextToken());
//			index++;
		}
		System.out.println(arr);
		for(int i=0; i<arr.size(); i++) {
			StringTokenizer st1 = new StringTokenizer(arr.get(i), "-");
			while(st1.hasMoreTokens()) {
				arr1.add(st1.nextToken());
			}
		}
		System.out.println(arr1);
		for(int i=0; i<arr1.size(); i++) {
			StringTokenizer st2 = new StringTokenizer(arr1.get(i), "+");
			while(st2.hasMoreTokens()) {
				arr2.add(st2.nextToken());				
			}
		}
//		if(arr2.size()>arr1.size()) {
//			int [] answer = new int [arr2.size()];
//			for(int i=0; i<arr2.size(); i++) {
//				answer[i] = Integer.parseInt(arr2.get(i));
//			}
//		}else if(arr1.size()>arr.size()) {
//			int [] answer = new int[arr1.size()];
//			for(int i=0; i<arr1.size(); i++) {
//				answer[i] = Integer.parseInt(arr1.get(i));
//			}			
//		}else {
//			int [] answer = new int[arr.size()];
//			for(int i=0; i<arr.size(); i++) {
//				answer[i] = Integer.parseInt(arr.get(i));
//			}
//		}
//		String [] arrayString = new String[];
		
		index1 = arr1.size()-arr.size();
		index2 = arr2.size()-arr1.size();
		System.out.println(arr2);
		System.out.println(index);
		System.out.println(index1);
		System.out.println(index2);
		//Á¤·Ä
		String temp;

//		System.out.println(answer.length);
		for(int i=0; i<arr2.size()-1; i++) {
			for(int j=0; j<arr2.size()-1; j++) {
				if(Integer.parseInt(arr2.get(i)) > Integer.parseInt(arr2.get(i+1))) {
					temp = arr2.get(i);
					arr2.set(i, arr2.get(i+1));
					arr2.set(i+1, temp);
				}				
			}
		}
		System.out.println(arr2);
		
		
		
	}

}
