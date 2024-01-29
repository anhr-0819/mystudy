package test;

import java.util.Scanner;

public class test5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = 0;
    int n = sc.nextInt();
    while (n != 1) {
      if (n % 2 == 0)
        n /= 2; // 짝수면 2로 나눈 몫을 저장
      else // 홀수면 3을 곱하고 1을 더한 값을 저장
        n = 3 * n + 1;
      m++;
    }
    System.out.println(m);

  }

}
