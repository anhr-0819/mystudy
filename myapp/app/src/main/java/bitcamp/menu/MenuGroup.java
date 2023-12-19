package bitcamp.menu;

import bitcamp.util.Prompt;

// Composite 패턴에서 '복합 객체(composite object)' 역할을 하는 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private Menu[] menus = new Menu[10];
  private int menuSize;

  public MenuGroup(String title) {
    super(title);
    // 추상 클래스는 기본 생성자가 없으므로, 수퍼 클래스에 어떤 생성자를 호출해야 하는지 직접 명시해야 한다.
    // 명시하지 않으면 컴파일러는 기본 생성자를 호출하는 코드를 자동으로 삽입한다.
  }

  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의하겠다고 컴파일러에게 알린다.
  public void execute(Prompt prompt) {
    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.getTitle());

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      int menuNo = Integer.parseInt(input);
      if (menuNo < 1 || menuNo > this.menuSize) {
        System.out.println("메뉴 번호가 옳지 않습니다.");
        continue;
      }

      this.menus[menuNo - 1].execute(prompt);
    }
  }

  private void printMenu() {
    System.out.printf("[%s]\n", this.getTitle());

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }

    System.out.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) {
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize >> 1);

      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }

      this.menus = arr;
    }
    this.menus[this.menuSize++] = menu;
  }

  public void remove(Menu menu) {
    int index = this.indexOf(menu);
    if (index == -1) {
      return;
    }

    for (int i = index; i < (this.menuSize - 1); i++) {
      this.menus[i] = this.menus[i + 1];
    }
    this.menus[--this.menuSize] = null;
  }

  int indexOf(Menu menu) {
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        return i;
      }
    }
    return -1;
  }
}
