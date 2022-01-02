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
         
         // Dao 객체 생성
         DAO dao = new DAO();
         
         // DAO객체의 메서드 사용
         MemberVO vo = dao.login(id, pw);
         
         if(vo != null){
        	 // 0. request 데이터를 담는다
        	 // request.setAttribute("(String)Name",(Object)담을 값);
        	 // java.lang.Object : 모든 클래스가 상속받는 객체, 최상위 클래스
        	 // ex) String --(업캐스팅)--> Object 
        	 
        	 request.setAttribute("vo", vo);
        	 
        	 RequestDispatcher rd = request.getRequestDispatcher("Ex12_LoginTrue.jsp");
        	 rd.forward(request, response);
             
        
            
            
            // 1. Redirect 방식
            
            // 2. Forward 방식
            // request.getRequestDispatcher("(String) 경로");
            
         }else{
            response.sendRedirect("Ex12_LoginFalse.jsp");
         }

	}
}
