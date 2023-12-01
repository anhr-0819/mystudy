package bitcamp.myapp;

import java.util.Scanner;

public class prompt {

  static Scanner keyIn = new java.util.Scanner(System.in);

  static String input(String title) {
    System.out.printf("%s> ", title);
    return keyIn.nextLine();
  }

  static void close() {
    keyIn.close();
  }
}
