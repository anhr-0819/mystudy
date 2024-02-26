package com.anhyeryoung.tapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

  @Override
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

    req.getRequestDispatcher("/header").include(req, resp);

    out.println("<h1>오류!</h1>");

    String message = (String) req.getAttribute("message");
    if (message != null) {
      out.printf("<p>%s</p>\n",message);
    }
    Throwable exception = (Throwable) req.getAttribute("exception");
    if (exception != null) {
      out.println("<pre>");
      exception.printStackTrace(out);
      out.println("</pre>");
    }
    req.getRequestDispatcher("/footer").include(req,resp);
    out.println("</body>");
    out.println("</html>");
  }
}
