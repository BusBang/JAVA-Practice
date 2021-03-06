package kh.java.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VocaGame {
	
	Scanner sc= new Scanner(System.in);
	Random ran = new Random();
	public int win = 0;
	public int lose = 0;
	ArrayList<String> words = new ArrayList<String>();		
	ArrayList<String> comWords = new ArrayList<String>();
	ArrayList<String> dupliWords = new ArrayList<String>();
	BufferedReader br = null;
	public String comVoca;
	
	public void main() {
		while(true) {
			comVoca=""; //comVoca 초기화
			System.out.println("----<끝말 잇기 게임>----");
			System.out.println("1. 게임 시작");
			System.out.println("2. 전적 보기");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				gameStart();
				break;
			case 2:
				viewScore();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다. ");
				return;
				default : System.out.println("정해진 숫자를 입력하세요.");
			}
		}
	}

	public void viewScore() {
		System.out.println("====<당신의 전적>====");
		System.out.println("승리 : "+win);
		System.out.println("패배 : "+lose);
		System.out.println("=================");
	}

	public void gameStart() {
				
		BufferedReader br = null;
		try {
			//words.txt를 불러와 words ArrayList로 저장
			br = new BufferedReader(new FileReader("C:\\Users\\user1\\Desktop\\words.txt"));
			while(true) { 
				String wordStr = br.readLine();
				if(wordStr == null) {
					break;
				}
				words.add(wordStr);
			}
			//게임 시작
			while(true) {
				System.out.println("당신 차례입니다.");
				System.out.print("단어를 입력하세요 : ");
				String inputVoca = sc.next(); 	// 유저 단어 입력
				char inputChar = inputVoca.charAt(inputVoca.length()-1);	//단어의 끝 글자 추출
				//컴퓨터의 끝 글자로 시작하는 단어 입력 여부 검사
				if(testWord(comVoca, inputVoca)) { 
					userDefeat();
					System.out.println("끝 글자로 시작하는 단어를 입력해야합니다.");
					return;
				}
				//InputVoca가 단어장에 있고, 중복단어가 아닐 때,
				if(searchWord(words, inputVoca) && !searchWord(dupliWords,inputVoca)) {	
					dupliWords.add(inputVoca); //중복 1 : 중복 단어장에 유저 보카 추가
					for(String a : words) {	// 컴퓨터 단어장 만들기
						if(a.charAt(0) == inputChar) {
							comWords.add(a);
						}
					}
					if(comWords.size()==0) {	//컴퓨터 패배인 경우.
						userWin();
						return;
					}else {	//컴퓨터 패배가 아닌경우,
						comGetWord();				
					}
				}else if(searchWord(words,inputVoca) && searchWord(dupliWords,inputVoca)){ 
					//InputVoca가 단어장에 있고 중복일때,
					userDefeat();
					System.out.println("중복된 단어를 입력했습니다. ");
					return;
				}else { 
					//단어장에 인풋 보카가 없을 때,
					userDefeat();
					System.out.println("단어장에 없는 단어를 입력하였습니다. ");
					return;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void comGetWord() { //컴퓨터의 단어 출력
		String getComWord = comWords.get(ran.nextInt(comWords.size()));	//컴퓨터 단어장에서 단어 랜덤 추출
		System.out.println("컴퓨터 차례 :"+getComWord);
		comVoca = getComWord;
		dupliWords.add(getComWord); // 중복 2 : 중복 단어장에 컴퓨터 보카 추가
		comWords.clear();	//컴퓨터 단어장 초기화		
	}

	public boolean searchWord(ArrayList<String> search, String word) {
		if(search.contains(word)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void userDefeat() { //유저가 졌을 때,
		System.out.println("<<<패배>>>");
		lose++;
		dupliWords.clear();
	}
	public void userWin() { //유저가 이겼을 대,
		System.out.println("<<<승리>>>");
		System.out.println("당신이 이겼습니다 !!!");
		win++;
		dupliWords.clear();
		comWords.clear();
	}
	public boolean testWord(String com, String user) {
		if(com.length()>1 && com.charAt(com.length()-1) != (user.charAt(0))) {
			return true;
		}else {
			return false;
		}
	}
}
