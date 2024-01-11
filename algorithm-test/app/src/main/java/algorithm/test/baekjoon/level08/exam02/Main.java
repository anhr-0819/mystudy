package algorithm.test.baekjoon.level08.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 10진법 => N진법
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int b = scan.nextInt();
    String str = Integer.toString(n, b);
    System.out.print(str.toUpperCase());
  }
}

