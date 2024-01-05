package algorithm.test.baekjoon.level07.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램
    Scanner scan = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int column = 0;
    int row = 0;
    int max = 0;

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scan.nextInt();
        if (arr[i][j] >= max) {
          max = arr[i][j];
          column = i + 1;
          row = j + 1;
        }
      }
    }
    scan.close();
    System.out.printf("%d\n%d %d", max, column, row);
  }
}
