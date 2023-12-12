package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 leaf 역할을 수행하는 클래스
// Leaf?
// - 하위 항목을 포함하지 않는 말단 객체
// - 예를들어 파일시스템에서 '파일'에 해당한다.
//
public class MenuItem implements Menu {

  String title;
  MenuHandler menuHandler;
  // MenuHandler 규칙에 따른 객체라면 어떤 객체든 주소를 받을 수 있다.
  // Low Copuling

  public MenuItem(String title) {
    this.title = title;
  }

  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action();
    }
  }

  @Override
  public String getTitle() {
    return this.title;
  }
}
