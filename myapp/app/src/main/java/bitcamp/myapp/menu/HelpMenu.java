package bitcamp.myapp.Menu;

import bitcamp.menu.Menu;
import bitcamp.util.Prompt;

// 메뉴 객체의 사용 규칙에 따라 문법을 정의한다.
public class HelpMenu implements Menu {

  String title;

  // 의존 객체(Dependency Object ==> dependency);
  // - 클래스가 작업을 수행할 때 사용하는 객체
  Prompt prompt;

  // BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요한다.
  // 생성자란(constructor)?
  // => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
  public HelpMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {
    System.out.printf("[%s]\n", this.title);
    System.out.println("도움말 입니다");
  }
}
