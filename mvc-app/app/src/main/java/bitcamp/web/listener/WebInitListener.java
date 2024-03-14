package bitcamp.web.listener;

import bitcamp.config.AppConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@WebListener
public class WebInitListener implements ServletContextListener {
// ServletContextListener <- 웹 어플리케이션이 시작될 때 서블릿컨테이너가 호출

  private static Log log = LogFactory.getLog(WebInitListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.debug("contextInitialized() 호출됨!");

    ServletContext sc = sce.getServletContext();
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    Dynamic 서블릿설정 = sc.addServlet("app", new DispatcherServlet(appContext));
    // 설정할 수 있는 javax.servlet.ServletRegistration.Dynamic 을 리턴(서블릿 설정 정보를 다루는 객체)
    서블릿설정.addMapping("/app/*");
    서블릿설정.setLoadOnStartup(1);

    
  }
}
