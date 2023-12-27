package algorithm.test.baekjoon.level04.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 수열 A에서 X보다 작은 수를 모두 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = scan.nextInt();
    int x = scan.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }
    scan.close();
    for (int i : arr) {
      if (i < x) {
        sb.append(i).append(" ");
      }
    }
    System.out.print(sb);
  }
}
