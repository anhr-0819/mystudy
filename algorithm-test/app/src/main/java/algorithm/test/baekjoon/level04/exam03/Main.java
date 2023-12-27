package algorithm.test.baekjoon.level04.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // N개의 정수 중, 최솟값과 최댓값을 구하는 프로그램
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int max = 0;
    int min = 0;

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }
    scan.close();

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        max = arr[i];
        min = arr[i];
      } else {
        if (arr[i] > max) {
          max = arr[i];
        } else if (arr[i] < min) {
          min = arr[i];
        }
      }
    }
    System.out.printf("%d %d", min, max);
  }
}
