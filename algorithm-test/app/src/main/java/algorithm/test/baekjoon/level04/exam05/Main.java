package algorithm.test.baekjoon.level04.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = scan.nextInt();
    int[] arr = new int[n];

    int m = scan.nextInt();

    for (int m1 = 0; m1 < m; m1++) {
      int i = scan.nextInt() - 1;
      int j = scan.nextInt() - 1;
      int k = scan.nextInt();

      for (; i <= j; i++) {
        arr[i] = k;
      }
    }

    for (int value : arr) {
      sb.append(value).append(" ");
    }
    System.out.print(sb);
    scan.close();
  }
}
