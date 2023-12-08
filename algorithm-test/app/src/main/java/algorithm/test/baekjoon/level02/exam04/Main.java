package algorithm.test.baekjoon.level02.exam04;

import java.util.Scanner;

public class Main {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    // 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램
    // 단, x좌표와 y좌표는 모두 양수나 음수라고 가정

    int x, y;
    Scanner scan = new Scanner(System.in);
    x = scan.nextInt();
    y = scan.nextInt();

    if (x > 0) {
      if (y > 0) {
        System.out.print(1);
        return;
      }
      System.out.print(4);
    } else if (y > 0) {
      System.out.print(2);
    } else {
      System.out.print(3);
    }
    scan.close();
  }

}
