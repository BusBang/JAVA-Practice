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

   // 메인페이지
   public void main() {

      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
         HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();
         readGoods.put("오버사이즈 스니커즈(오버솔 클리어)", new Goods("오버사이즈 스니커즈(오버솔 클리어)", 750000));
         readGoods.put("오버사이즈 스니커즈(오버솔)", new Goods("오버사이즈 스니커즈(오버솔)", 680000));
         readGoods.put("20SS 구찌밴드 에이스(스타)", new Goods("20SS 구찌밴드 에이스(스타)", 809000));
         readGoods.put("20SS GUCCI Rhyton(사각로고)", new Goods("20SS GUCCI Rhyton(사각로고)", 1120000));
         readGoods.put("20SS GUCCI Rhyton(띠로고)", new Goods("20SS GUCCI Rhyton(띠로고)", 1100000));
         readGoods.put("20SS 발렌시아가 Triple S(클리어솔)", new Goods("20SS 발렌시아가 Triple S(클리어솔)", 1180000));
         readGoods.put("20SS 발렌시아가 Speed runner", new Goods("20SS 발렌시아가 Speed runner", 880000));
         readGoods.put("20SS 발렌시아가 Triple S(블랙에어솔)", new Goods("20SS 발렌시아가 Triple S(블랙에어솔)", 1290000));
         readGoods.put("20SS 지방시 어반로고 밴딩 스니커즈", new Goods("20SS 지방시 어반로고 밴딩 스니커즈", 645000));
         readGoods.put("20SS 에르메스(H) 턴 스니커즈", new Goods("20SS 에르메스(H) 턴 스니커즈", 1480000));
         readGoods.put("20SS 발렌티노 멀티스터드 V펑크", new Goods("20SS 발렌티노 멀티스터드 V펑크", 349000));
         readGoods.put("20SS 발렌티노 바운스 에어오버솔", new Goods("20SS 발렌티노 바운스 에어오버솔", 985000));
         readGoods.put("20SS 펀칭리버토 스니커즈(Thom Browne)", new Goods("20SS 펀칭리버토 스니커즈(Thom Browne)", 585000));
         readGoods.put("19FW 삼선X스트랩 트에리너 멀티컬러", new Goods("19FW 삼선X스트랩 트에리너 멀티컬러", 999000));
         readGoods.put("20SS OFF White 애로우 벌크", new Goods("20SS OFF White 애로우 벌크", 305000));
         readGoods.put("19FW 오프화이트 애로수 패치 로우탑", new Goods("19FW 오프화이트 애로수 패치 로우탑", 345000));
         readGoods.put("20SS Golden Goose 슈퍼스타 스니커즈", new Goods("20SS Golden Goose 슈퍼스타 스니커즈", 408000));
         readGoods.put("20SS CHANEL 믹스드파이버 스니커즈", new Goods("20SS CHANEL 믹스드파이버 스니커즈", 1650000));
         readGoods.put("19FW CHANEL 샤넬로고 스니커즈 ", new Goods("19FW CHANEL 샤넬로고 스니커즈 ", 1590000));
         readGoods.put("피스마이너스원 에어포스1 파라노이즈 GD (Yellow)", new Goods("피스마이너스원 에어포스1 파라노이즈 GD (Yellow)", 8500000));

         Set<String> maxKey = readGoods.keySet();
         if (!goods.isEmpty()) {
            for (String one : maxKey) {
               goods.remove(one);
            }
         }
         for (String one : maxKey) {
            goods.put(one, readGoods.get(one));
         }
         view.printMsg("데이터 불러오기 완료.");
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
      ObjectOutputStream oos = null; // 객체를 내보내는 보조스트림
      try {
         FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
         oos = new ObjectOutputStream(fos);
         oos.writeObject(goods);
         view.printMsg("저장완료");
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
            view.printMsg("정해진 숫자만 입력하십시오. ");
         }
      }
   }

   // 고객 메인페이지
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

   // 관리자 메인페이지
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

   // 상품 조회
   public void goodsPrint() {
      try {
         ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
         HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();
         view.printMsg("상품명\t가격");
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

   // 구매
   public void perchase() {
      HashMap<String, Goods> temp = objectInput();
      copyAndpaste();
      goodsPrint();
      System.out.println();
      sc.nextLine();      //개행제거 위해 엔터한번
      try {
         System.out.print("상품명을 입력해주세요 :");      
         String name = sc.nextLine();
         System.out.println("[" + name + "]제품을 선택하셨습니다.");
         System.out.print("장바구니에 담으시겠습니까?[y/n] : ");

         char sel = sc.next().charAt(0);
         if (sel == 'y') {
            Buylist tempBuy = new Buylist(tempName, name, temp.get(name).getGoodsPrice());
            buylist.put(tempName, tempBuy);
            System.out.println("상품 구입이 완료되었습니다");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\buylist.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buylist);
            System.out.println("저장완료");
            tempName="";
            name="";
         } else {
            System.out.println("입력하신 상품이 없습니다.");
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

   // 고객1) 구매내역
   public void perchaseList() {
      view.printMsg("----- 구매내역 목록 -----");
      view.printMsg("이름\t제품이름\t가격");
      int totalprice = 0;
      if (!buylist.containsKey(tempName)) {
         view.printMsg("장바구니에 담아온 물건이 없습니다.");
      } else {
         Set<String> maxKey = buylist.keySet();
         for (String one : maxKey) {
            view.printMsg(buylist.get(one).getGoodsName() + "\t" + buylist.get(one).getGoodsPrice());
            totalprice += buylist.get(one).getGoodsPrice();
         }
         view.printMsg("------------------------------------");
         view.printMsg("총 구매금액은 " + totalprice + "원 입니다.");
      }

   }

   // 고객2) 회원가입
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
                  view.printMsg("회원가입 완료");

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
         System.out.print("비밀번호를 입력하세요 : ");
         String str = sc.next().toLowerCase();
         String str1 = "admin";
         if (str.equals(str1)) {
            view.printMsg("접속하셨습니다.");
            return true;
         } else {
            view.printMsg("비밀번호가 일치하지 않습니다.");
            return false;
         }
      }
   }

   // 관리자
   // 1)상품 등록
   public void goodsEnroll() {
      ObjectInputStream ois = null; // 기존 상품 불러오기
      ObjectOutputStream oos = null; // 객체를 내보내는 보조스트림
      while (true) {
         try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user1\\Desktop\\Goods.txt"));
            HashMap<String, Goods> readGoods = (HashMap<String, Goods>) ois.readObject();

            System.out.print("상품 이름을 입력해주세요 : ");
            sc.nextLine();
            String gName = sc.nextLine();
            System.out.print("상품 가격을 입력해주세요 : ");
            int gPrice = sc.nextInt();
            readGoods.put(gName, new Goods(gName, gPrice));

            FileOutputStream fos = new FileOutputStream("C:\\Users\\user1\\Desktop\\Goods.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readGoods);
            view.printMsg("상품 등록 완료");
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

   // 2)상품 삭제
   public void goodsDelete() {
      Set<String> maxGoods = goods.keySet();
      view.printMsg("상품\t가격");
      for (String one : maxGoods) {
         System.out.println(one + "\t" + goods.get(one));
      }
      view.printMsg("======================");
      String name = view.goodsDelete();
      if (goods.containsKey(name)) {
         goods.remove(name);
         view.printMsg("삭제되었습니다.");
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
         view.printMsg("해당 상품은 존재하지 않습니다.");
      }

   }

   // 3)상품 수정
   public void goodsModify() {
      while (true) {
         System.out.println("===== 상품 수정 페이지 입니다. =====");
         goodsPrint();
         System.out.print("수정할 상품 이름을 입력하세요 : ");
         String name = sc.next();
         if (goods.containsKey(name)) {
            Goods g = view.goodsModify();
            goods.put(name, g);
            view.printMsg("수정이 완료되었습니다.");
            objectOut();
            break;
         } else if (!goods.containsKey(name)) {
            view.printMsg("조회할 상품이 없습니다.");
            break;
         }
      }
   }

   // 4)회원정보 출력
   public void userPrint() {
      ObjectInputStream ois = null;
      try {
         FileInputStream fis = new FileInputStream("C:\\Users\\user1\\Desktop\\customer.txt");
         ois = new ObjectInputStream(fis);
         HashMap<String, User> customer = (HashMap<String, User>) ois.readObject();
         Set <String> max = customer.keySet();
         view.printMsg("이름\t전화번호");
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
         view.printMsg("저장완료");
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
         view.printMsg("저장완료");
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