package algorithm.test.baekjoon.level03.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    System.out.print(sum);
    scan.close();

  }

}
