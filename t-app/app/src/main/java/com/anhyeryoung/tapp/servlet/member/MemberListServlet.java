package com.anhyeryoung.tapp.servlet.member;

import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>t-app test</title>");
    out.println("</head>");
    out.println("<body>");
    req.getRequestDispatcher("/header").include(req,resp);
    out.println("<h1>회원</h1>");

    out.println("<a href=''>새 회원</a>");
    try {
      out.println("<table border='1'>");
      out.println("    <thead>");
      out.println("    <tr> <th>번호</th> <th>이름</th> <th>이메일</th> <th>가입일</th> </tr>");
      out.println("    </thead>");
      out.println("    <tbody>");

      List<Member> list = memberDao.findAll();

      for (Member member : list) {
        out.printf(
            "<tr> <td>%d</td> <td><a href='/member/view?no=%1$d'>%s</a></td> <td>%s</td> <td>%s</td> </tr>\n",
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getCreatedDate());
      }
      out.println("    </tbody>");
      out.println("</table>");

    } catch (Exception e) {
      req.setAttribute("message","목록 오류.");
      req.setAttribute("exception",e);
      req.getRequestDispatcher("/error").forward(req,resp);
    }
    req.getRequestDispatcher("/footer").include(req,resp);
    out.println("</body>");
    out.println("</html>");
  }
}
