package algorithm.test.baekjoon.level06.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 단어가 팰린드롬인지 아닌지 확인하는 프로그램
    Scanner scan = new Scanner(System.in);
    String[] arr = scan.nextLine().split("");
    scan.close();

    int first = 0;
    int last = arr.length - 1;
    int result = 1;

    try {
      while (first != last) {
        if (!arr[first++].equals(arr[last--])) {
          result = 0;
          break;
        }
      }
      System.out.print(result);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.print(result);
    }
  }
}
