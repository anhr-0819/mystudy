package algorithm.test.baekjoon.level05.exam11;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    // String[] arr = new String[3];
    scan.useDelimiter("\\.");
    int y = scan.nextInt();
    int m = scan.nextInt();
    int d = scan.nextInt();
    scan.close();
    System.out.printf("%d-%d-%d", m, d, y);
  }
}
