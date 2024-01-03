package algorithm.test.baekjoon.level06.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = scan.nextInt();
    int j = n;
    int s = 1;
    boolean b1 = false;
    boolean b2 = false;

    for (int i = 1; i < n * 2; i++) {
      if (s < j) {
        for (int m = 0; m < j - s; m++) {
          sb.append(" ");
        }
      }
      for (int m = 0; m < s; m++) {
        sb.append("*");
      }
      sb.append("\n");

      if (s == 2 * n - 1) {
        b1 = true;
        s = s - 2;
      } else if (b1) {
        s = s - 2;
      } else {
        s = s + 2;
      }

      if (j == 2 * n - 1) {
        b2 = true;
        j = --j;
      } else if (b2) {
        j = --j;
      } else {
        j = ++j;
      }

    }
    scan.close();
    System.out.print(sb);
  }
}

