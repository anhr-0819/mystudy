package bitcamp.app2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터셉터 만들기
// => 프론트 컨트롤러와 페이지 컨트롤러 사이에 코드를 삽입하는 기술
// => 프론트 컨트롤러와 뷰 컴포넌트 사이에 코드를 삽입하는 기술
//
// 인터셉터를 배치하기
// => 프론트 컨트롤러의 IoC 설정 파일에 배치 정보를 추가한다.
//
public class Interceptor1 implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("Interceptor1.preHandle()");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("Interceptor1.postHandle()");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    System.out.println("Interceptor1.afterCompletion()");
  }
}
