package algorithm.test.baekjoon.level02.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();

    if (a > b) {
      System.out.print(">");
    } else if (a < b) {
      System.out.print("<");
    } else {
      System.out.print("==");
    }
    scan.close();
  }

}
