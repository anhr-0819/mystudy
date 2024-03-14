package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImpl implements WebApplicationInitializer {

  private static Log log = LogFactory.getLog(WebApplicationInitializerImpl.class);

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    log.debug("onStartup() 호출됨!");
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();

    ContextLoaderListener listener = new ContextLoaderListener(rootContext);
    servletContext.addListener(listener); // Listener가 시작되기 전이기 때문에 추가 가능!

    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.setParent(rootContext);
    appContext.register(AppConfig.class);
    appContext.refresh();
    Dynamic appServletRegistration = servletContext.addServlet("app", new DispatcherServlet(appContext));
    appServletRegistration.addMapping("/app/*");
    appServletRegistration.setLoadOnStartup(1);

    AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
    adminContext.setParent(rootContext);
    adminContext.register(AdminConfig.class);
    adminContext.refresh();
    Dynamic adminServletRegistration =servletContext.addServlet("admin", new DispatcherServlet(adminContext));
    adminServletRegistration.addMapping("/admin/*");
    adminServletRegistration.setLoadOnStartup(1);
  }
}
