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
			comVoca=""; //comVoca �ʱ�ȭ
			System.out.println("----<���� �ձ� ����>----");
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >>");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				gameStart();
				break;
			case 2:
				viewScore();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�. ");
				return;
				default : System.out.println("������ ���ڸ� �Է��ϼ���.");
			}
		}
	}

	public void viewScore() {
		System.out.println("====<����� ����>====");
		System.out.println("�¸� : "+win);
		System.out.println("�й� : "+lose);
		System.out.println("=================");
	}

	public void gameStart() {
				
		BufferedReader br = null;
		try {
			//words.txt�� �ҷ��� words ArrayList�� ����
			br = new BufferedReader(new FileReader("C:\\Users\\user1\\Desktop\\words.txt"));
			while(true) { 
				String wordStr = br.readLine();
				if(wordStr == null) {
					break;
				}
				words.add(wordStr);
			}
			//���� ����
			while(true) {
				System.out.println("��� �����Դϴ�.");
				System.out.print("�ܾ �Է��ϼ��� : ");
				String inputVoca = sc.next(); 	// ���� �ܾ� �Է�
				char inputChar = inputVoca.charAt(inputVoca.length()-1);	//�ܾ��� �� ���� ����
				//��ǻ���� �� ���ڷ� �����ϴ� �ܾ� �Է� ���� �˻�
				if(testWord(comVoca, inputVoca)) { 
					userDefeat();
					System.out.println("�� ���ڷ� �����ϴ� �ܾ �Է��ؾ��մϴ�.");
					return;
				}
				//InputVoca�� �ܾ��忡 �ְ�, �ߺ��ܾ �ƴ� ��,
				if(searchWord(words, inputVoca) && !searchWord(dupliWords,inputVoca)) {	
					dupliWords.add(inputVoca); //�ߺ� 1 : �ߺ� �ܾ��忡 ���� ��ī �߰�
					for(String a : words) {	// ��ǻ�� �ܾ��� �����
						if(a.charAt(0) == inputChar) {
							comWords.add(a);
						}
					}
					if(comWords.size()==0) {	//��ǻ�� �й��� ���.
						userWin();
						return;
					}else {	//��ǻ�� �й谡 �ƴѰ��,
						comGetWord();				
					}
				}else if(searchWord(words,inputVoca) && searchWord(dupliWords,inputVoca)){ 
					//InputVoca�� �ܾ��忡 �ְ� �ߺ��϶�,
					userDefeat();
					System.out.println("�ߺ��� �ܾ �Է��߽��ϴ�. ");
					return;
				}else { 
					//�ܾ��忡 ��ǲ ��ī�� ���� ��,
					userDefeat();
					System.out.println("�ܾ��忡 ���� �ܾ �Է��Ͽ����ϴ�. ");
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
	
	private void comGetWord() { //��ǻ���� �ܾ� ���
		String getComWord = comWords.get(ran.nextInt(comWords.size()));	//��ǻ�� �ܾ��忡�� �ܾ� ���� ����
		System.out.println("��ǻ�� ���� :"+getComWord);
		comVoca = getComWord;
		dupliWords.add(getComWord); // �ߺ� 2 : �ߺ� �ܾ��忡 ��ǻ�� ��ī �߰�
		comWords.clear();	//��ǻ�� �ܾ��� �ʱ�ȭ		
	}

	public boolean searchWord(ArrayList<String> search, String word) {
		if(search.contains(word)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void userDefeat() { //������ ���� ��,
		System.out.println("<<<�й�>>>");
		lose++;
		dupliWords.clear();
	}
	public void userWin() { //������ �̰��� ��,
		System.out.println("<<<�¸�>>>");
		System.out.println("����� �̰���ϴ� !!!");
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
