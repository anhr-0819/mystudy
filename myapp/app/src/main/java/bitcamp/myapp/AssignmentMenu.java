package bitcamp.myapp;

import bitcamp.myapp.vo.AssignmentMenuList;

public class AssignmentMenu {

  AssignmentMenuList menu = new AssignmentMenuList();

  static void printMenu() {
    System.out.println("[과제]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/과제> ");

      switch (input) {
        case "1":
          menu.add();
          break;
        case "2":
          menu.view();
          break;
        case "3":
          menu.modify();
          break;
        case "4":
          menu.delete();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }
}

// java.lang 패키지에 있는 클래스를 쓸땐 import 안해도됨
// ex) java.lang.String
// 그 외 다른 모든 패키지에 있는 클래스는 패키지명을 적거나 import 해야함