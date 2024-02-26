package com.anhyeryoung.tapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println(
        "<footer style='background-color:black; color:gray; padding:10px; font-size:10px; text-align:center;'>");
    out.println("  <address> address:서울 XX구 XXX로00길 00, XXXXX XXX </address>");
    out.println("  <p>&copy; 2024 mystudy project : t-app testing</p>");
    out.println("</footer>");
  }
}
