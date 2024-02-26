package com.anhyeryoung.tapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>test page</title>");
    out.println("</head>");
    out.println("<body>");
    req.getRequestDispatcher("/header").include(req,resp);

    out.println("<h1>Main</h1>");
    out.println("<p>test page - main content</p>");

    req.getRequestDispatcher("/footer").include(req,resp);
    out.println("</body>");
    out.println("</html>");
  }
}
