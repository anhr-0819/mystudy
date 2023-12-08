package algorithm.test.baekjoon.level01.exam11;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 첫 번째 줄에 주어지는 A,B,C의 값을 계산(A+B+C의 값 출력)
    Scanner scan = new Scanner(System.in);
    long a = scan.nextLong();
    long b = scan.nextLong();
    long c = scan.nextLong();
    scan.close();

    long result = a + b + c;
    System.out.println(result);
  }
}
