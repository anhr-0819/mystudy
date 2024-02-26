package com.anhyeryoung.tapp.servlet.auth;

import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
  @Override
  public void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    req.getSession().invalidate();

    String email = req.getParameter("email");
    String password = req.getParameter("password");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>t-app test</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>test page</h1>");
    out.println("<h2>Logout</h2>");

    Member loginUser = (Member) req.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      return;
    }
    req.getSession().invalidate(); // 세션을 종료시키고 연결된 객체 해제
    out.println("<p>로그아웃 완료</p>");

    out.println("</body>");
    out.println("</html>");
  }
}
