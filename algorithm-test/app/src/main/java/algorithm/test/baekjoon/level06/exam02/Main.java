package algorithm.test.baekjoon.level06.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int[] arr = {1, 1, 2, 2, 2, 8};
    for (int i = 0; i < arr.length; i++) {
      int input = scan.nextInt();
      sb.append(arr[i] - input).append(" ");
    }
    scan.close();
    System.out.print(sb);
  }
}
