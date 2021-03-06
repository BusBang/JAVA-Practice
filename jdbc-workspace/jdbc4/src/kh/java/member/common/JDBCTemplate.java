package kh.java.member.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//드라이버 등록
//Connection 객체 생성
//Statement 객체 생성
//ResultSet (경우에 따라)
//결과 처리
//자원 반환

public class JDBCTemplate {	//드라이버 등록 및 Connection 객체 생성
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			// 자동 커밋 방지 설정
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//Connection 닫기. Overloading1
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {	//Connection이 null이 아니며 닫혀있지 않을 때 -> 정상적으로 작동할 때.
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ResultSet 닫기. Overloading2
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {	//ResultSet이 null이 아니며 닫혀있지 않을 때,
				rset.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement 닫기. Overloading3. PreparedStatement는 Statement를 상속하기 때문에 따로 만들필요가 없다. 다형성.
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {	//Statement가 null이 아니며 닫혀있지 않을 때.
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Commit Method
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Rollback Method
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
