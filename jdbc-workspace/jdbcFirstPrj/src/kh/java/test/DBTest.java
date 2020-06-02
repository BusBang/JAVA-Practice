package kh.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTest {
	public void main() {

		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver"); //패키지명, 클래스명. 반드시 try/catch를 사용해야함
			//2. 커넥션 객체 생성 (자바랑 오라클을 연결해주는 것) 
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"kh",
					"kh");
			//jdbc를 통해 오라클로 연결할 것이고 thin이라는 방식을 통해 내 ip주소로 들어갈거고 포트번호1521의 xe버전을 사용할 거야. 계정, 패스워드명.
			String query01 = "select emp_name as name from employee"; 
			//3. statement 객체 생성
			Statement stmt = conn.createStatement();
			//4. 쿼리문 요청 후 결과 받기
			ResultSet rset = stmt.executeQuery(query01);
			//5. 결과 처리
			while(rset.next()) { //커서가 다음으로 내려감
				String name = rset.getString("name"); //별칭을 사용하였으면, 별칭으로 꺼내와야한다.
//				int salary = rset.getInt(9);
//				String phone = rset.getString(5);
//				System.out.println(name+"/"+phone+"/"+salary);
				System.out.println(name);
			}
			//6. 자원 반환
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmp() {
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("해고할 직원 이름 입력 : ");
		String fireMember =sc.next();
		String query = "delete from employee where emp_name='"+fireMember+"'"; //따옴표를 써줘야한다.
		
		
		try {
			//1. 드라이버 등록			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			//4. 쿼리 전송 및 결과 받기 -- select할땐 executeQuery를 쓴다
			int result = stmt.executeUpdate(query);
			//5. 결과 처리
			if(result>0) {
				conn.commit();
				System.out.println("삭제 완료");
			}else {
				conn.rollback();
				System.out.println("삭제 실패");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//6. 자원 반환
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
