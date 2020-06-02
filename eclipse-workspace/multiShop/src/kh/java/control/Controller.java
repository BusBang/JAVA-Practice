package kh.java.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import kh.java.model.vo.Buylist;
import kh.java.model.vo.Goods;
import kh.java.model.vo.User;
import kh.java.view.View;

public class Controller implements Serializable {
   private static final long serialVersionUID = 11111111111L;
   Scanner sc = new Scanner(System.in);
   HashMap<String, User> users = new HashMap<String, User>();
   HashMap<String, Buylist> buylist = new HashMap<String, Buylist>();
   HashMap<String, Goods> goods = new HashMap<String, Goods>();
   View view = new View();
   ObjectInputStream ois;
   ObjectOutputStream oos;
   String tempName;

   // ����������
   public void main() {

      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
         HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();
         readGoods.put("���������� ����Ŀ��(������ Ŭ����)", new Goods("���������� ����Ŀ��(������ Ŭ����)", 750000));
         readGoods.put("���������� ����Ŀ��(������)", new Goods("���������� ����Ŀ��(������)", 680000));
         readGoods.put("20SS ������ ���̽�(��Ÿ)", new Goods("20SS ������ ���̽�(��Ÿ)", 809000));
         readGoods.put("20SS GUCCI Rhyton(�簢�ΰ�)", new Goods("20SS GUCCI Rhyton(�簢�ΰ�)", 1120000));
         readGoods.put("20SS GUCCI Rhyton(��ΰ�)", new Goods("20SS GUCCI Rhyton(��ΰ�)", 1100000));
         readGoods.put("20SS �߷��þư� Triple S(Ŭ�����)", new Goods("20SS �߷��þư� Triple S(Ŭ�����)", 1180000));
         readGoods.put("20SS �߷��þư� Speed runner", new Goods("20SS �߷��þư� Speed runner", 880000));
         readGoods.put("20SS �߷��þư� Triple S(�������)", new Goods("20SS �߷��þư� Triple S(�������)", 1290000));
         readGoods.put("20SS ����� ��ݷΰ� ��� ����Ŀ��", new Goods("20SS ����� ��ݷΰ� ��� ����Ŀ��", 645000));
         readGoods.put("20SS �����޽�(H) �� ����Ŀ��", new Goods("20SS �����޽�(H) �� ����Ŀ��", 1480000));
         readGoods.put("20SS �߷�Ƽ�� ��Ƽ���͵� V��ũ", new Goods("20SS �߷�Ƽ�� ��Ƽ���͵� V��ũ", 349000));
         readGoods.put("20SS �߷�Ƽ�� �ٿ ���������", new Goods("20SS �߷�Ƽ�� �ٿ ���������", 985000));
         readGoods.put("20SS ��Ī������ ����Ŀ��(Thom Browne)", new Goods("20SS ��Ī������ ����Ŀ��(Thom Browne)", 585000));
         readGoods.put("19FW �ＱX��Ʈ�� Ʈ������ ��Ƽ�÷�", new Goods("19FW �ＱX��Ʈ�� Ʈ������ ��Ƽ�÷�", 999000));
         readGoods.put("20SS OFF White �ַο� ��ũ", new Goods("20SS OFF White �ַο� ��ũ", 305000));
         readGoods.put("19FW ����ȭ��Ʈ �ַμ� ��ġ �ο�ž", new Goods("19FW ����ȭ��Ʈ �ַμ� ��ġ �ο�ž", 345000));
         readGoods.put("20SS Golden Goose ���۽�Ÿ ����Ŀ��", new Goods("20SS Golden Goose ���۽�Ÿ ����Ŀ��", 408000));
         readGoods.put("20SS CHANEL �ͽ������̹� ����Ŀ��", new Goods("20SS CHANEL �ͽ������̹� ����Ŀ��", 1650000));
         readGoods.put("19FW CHANEL ���ڷΰ� ����Ŀ�� ", new Goods("19FW CHANEL ���ڷΰ� ����Ŀ�� ", 1590000));
         readGoods.put("�ǽ����̳ʽ��� ��������1 �Ķ������ GD (Yellow)", new Goods("�ǽ����̳ʽ��� ��������1 �Ķ������ GD (Yellow)", 8500000));

         Set<String> maxKey = readGoods.keySet();
         if (!goods.isEmpty()) {
            for (String one : maxKey) {
               goods.remove(one);
            }
         }
         for (String one : maxKey) {
            goods.put(one, readGoods.get(one));
         }
         view.printMsg("������ �ҷ����� �Ϸ�.");
      } catch (IOException | ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            ois.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      ObjectOutputStream oos = null; // ��ü�� �������� ������Ʈ��
      try {
         FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
         oos = new ObjectOutputStream(fos);
         oos.writeObject(goods);
         view.printMsg("����Ϸ�");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            oos.close();
         } catch (FileNotFoundException e2) {
            e2.printStackTrace();
         } catch (IOException e2) {
            e2.printStackTrace();
         }
      }

      while (true) {
         int sel = view.mainMenu();
         switch (sel) {
         case 1:
            customerMain();
            break;
         case 2:
            managerMain();
            break;
         case 3:
            return;
         default:
            view.printMsg("������ ���ڸ� �Է��Ͻʽÿ�. ");
         }
      }
   }

   // �� ����������
   public void customerMain() {
      if (!customerEnroll()) {
         return;
      }
      while (true) {
         int sel = view.customerMain();

         switch (sel) {
         case 1:
            perchase();
            break;
         case 2:
            perchaseList();
            break;
         case 0:
            return;
         }
      }
   }

   // ������ ����������
   public void managerMain() {
      managerLogin();
      int sel = view.managerMain();
      switch (sel) {
      case 1:
         goodsPrint();
         break;
      case 2:
         goodsEnroll();
         break;
      case 3:
         goodsDelete();
         break;
      case 4:
         goodsModify();
         break;
      case 5:
         userPrint();
         break;
      case 0:
         return;
      }
   }

   // ��ǰ ��ȸ
   public void goodsPrint() {
      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
         HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();
         view.printMsg("��ǰ��\t����");
         Set<String> keys = readGoods.keySet();
         for (String one : keys) {
            System.out.println(readGoods.get(one));
         }
         view.printMsg("---------------------------");

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e2) {
         e2.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            ois.close();
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e2) {
            e2.printStackTrace();
         }
      }
   }

   // ����
   public void perchase() {
      HashMap<String, Goods> temp = objectInput();
      copyAndpaste();
      goodsPrint();
      System.out.println();
      sc.nextLine();      //�������� ���� �����ѹ�
      try {
         System.out.print("��ǰ���� �Է����ּ��� :");      
         String name = sc.nextLine();
         System.out.println("[" + name + "]��ǰ�� �����ϼ̽��ϴ�.");
         System.out.print("��ٱ��Ͽ� �����ðڽ��ϱ�?[y/n] : ");

         char sel = sc.next().charAt(0);
         if (sel == 'y') {
            Buylist tempBuy = new Buylist(tempName, name, temp.get(name).getGoodsPrice());
            buylist.put(tempName, tempBuy);
            System.out.println("��ǰ ������ �Ϸ�Ǿ����ϴ�");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\buylist.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buylist);
            System.out.println("����Ϸ�");
            tempName="";
            name="";
         } else {
            System.out.println("�Է��Ͻ� ��ǰ�� �����ϴ�.");
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            ois.close();
         } catch (Exception e2) {
            e2.printStackTrace();

         }
      }
   }

   // ��1) ���ų���
   public void perchaseList() {
      view.printMsg("----- ���ų��� ��� -----");
      view.printMsg("�̸�\t��ǰ�̸�\t����");
      int totalprice = 0;
      if (!buylist.containsKey(tempName)) {
         view.printMsg("��ٱ��Ͽ� ��ƿ� ������ �����ϴ�.");
      } else {
         Set<String> maxKey = buylist.keySet();
         for (String one : maxKey) {
            view.printMsg(buylist.get(one).getGoodsName() + "\t" + buylist.get(one).getGoodsPrice());
            totalprice += buylist.get(one).getGoodsPrice();
         }
         view.printMsg("------------------------------------");
         view.printMsg("�� ���űݾ��� " + totalprice + "�� �Դϴ�.");
      }

   }

   // ��2) ȸ������
   public boolean customerEnroll() {
      while (true) {
         ObjectOutputStream oos = null;
         try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\customer.txt");
            oos = new ObjectOutputStream(fos);
            while (true) {
               int select = view.customerEnroll2();
               switch (select) {
               case 1:

                  HashMap<String, User> customer = new HashMap<String, User>();

                  User u = view.customerEnroll();
                  customer.put(u.getUserName(), u);

                  tempName = u.getUserName();
                  oos.writeObject(customer);
                  view.printMsg("ȸ������ �Ϸ�");

                  return true;
               case 0:
                  return false;
               }
            }
         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            try {
               oos.close();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

      }
   }

   public boolean managerLogin() {
      while (true) {
         System.out.print("��й�ȣ�� �Է��ϼ��� : ");
         String str = sc.next().toLowerCase();
         String str1 = "admin";
         if (str.equals(str1)) {
            view.printMsg("�����ϼ̽��ϴ�.");
            return true;
         } else {
            view.printMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
            return false;
         }
      }
   }

   // ������
   // 1)��ǰ ���
   public void goodsEnroll() {
      ObjectInputStream ois = null; // ���� ��ǰ �ҷ�����
      ObjectOutputStream oos = null; // ��ü�� �������� ������Ʈ��
      while (true) {
         try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
            HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();

            System.out.print("��ǰ �̸��� �Է����ּ��� : ");
            sc.nextLine();
            String gName = sc.nextLine();
            System.out.print("��ǰ ������ �Է����ּ��� : ");
            int gPrice = sc.nextInt();
            readGoods.put(gName, new Goods(gName, gPrice));

            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readGoods);
            view.printMsg("��ǰ ��� �Ϸ�");
            break;
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e2) {
            e2.printStackTrace();
         } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            try {
               ois.close();
               oos.close();
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            } catch (IOException e2) {
               e2.printStackTrace();
            }
         }
      }
   }

   // 2)��ǰ ����
   public void goodsDelete() {
      Set<String> maxGoods = goods.keySet();
      view.printMsg("��ǰ\t����");
      for (String one : maxGoods) {
         System.out.println(one + "\t" + goods.get(one));
      }
      view.printMsg("======================");
      String name = view.goodsDelete();
      if (goods.containsKey(name)) {
         goods.remove(name);
         view.printMsg("�����Ǿ����ϴ�.");
         ObjectOutputStream oos = null;
         try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(goods);
         } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
         } finally {
            try {
               oos.close();
            } catch (Exception e2) {
               e2.printStackTrace();
            }
         }
      } else {
         view.printMsg("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
      }

   }

   // 3)��ǰ ����
   public void goodsModify() {
      while (true) {
         System.out.println("===== ��ǰ ���� ������ �Դϴ�. =====");
         goodsPrint();
         System.out.print("������ ��ǰ �̸��� �Է��ϼ��� : ");
         String name = sc.next();
         if (goods.containsKey(name)) {
            Goods g = view.goodsModify();
            goods.put(name, g);
            view.printMsg("������ �Ϸ�Ǿ����ϴ�.");
            objectOut();
            break;
         } else if (!goods.containsKey(name)) {
            view.printMsg("��ȸ�� ��ǰ�� �����ϴ�.");
            break;
         }
      }
   }

   // 4)ȸ������ ���
   public void userPrint() {
      ObjectInputStream ois = null;
      try {
         FileInputStream fis = new FileInputStream("C:\\Users\\user1\\Desktop\\customer.txt");
         ois = new ObjectInputStream(fis);
         HashMap<String, User> customer = (HashMap<String, User>) ois.readObject();
         Set <String> max = customer.keySet();
         view.printMsg("�̸�\t��ȭ��ȣ");
         for(String one : max) {
            view.printMsg(customer.get(one).toString());
         }

      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            ois.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

   }

   public String searchGoods() {
      Set<String> keyMax = goods.keySet();
      for (String one : keyMax) {
         if (goods.containsKey(one)) {
            return one;
         }
      }
      return null;
   }
   
   public HashMap<String, Goods> objectInput() {
      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
         HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();
         return readGoods;
      } catch (Exception e) {
         e.printStackTrace();
         // TODO: handle exception
      } finally {
         try {
            ois.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return goods;
   }

   public void objectOut() {
      try {
         FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
         oos = new ObjectOutputStream(fos);
         oos.writeObject(goods);
         view.printMsg("����Ϸ�");
      } catch (Exception e) {
         e.printStackTrace();
         // TODO: handle exception
      } finally {
         try {
            oos.close();
         } catch (Exception e2) {
            e2.printStackTrace();
            // TODO: handle exception
         }
      }
   }

   public void objectOutCustomer() {
      try {
         FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\customer.txt");
         oos = new ObjectOutputStream(fos);
         oos.writeObject(users);
         view.printMsg("����Ϸ�");
      } catch (Exception e) {
         e.printStackTrace();
         // TODO: handle exception
      } finally {
         try {
            oos.close();
         } catch (Exception e2) {
            e2.printStackTrace();
            // TODO: handle exception
         }
      }
   }
   sfadfsdw <Stirng, User> = new sfadfsdw<String, User>();
   
   public HashMap<String, User> objectInputCustomer() {
      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\customer.txt"));
         HashMap<String, User> readUser = (HashMap<String, User>) ois.readObject();
         return readUser;
      } catch (Exception e) {
         e.printStackTrace();
         // TODO: handle exception
      } finally {
         try {
            ois.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return users;
   }

   public void copyAndpaste() {
      HashMap<String, Goods> temp = objectInput();
      Set<String> maxKey = temp.keySet();
      if (!goods.isEmpty()) {
         for (String one : maxKey) {
            goods.remove(one);
         }
      }
      for (String one : maxKey) {
         goods.put(one, temp.get(one));
      }
   }

}