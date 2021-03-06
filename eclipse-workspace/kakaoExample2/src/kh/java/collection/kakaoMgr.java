package kh.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class kakaoMgr {
	Scanner sc = new Scanner(System.in);	
	String cities;
	int usedTime;

	HashMap<String, Integer> hm = new HashMap<String, Integer>();

	public void run() {
		System.out.println("캐시 크기를 입력해주세요 [0<=캐시크기<=30]");
		int cacheSize = sc.nextInt();
		if(cacheSize<0 || cacheSize>30) {
			System.out.println("캐시 크기를 초과하였습니다. ");
			return;
		}else if(cacheSize>0 && cacheSize<=30){
			while(true) {
				System.out.print("도시 이름을 입력해주세요 : ");
				String inputCity = sc.next().toUpperCase();
				if(hm.size()<cacheSize) { //도시수 < 캐시사이즈
					Set <String> maxKey = hm.keySet();
					if(hm.containsKey(inputCity)) {  //목록에 있을 때 (1)
						for(String one : maxKey) {
							if(hm.containsKey(inputCity)) {
								hm.put(one, 1);
							}else {
								hm.put(one, hm.get(one)+1);
							}	
						}
						usedTime += 1;
						System.out.println(hm.keySet()+"/"+usedTime); //출력
					}else { //목록에 없을 때, (2)
						for(String one : maxKey) {
							hm.put(one, hm.get(one)+1);
						}
						hm.put(inputCity, 1);
						usedTime += 5;
						System.out.println(hm.keySet()+"/"+usedTime); //출력
					}
				}else if(hm.size()==cacheSize) { //도시수 = 캐시사이즈
					Set <String> maxKey = hm.keySet();
					if(hm.containsKey(inputCity)) { //목록에 있을 때 (3)
						for(String one : maxKey) {
							if(hm.containsKey(inputCity)) {
								hm.put(one, 1);
							}else {
								hm.put(one, hm.get(one)+1);
							}
						}
						usedTime +=1 ;
						System.out.println(hm.keySet()+"/"+usedTime); //출력
					}else { //목록에 없을 때 (4) // 오래된 도시 빼기, 다른 도시 +1, time +5
						ArrayList<String> list = new ArrayList<String>(maxKey); //value 비교를 위한 arraylist생성
						for(String one : maxKey) {
							list.add(one);						
						}
						int bigInt=0;
						int index =0;
						for(int i=0; i<list.size()-1;i++) {
							if(hm.get(list.get(i))<hm.get(list.get(i+1))) {
								if(bigInt<hm.get(list.get(i+1))) {
									bigInt = hm.get(list.get(i+1));
									index = i+1;
								}
							}else {
								if(bigInt<hm.get(list.get(i))) {
									bigInt = hm.get(list.get(i));
									index = i;
								}
							}
						}
						for(String one : maxKey) {
							hm.put(one, hm.get(one)+1);
						}
						hm.remove(list.get(index));
						hm.put(inputCity, 1);
						usedTime+=5;
						System.out.println(hm.keySet()+"/"+usedTime);
					}
				}
			}			
		}else if(cacheSize == 0) {
			while(true) {
				System.out.print("도시 이름을 입력해주세요 : ");
				String inputCity = sc.next().toUpperCase();
				usedTime += 5;
				System.out.println(hm.keySet()+"/"+usedTime);				
			}
		}
	}
}
