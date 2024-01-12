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
        while (x <= x + 10) {
          while (y <= y + 10) {
            if (arr[x][y] == 0) {
              area++;
            }
            arr[x][y] += 1;
            System.out.print(arr[x][y]);
            // System.out.printf("arr[x][y] = %d\n", arr[x][y]);
            // System.out.printf("arr[x++][y++] = %d\n", arr[x++][y++]);
            y++;
          }
          x++;
          System.out.println("i = " + i);
        }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
    }
    scan.close();
    System.out.print(area);
  }
}
