<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.List"%>
<%@ page import="bitcamp.myapp.vo.Board"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<%
String title = "";
int category = Integer.valueOf(request.getParameter("category"));
title = category == 1 ? "게시글" : "가입인사";
%>
<h1><%=title%></h1>
<a href='/board/add?category=<%=category%>'>새 글</a>
<table border='1'>
    <thead>
    <tr> <th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>첨부파일</th> </tr>
    </thead>
    <tbody>
<%
List<Board> list = (List<Board>) request.getAttribute("board");
for (Board board : list) {%>
      <tr>
        <td><%=board.getNo()%></td>
        <td><a href='/board/view?no=<%=board.getNo()%>&category=<%=category%>'><%=board.getTitle()%></a></td>
        <td><%=board.getWriter().getName()%></td>
        <td><%=board.getCreatedDate()%></td>
        <td><%=board.getFileCount()%></td>
      </tr>
<%}%>
    </tbody>
</table>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>