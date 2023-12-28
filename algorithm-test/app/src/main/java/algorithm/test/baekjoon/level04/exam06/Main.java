package algorithm.test.baekjoon.level04.exam06;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = scan.nextInt();
    int m = scan.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    for (int m2 = 0; m2 < m; m2++) {
      int i = scan.nextInt() - 1;
      int j = scan.nextInt() - 1;
      int temp;

      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    for (int value : arr) {
      sb.append(value).append(" ");
    }
    System.out.print(sb);
    scan.close();
  }

}
