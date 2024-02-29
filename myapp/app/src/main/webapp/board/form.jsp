<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List"%>
<%@ page import="bitcamp.myapp.vo.Board"%>
<%@ page import="bitcamp.myapp.vo.AttachedFile"%>

<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>과제 관리 시스템</h1>

<%
String title = "";
int category = Integer.valueOf(request.getParameter("category"));
title = category == 1 ? "게시글" : "가입인사";
%>
<h2><%=title%></h2>

<form action='/board/add?category=<%=category%>' method='post' enctype='multipart/form-data'>
  <div>
        <input name='category' type='hidden' value='<%=category%>'>
  </div>
  <div>
        제목: <input name='title' type='text'>
  </div>
  <div>
        내용: <textarea name='content'></textarea>
  </div>
  <div>
        첨부파일: <input multiple name='files' type='file'>
  </div>
  <div>
    <button>등록</button>
  </div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>