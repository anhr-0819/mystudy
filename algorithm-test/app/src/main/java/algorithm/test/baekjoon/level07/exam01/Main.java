package algorithm.test.baekjoon.level07.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = scan.nextInt();
    int m = scan.nextInt();

    int[][] arr = new int[n + 1][m + 1];
    int j = 0;

    try {
      for (int i = 0; i < n * 2; i++) {
        if (i < n) {
          for (int k = 0; k < m; k++) {
            arr[i][k] = scan.nextInt();
          }
        } else if (i >= n) {
          for (int k = 0; k < m; k++) {
            arr[j][k] = scan.nextInt() + arr[j][k];
            sb.append(arr[j][k]).append(" ");
            if (k == m - 1) {
              sb.append("\n");
              j++;
            }
          }
        }
      }
    } catch (Exception e) {
    }
    System.out.print(sb);
    scan.close();
  }
}
