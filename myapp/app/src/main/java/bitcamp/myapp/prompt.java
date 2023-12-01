package bitcamp.myapp;

import java.util.Scanner;

public class prompt {

  static String input(String title, Scanner keyIn) {
    System.out.printf("%s> ", title);
    return keyIn.nextLine();
  }
}
