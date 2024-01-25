package test;

import java.util.Scanner;

public class divisor {

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    int sum = 1;
    for (int i = 2; i * i < n; i++) {
      if (n % i == 0) {
        sum += i + n / i;
        System.out.println("약수 = " + i + "약수 = " + n / i);
      }
    }

    System.out.println(sum);
    if (sum == n) {
      System.out.print("P");
    } else {
      System.out.print("N");
    }

  }

}
