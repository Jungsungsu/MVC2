<%@page import="Model.DAO"%>
<%@page import="java.io.DataOutput"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

// 1. �Ķ���� ����
String ID = request.getParameter("ID");
String PW = request.getParameter("Pw");
String nick = request.getParameter("nick");

// 2. DAO ��ü ����
DAO dao = new DAO();


// 3. dao�� �޼��� ���
int cnt = dao.Join(ID,PW,nick);

if(cnt >0){
	   response.sendRedirect("Ex12_joinTrue.jsp?nick=" + nick);
	}else{
	   response.sendRedirect("Ex12_joinFalse.jsp");
	}



	
%>
</body>
</html>