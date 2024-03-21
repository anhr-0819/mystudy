package bitcamp.myapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(value = {
    "bitcamp.myapp.dao",
    "bitcamp.util"
}) // RootConfig는 dao, 트랜잭션 관련 객체를 생성하도록함
@PropertySource({
    "classpath:config/jdbc.properties"
})
public class RootConfig {

  public RootConfig() {
    System.out.println("RootConfig() 호출됨");
  }
}
