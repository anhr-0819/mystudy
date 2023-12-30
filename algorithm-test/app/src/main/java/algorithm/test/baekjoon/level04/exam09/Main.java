package algorithm.test.baekjoon.level04.exam09;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int b = scan.nextInt(); // 바구니 수
    int m = scan.nextInt(); // 반복 횟수
    int[] arr = new int[b];
    for (int i = 0; i < b; i++) {
      arr[i] = i + 1; // 바구니 번호
    }

    for (int k = 0; k < m; k++) {
      int i = scan.nextInt() - 1;
      int j = scan.nextInt() - 1;

      for (int i2 = i, j2 = j; i2 < j2; i2++, j2--) {
        int temp = arr[i2];
        arr[i2] = arr[j2];
        arr[j2] = temp;
      }
    }
    scan.close();
    for (int value : arr) {
      sb.append(value).append(" ");
    }
    System.out.println(sb);
  }
}
