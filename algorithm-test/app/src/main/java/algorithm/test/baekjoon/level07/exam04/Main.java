package algorithm.test.baekjoon.level07.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] arr = new int[101][101];
    int area = 0;
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      for (int x2 = x; x2 < (x + 10); x2++) {
        for (int y2 = y; y2 < (y + 10); y2++) {
          if (arr[x2][y2] == 0) {
            area++;
          }
          arr[x2][y2] += 1;
        }
      }
    }
    System.out.println(area);
    scan.close();
  }
}
