package algorithm.test.baekjoon.level01.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // (세 자리 수) × (세 자리 수) 주어진 위치에 들어갈 값을 구하는 프로그램
    Scanner scan = new Scanner(System.in);

    String input1 = scan.nextLine();
    String input2 = scan.nextLine();

    int[] intArr = new int[4];
    int result = 0;

    for (int i = 2, j = 0; i >= 0; i--, j++) {
      String value = input2.substring(i, i + 1);
      intArr[j] = Integer.parseInt(input1) * Integer.parseInt(value);
      System.out.println(intArr[j]);
      result += intArr[j] * Math.pow(10, j);
    }
    System.out.println(result);
    scan.close();
  }
}
