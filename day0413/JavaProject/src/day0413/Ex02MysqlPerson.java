package day0413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class Ex02MysqlPerson {
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	static final String URL = "jdbc:mysql://localhost:3306/bitcamp";//5버전
	static final String URL = "jdbc:mysql://localhost:3306/bitcamp?serverTimezone=Asia/Seoul";//5,8버전
	Scanner sc = new Scanner(System.in);
	
	public Ex02MysqlPerson () {
		try {
			Class.forName(DRIVER);
//			System.out.println("mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 드라이버 실패:"+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(URL, "root", "1234");
//			System.out.println("mysql 성공");
		} catch (SQLException e1) {
			System.out.println("mysql 실패:"+e1.getMessage());
		}
		return conn;
	}
	
	public int getMenu() {
		System.out.println("** 메뉴선택 **");
		System.out.println("1.추가 2.전체출력 3.삭제 4.분석 5.종료");
		int n = Integer.parseInt(sc.nextLine());
		return n;
	}
	
	public void personInsert() {
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		String sql = "";
		//필요한 데이타 입력
		System.out.println("이름 입력");
		String name = sc.nextLine();
		System.out.println("혈액형 입력");
		String blood = sc.nextLine();
		System.out.println("나이 입력");
		int age = Integer.parseInt(sc.nextLine());
		
		//db 연결
		conn = this.getConnection();
		sql = "insert into person (name,blood,age,writeday) values (?,?,?,now())";
		
		try {
			//sql 검사
			pstmt = conn.prepareStatement(sql);
			//물음표 갯수만큼 반드시 바인딩:?는 1번부터 시작
			pstmt.setString(1,  name);
			pstmt.setString(2, blood);
			pstmt.setInt(3, age);
			//실행
			pstmt.execute();
			System.out.println("추가되었습니다!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void AllWrite() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from person order by name";
		
		//db연결
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t** Person DB 목록 **");
			System.out.println();
			System.out.println("번호\t이름\t혈액형\t나이\t작성일");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				String num = rs.getString("num");
				String name = rs.getString("name");
				String blood = rs.getString("blood").toUpperCase();//대문자로 변환
				int age = rs.getInt("age");
				Timestamp ts = rs.getTimestamp("writeday");
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+age+"\t"+sdf.format(ts));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void personDelete() {
		//이름을 입력 후 해당 데이타 삭제
		//삭제 후 "삭제되었습니다" 메세지 출력
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		//필요한 데이타 입력
		System.out.println("삭제할 데이타 이름 입력");
		String name = sc.nextLine();
		
		//db연결
		conn = this.getConnection();
		sql = "delete from person where name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.execute();
			System.out.println("삭제되었습니다!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void personBloodGroup() {
		//혈액형별 인원수와 평균나이 출력(group by이용)
		/*
		 * 	혈액형	인원수	평균나이
		 * 	A형		2		32(정수로)
		 * 	B형		3		29
		 * 	....
		 */
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select blood, count(*), round(avg(age),0) from person group by blood";
		
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t** Person group by blood DB **");
			System.out.println();
			System.out.println("혈액형\t인원수\t평균나이");
			while(rs.next()) {
				String blood = rs.getString("blood");
				String cnt = rs.getString("count(*)");
				String avg = rs.getString("round(avg(age),0)");
				System.out.println(blood+"\t"+cnt+"\t"+avg);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static void main(String[] args) {
		Ex02MysqlPerson ex = new Ex02MysqlPerson();
		while(true) {
			int n = ex.getMenu();
			switch(n) {
			case 1:
				ex.personInsert();
				break;
			case 2:
				ex.AllWrite();
				break;
			case 3:
				ex.personDelete();
				break;
			case 4:
				ex.personBloodGroup();
				break;
			default:
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
	}

}
