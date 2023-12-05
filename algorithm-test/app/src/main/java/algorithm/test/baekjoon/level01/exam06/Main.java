package algorithm.test.baekjoon.level01.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램
    int a, b;
    Scanner scan = new Scanner(System.in);

    a = scan.nextInt();
    b = scan.nextInt();

    System.out.println(a + b);
    System.out.println(a - b);
    System.out.println(a * b);
    System.out.println(a / b);
    System.out.println(a % b);
    scan.close();
  }
}
