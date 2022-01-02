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
  		// request에 담긴 Attribute 가져오기
  		// Attribute로 데이터를 담을때, Object로 업캐스팅 --> 받아서 변수에 담아서 활용하려면 다운캐스팅
  		MemberVO vo = (MemberVO)request.getAttribute("vo");
   %>

   <fieldset>
   
      <h1>  <%= vo.getNickname() %>님 회원가입이 성공하셨습니다. </h1>
   
   </fieldset>

</body>
</html>