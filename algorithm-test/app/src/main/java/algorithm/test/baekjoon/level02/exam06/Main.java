package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 시작하는 시각과 필요한 시간이 분단위로 주어졌을 때, 끝나는 시각을 계산하는 프로그램

    Scanner scan = new Scanner(System.in);

    int h = scan.nextInt();
    int m = scan.nextInt();
    int t = scan.nextInt();

    if (m + t >= 60) {
      if (h + ((m + t) / 60) > 23) {
        System.out.printf("%d %d", ((m + t) / 60) - 1, (m + t) % 60);
      } else {
        System.out.printf("%d %d", h + ((m + t) / 60), (m + t) % 60);
      }
    } else {
      System.out.printf("%d %d", h, m + t);
    }
    scan.close();

    // int sh = 0;
    // int sm = 0;
    //
    // if (m + t >= 60) {
    // sh = h + ((m + t) / 60);
    // if (sh >= 24) {
    // sh = sh - 24;
    // }
    // sm = (m + t) % 60;
    // } else {
    // sh = h;
    // sm = m + t;
    // }
    // System.out.printf("%d %d", sh, sm);
  }
}
