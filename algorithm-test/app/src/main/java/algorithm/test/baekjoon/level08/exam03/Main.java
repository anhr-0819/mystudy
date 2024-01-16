package algorithm.test.baekjoon.level08.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      double d = scan.nextDouble() * 0.01;

      System.out.printf("d = %.2f\n", d);
      if (d >= 0.25) { // Quarter, $0.25
        sb.append((int) (d / 0.25)).append(" ");
        d = d - 0.25 * (int) (d / 0.25);
        System.out.printf("Quarter, $0.25 계산 -> d = %.2f\n", d);
      } else {
        sb.append(0).append(" ");
      }

      if (d >= 0.10) { // Dime, $0.10
        sb.append((int) (d / 0.10)).append(" ");
        d = d - (0.10 * (int) (d / 0.10));
        System.out.printf("test = %.2f\n", d - ((0.10 * (int) (d / 0.10))));
        System.out.printf("Dime, $0.10 계산 -> d = %.2f\n", d);
      } else {
        sb.append(0).append(" ");
      }

      if (d >= 0.05) { // Nickel, $0.05
        sb.append((int) (d / 0.05)).append(" ");
        d = d - 0.05 * (int) (d / 0.05);
        System.out.printf("Nickel, $0.05 계산 -> d = %.2f\n", d);
      } else {
        sb.append(0).append(" ");
      }

      if (d >= 0.01) { // Penny, $0.01
        sb.append((int) (d * 100)).append(" ");
        d = (int) (d * 100);
        System.out.printf("Penny, $0.01 계산 -> d = %.2f\n", d);
      } else {
        sb.append(0).append(" ");
      }
      sb.append("\n");
    }
    scan.close();
    System.out.print(sb);
  }

}
