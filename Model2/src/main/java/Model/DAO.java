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
			 // 1. ���� �ε�
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 // 2. DB ���� / Connection ��ü ����
			 String url = "jdbc:oracle:thin:@localhost:1521:xe";
			 String dbid = "hr";
			 String dbpw = "hr";
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
		} catch (Exception e) {
			
			e.printStackTrace(); // ������ ������ִ� �޼���
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
	      // 2. id�� smhrd��, pw�� 1234���� ��
	      if(id.equals("smhrd") && pw.equals("1234")){
	         // 3. �α��� ���� > ex12LoginTrue.jsp
	         //      �α��� ���� > ex12LoginFalse.jsp
	         //      response.sendRedirect(); �̿�
	         
	         // ������Ʈ�� �̿� ������ ����
	         // ?�̸�=��
	         response.sendRedirect("ex12LoginTrue.jsp?id=" + id);
	      }else{
	         response.sendRedirect("ex12LoginFalse.jsp");
	      }
	      */
		   connection();
	      try{
	      
	      
	      // 3. sql�� �غ�
	      String sql = "select * from jdbc_member where id = ? and pw = ?";
	      
	      // 4. PreparedStatement ��ü �غ�
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. ���ε庯�� ä���
	      psmt.setString(1, id); // (���° ����ǥ����, ����� ����������)
	      psmt.setString(2, pw);
	      
	      // ����
	      // executeQuery() : select���϶���!
	      // executeUpdate() : update / insert / delete : DB�� ��ȭ������� ��û
	      rs =  psmt.executeQuery();
	      // ResultSet
	      // rs.next() : ���� �����Ͱ� �ִٸ� true / ������ false
	      
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
	      
	      // 3. sql�� �غ�
	      String sql = "insert into jdbc_member values(msg_num_seq.nextval,?, ?, ?,sysdate)";
	      
	      // 4. PreparedStatement ��ü �غ�
	      psmt = conn.prepareStatement(sql);
	      
	      // 5. ���ε庯�� ä���
	      psmt.setString(1, id); // (���° ����ǥ����, ����� ����������)
	      psmt.setString(2, pw);
	      psmt.setString(3, nick);
	      
	      // ����
	      // executeQuery() : select���϶���!
	      // executeUpdate() : update / insert / delete : DB�� ��ȭ������� ��û
	      cnt = psmt.executeUpdate();
	      
	      
	      }catch(Exception e){
	         
	      }finally{
	      
	    	close();  
	      }
	      return cnt;
	      
	   }
	   //===================

	
}
