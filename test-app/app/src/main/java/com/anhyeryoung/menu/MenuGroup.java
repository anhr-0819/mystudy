package com.anhyeryoung.menu;

import com.anhyeryoung.util.AnsiEscape;
import com.anhyeryoung.util.Prompt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();

  private MenuGroup(String title, Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  public static MenuGroup getInstance(String title) {
    return new MenuGroup(title, new Stack<String>());
  }

  @Override
  public void execute(Prompt prompt) {
    breadcrumb.push(this.title);

    this.printMenu();

    while (true) {
      String input = prompt.input("%s%s%s -> ", AnsiEscape.GREEN_UNDERLINED,this.getMenuPath(),AnsiEscape.RESET);

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      try {
        int menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menus.size()) {
          System.out.println(AnsiEscape.RED_BRIGHT + "메뉴 번호가 유효하지 않습니다." + AnsiEscape.RESET);
          continue;
        }

        this.menus.get(menuNo - 1).execute(prompt);

      } catch (Exception e) {
        System.out.println(AnsiEscape.RED_BRIGHT + "메뉴가 옳지 않습니다." + AnsiEscape.RESET);
      }
    }

    breadcrumb.pop();
  }

  private void printMenu() {
    System.out.printf("%s#%s#%s\n", AnsiEscape.GREEN_BOLD,this.getTitle(),AnsiEscape.RESET);

    Iterator<Menu> iterator = this.menus.iterator();
    int i = 1;
    while (iterator.hasNext()) {
      Menu menu = iterator.next();
      System.out.printf("%d. %s\n", i++, menu.getTitle());
    }

    System.out.printf("%s0. %s%s\n",AnsiEscape.CYAN, "pre",AnsiEscape.RESET);
  }

  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public MenuItem addItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, this.breadcrumb, handler);
    this.add(menuItem);
    return menuItem;
  }

  public MenuGroup addGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title, this.breadcrumb);
    this.add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }
}
