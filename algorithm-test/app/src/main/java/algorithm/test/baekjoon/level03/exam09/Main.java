package algorithm.test.baekjoon.level03.exam09;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = scan.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
    scan.close();

  }

}
