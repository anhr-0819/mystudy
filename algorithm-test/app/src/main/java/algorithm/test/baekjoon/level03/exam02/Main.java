package algorithm.test.baekjoon.level03.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);

    int t = scan.nextInt();
    int[] arr = new int[t];

    for (int i = 0; i < t; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      arr[i] = a + b;
    }

    for (int i : arr) {
      System.out.println(i);
    }
    scan.close();
  }
}
