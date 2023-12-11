package bitcamp.myapp.Menu;

import bitcamp.menu.Menu;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

// - 메뉴간의 연결을 느슨하게 조정하기
//  -MainMenu와 나머지 Menu 객체들 사이에 coupling이 강결합되어 있다.
//   -- 메뉴 클래스가 추가되면 MainMemu 클래스를 또 추가해야한다.
//   -- 메뉴 클래스가 추가되더라도 MainMemu 클래스를 변경하지 않을 방법이 필요하다.
//  - 적용 설계 원칙
//   -- SOLID 원칙 중에 (OCP, Open-Closed Principle)' 적용
//   -- GRSAP 패턴의 'Low COubling' 책임 할당 원칙 준수
//  - 설계 원칙을 따르는 구현 방법
//   -- GoF의 'Composite' 패턴 적용

public class MainMenu implements Menu {

  static final String APP_TITLE =
      AnsiEscape.ANSI_BOLD_RED + "[과제관리 시스템]" + AnsiEscape.ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입인사",
      "5. 도움말",
      AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.ANSI_CLEAR
  };

  // 의존 객체(Dependency Object ==> dependency);
  // - 클래스가 작업을 수행할 때 사용하는 객체
  Prompt prompt;

  // BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요한다.
  // 생성자란(constructor)?
  // => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {

    Menu assignmentMenu = new AssignmentMenu("과제", prompt);
    Menu boardMenu = new BoardMenu("게시판", prompt);
    Menu greetingBoardMenu = new BoardMenu("가입인사", prompt);
    Menu memberMenu = new MemberMenu("회원", prompt);
    Menu helpMenu = new HelpMenu("도움말", prompt);

    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute(prompt);
          break;
        case "2":
          boardMenu.execute(prompt);
          break;
        case "3":
          memberMenu.execute(prompt);
          break;
        case "4":
          greetingBoardMenu.execute(prompt);
          break;
        case "5":
          helpMenu.execute(prompt);
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
