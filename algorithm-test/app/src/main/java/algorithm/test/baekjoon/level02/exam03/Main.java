package algorithm.test.baekjoon.level02.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램
    @SuppressWarnings("resource")
    int year = new Scanner(System.in).nextInt();

    if ((year % 4 < 1 && year % 100 != 0) || (year % 400 < 1)) {
      System.out.print(1);
    } else {
      System.out.print(0);
    }
  }

}
