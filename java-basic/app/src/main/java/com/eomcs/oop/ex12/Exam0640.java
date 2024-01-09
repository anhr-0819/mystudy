// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {

  static class My {
    public boolean m() { // 리턴타입은 같으나 규격이 Predicate의 test()와 일치하지 않음
      return true;
    }
  }

  public static void main(String[] args) {
    // interface Predicate<T> {
    // boolean test(T value); // T 타입의 값을 받아서 boolean 값을 리턴하는 메서드
    // ...
    // }

    // Predicate<String> p1 = My::m; // 컴파일 오류!
    // 1) My의 m()는 스태틱 메서드가 아니다.
    // 2) My의 m()는 String 파라미터를 못받는다.


    // My obj = new My();
    // Predicate<String> p2 = obj::m; // 컴파일 오류!
    // 1) My의 m()는 String 파라미터를 못받는다.

    // 기존의 My의 m()를 test() 메서드를 구현하는데 사용하기
    //
    Predicate<My> obj = (My value) -> {
      return value.m();
    };
    // 코드를 좀 더 줄이기
    Predicate<My> obj2 = value -> value.m();
    // 코드를 더 줄이기 - 바로 위의 코드를 작성하는 경우가 많다 보니 다음과 같은 단축 문법이 등장!
    Predicate<My> obj3 = My::m;

    // 위와 같이 단축 문법을 사용하려면,
    // => 타입 파라미터의 클래스가 인스턴스 메서드의 클래스랑 같아야 한다.
    // => 즉 다음과 같이 람다 문법으로 변경될 수 있어야 한다.
    //
    // => Predicate<String> obj3 = (My value) -> {return value.m();};

    obj3.test(new My());
  }
}


