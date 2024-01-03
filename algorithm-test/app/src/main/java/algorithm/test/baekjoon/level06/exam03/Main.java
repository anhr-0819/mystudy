package algorithm.test.baekjoon.level06.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력
    Scanner scan = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = scan.nextInt();
    for (int i = 1; i < n * 2; i++) { // 2×N-1번 반복
      for (int j = n - i; j < 10; j++) { // 공백 넣기
        sb.append(" ");
      }
      sb.append("*");
    }
    scan.close();
  }
}
