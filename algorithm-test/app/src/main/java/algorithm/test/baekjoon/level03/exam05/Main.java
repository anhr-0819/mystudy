package algorithm.test.baekjoon.level03.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();
    String s = "";

    for (int i = 0; i < input / 4; i++) {
      s += "long ";
    }
    System.out.printf("%s%s", s, "int");
    scan.close();
  }
}
