package algorithm.test.baekjoon.level08.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int m = scan.nextInt();
      if (m >= 25) {
        sb.append(m / 25).append(" ");
        m = m - (25 * (m / 25));
      } else {
        sb.append(0).append(" ");
      }

      if (m >= 10) {
        sb.append(m / 10).append(" ");
        m = m - (10 * (m / 10));
      } else {
        sb.append(0).append(" ");
      }

      if (m >= 5) {
        sb.append(m / 5).append(" ");
        m = m - 5 * (m / 5);
      } else {
        sb.append(0).append(" ");
      }

      if (m >= 1) {
        sb.append(m / 1).append(" ");
      } else {
        sb.append(0).append(" ");
      }
      sb.append("\n");
    }
    scan.close();
    System.out.print(sb);
  }
}
