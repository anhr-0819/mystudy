package algorithm.test.baekjoon.level05.exam06;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    char[] alphabets = alphabet.toCharArray();

    String str = scan.nextLine();

    int index = 0;
    for (char c : alphabets) {
      index = str.indexOf(c);
      sb.append(index).append(" ");
    }

    System.out.print(sb);
    scan.close();
  }
}
