<%@page import="Model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
fieldset{
   border: dotted;
   text-align: center;
}

</style>
</head>
<body>
   <%
  		// request�� ��� Attribute ��������
  		// Attribute�� �����͸� ������, Object�� ��ĳ���� --> �޾Ƽ� ������ ��Ƽ� Ȱ���Ϸ��� �ٿ�ĳ����
  		MemberVO vo = (MemberVO)request.getAttribute("vo");
   %>

   <fieldset>
   
      <h1>  <%= vo.getNickname() %>�� ȸ�������� �����ϼ̽��ϴ�. </h1>
   
   </fieldset>

</body>
</html>