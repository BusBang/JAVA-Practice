package kakao200509;

import java.util.Vector;

public class kakao3 {

	public static void main(String[] args) {
		String [] arr = {"AA", "AB", "AC", "AA", "AC"};
//		int [] indexArr = {0, 0, 0, 0, 0};
		int [] gemIndex = {0, 0, 0, 0, 0};
		
		int [] indexArr = new int[arr.length];
		
		int gindex=1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i].equals(arr[j])) {
					gemIndex[j]=gindex;					
					gemIndex[i]=gindex;
				}
			}
			gindex++;
			System.out.println("gemIndex :"+gemIndex[i]);
		}
		
		//���� ª�� �Ÿ��� ���ؾ� ��.
		
		//1�� ���� ��,
		//���� �ڿ� �ִ� 1���� ������ ���ߵ�.
		
		//1�̻��� 1���� �տ� ������, ���� �ڿ� �ִ� �ͺ��� �ϸ� ��
		//1�̻��� 1���� �ڿ� ������, ���� �տ� �ִ� �ͺ��� �ϸ� ��
		
		
		int findIndex1=0;
		for(int i=0; i<arr.length; i++) {
			int index =0;
			for(int j=0 ; j<arr.length; j++) {
				if(arr[i].equals(arr[j])) {
					index++;
				}
			}
			indexArr[i] = index;
			System.out.println("indexArr :"+indexArr[i]);
		}
		for(int i=0; i<indexArr.length; i++) {
			if(indexArr[i]==1) {
				findIndex1 = i;
			}
			System.out.println("findIndex1:"+findIndex1);
		}
		int findIndex2 = 0;
		for(int i=0; i<indexArr.length; i++) {
			for(int j=0; j<indexArr.length; j++) {
				if(indexArr[i]<indexArr[j] && indexArr[i] != 1) {
					findIndex2 = i;
				}
			}
			System.out.println("findIndex2 :"+findIndex2);
		}
		System.out.println(findIndex2);
		System.out.println(findIndex1);
		int[] answer = {findIndex2+1, findIndex1+1};
		
		
		
		

	}

}
