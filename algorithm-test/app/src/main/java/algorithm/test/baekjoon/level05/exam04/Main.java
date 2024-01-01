package algorithm.test.baekjoon.level05.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    int asc = str.charAt(0);

    System.out.print(asc);
    scan.close();
  }
}
