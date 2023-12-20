package algorithm.test.baekjoon.level02.exam06;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 시작하는 시각과 필요한 시간이 분단위로 주어졌을 때, 끝나는 시각을 계산하는 프로그램

    Scanner scan = new Scanner(System.in);

    int h = scan.nextInt();
    int m = scan.nextInt();
    int cookingTime = scan.nextInt();

    if (m + cookingTime >= 60) {
      if (h + ((m + cookingTime) / 60) > 23) {
        System.out.printf("%d %d", ((m + cookingTime) / 60) - 1, (m + cookingTime) % 60);
      } else {
        System.out.printf("%d %d", h + ((m + cookingTime) / 60), (m + cookingTime) % 60);
      }
    } else {
      System.out.printf("%d %d", h, m + cookingTime);
    }
    scan.close();
  }
}
