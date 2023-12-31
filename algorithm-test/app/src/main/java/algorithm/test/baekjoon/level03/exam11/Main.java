package algorithm.test.baekjoon.level03.exam11;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램

    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    while (true) {
      int a = scan.nextInt();
      int b = scan.nextInt();

      if (a == 0 && b == 0) {
        System.out.print(sb);
        scan.close();
        return;
      }
      sb.append(a + b).append("\n");
    }
  }
}
