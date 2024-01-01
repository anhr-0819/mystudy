package algorithm.test.baekjoon.level05.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] arr = scan.nextLine().split(" ");
    int count = 0;
    for (String s : arr) {
      count = s.trim().isEmpty() ? count : ++count;
    }
    System.out.println(count);
    scan.close();
  }
}
