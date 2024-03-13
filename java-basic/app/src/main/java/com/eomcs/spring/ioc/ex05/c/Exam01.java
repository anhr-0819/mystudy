// 컬렉션 타입의 프로퍼티 값 설정 - Map<,>
package com.eomcs.spring.ioc.ex05.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(//
        "com/eomcs/spring/ioc/ex05/c/application-context.xml");

    System.out.println(iocContainer.getBean("c1"));
  }

  // 프로퍼티 타입이 맵인경우 xml에 맵 태그로 맵객체를 만들어 설정한다.

}


