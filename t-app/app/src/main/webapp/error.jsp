<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='UTF-8'>
    <title>t-app test</title>
  </head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<h1>오류!</h1>
<c:if test="${not empty message}">
  <p>${message}</p>
</c:if>
<c:if test="${not empty detail}">
  <pre>${detail}</pre>
</c:if>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>