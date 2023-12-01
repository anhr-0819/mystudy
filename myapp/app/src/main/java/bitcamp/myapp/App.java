package bitcamp.myapp;

import java.util.Scanner;

public class App {

  // 애플리케이션 클레스 객체를 실행할 때 다음 변수를 미리 준비해 둔다.
  // 메소드 밖에 선언하게 되면 static 을 붙인다.
  //  --> 변수를 전달할 필요 없이 바로 접근해서 사용가능
  // class에 선언되는 변수 : class field(=static field)
  // 클래스가 사용될때 만들어지고 JVM이 종료될때(클래스가 사라질때) 사라짐
  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = "[과제관리 시스템]";
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      "4. 종료"
  };
  static final String[] HOMEWORK_MENU = {
      "[" + ANSI_RED + "과제" + ANSI_CLEAR + "]",
      "1. 등록",
      "2. 조회",
      "3. 변경",
      "4. 삭제",
      "0. 이전",
  };

  static void printMenu() {
    // ANSI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에
    // 클래스 블록 안에 두면
    // printMenu()를 호출할 때마다 변수를 만들지 않기 때문에 실행 속도나 메모리 부분에서
    // 훨씬 효율적이다.
    // 보통 메서드 호출될 때 마다 값이 바뀌는 변수가 아니라 고정 값을 갖는 변수인 경우
    // 메서드 밖에 두는 것이 좋다.
    //
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  static void printHomeWorkMenu() {
    for (String inputNum : HOMEWORK_MENU) {
      System.out.println(inputNum);
    }
  }

  static String prompt(Scanner keyIn, String title) { // 사용자에게 프롬프트를 띄우고 사용자 입력값을 리턴
    System.out.print(title);
    return keyIn.nextLine();
  }

  //static void setHomeworkMenu() {}

  public static void main(String[] args) {
    printMenu();
    java.util.Scanner keyIn = new java.util.Scanner(System.in);

    mainLoop:
    while (true) {
      String input = prompt(keyIn, "메인> ");
      switch (input) {
        case "1":
          printHomeWorkMenu();
          subLoop:
          while (true) {
            String inputHomeWorkMenu = prompt(keyIn, "메인/과제> ");
            switch (inputHomeWorkMenu) {
              case "1":
                System.out.println("과제 등록입니다.");
                break;
              case "2":
                System.out.println("과제 조회입니다.");
                break;
              case "3":
                System.out.println("과제 변경입니다.");
                break;
              case "4":
                System.out.println("과제 삭제입니다.");
                break;
              case "0":
                break subLoop;
              default:
                System.out.println("메뉴 번호가 옳지 않습니다.");
            }
          }
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break mainLoop;
        case "menu":
          // 코드를 기능 단위로 묶어 메서드로 정의하면
          // 메서드의 이름을 통해 해당 기능을 쉽게 유추할 수 있어 유지보수에 좋다.
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    keyIn.close();
  }
}
