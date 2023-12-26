package algorithm.test.baekjoon.level03.exam12;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    while (scan.hasNext()) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      System.out.println(a + b);
    }
    scan.close();
  }
}
