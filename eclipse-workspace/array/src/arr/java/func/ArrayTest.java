package arr.java.func;
import java.util.Scanner;
import java.util.Random;

public class ArrayTest {
	public void arrayTest1() {
		//정수형 변수 5개를 만들어야 한다면?
		int num1, num2, num3, num4, num5;
		//배열을 사용하면
		int [] num = new int[5];
		//num[0], num[1], num[2], num[3], num[4], num[5]
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
		//0번 칸 속에 10 넣기
		num[0] = 10; // 변수에 값 대입하는 것과 같음
		System.out.println(num[0]);
		
		//0~4칸에 1~5값을 넣는다면?
		num[0]=1;
		num[1]=2;
		num[2]=3;
		num[3]=4;
		num[4]=5;
		System.out.println(num[0]); //이제 이런 방법은 No!
		
		//반복문을 배웠으니 for를 쓰자
		for(int i=0; i<5; i++) {
			num[i] = i;
			System.out.println(num[i]+1);
		}
		
		//String Array //length활용
		Scanner sc1 = new Scanner(System.in);
		String[] strArr = new String[2]; //strArr 배열 선언
		for(int i=0;i<strArr.length;i++) {  //i의 횟수로 strArr 배열의 길이로 선언
			System.out.print("이름을 입력하세요 :");
			strArr[i] = sc1.next();
		}
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
		
		//배열 값 기록
		//-배열은 []안의 인덱스를 통해 값에 접근한다는 것을 이용하면 변수를 이용한 처리가 가능
		int [] arrarr = new int[3];
		int index =0;
		arrarr[index++] = 1;
		arrarr[index++] = 2;
		arrarr[index++] = 3;
		for(int i=0;i<3;i++) {
			System.out.println(arrarr[i]);
		}

	}
	
	public void arrayExample1() {
		String [] fru = new String[5];
		fru[0] = "딸기";
		fru[1] = "복숭아";
		fru[2] = "키위";
		fru[3] = "사과";
		fru[4] = "바나나";
						
		//1-1배열 인덱스를 이용해서 바나나 출력
		System.out.println(fru[4]);
		//1-2for문을 쓰지않고 출력
		System.out.println(fru[0]);
		System.out.println(fru[1]);
		System.out.println(fru[2]);
		System.out.println(fru[3]);
		System.out.println(fru[4]);

		for(int i=0;i<fru.length;i++) {
			System.out.println(fru[i]);
		}
	
	}
	public void arrayExample2() {
		int [] leng = new int[100];
		for (int i = 0; i<100; i++) {
			leng[i] = i+1;
			System.out.println(leng[i]);
		}
	}
	public void arrayExample3() {
		//예제3
		Scanner sc3 = new Scanner(System.in);
		String [] subject = {"국어", "영어", "수학", "평균", "합계"};
		int [] score = new int[4];
		System.out.print("국어 점수를 입력하세요 :");
		int kor = sc3.nextInt();
		score[0] = kor;
		System.out.print("영어 점수를 입력하세요 :");
		int eng = sc3.nextInt();
		score[1] = eng;
		System.out.print("수학 점수를 입력하세요 :");
		int math = sc3.nextInt();
		score[2] = math;
		score[3] = kor+eng+math;
		
		for(int i=0;i<4;i++) {
			System.out.println(subject[i]+" "+score[i]);
		}
		System.out.printf("%s %.2f",subject[4],(double)score[3]/3);
	}
	public void arrayExample4() {
		//예제 4 : 버블정렬을 활용한 숫자 오름차순 정리
		Scanner sc4 = new Scanner(System.in);
		int [] input = new int[10]; //배열 수만 바꾸면 알아서 길이에 맞춰서 해준다. (input.length)
		int count = 1; //제대로 작동하는지 카운트
		for(int i=0;i<input.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 :");
			input[i] = sc4.nextInt();
		}
		
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input.length-i-1;j++) {
				if(input[j]>input[j+1]) { //부호를 반대로하면 내림차순으로 바뀐다
					int temp = input[j];
					input[j] = input[j+1]; 
					input[j+1] = temp;
				}
			//제대로 작동하는지 테스트
			System.out.println(count+"번째 테스트");
			System.out.print(input[0]+" "+input[1]+" "+input[2]+" "+input[3]+" "+input[4]+"\n");
			count++;
			}
		}
		
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+"\t");
		}

	}
	public void motelExample() {
		//모텔 예약 프로그램 
		Scanner sc5 = new Scanner(System.in);
		boolean [] room = new boolean[10]; //[index] index 값 수정시 방 갯수 변경 가능
		
		while(true) {
			System.out.println("========== 모텔 관리 프로그램 ==========");
			System.out.println("1.입실	2.퇴실	3.방보기	4.종료");
			System.out.print("선택 >>");
			int manuSelect = sc5.nextInt();
			if(manuSelect>4 || manuSelect<1) {
				System.out.println("잘못 입력하셨습니다.");
			}
			if(manuSelect==4) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			switch(manuSelect) {
			case 1 : //입실
				while(true) {
					System.out.println("몇 번 방에 입실하시겠습니까?");
					System.out.print("선택 >>");
					int roomSelect = sc5.nextInt();
					if(roomSelect>room.length || roomSelect<1) {
						System.out.println("잘못 입력하셨습니다");
					}else if (room[roomSelect-1]){
						System.out.println(roomSelect+"번 방은 현재 손님이 있습니다.");
					}else {
						System.out.println(roomSelect+"번 방으로 입실합니다.");
						room[roomSelect-1] = true;
						break;
					}
				}
				break;
			case 2 : //퇴실
				while(true) {
					System.out.println("몇 번 방에서 퇴실하시겠습니까?");
					System.out.print("선택>>");
					int roomSelect = sc5.nextInt();
					if(roomSelect>room.length || roomSelect<1) {
						System.out.println("잘못 입력하셨습니다");
					}else if (room[roomSelect-1]){
						System.out.println(roomSelect+"번 방에서 퇴실합니다.");
						room[roomSelect-1]=false;
						break;
					}else {
						System.out.println(roomSelect+"번 방은 빈방입니다.");
					}
				}
				break;
			case 3: //방보기
				for(int i=0; i<room.length; i++) {
					if(room[i]) {
						System.out.println(i+1+"번 방에는 손님이 있습니다.");									
					}else {
						System.out.println(i+1+"번 방은 현재 비어있습니다.");									
					}
				}
				break;
			}
		}
	}
	public void arrayTest2() {
		int [] arr1 = {1,2,3,4,5};
		//얕은 복사
		int [] arr2 = arr1;
		//각 배열의 주소값 출력
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode()); //같은 주소 값을 참조하는 것을 알 수 있다.
		//arr1 배열 출력
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		//arr2 배열 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		//얕은 복사의 차이는?
		
		arr1[2]=100;
		arr2[1]=300;
		//각 배열의 주소값 출력
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode()); //같은 주소 값을 참조하는 것을 알 수 있다.
		//arr1 배열 출력
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 배열 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		//양쪽 모두 값이 복사됐다. 
	}
	public void arrayTest3() {
		int [] arr1 = {1,2,3,4,5};
		
		int [] arr2 = new int[arr1.length];
		
		arr2=arr1.clone(); //깊은 복사
		/*
		system array를 이용한 얕은 복사
		System.arraycopy(arr1, 0, arr2, 1, 4); //일부만 복사할 때 사용
		*/

		
		/*
		int [] arr2 = new int[arr1.length];
		for(int i = 0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		*/
		//arr1 배열 출력
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 배열 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}		
		//깊은 복사와 얕은 복사의 차이는?
		System.out.println();
		arr1[2]=100;
		arr2[1]=300;
		//arr1 배열 출력
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 배열 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}		
		
	}
	public void arrayExample6() {
		//문자열 받아서 문자열에 문자 개수 세기
		Scanner sc1 = new Scanner(System.in);
		int count = 0;
		System.out.print("입력값 : ");
		String inputText = sc1.next();
		char [] text = new char [inputText.length()]; //입력 값 선언
		for(int i=0; i<text.length;i++) {
			text[i] = inputText.charAt(i);
		}
		System.out.print("검색값 : ");
		char search = sc1.next().charAt(0);
		for(int i=0; i<text.length; i++) {
			if(text[i]==search) {
				count++;
			}
		}
		System.out.println("입력하신 문자열 "+inputText+"에서 찾으시는 문자 "+search+"는(은) "+count+"개 입니다.");	
	}
	public void arrayExample7() {
		//전화번호 입력 받고 가운데 4자리 *로 가리기
		Scanner sc7 = new Scanner(System.in);
		System.out.print("전화번호를 입력해주세요 (형식 010-2467-4685)");
		String input = sc7.next();
		
		char [] inputNumber = new char [input.length()];
		for(int i=0; i<inputNumber.length;i++) {
			inputNumber[i] = input.charAt(i);
		}
		
		//for문 이용
		char [] numPaste1 = new char[inputNumber.length];
		for(int i = 0; i < inputNumber.length; i++) {
			numPaste1[i] = inputNumber[i]; 
		}
		//System.arraycopy()이용
		char [] numPaste2 = new char[inputNumber.length];
		System.arraycopy(inputNumber,0,numPaste2,0,inputNumber.length);
		
		//clone() 메소드 이용
		char [] numPaste3 = new char[inputNumber.length];
		numPaste3 = numPaste1.clone();
		
		//* 넣기
		for(int i = 4; i<8; i++) {
			numPaste1[i] = '*';
			numPaste2[i] = '*';
			numPaste3[i] = '*';
		}
		//출력
		System.out.println("<<입력 값>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(inputNumber[i]);
		}
		System.out.println();
		System.out.println("<<for문 이용>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste1[i]);
		}
		System.out.println();
		System.out.println("<<arraycopy>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste2[i]);
		}
		System.out.println();
		System.out.println("<<clone>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste2[i]);
		}
		
	}
	public void arrayExample8() {
		//주민번호 성별 이후부터 가리기
		Scanner sc8 = new Scanner(System.in);
		System.out.print("주민번호를 입력해주세요 (형식 940816-1234567)");
		String input = sc8.next();
		
		char [] inputNumber = new char [input.length()];
		for(int i=0; i<inputNumber.length;i++) {
			inputNumber[i] = input.charAt(i);
		}
		
		//for문 이용
		char [] numPaste1 = new char[inputNumber.length];
		for(int i = 0; i < inputNumber.length; i++) {
			numPaste1[i] = inputNumber[i]; 
		}
		//System.arraycopy()이용
		char [] numPaste2 = new char[inputNumber.length];
		System.arraycopy(inputNumber,0,numPaste2,0,inputNumber.length);
		
		//clone() 메소드 이용
		char [] numPaste3 = new char[inputNumber.length];
		numPaste3 = numPaste1.clone();
		
		//* 넣기
		for(int i = 8; i<inputNumber.length; i++) {
			numPaste1[i] = '*';
			numPaste2[i] = '*';
			numPaste3[i] = '*';
		}
		//출력
		System.out.println("<<입력 값>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(inputNumber[i]);
		}
		System.out.println();
		System.out.println("<<for문 이용>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste1[i]);
		}
		System.out.println();
		System.out.println("<<arraycopy>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste2[i]);
		}
		System.out.println();
		System.out.println("<<clone>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(numPaste2[i]);
		}
	}
	
	public void arrayExample9() {
		//배열의 크기로 홀수인 양의 정수를 입력받아 배열을 만들기
		Scanner sc9 = new Scanner(System.in);

		while(true) {
			System.out.print("숫자를 입력하세요 :");
			int input = sc9.nextInt();
			int [] arr1 = new int [input];

			if(input%2==0) {
				System.out.println("잘못 입력하셨습니다. 홀수 정수를 입력해주세요.");
			}else {
				int count =(input/2)+1;
				for (int i = 0; i < count; i++) {
					arr1[i] = i+1;
				}
				for (int i = count; i < arr1.length; i++) {
					arr1[i] =arr1.length - i;
				}
				for (int i=0; i < arr1.length; i++) {
					System.out.print(arr1[i]+" ");
				}
				break;
			}
		}
	}
	public void arrayExample10() {
		
		//로또 프로그램//
		
		Scanner sc10 = new Scanner(System.in);
		Random ran = new Random();

		
		while(true) {
			int [] userArray = new int [6];
			int [] comArray = userArray.clone();
			int count = 0;
			
			System.out.println("========== 로또 프로그램 ==========");
			
			for(int i=0; i<6; i++) {
				boolean bool = true;
				System.out.print(i+1+"번째 번호 입력 (1~45) : ");
				int input = sc10.nextInt();
				if(input>45||input<1) {
					System.out.println("<<System : 1~45 사이 값을 입력해주세요>>");
				}else{
					if(i==0) {
						userArray[0] = input;						
					}
					//중복 검사
					for(int j=0; j<i;j++) {
						if(userArray[j]==input) {
							System.out.println("이미 입력한 값입니다. 다시 입력해주세요");
							bool = false;
							i--;
							break;
						}
					if(bool) {
						userArray[i] = input;													
					}
					}
				}
			}
			//컴퓨터 값 넣기
			for(int i=0; i<6; i++) {
				boolean bool = true;
				for(int j=0;j<i;j++) {
					comArray[j] = ran.nextInt(45)+1;
					if(comArray[i]==comArray[j]) { //중복검사
						while(true) {
							comArray[j] =ran.nextInt(45)+1;
							if(comArray[i]!=comArray[j]) {
								break;
							}
						}
					}
				}
			}

			System.out.println("<<사용자 번호>>");
			for(int i=0; i<userArray.length; i++) {
				System.out.print(userArray[i]+" ");
			}
			System.out.println();
			System.out.println("<<컴퓨터 번호>>");
			for(int i=0; i<comArray.length; i++) {
				System.out.print(comArray[i]+" ");
			}
			//맞은 갯수 파악
			for(int i=0; i<userArray.length; i++) {
				for(int j=0; j<comArray.length; j++) {
					if(userArray[i]==comArray[j]) {
						count++;
					}
				}
			}
			System.out.println("맞은 갯수 : "+count);
			
			//등수 
			switch(count) {
			case 1 : System.out.println("꽝");
			case 2 :
				break;
			case 3 : System.out.println(count+"개 일치 <4등>");
				break;
			case 4 : System.out.println(count+"개 일치 <3등>");
				break;
			case 5 : System.out.println(count+"개 일치 <2등>");
				break;
			case 6 : System.out.println(count+"개 일지 <1등>");
				break;
			}
			System.out.print("한 번 더 하시겠습니까? (1.yes, 2.no) : ");
			int select = sc10.nextInt();
			if(select < 1 || select >2) {
				System.out.println("Do Choice 'Yes' or 'No'");			
			}else if(select == 2) {
				break;
			}
		}		
	}
}
