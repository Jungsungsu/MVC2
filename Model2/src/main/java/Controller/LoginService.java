package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String id = request.getParameter("ID");
         String pw = request.getParameter("Pw");
         
         // Dao ��ü ����
         DAO dao = new DAO();
         
         // DAO��ü�� �޼��� ���
         MemberVO vo = dao.login(id, pw);
         
         if(vo != null){
        	 // 0. request �����͸� ��´�
        	 // request.setAttribute("(String)Name",(Object)���� ��);
        	 // java.lang.Object : ��� Ŭ������ ��ӹ޴� ��ü, �ֻ��� Ŭ����
        	 // ex) String --(��ĳ����)--> Object 
        	 
        	 request.setAttribute("vo", vo);
        	 
        	 RequestDispatcher rd = request.getRequestDispatcher("Ex12_LoginTrue.jsp");
        	 rd.forward(request, response);
             
        
            
            
            // 1. Redirect ���
            
            // 2. Forward ���
            // request.getRequestDispatcher("(String) ���");
            
         }else{
            response.sendRedirect("Ex12_LoginFalse.jsp");
         }

	}
}
