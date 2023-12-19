package bitcamp.menu;

public abstract class AbstractMenu implements Menu {

  private String title;

  public AbstractMenu(String title) {
    this.title = title;
  }

  @Override
  public String getTitle() { // Menu라는 사용 규칙에 해당되기 때문에 오버라이드
    return title;
  }

  public void setTitle(String title) { // 임의로 추가했기 때문에 세터는 오버라이드 X
    this.title = title;
  }
}
