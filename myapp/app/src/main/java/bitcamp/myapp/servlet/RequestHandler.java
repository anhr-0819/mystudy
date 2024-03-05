package bitcamp.myapp.servlet;

import java.lang.reflect.Method;

public class RequestHandler { // RequestHandler <- 클라이언트에서 요청이 들어오면 요청을 처리
  // 메서드를 호출하는데 필요한 인스턴스정보와 메서드 정보를 담는다

  Object controller;
  Method handler;

  public RequestHandler() {
  }

  public RequestHandler(Object controller, Method handler) {
    this.controller = controller;
    this.handler = handler;
  }
}
