package algorithm.test.baekjoon.level03.exam09;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner scan = new Scanner(System.in);
    // StringBuilder sb = new StringBuilder();
    //
    // int n = scan.nextInt();
    // for (int i = 1; i <= n; i++) {
    // for (int j = 0; j < i; j++) {
    // sb.append("*");
    // }
    // sb.append("\n");
    // }
    // System.out.print(sb);
    // scan.close();

    Scanner scan = new Scanner(System.in);

    int d1 = scan.nextInt();
    int d2 = scan.nextInt();
    int d3 = scan.nextInt();

    scan.close();

    int r = 0;
    if (d1 == d2 && d2 == d3) {
      r = 10000 + d1 * 1000;
    } else if (d1 != d2 && d2 != d3 && d1 != d3) {
      int temp = d1;
      if (temp < d2) {
        temp = d2;
      }
      if (temp < d3) {
        temp = d3;
      }
      r = temp * 100;
    } else {
      int temp = (d1 == d2) ? d1 : (d2 == d3) ? d2 : d3;
      r = 1000 + temp * 100;
    }
    System.out.print(r);

  }

}
