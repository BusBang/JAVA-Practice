package kh.java.view;

import java.io.Serializable;
import java.util.Scanner;

import kh.java.model.vo.Buylist;
import kh.java.model.vo.Goods;
import kh.java.model.vo.User;

public class View implements Serializable{
   private static final long serialVersionUID = 11111111111L;
   Scanner sc = new Scanner(System.in);

   //메인 페이지
   public int mainMenu() {

      System.out.println("☆★☆★☆★멀티샵에 오신것을 환영합니다☆★☆★☆★");
      System.out.println("당신은 누구십니까 ? ");
      System.out.println("1. 고객");
      System.out.println("2. 관리자");
      System.out.println("3. 프로그램 종료");
      System.out.print("선택 >> ");
      int sel = sc.nextInt();
      return sel;

   }
   
   //고객메인페이지
   public int customerMain() {
      
      System.out.println("☆★☆★☆★지갑을 열어주세요☆★☆★☆★");
        System.out.println("1. 상품 구매");
        System.out.println("2. 구매 내역");
        System.out.println("0. 돌아가기");
        System.out.print("선택 > ");
        int sel = sc.nextInt();
        return sel;
   }
   
   //관리자 메인 페이지
   public int managerMain() {
      System.out.println("=======관리자 모드입니다=======");
          System.out.println("1. 상품 전체 조회");
          System.out.println("2. 상품 등록");
          System.out.println("3. 상품 삭제");
          System.out.println("4. 상품 수정");
          System.out.println("5. 회원 정보 출력");
          System.out.println("0. 돌아가기");
          System.out.print("선택 > ");
          int sel = sc.nextInt();
          return sel;
   }
   
   //출력문 간략화
   public void printMsg(String msg) {
      System.out.println(msg);
   }
   
   //회원가입
   public User customerEnroll() {
       System.out.print("이름을 입력하세요 : ");
         String name = sc.next();
         System.out.print("핸드폰 번호를 입력하세요 [\"-\" 필수] : ");
         String phone = sc.next();
         User u = new User(name,phone);
         return u;
   }
   //회원가입
   public int customerEnroll2() {
      System.out.println("회원가입 페이지입니다.");
        System.out.println("회원가입을 원하시면 1번을 눌러주세요");
        System.out.println("뒤로가기는 0번 입니다.");
        System.out.print("선택 > ");
        int select = sc.nextInt();
        return select;
   }
   
   //상품 수정
   public Goods goodsModify() {
        System.out.print("수정할 이름을 입력하세요 : ");
          String nGoodsName = sc.next();
          System.out.print("수정할 가격을 입력하세요 : ");
          int nGoodsPrice = sc.nextInt();
          Goods g = new Goods(nGoodsName,nGoodsPrice);
          return g;
   }

   
   //상품 삭제
   public String goodsDelete() {
      System.out.print("삭제할 상품의 이름을 입력하세요 : ");
      sc.nextLine();
      String name = sc.nextLine();
      return name;
   }
   
}