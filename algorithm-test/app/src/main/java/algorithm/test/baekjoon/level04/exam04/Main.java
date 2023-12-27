package algorithm.test.baekjoon.level04.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고
    // 그 최댓값이 몇 번째 수인지를 구하는 프로그램
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[9];
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < 9; i++) {
      arr[i] = scan.nextInt();
      if (i == 0) {
        max = arr[i];
        maxIndex = i + 1;
      } else if (arr[i] > max) {
        max = arr[i];
        maxIndex = i + 1;
      }
    }
    scan.close();
    System.out.printf("%d\n%d", max, maxIndex);
  }
}
