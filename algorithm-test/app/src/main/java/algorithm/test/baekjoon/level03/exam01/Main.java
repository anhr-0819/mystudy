package algorithm.test.baekjoon.level03.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램

    int n = new Scanner(System.in).nextInt();

    for (int i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %d\n", n, i, n * i);
    }
  }
}
