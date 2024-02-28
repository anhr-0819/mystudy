package com.anhyeryoung.tapp.servlet.auth;

import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  MemberDao memberDao;

  @Override
  public void init() {
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String email = "";
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>t-app test</title>");
    out.println("</head>");

    out.println("<body>");
    req.getRequestDispatcher("/header").include(req,resp);

    out.println("<h1>login page</h1>");

    out.println("<form action='/auth/login' method='post'>");
    out.println("<div>");
    out.printf("이메일: <input name='email' type='text' value='%s'>",email);
    out.println("</div>");
    out.println("<div>");
    out.println("암호: <input name='password' type='password'>");
    out.println("</div>");
    out.println("<button>로그인</button>");
    out.println("<input name='saveEmail' type='checkbox'> save email");
    out.println("</form>");

    req.getRequestDispatcher("/footer").include(req,resp);
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>t-app test</title>");
    out.println("</head>");
    out.println("<body>");
    req.getRequestDispatcher("/header").include(req,resp);
    out.println("<h1>login page</h1>");

      Member member = memberDao.findByEmailAndPassword(email, password);
      if (member != null) {
        req.getSession().setAttribute("loginUser", member);
        memberDao.update(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Timestamp(System.currentTimeMillis())));
        out.printf("<p>%s 님 환영합니다.</p>\n", member.getName());
        resp.setHeader("Refresh","1;url=/index.html");
      } else {
        out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");
        resp.setHeader("Refresh","1;url=/index.html");
      }
      req.getRequestDispatcher("/footer").include(req,resp);
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      req.setAttribute("message","로그인 오류.");
      req.setAttribute("exception",e);
      req.getRequestDispatcher("/error").forward(req,resp);
    }
  }
}
