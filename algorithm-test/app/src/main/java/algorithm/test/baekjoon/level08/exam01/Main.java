package algorithm.test.baekjoon.level08.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // B진법 => 10진법
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    int b = scan.nextInt();
    System.out.print(Integer.parseInt(str, b));
  }
}
