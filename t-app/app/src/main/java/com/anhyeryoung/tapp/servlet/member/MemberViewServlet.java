package com.anhyeryoung.tapp.servlet.member;

import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

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
    out.println("<h1>회원정보</h1>");

    try {
      int no = Integer.parseInt(req.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='/member/update'>");
      out.println("<div>");
      out.println("<input name='email' type='text'>");
      out.println("</div>");

      out.println("<button>저장</button>");
      out.println("</form>");


    } catch (Exception e) {

    }

    out.println("</body>");
    out.println("</html>");
  }
}
