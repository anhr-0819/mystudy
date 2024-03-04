package com.anhyeryoung.tapp.servlet;

import com.anhyeryoung.tapp.controller.PageController;
import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {
  private Map<String, PageController> controllerMap = new HashMap<>();

  @Override
  public void init() throws ServletException {
    ServletContext ctx = this.getServletContext();
    MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
    TransactionManager txManager = (TransactionManager) ctx.getAttribute("txManager");

    controllerMap.put("/home",null);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PageController controller = controllerMap.get(req.getPathInfo());
    if (controller == null) {
      throw new ServletException(req.getPathInfo()+" 요청 페이지를 찾을 수 없습니다.");
    }
    try {
      String viewUrl = controller.execute(req,resp);
      if (viewUrl.startsWith("redirect:")) {
        resp.sendRedirect(viewUrl.substring(9));
      } else {
        req.getRequestDispatcher(viewUrl).forward(req,resp);
      }
    } catch (Exception e) {
      req.setAttribute("message",req.getPathInfo()+" 실행 오류");

      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      req.setAttribute("detail",stringWriter.toString());

      req.getRequestDispatcher("/error.jsp").forward(req,resp);
    }
  }
}
