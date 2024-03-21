package bitcamp.myapp.config;

import java.io.File;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class AppWebApplicationInitializer2 /*extends AbstractContextLoaderInitializer*/ {

  AnnotationConfigWebApplicationContext rootContext;

  protected WebApplicationContext createRootApplicationContext() {
    this.rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(RootConfig.class);
    rootContext.refresh();
    return rootContext;
  }

  public void onStartup(ServletContext servletContext) throws ServletException {
    // 수퍼 클래스의 onStartup() 에서 ContextLoaderListener를 생성하기 때문에
    // 기존의 기능을 그대로 수행하도록 수퍼 클래스의 메서드를 호출한다.
    //super.onStartup(servletContext);

    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    appContext.register(AppConfig.class);
    appContext.setParent(rootContext); // 루트컨텍스트를 쓸 수 있도록 설정
    appContext.setServletContext(servletContext);
    appContext.refresh();
    Dynamic registration = servletContext.addServlet("app", new DispatcherServlet(appContext));
    registration.addMapping("/app/*");
    registration.setLoadOnStartup(1);
    registration.setMultipartConfig(new MultipartConfigElement(
        new File("./temp").getAbsolutePath(), // 클라이언트가 올린 파일을 임시보관할 폴더
        //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
        1024 * 1024 * 10,
        1024 * 1024 * 100,
        1024 * 1024 * 1
    ));

    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
    FilterRegistration filterRegistration =
        servletContext.addFilter("CharacterEncodingFilter", characterEncodingFilter);
    filterRegistration.addMappingForServletNames(
        // 필터를 언제 꼽을지
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),
        false,
        new String[]{"app"} // app 이라는 이름을 가진 서블릿에 적용
    );
  }
}
