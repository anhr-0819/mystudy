package algorithm.test.baekjoon.level02.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 알람 시각이 주어졌을 때, 알람을 45분 앞서는 시간으로 바꾸는
    // 방법을 사용한다면, 언제로 고쳐야 하는지 구하는 프로그램

    Scanner scan = new Scanner(System.in);
    int h = scan.nextInt();
    int m = scan.nextInt();

    if (m >= 45) {
      System.out.printf("%d %d", h, m - 45);
    }
    int restult;


    scan.close();

  }

  static int hourCarculate(int h) {
    return 0;
  }

  static int minuteCarculate(int m) {
    if (m >= 45) {
      return m - 45;
    }
    return 0;
  }

}
