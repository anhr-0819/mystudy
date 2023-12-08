package algorithm.test.baekjoon.level02.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B,
    // 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램

    @SuppressWarnings("resource")
    int score = new Scanner(System.in).nextInt();

    if (score > 89) {
      System.out.print("A");
    } else if (score > 79) {
      System.out.print("B");
    } else if (score > 69) {
      System.out.print("C");
    } else if (score > 59) {
      System.out.print("D");
    } else {
      System.out.print("F");
    }

  }

}
