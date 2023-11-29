/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.myapp;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";

    String appTitle = "[과제관리시스템]";
    String menu1 = "1.과제",
        menu2 = "2.게시글",
        menu3 = "3.도움말",
        menu4 = "4.종료",

        input1 = "과제입니다.",
        input2 = "게시글입니다.",
        input3 = "도움말입니다.",
        input4 = "종료합니다.";

    setMenu(ANSI_BOLD_RED, appTitle, ANSI_CLEAR, menu1, menu2, menu3, ANSI_RED, menu4);

    Scanner scan = new Scanner(System.in);

    loop:
    while (true) {
      System.out.print(">");
      String menuInput = scan.nextLine();

      switch (menuInput) {
        case "1":
          System.out.println(input1);
          break;
        case "2":
          System.out.println(input2);
          break;
        case "3":
          System.out.println(input3);
          break;
        case "4":
          System.out.println(input4);
          break loop;
        case "menu":
          setMenu(ANSI_BOLD_RED, appTitle, ANSI_CLEAR, menu1, menu2, menu3, ANSI_RED, menu4);
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
    scan.close();
  }

  private static void setMenu(String ANSI_BOLD_RED, String appTitle, String ANSI_CLEAR,
      String menu1, String menu2, String menu3, String ANSI_RED, String menu4) {
    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);
  }
}