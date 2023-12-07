package algorithm.test.baekjoon.level01.exam08;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는 프로그램
    Scanner scan = new Scanner(System.in);
    int y = scan.nextInt();

    System.out.println(y - 543);
    scan.close();
  }
}
