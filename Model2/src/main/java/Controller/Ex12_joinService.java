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
		
		// �ٸ� �޼��忡���� ���������� �� �� �ִ� connection, preparestatement,
		// resultset�� ��������� ���ش�.
		Connection conn =null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		// 1. �Ķ���� ����
		String ID = request.getParameter("ID");
		String PW = request.getParameter("Pw");
		String nick = request.getParameter("nick");
		
		// 1. DAO ��ü ����
		DAO dao = new DAO();
		
		// 2. dao�� ���
		int cnt = dao.Join(ID, PW, nick);
		
		if(cnt > 0) {
			// ȸ������ ����
			// VO��ü ����
			MemberVO vo = new MemberVO(ID, PW, nick);
			
			// Forward ���
			RequestDispatcher rd = request.getRequestDispatcher("Ex12_joinTrue.jsp");
			// �����͸� request��ü�� Attribute�� ����ֱ�
			request.setAttribute("vo", vo);
			// ������ �̵�
			rd.forward(request, response);
			
		}else {
			response.sendRedirect("Ex12_joinFalse.jsp");
		}
		
		
				 
		 
	}

}
