package com.anhyeryoung.tapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PageController {
  String execute(HttpServletRequest request, HttpServletResponse response);
}
