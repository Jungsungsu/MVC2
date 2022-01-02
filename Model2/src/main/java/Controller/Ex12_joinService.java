package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/Ex12_joinService")
public class Ex12_joinService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 다른 메서드에서도 공통적으로 쓸 수 있는 connection, preparestatement,
		// resultset을 멤버변수로 빼준다.
		Connection conn =null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		// 1. 파라미터 수집
		String ID = request.getParameter("ID");
		String PW = request.getParameter("Pw");
		String nick = request.getParameter("nick");
		
		// 1. DAO 객체 생성
		DAO dao = new DAO();
		
		// 2. dao를 사용
		int cnt = dao.Join(ID, PW, nick);
		
		if(cnt > 0) {
			// 회원가입 성공
			// VO객체 생성
			MemberVO vo = new MemberVO(ID, PW, nick);
			
			// Forward 방식
			RequestDispatcher rd = request.getRequestDispatcher("Ex12_joinTrue.jsp");
			// 데이터를 request객체의 Attribute로 담아주기
			request.setAttribute("vo", vo);
			// 페이지 이동
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("Ex12_joinFalse.jsp");
		}
		
		
				 
		 
	}

}
