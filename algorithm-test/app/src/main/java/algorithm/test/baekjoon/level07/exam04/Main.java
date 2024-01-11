package algorithm.test.baekjoon.level07.exam04;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] arr = new int[100][100];
    int area = 0;

    for (int i = 0; i < n; i++) {
      int x = scan.nextInt() - 1;
      int y = scan.nextInt() - 1;
      try {
        for (; x < x + 10; x++) {
          for (; y < y + 10; y++) {
            arr[x][y] += 1;
            if (arr[x][y] == 1) {
              area++;
            }
            // System.out.printf("arr[x][y] = %d\n", arr[x][y]);
            // System.out.printf("arr[x++][y++] = %d\n", arr[x++][y++]);
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        continue;
      }
    }
    scan.close();
    System.out.print(area);
  }
}
