package algorithm.test.baekjoon.level05.exam07;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int t = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < t; i++) {
      int r = scan.nextInt();
      String s = scan.nextLine().trim();

      for (int j = 0; j < s.length(); j++) {
        for (int k = 0; k < r; k++) {
          sb.append(s.charAt(j));
        }
      }
      sb.append("\n");
    }
    System.out.print(sb);
    scan.close();
  }
}
