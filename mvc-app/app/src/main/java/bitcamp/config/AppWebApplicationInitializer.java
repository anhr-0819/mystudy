package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AppWebApplicationInitializer extends AbstractDispatcherServletInitializer {

  private static Log log = LogFactory.getLog(AppWebApplicationInitializer.class);
  AnnotationConfigWebApplicationContext rootContext;

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null;
    // ContextLoaderListener가 사용할 IoC컨테이너를 리턴
    // AdminWebApplicationInitializer에서 이미 만들었기 때문에 null을 리턴한다.
    // null이면 ContextLoaderListener를 만들지 않는다.
  }

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    appContext.refresh();
    return appContext; // DispatcherServlet이 사용할 IoC컨테이너를 리턴
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }
}
