package bitcamp.myapp.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서브 클래스에게 메서드를 상속해줄 용도로 만든 클래스
// -> 이러한 클래스는 추상클래스로 만든다.
public abstract class HttpServlet extends GenericServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    service(request, response);
    // this.service(request,response) <-- this 생략
    // this에 저장된 인스턴스의 클래스부터 메서드를 찾아 올라간다.
  }

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }
}
