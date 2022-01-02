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
      // 1. 파라미터 수집
      // Attribute값을 가져오기
      // request.getAttribute("이름");
   	  // setAttribute로 저장할때 Object타입으로 저장한다.
   	  // getAttribute로 꺼낼때, Object타입으로 리턴된다.
   	  // 다운캐스팅 (명시적 형변환) 필요
      MemberVO vo = (MemberVO)request.getAttribute("vo");
   %>

   <fieldset>
   
      <h1>  <%=vo.getNickname() %>님 환영합니다. </h1>
   
   </fieldset>

</body>
</html>