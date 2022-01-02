package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	   MemberVO vo = null;
	   Connection conn = null;   
	   PreparedStatement psmt = null;
	   ResultSet rs = null;
	   int cnt = 0;
	   
	   public void connection() {
		   
		 try {
			 // 1. 동적 로딩
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 // 2. DB 연결 / Connection 객체 생성
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String dbid = "hr";
			 String dbpw = "hr";
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
		} catch (Exception e) {
			
			e.printStackTrace(); // 오류를 출력해주는 메서드
		}  
		   
		   
	   }
	   // =============================================
	   
	   public void close() {
		   
		   
	         try {
	            if( psmt != null){
	               psmt.close();
	            }
	            if(conn != null){
	               conn.close();
	            }
	            
	         } catch (Exception e2) {
	            // TODO: handle exception
	         }
	         
	      }

	   
	   
	   public MemberVO login(String id, String pw) {
	      /*
	      // 2. id가 smhrd고, pw가 1234인지 비교
	      if(id.equals("smhrd") && pw.equals("1234")){
	         // 3. 로그인 성공 > ex12LoginTrue.jsp
	         //      로그인 실패 > ex12LoginFalse.jsp
	         //      response.sendRedirect(); 이용
	         
	         // 쿼리스트링 이용 데이터 전달
	         // ?이름=값
	         response.sendRedirect("ex12LoginTrue.jsp?id=" + id);
	      }else{
	         response.sendRedirect("ex12LoginFalse.jsp");
	      }
	      */
		   connection();
	      try{
	      
	      
	      // 3. sql문 준비
	      String sql = "select * from jdbc_member where id = ? and pw = ?";
	      
	      // 4. PreparedStatement 객체 준비
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. 바인드변수 채우기
	      psmt.setString(1, id); // (몇번째 물음표인지, 어떤값을 넣을것인지)
	      psmt.setString(2, pw);
	      
	      // 실행
	      // executeQuery() : select문일때만!
	      // executeUpdate() : update / insert / delete : DB에 변화가생기는 요청
	      rs =  psmt.executeQuery();
	      // ResultSet
	      // rs.next() : 다음 데이터가 있다면 true / 없으면 false
	      
	      if(rs.next() == true) {
	         String userId = rs.getString("id");
	         String userPw = rs.getString("pw");
	         String userNick = rs.getString("nickname");
	         
	         vo = new MemberVO(userId, userPw, userNick);
	      }
	      
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         
	       close();
	      }
	      return vo;
	   }
	   // ============
	   
	   // 2. Join
	   public int Join(String id, String pw, String nick) {
	      

	      int cnt = 0;
	      
	      try{
	      
	      connection();
	      
	      // 3. sql문 준비
	      String sql = "insert into jdbc_member values(msg_num_seq.nextval,?, ?, ?,sysdate)";
	      
	      // 4. PreparedStatement 객체 준비
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. 바인드변수 채우기
	      psmt.setString(1, id); // (몇번째 물음표인지, 어떤값을 넣을것인지)
	      psmt.setString(2, pw);
	      psmt.setString(3, nick);
	      
	      // 실행
	      // executeQuery() : select문일때만!
	      // executeUpdate() : update / insert / delete : DB에 변화가생기는 요청
	      cnt = psmt.executeUpdate();
	      
	      
	      }catch(Exception e){
	         
	      }finally{
	      
	    	close();  
	      }
	      return cnt;
	      
	   }
	   //===================

	
}
