package algorithm.test.baekjoon.level03.exam10;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = scan.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < n - i; j++) {
        sb.append(" ");
      }
      for (int k = 0; k < i; k++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.print(sb);
    scan.close();

  }

}
