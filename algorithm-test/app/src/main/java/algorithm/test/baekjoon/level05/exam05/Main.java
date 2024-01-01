package algorithm.test.baekjoon.level05.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    scan.nextLine();
    String str = scan.nextLine();

    int sum = 0;
    String s = "";
    for (int i = 0; i < n; i++) {
      s = String.valueOf(str.charAt(i));
      sum += Integer.parseInt(s);
    }
    System.out.print(sum);
    scan.close();
  }
}
