package arr.java.func;

import java.util.Scanner;
import java.util.Random;

public class ArrayTest {
	public void arrayPractice1() {
		int [][]arr = new int[2][2];
		int k=0;
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        arr[i][j]=k;
		        k++;
		        System.out.println(arr[i][j]);
		    }
		}
	}
	
	public void arrayPractice2() {
		int [][] arr = new int[3][5];
		arr[0][3] =10;
		arr[2][1] =20;
		System.out.println(arr[0][3]);
		System.out.println(arr[2][1]);
		
		int k=1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=k;
				k++;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		//출력문
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        arr[i][j]=k;
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}

	}
	
	public void arrayExample1() {
		//2차원 배열 실습1
		int [][] arr = new int [5][5];
		int k = 5;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = k*(i+1)-j;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	public void arrayExample2() {
		int [][] arr = new int [5][5];
		int k = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[j][i] = k;
				k++;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	public void arrayExample3() {
		int [][] arr = new int [5][5];
		int k =5;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = k*(j+1)-i;
			}
		}
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	public void arrayExample4() {
		int [][] arr= new int [5][5];
		int k = 1;
		for(int i=0; i<arr.length/2+1; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[2*i][j] = k*10*i+(j+1);
			}	
		}
		for(int i=0; i<arr.length/2; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[2*i+1][j] = k*10*(i+1)-j;
			}
		}
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	public void arrayExample5() {
		int [][] arr= new int [5][5];
		int k = 5;
		for(int i=0; i<arr.length/2+1; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[2*i][j] = (i)*10+k-j;
			}	
		}
		for(int i=0; i<arr.length/2; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[2*i+1][j] = (i)*10+k+1+j;
			}
		}
		//출력
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	
	public void arrayExample6() {
		int [][] arr= new int [5][5];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length/2+1; j++) {
				arr[i][2*j] = (i+1)+10*j;
			}	
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length/2; j++) {
				arr[i][2*j+1] = 10*(j+1)-i;	
			}
		}
		//출력
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}
	}
	public void arrayExample7() {
		int [][] arr= new int [5][5];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length/2+1; j++) {
				arr[i][2*j] = 5-i+10*j;
			}	
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length/2; j++) {
				arr[i][2*j+1] = 5+(i+1)+10*j;	
			}
		}
		//출력
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}	
	}
	public void arrayExample8() {
		//이차원 배열 크기를 입력받아 랜덤으로 알파벳 소문자 넣기
		Scanner sc8 = new Scanner(System.in);
		Random rand = new Random();
		while(true) {
			System.out.print("가로열 갯수를 입력하세요. (1~10):");
			int inputH = sc8.nextInt();
			if(inputH>10 || inputH<1) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}else{
				System.out.print("세로열 갯수를 입력하세요. (1~10):");
				int inputV = sc8.nextInt();
				if(inputV>10 || inputV<1) {
					System.out.println("잘못 입력하셨습니다.");
					continue;					
				}else {
					char [][] arr = new char [inputH][inputV];
					
					for(int i=0; i<arr.length; i++) {
						for(int j=0; j<arr[i].length; j++) {
							char letter = (char)(rand.nextInt(16)+97);
							arr[i][j] = letter;
						}
					}
				//출력
				for(int i=0; i<arr.length; i++) {
				    for(int j=0; j<arr[i].length; j++) {
				        System.out.print(arr[i][j]+"\t");
				    }
				System.out.println();
				
				}
				break;
				}
			}
			
		}
				
		
	}
	public void arrayExample9() {
		Scanner sc9 = new Scanner(System.in);
		
		//달팽이 배열 (시계 방향)
		System.out.print("2차원 배열 크기 입력(정방형) :");
		int input = sc9.nextInt();
		int [][] arr = new int [input][input];
		int start = 0; //int end =0; // end = arr.length
		int k = 1; 
		for(int a=start; a<arr.length/2+1;a++) { //반복 
			for(int j=a; j<arr[a].length-a; j++) { //좌에서 우
				arr[a][j] = k;
				k++;
			}
			for(int i=a; i<arr[a].length-1-a; i++) { //위에서 아래
				arr[i+1][arr.length-a-1] = k;
				k++;
			}
			for(int j=arr.length-1; j>2*a; j--) { //오른쪽끝 -> 왼쪽끝 . 0은 시작값 = start
				arr[arr.length-a-1][j-a-1] = k;
				k++;
			}
			for(int i=arr.length-a-1; i>a+1; i--) { //아래에서 위. 0은 시작값=start. [0][0]은 포함하면 안 됨
				arr[i-1][a] = k;
				k++;
			}
		}
		//출력
		for(int i=0; i<arr.length; i++) {
		    for(int j=0; j<arr[i].length; j++) {
		        System.out.print(arr[i][j]+"\t");
		    }
		System.out.println();
		}	
	}
	public void kakaoExample() {
		//카카오 예제 - 비밀지도 문제 (난이도 : 하)
		Scanner scK = new Scanner(System.in); //Scanner
		
		System.out.print("지도 1, 2의 크기를 정해주세요 : "); //지도크기 n
		int n = scK.nextInt();
		int [] map1 = new int[n];
		int [] map2 = new int[n];
		boolean [][] arr1 = new boolean [n][n];
		boolean [][] arr2 = new boolean [n][n];
		char [][] mergeMap = new char [n][n];
	
		for(int i=0; i<n; i++) {
			System.out.print("지도 1의 값 "+n+"개를 넣어주세요.(가능한 값 : 0<x<"+(int)(Math.pow(2,n))+") : ");
			map1[i] = scK.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			System.out.print("지도 2의 값 "+n+"개를 넣어주세요.(가능한 값 : 0<x<"+(int)(Math.pow(2,n))+") : ");
			map2[i] = scK.nextInt();
		}
		
		System.out.println("arr1 입력 값 :");
		for(int i=0; i<n; i++) {
			System.out.print(map1[i]+"\t");
		}
		System.out.println();
		
		System.out.println("arr2 입력 값 :");
		for(int i=0; i<n; i++) {
			System.out.print(map2[i]+"\t");
		}
		System.out.println();

		//Array 1 : 배열에 true/false 넣기
		for(int i=0;i<arr1.length; i++) {
			for(int j=0;j<map1.length;j++) {
				if(map1[i]%2==1 && map1[i]!=1) {
					arr1[i][arr1.length-1-j]=true;
					map1[i] = map1[i]/2;
				}else if(map1[i]%2==0 && map1[i]!=1){
					map1[i] = map1[i]/2;
					arr1[i][arr1.length-1-j]=false;
				}else if(map1[i]==1 && map1[i]!=2) {
					arr1[i][map1.length-1-j]=true;
					break;
				}
			}
		}

		//Array 2 : 배열에 1과 0 넣기
		for(int i=0;i<arr2.length; i++) {
			for(int j=0;j<map2.length;j++) {
				if(map2[i]%2==1 && map2[i]!=1) {
					arr2[i][arr2.length-1-j]=true;
					map2[i] = map2[i]/2;
				}else if(map2[i]%2==0 && map2[i]!=1){
					map2[i] = map2[i]/2;
					arr2[i][arr2.length-1-j]=false;
				}else if(map2[i]==1 && map2[i]!=2) {
					arr2[i][map2.length-1-j]=true;
					break;
				}
			}
		}
		/*
		//Arr1 전체 보기
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j]+"\t");
			}
			System.out.println();
		}
		//Arr2 전체 보기
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j]+"\t");
			}
			System.out.println();
		}
		*/
		//지도합치기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr1[i][j]==false && arr2[i][j]==false) {
					mergeMap[i][j] = ' ';
				}else{
					mergeMap[i][j] = '#';
				}
			}
		}
		/*
		//합친 지도 보기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(mergeMap[i][j]+"\t");
			}
			System.out.println();
		}
		*/
		//합친 지도 출력
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				System.out.print(mergeMap[i][j]);
			}
			System.out.println();
		}
	
	}

}
