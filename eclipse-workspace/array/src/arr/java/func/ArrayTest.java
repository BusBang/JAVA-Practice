package arr.java.func;
import java.util.Scanner;
import java.util.Random;

public class ArrayTest {
	public void arrayTest1() {
		//������ ���� 5���� ������ �Ѵٸ�?
		int num1, num2, num3, num4, num5;
		//�迭�� ����ϸ�
		int [] num = new int[5];
		//num[0], num[1], num[2], num[3], num[4], num[5]
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
		//0�� ĭ �ӿ� 10 �ֱ�
		num[0] = 10; // ������ �� �����ϴ� �Ͱ� ����
		System.out.println(num[0]);
		
		//0~4ĭ�� 1~5���� �ִ´ٸ�?
		num[0]=1;
		num[1]=2;
		num[2]=3;
		num[3]=4;
		num[4]=5;
		System.out.println(num[0]); //���� �̷� ����� No!
		
		//�ݺ����� ������� for�� ����
		for(int i=0; i<5; i++) {
			num[i] = i;
			System.out.println(num[i]+1);
		}
		
		//String Array //lengthȰ��
		Scanner sc1 = new Scanner(System.in);
		String[] strArr = new String[2]; //strArr �迭 ����
		for(int i=0;i<strArr.length;i++) {  //i�� Ƚ���� strArr �迭�� ���̷� ����
			System.out.print("�̸��� �Է��ϼ��� :");
			strArr[i] = sc1.next();
		}
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
		
		//�迭 �� ���
		//-�迭�� []���� �ε����� ���� ���� �����Ѵٴ� ���� �̿��ϸ� ������ �̿��� ó���� ����
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
		fru[0] = "����";
		fru[1] = "������";
		fru[2] = "Ű��";
		fru[3] = "���";
		fru[4] = "�ٳ���";
						
		//1-1�迭 �ε����� �̿��ؼ� �ٳ��� ���
		System.out.println(fru[4]);
		//1-2for���� �����ʰ� ���
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
		//����3
		Scanner sc3 = new Scanner(System.in);
		String [] subject = {"����", "����", "����", "���", "�հ�"};
		int [] score = new int[4];
		System.out.print("���� ������ �Է��ϼ��� :");
		int kor = sc3.nextInt();
		score[0] = kor;
		System.out.print("���� ������ �Է��ϼ��� :");
		int eng = sc3.nextInt();
		score[1] = eng;
		System.out.print("���� ������ �Է��ϼ��� :");
		int math = sc3.nextInt();
		score[2] = math;
		score[3] = kor+eng+math;
		
		for(int i=0;i<4;i++) {
			System.out.println(subject[i]+" "+score[i]);
		}
		System.out.printf("%s %.2f",subject[4],(double)score[3]/3);
	}
	public void arrayExample4() {
		//���� 4 : ���������� Ȱ���� ���� �������� ����
		Scanner sc4 = new Scanner(System.in);
		int [] input = new int[10]; //�迭 ���� �ٲٸ� �˾Ƽ� ���̿� ���缭 ���ش�. (input.length)
		int count = 1; //����� �۵��ϴ��� ī��Ʈ
		for(int i=0;i<input.length;i++) {
			System.out.print((i+1)+"��° ���� �Է� :");
			input[i] = sc4.nextInt();
		}
		
		for(int i=0;i<input.length;i++) {
			for(int j=0;j<input.length-i-1;j++) {
				if(input[j]>input[j+1]) { //��ȣ�� �ݴ���ϸ� ������������ �ٲ��
					int temp = input[j];
					input[j] = input[j+1]; 
					input[j+1] = temp;
				}
			//����� �۵��ϴ��� �׽�Ʈ
			System.out.println(count+"��° �׽�Ʈ");
			System.out.print(input[0]+" "+input[1]+" "+input[2]+" "+input[3]+" "+input[4]+"\n");
			count++;
			}
		}
		
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+"\t");
		}

	}
	public void motelExample() {
		//���� ���� ���α׷� 
		Scanner sc5 = new Scanner(System.in);
		boolean [] room = new boolean[10]; //[index] index �� ������ �� ���� ���� ����
		
		while(true) {
			System.out.println("========== ���� ���� ���α׷� ==========");
			System.out.println("1.�Խ�	2.���	3.�溸��	4.����");
			System.out.print("���� >>");
			int manuSelect = sc5.nextInt();
			if(manuSelect>4 || manuSelect<1) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			if(manuSelect==4) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
			switch(manuSelect) {
			case 1 : //�Խ�
				while(true) {
					System.out.println("�� �� �濡 �Խ��Ͻðڽ��ϱ�?");
					System.out.print("���� >>");
					int roomSelect = sc5.nextInt();
					if(roomSelect>room.length || roomSelect<1) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}else if (room[roomSelect-1]){
						System.out.println(roomSelect+"�� ���� ���� �մ��� �ֽ��ϴ�.");
					}else {
						System.out.println(roomSelect+"�� ������ �Խ��մϴ�.");
						room[roomSelect-1] = true;
						break;
					}
				}
				break;
			case 2 : //���
				while(true) {
					System.out.println("�� �� �濡�� ����Ͻðڽ��ϱ�?");
					System.out.print("����>>");
					int roomSelect = sc5.nextInt();
					if(roomSelect>room.length || roomSelect<1) {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}else if (room[roomSelect-1]){
						System.out.println(roomSelect+"�� �濡�� ����մϴ�.");
						room[roomSelect-1]=false;
						break;
					}else {
						System.out.println(roomSelect+"�� ���� ����Դϴ�.");
					}
				}
				break;
			case 3: //�溸��
				for(int i=0; i<room.length; i++) {
					if(room[i]) {
						System.out.println(i+1+"�� �濡�� �մ��� �ֽ��ϴ�.");									
					}else {
						System.out.println(i+1+"�� ���� ���� ����ֽ��ϴ�.");									
					}
				}
				break;
			}
		}
	}
	public void arrayTest2() {
		int [] arr1 = {1,2,3,4,5};
		//���� ����
		int [] arr2 = arr1;
		//�� �迭�� �ּҰ� ���
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode()); //���� �ּ� ���� �����ϴ� ���� �� �� �ִ�.
		//arr1 �迭 ���
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		//arr2 �迭 ���
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		//���� ������ ���̴�?
		
		arr1[2]=100;
		arr2[1]=300;
		//�� �迭�� �ּҰ� ���
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode()); //���� �ּ� ���� �����ϴ� ���� �� �� �ִ�.
		//arr1 �迭 ���
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 �迭 ���
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}
		//���� ��� ���� ����ƴ�. 
	}
	public void arrayTest3() {
		int [] arr1 = {1,2,3,4,5};
		
		int [] arr2 = new int[arr1.length];
		
		arr2=arr1.clone(); //���� ����
		/*
		system array�� �̿��� ���� ����
		System.arraycopy(arr1, 0, arr2, 1, 4); //�Ϻθ� ������ �� ���
		*/

		
		/*
		int [] arr2 = new int[arr1.length];
		for(int i = 0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		*/
		//arr1 �迭 ���
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 �迭 ���
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}		
		//���� ����� ���� ������ ���̴�?
		System.out.println();
		arr1[2]=100;
		arr2[1]=300;
		//arr1 �迭 ���
		for(int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		//arr2 �迭 ���
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}		
		
	}
	public void arrayExample6() {
		//���ڿ� �޾Ƽ� ���ڿ��� ���� ���� ����
		Scanner sc1 = new Scanner(System.in);
		int count = 0;
		System.out.print("�Է°� : ");
		String inputText = sc1.next();
		char [] text = new char [inputText.length()]; //�Է� �� ����
		for(int i=0; i<text.length;i++) {
			text[i] = inputText.charAt(i);
		}
		System.out.print("�˻��� : ");
		char search = sc1.next().charAt(0);
		for(int i=0; i<text.length; i++) {
			if(text[i]==search) {
				count++;
			}
		}
		System.out.println("�Է��Ͻ� ���ڿ� "+inputText+"���� ã���ô� ���� "+search+"��(��) "+count+"�� �Դϴ�.");	
	}
	public void arrayExample7() {
		//��ȭ��ȣ �Է� �ް� ��� 4�ڸ� *�� ������
		Scanner sc7 = new Scanner(System.in);
		System.out.print("��ȭ��ȣ�� �Է����ּ��� (���� 010-2467-4685)");
		String input = sc7.next();
		
		char [] inputNumber = new char [input.length()];
		for(int i=0; i<inputNumber.length;i++) {
			inputNumber[i] = input.charAt(i);
		}
		
		//for�� �̿�
		char [] numPaste1 = new char[inputNumber.length];
		for(int i = 0; i < inputNumber.length; i++) {
			numPaste1[i] = inputNumber[i]; 
		}
		//System.arraycopy()�̿�
		char [] numPaste2 = new char[inputNumber.length];
		System.arraycopy(inputNumber,0,numPaste2,0,inputNumber.length);
		
		//clone() �޼ҵ� �̿�
		char [] numPaste3 = new char[inputNumber.length];
		numPaste3 = numPaste1.clone();
		
		//* �ֱ�
		for(int i = 4; i<8; i++) {
			numPaste1[i] = '*';
			numPaste2[i] = '*';
			numPaste3[i] = '*';
		}
		//���
		System.out.println("<<�Է� ��>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(inputNumber[i]);
		}
		System.out.println();
		System.out.println("<<for�� �̿�>>");
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
		//�ֹι�ȣ ���� ���ĺ��� ������
		Scanner sc8 = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է����ּ��� (���� 940816-1234567)");
		String input = sc8.next();
		
		char [] inputNumber = new char [input.length()];
		for(int i=0; i<inputNumber.length;i++) {
			inputNumber[i] = input.charAt(i);
		}
		
		//for�� �̿�
		char [] numPaste1 = new char[inputNumber.length];
		for(int i = 0; i < inputNumber.length; i++) {
			numPaste1[i] = inputNumber[i]; 
		}
		//System.arraycopy()�̿�
		char [] numPaste2 = new char[inputNumber.length];
		System.arraycopy(inputNumber,0,numPaste2,0,inputNumber.length);
		
		//clone() �޼ҵ� �̿�
		char [] numPaste3 = new char[inputNumber.length];
		numPaste3 = numPaste1.clone();
		
		//* �ֱ�
		for(int i = 8; i<inputNumber.length; i++) {
			numPaste1[i] = '*';
			numPaste2[i] = '*';
			numPaste3[i] = '*';
		}
		//���
		System.out.println("<<�Է� ��>>");
		for(int i=0; i<inputNumber.length; i++) {
			System.out.print(inputNumber[i]);
		}
		System.out.println();
		System.out.println("<<for�� �̿�>>");
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
		//�迭�� ũ��� Ȧ���� ���� ������ �Է¹޾� �迭�� �����
		Scanner sc9 = new Scanner(System.in);

		while(true) {
			System.out.print("���ڸ� �Է��ϼ��� :");
			int input = sc9.nextInt();
			int [] arr1 = new int [input];

			if(input%2==0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. Ȧ�� ������ �Է����ּ���.");
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
		
		//�ζ� ���α׷�//
		
		Scanner sc10 = new Scanner(System.in);
		Random ran = new Random();

		
		while(true) {
			int [] userArray = new int [6];
			int [] comArray = userArray.clone();
			int count = 0;
			
			System.out.println("========== �ζ� ���α׷� ==========");
			
			for(int i=0; i<6; i++) {
				boolean bool = true;
				System.out.print(i+1+"��° ��ȣ �Է� (1~45) : ");
				int input = sc10.nextInt();
				if(input>45||input<1) {
					System.out.println("<<System : 1~45 ���� ���� �Է����ּ���>>");
				}else{
					if(i==0) {
						userArray[0] = input;						
					}
					//�ߺ� �˻�
					for(int j=0; j<i;j++) {
						if(userArray[j]==input) {
							System.out.println("�̹� �Է��� ���Դϴ�. �ٽ� �Է����ּ���");
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
			//��ǻ�� �� �ֱ�
			for(int i=0; i<6; i++) {
				boolean bool = true;
				for(int j=0;j<i;j++) {
					comArray[j] = ran.nextInt(45)+1;
					if(comArray[i]==comArray[j]) { //�ߺ��˻�
						while(true) {
							comArray[j] =ran.nextInt(45)+1;
							if(comArray[i]!=comArray[j]) {
								break;
							}
						}
					}
				}
			}

			System.out.println("<<����� ��ȣ>>");
			for(int i=0; i<userArray.length; i++) {
				System.out.print(userArray[i]+" ");
			}
			System.out.println();
			System.out.println("<<��ǻ�� ��ȣ>>");
			for(int i=0; i<comArray.length; i++) {
				System.out.print(comArray[i]+" ");
			}
			//���� ���� �ľ�
			for(int i=0; i<userArray.length; i++) {
				for(int j=0; j<comArray.length; j++) {
					if(userArray[i]==comArray[j]) {
						count++;
					}
				}
			}
			System.out.println("���� ���� : "+count);
			
			//��� 
			switch(count) {
			case 1 : System.out.println("��");
			case 2 :
				break;
			case 3 : System.out.println(count+"�� ��ġ <4��>");
				break;
			case 4 : System.out.println(count+"�� ��ġ <3��>");
				break;
			case 5 : System.out.println(count+"�� ��ġ <2��>");
				break;
			case 6 : System.out.println(count+"�� ���� <1��>");
				break;
			}
			System.out.print("�� �� �� �Ͻðڽ��ϱ�? (1.yes, 2.no) : ");
			int select = sc10.nextInt();
			if(select < 1 || select >2) {
				System.out.println("Do Choice 'Yes' or 'No'");			
			}else if(select == 2) {
				break;
			}
		}		
	}
}
