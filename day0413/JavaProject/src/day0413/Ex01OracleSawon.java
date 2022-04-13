package day0413;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ex01OracleSawon {
   static final String DRIVER="oracle.jdbc.driver.OracleDriver";
   static final String URL="jdbc:oracle:thin:@localhost:1521:xe";

   Scanner sc=new Scanner(System.in);
   
   public Ex01OracleSawon() {
   
      try {
         Class.forName(DRIVER);
//         System.out.println("오라클 드라이버 성공!");
      } catch (ClassNotFoundException e) {
         System.out.println("오라클 드라이버 실패!:"+e.getMessage());
         e.printStackTrace();
      }
   }
   
   public int getMenu()
   {
      System.out.println("**메뉴 선택**");
      System.out.println("1.사원추가 2.전체사원출력 3.종료");
      int n=Integer.parseInt(sc.nextLine());
      return n;
   }
   
   //db 서버에 연결하는 메서드
   public Connection getConnection()   {
      Connection conn=null;
      try {
         conn=DriverManager.getConnection(URL, "bit901","1234");
//         System.out.println("db 연결 성공!");
      } catch (SQLException e) {
         System.out.println("db 연결 실패!"+e.getMessage());
         
      }
      return conn;
   }
   
   public void sawonInsert()   {
      Connection conn = this.getConnection();
      Statement stmt = null;
      
      System.out.println("사원명:");
      String name = sc.nextLine();
      System.out.println("부서명(홍보부,인사부,교육부):");
      String buseo = sc.nextLine();
      System.out.println("기본급");
      int gibon = Integer.parseInt(sc.nextLine());
      System.out.println("수당");
      int sudang = Integer.parseInt(sc.nextLine());
      
      String sql = "insert into sawon values (seq_bit.nextval,'"+name
                  +"','"+buseo+"',"+gibon+","+sudang+",sysdate)";
//      System.out.println(sql);
      
      try {
      stmt = conn.createStatement();
      //sql문을 실행
      stmt.execute(sql);
      
      System.out.println("DB에 데이타가 추가되었어요!!");
   } catch (SQLException e) {
      System.out.println("insert 오류:"+e.getMessage());
   } finally {
      try {
         if(stmt != null) stmt.close();
         if(conn != null) conn.close();
      }catch(SQLException e) {
         
      }
   }
      
   }
   
   public void sawonAllWrite()   {
      Connection conn = this.getConnection();
      Statement stmt = null;
      ResultSet rs = null;
      String sql = "select * from sawon order by name";//이름순
      
      try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      //제목
      System.out.println("번호\t사원명\t부서명\t기본급\t수당\t총급여\t등록일");
      while(rs.next()){
         //일단 열번호 가져와보자
//         int num = rs.getInt(1);
//         String name = rs.getString(2);
//         String buseo = rs.getString(3);
//         int gibon = rs.getInt(4);
//         int sudang = rs.getInt(5);
//         int total = gibon + sudang;
//         Timestamp ts = rs.getTimestamp(6);
         
         //컬럼명으로 가져와 보자
         int num = rs.getInt("num");
         String name = rs.getString("name");
         String buseo = rs.getString("buseo");
         int gibon = rs.getInt("gibon");
         int sudang = rs.getInt("sudang");
         int total = gibon + sudang;
         Timestamp ts = rs.getTimestamp("writeday");
         
         
         
         //날짜를 문자열로 변환
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
         System.out.println(num+"\t"+name+"\t"+buseo+"\t"+gibon+"\t"+sudang+"\t"+total+"\t"+sdf.format(ts));
               
      };
   } catch (SQLException e) {
      e.printStackTrace();
   }finally {
      try {
         if(rs != null) rs.close();
         if(stmt != null) stmt.close();
         if(conn != null) conn.close();
      }catch(SQLException e) {
         
      }
   }
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Ex01OracleSawon ex=new Ex01OracleSawon();
      while(true)
      {
         int n=ex.getMenu();
         switch(n)
         {
         case 1:
            ex.sawonInsert();
            break;
         case 2:
            ex.sawonAllWrite();
            break;
         default:
            System.out.println("프로그램 종료!!");
            System.exit(0);
         }
      }
   }

}