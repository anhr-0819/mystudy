package test;

import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    for (int i = 0;; i++) {
      int n = scan.nextInt();
      switch (n) {
        case 1:
          System.out.println("John");
          continue;
        case 2:
          System.out.println("Tom");
          continue;
        case 3:
          System.out.println("Paul");
          continue;
        case 4:
          System.out.println("Sam");
          continue;
        default:
          System.out.println("Vacancy");
          return;
      }

    }
  }


}
