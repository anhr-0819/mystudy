package bitcamp.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan(value = {
    "bitcamp.myapp.controller"
}) // AppConfig controller 객체를 생성하도록함
public class AppConfig { // 디스패쳐서블릿이 사용할 IoC 컨테이너 설정

  @Bean
  MultipartResolver multipartResolver() {
    StandardServletMultipartResolver mr = new StandardServletMultipartResolver();
    return mr; // 멀티파트로 넘어오는 파라미터를 처리해주는 객체
  }
  // 서블릿 3.0은 추가하지 않아도 처리한다.
}
