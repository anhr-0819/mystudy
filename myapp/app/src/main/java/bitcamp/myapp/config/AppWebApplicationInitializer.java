package bitcamp.myapp.config;

import java.io.File;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebApplicationInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  AnnotationConfigWebApplicationContext rootContext;

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class};
  } // 컨텍스트로더리스너의 IoC 컨테이너를 직접 만들필요없이 설정클래스만 알려주면된다.

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{AppConfig.class};
  } // 디스패처서블릿의 IoC 컨테이너를 직접 만들필요없이 설정클래스만 알려주면된다.

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/app/*"};
  }

  @Override
  protected void customizeRegistration(Dynamic registration) { // 디스패처서블릿의 추가정보
    registration.setMultipartConfig(new MultipartConfigElement(
        new File("./temp").getAbsolutePath(), // 클라이언트가 올린 파일을 임시보관할 폴더
        //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
        1024 * 1024 * 10,
        1024 * 1024 * 100,
        1024 * 1024 * 1
    ));
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[]{new CharacterEncodingFilter("UTF-8")};
  }
}
