package algorithm.test.baekjoon.level02.exam07;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int d1 = scan.nextInt();
    int d2 = scan.nextInt();
    int d3 = scan.nextInt();

    scan.close();

    if (d1 == d2) {
      if (d1 == d3) {
        System.out.print(10000 + d1 * 1000);
        return;
      } else {
        System.out.print(1000 + d1 * 100);
      }
    } else if (d2 == d3) {
      System.out.print(1000 + d2 * 100);
    } else {
      if (d1 > d2) {
        if (d3 > d1) {
          System.out.print(d3 * 100);
        } else {
          System.out.print(d1 * 100);
        }
      } else if (d2 > d3) {
        System.out.print(d2 * 100);
      } else {
        System.out.print(d3 * 100);
      }
    }
  }
}
