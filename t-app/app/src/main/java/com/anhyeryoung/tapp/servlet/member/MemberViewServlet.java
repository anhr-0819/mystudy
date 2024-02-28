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

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
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
    out.println("<h1>member</h1>");


      int no = Integer.parseInt(req.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<hr><h5>기본정보</h5><hr>");
      out.println("<form action='/member/update' method='post'>");
      out.println("<div>");
      out.println("<span>회원번호:</span>");
      out.printf("<input readonly name='no' type='text' value='%d'>\n",member.getNo());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>이름:</span>");
      out.printf("<input name='name' type='text' value='%s'>\n",member.getName());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>이메일:</span>");
      out.printf("<input name='email' type='text' value='%s'>\n",member.getEmail());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>암호:</span>");
      out.println("<input name='password' type='password'>");
      out.println("</div>");
      out.println("<hr><h5>상세정보</h5><hr>");
      out.println("<div>");
      out.println("<span>전화번호:</span>");
      out.printf("<input name='tel' type='text' value='%s'>\n",member.getTel());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>우편번호:</span>");
      out.printf("<input name='pCode' type='text' value='%s'>\n",member.getpCode());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>기본주소:</span>");
      out.printf("<input name='bAddr' type='text' value='%s'>\n",member.getbAddr());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>상세주소:</span>");
      out.printf("<input name='dAddr' type='text' value='%s'>\n",member.getdAddr());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>가입일:</span>");
      out.printf("<input readonly name='createdDate' type='date' value='%s'>\n",member.getCreatedDate());
      out.println("</div>");
      out.println("<div>");
      out.println("<span>권한:</span>");
      out.printf("<input readonly name='authority' type='text' value='%s'>\n",member.getAuthority());
      out.println("</div>");

      out.println("<div>");
      out.println("<button>저장</button>");
      out.println("</div>");
      out.println("</form>");
      req.getRequestDispatcher("/footer").include(req,resp);
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      req.setAttribute("message","view error");
      req.setAttribute("exception",e);
      req.getRequestDispatcher("/error").forward(req,resp);
    }
  }
}
