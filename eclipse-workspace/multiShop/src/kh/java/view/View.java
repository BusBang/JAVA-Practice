package kh.java.view;

import java.io.Serializable;
import java.util.Scanner;

import kh.java.model.vo.Buylist;
import kh.java.model.vo.Goods;
import kh.java.model.vo.User;

public class View implements Serializable{
   private static final long serialVersionUID = 11111111111L;
   Scanner sc = new Scanner(System.in);

   //���� ������
   public int mainMenu() {

      System.out.println("�١ڡ١ڡ١ڸ�Ƽ���� ���Ű��� ȯ���մϴ١١ڡ١ڡ١�");
      System.out.println("����� �����ʴϱ� ? ");
      System.out.println("1. ��");
      System.out.println("2. ������");
      System.out.println("3. ���α׷� ����");
      System.out.print("���� >> ");
      int sel = sc.nextInt();
      return sel;

   }
   
   //������������
   public int customerMain() {
      
      System.out.println("�١ڡ١ڡ١������� �����ּ���١ڡ١ڡ١�");
        System.out.println("1. ��ǰ ����");
        System.out.println("2. ���� ����");
        System.out.println("0. ���ư���");
        System.out.print("���� > ");
        int sel = sc.nextInt();
        return sel;
   }
   
   //������ ���� ������
   public int managerMain() {
      System.out.println("=======������ ����Դϴ�=======");
          System.out.println("1. ��ǰ ��ü ��ȸ");
          System.out.println("2. ��ǰ ���");
          System.out.println("3. ��ǰ ����");
          System.out.println("4. ��ǰ ����");
          System.out.println("5. ȸ�� ���� ���");
          System.out.println("0. ���ư���");
          System.out.print("���� > ");
          int sel = sc.nextInt();
          return sel;
   }
   
   //��¹� ����ȭ
   public void printMsg(String msg) {
      System.out.println(msg);
   }
   
   //ȸ������
   public User customerEnroll() {
       System.out.print("�̸��� �Է��ϼ��� : ");
         String name = sc.next();
         System.out.print("�ڵ��� ��ȣ�� �Է��ϼ��� [\"-\" �ʼ�] : ");
         String phone = sc.next();
         User u = new User(name,phone);
         return u;
   }
   //ȸ������
   public int customerEnroll2() {
      System.out.println("ȸ������ �������Դϴ�.");
        System.out.println("ȸ�������� ���Ͻø� 1���� �����ּ���");
        System.out.println("�ڷΰ���� 0�� �Դϴ�.");
        System.out.print("���� > ");
        int select = sc.nextInt();
        return select;
   }
   
   //��ǰ ����
   public Goods goodsModify() {
        System.out.print("������ �̸��� �Է��ϼ��� : ");
          String nGoodsName = sc.next();
          System.out.print("������ ������ �Է��ϼ��� : ");
          int nGoodsPrice = sc.nextInt();
          Goods g = new Goods(nGoodsName,nGoodsPrice);
          return g;
   }

   
   //��ǰ ����
   public String goodsDelete() {
      System.out.print("������ ��ǰ�� �̸��� �Է��ϼ��� : ");
      sc.nextLine();
      String name = sc.nextLine();
      return name;
   }
   
}