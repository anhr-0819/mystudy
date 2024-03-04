<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
  <a href='/index.html'><img src='/img/cat_icon.png' width=60 height=60></a>
  <a href='/member/list'>member</a>

<c:if test="${not empty loginUser}">
  <span>welcome! ${loginUser.name}</span>
  <a href='/app/auth/logout' color='gray'>로그아웃</a>
</c:if>
<c:if test="${empty loginUser}">
  <a href='/app/auth/login' >로그인</a>
</c:if>

<a href='/about.html'>소개</a>
</header>