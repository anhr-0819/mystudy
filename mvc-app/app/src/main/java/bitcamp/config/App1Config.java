package bitcamp.config;

import javax.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan(value = "bitcamp.app1")
public class App1Config {
  @Bean
  MultipartResolver multipartResolver() {
    StandardServletMultipartResolver mr = new StandardServletMultipartResolver();
    return mr; // 멀티파트로 넘어오는 파라미터를 처리해주는 객체
  }
}
