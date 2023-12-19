package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// Leaf?
// - 하위 항목을 포함하지 않는 말단 객체
// - 예를들어 파일시스템에서 '파일'에 해당한다.
//
public class MenuItem extends AbstractMenu {

  private MenuHandler menuHandler;

  public MenuItem(String title) {
    super(title);
  }
  // 모든 생성자는 반드시 수퍼 클래스의 기본 생성자를 호출하게 되어있다.
  // super(); <- 컴파일러가 자동 삽입.
  //  public MenuItem(String title) {
  //    super();
  //    this.title = title;
  //  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action(this);
    }
  }
}
