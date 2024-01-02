package algorithm.test.baekjoon.level05.exam11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String s = "";
    int count = 0;

    while (scan.hasNextLine()) {
      s = scan.nextLine().trim();
      scan.nextLine();
      // if (s.isBlank()) {
      // break;
      // }
      sb.append(s).append("\n");
    }
    scan.close();

    System.out.print(sb);
  }
}
