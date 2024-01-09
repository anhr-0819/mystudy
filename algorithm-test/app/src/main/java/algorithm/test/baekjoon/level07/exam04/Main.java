package algorithm.test.baekjoon.level07.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<int[][]> list = new ArrayList<>();
    int n = scan.nextInt();
    int[][] arr = new int[n][4];

    int area = 0;
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
    }

    System.out.print((100 * n) - area);
  }

}
