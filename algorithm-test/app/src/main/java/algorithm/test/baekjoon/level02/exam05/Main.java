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
    } else {
      if (h == 0) {
        System.out.printf("%d %d", 23, 60 - (45 - m));
        return;
      }
      System.out.printf("%d %d", h - 1, 60 - (45 - m));
    }
    scan.close();
  }

}
