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
      // 1. �Ķ���� ����
      // Attribute���� ��������
      // request.getAttribute("�̸�");
   	  // setAttribute�� �����Ҷ� ObjectŸ������ �����Ѵ�.
   	  // getAttribute�� ������, ObjectŸ������ ���ϵȴ�.
   	  // �ٿ�ĳ���� (����� ����ȯ) �ʿ�
      MemberVO vo = (MemberVO)request.getAttribute("vo");
   %>

   <fieldset>
   
      <h1>  <%=vo.getNickname() %>�� ȯ���մϴ�. </h1>
   
   </fieldset>

</body>
</html>