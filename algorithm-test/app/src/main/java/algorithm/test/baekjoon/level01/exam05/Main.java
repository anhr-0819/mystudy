package algorithm.test.baekjoon.level01.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);

    double a = scan.nextInt();
    double b = scan.nextInt();

    System.out.println(a / b);
    scan.close();
  }
}
