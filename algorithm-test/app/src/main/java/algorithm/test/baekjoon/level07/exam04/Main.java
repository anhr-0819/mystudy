package algorithm.test.baekjoon.level07.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] arr = new int[100][100];
    int area = 0;
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      for (int j = 0; j < 10; j++) {
        arr[x++][y++] += 1;
        if (arr[x][y] == 1)
          area++;
      }
    }
    scan.close();
    System.out.print(area);

    for (int[] arr2 : arr) {
      // System.out.println(arr2.);
    }
  }
}
