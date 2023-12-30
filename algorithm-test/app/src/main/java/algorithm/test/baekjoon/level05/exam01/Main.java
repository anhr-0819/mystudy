package algorithm.test.baekjoon.level05.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    int i = scan.nextInt();
    System.out.print(str.charAt(i - 1));
  }
}
