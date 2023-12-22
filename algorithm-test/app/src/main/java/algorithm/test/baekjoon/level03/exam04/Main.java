package algorithm.test.baekjoon.level03.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int n = scan.nextInt();
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();

      sum += a * b;
    }

    String result = (x == sum) ? "Yes" : "No";
    System.out.print(result);
    scan.close();
  }

}
