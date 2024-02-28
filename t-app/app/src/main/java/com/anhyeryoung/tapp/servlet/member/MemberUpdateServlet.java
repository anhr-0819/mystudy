package com.anhyeryoung.tapp.servlet.member;

import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("member/update")
public class MemberUpdateServlet extends HttpServlet {

  private MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      req.setCharacterEncoding("UTF-8");

      int no = Integer.parseInt(req.getParameter("no"));
      Member old = memberDao.findBy(no);
      if (old == null) {
        throw new Exception("회원 번호가 유효하지 않습니다.");
      }

      Member member = new Member();
      member.setName(req.getParameter("name"));
      member.setTel(req.getParameter("tel"));
      member.setEmail(req.getParameter("email"));
      member.setPassword(req.getParameter("password"));
      member.setpCode(req.getParameter("pCode"));
      member.setbAddr(req.getParameter("bAddr"));
      member.setdAddr(req.getParameter("dAddr"));

      memberDao.update(member);
      resp.sendRedirect("list");

    } catch (Exception e) {
      req.setAttribute("message","update error");
      req.setAttribute("exception",e);
      req.getRequestDispatcher("/error").forward(req,resp);
    }
  }
}
