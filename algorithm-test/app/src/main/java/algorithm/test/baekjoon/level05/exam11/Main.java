package algorithm.test.baekjoon.level05.exam11;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] s = scan.nextLine().split(".");

    for (String str : s) {
      System.out.print(s);
    }
    scan.close();

    System.out.print(sb);
  }
}
