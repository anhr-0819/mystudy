package com.anhyeryoung.tapp.servlet;

import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<header>");
    out.println("  <a href='/index.html'><img src='/img/cat_icon.png' width=60 height=60></a>");
    out.println("  <a href='/member/list'>member</a>");

    Member loginUser = (Member) req.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("  <a href='/auth/login'>login</a>");
    } else {
      out.printf("  <span>welcome! %s</span>\n", loginUser.getName());
      out.println("  <a href='/auth/logout' color='gray'>logout</a>");
    }
    out.println("</header>");

  }
}
