package algorithm.test.baekjoon.level05.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);

    int t = scan.nextInt();
    scan.nextLine();
    String[] strArr = new String[t];

    for (int i = 0; i < t; i++) {
      strArr[i] = scan.nextLine();
    }

    StringBuilder sb = new StringBuilder();
    for (String str : strArr) {
      sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
    }
    System.out.print(sb);
    scan.close();
  }
}
