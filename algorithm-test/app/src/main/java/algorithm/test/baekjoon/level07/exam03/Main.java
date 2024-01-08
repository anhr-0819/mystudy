package algorithm.test.baekjoon.level07.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    String[][] arr = new String[5][15];
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      String s = scan.nextLine();
      for (int j = 0; j < s.length(); j++) {
        arr[i][j] = String.valueOf(s.charAt(j));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 5; j++) {
        if (arr[j][i] == null)
          continue;
        sb.append(arr[j][i]);
      }
    }
    scan.close();
    System.out.println(sb);
  }
}
