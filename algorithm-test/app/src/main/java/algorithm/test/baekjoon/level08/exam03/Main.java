package algorithm.test.baekjoon.level08.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      double d = scan.nextDouble() / 100;
      if (d >= 0.25) { // Quarter, $0.25
        sb.append((int) (d / 0.25)).append(" ");
        d = d - (0.25 * (d / 0.25));
      } else {
        sb.append(0).append(" ");
      }

      System.out.print(false);

      if (d >= 0.10) { // Dime, $0.10
        sb.append((int) (d / 0.10)).append(" ");
        d = d - (0.10 * (d / 0.10));
      } else {
        sb.append(0).append(" ");
      }

      if (d >= 0.05) { // Nickel, $0.05
        sb.append((int) (d / 0.05)).append(" ");
        d = d - (0.05 * (d / 0.05));
      } else {
        sb.append(0).append(" ");
      }

      if (d >= 0.01) { // Penny, $0.01
        sb.append((int) (d / 0.01)).append(" ");
        d = d - (0.01 * (d / 0.01));
      } else {
        sb.append(0).append(" ");
      }
      sb.append("\n");
    }
    scan.close();
    System.out.print(sb);
  }

}
