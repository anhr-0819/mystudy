package algorithm.test.baekjoon.level05.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    char[] arr = new char[3];
    char[] arr1 = scan.next().toCharArray();
    char[] arr2 = scan.next().toCharArray();

    for (int i = 2; i >= 0; i--) {
      if (arr1[i] > arr2[i]) {
        arr[0] = arr1[2];
        arr[1] = arr1[1];
        arr[2] = arr1[0];
        break;
      } else if (arr2[i] > arr1[i]) {
        arr[0] = arr2[2];
        arr[1] = arr2[1];
        arr[2] = arr2[0];
        break;
      }
    }
    for (char c1 : arr) {
      System.out.print(c1);
    }
    scan.close();
  }
}
