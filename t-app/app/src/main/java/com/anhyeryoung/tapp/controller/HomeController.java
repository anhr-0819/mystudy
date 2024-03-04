package com.anhyeryoung.tapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements PageController{

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return "/home.jsp";
  }
}
