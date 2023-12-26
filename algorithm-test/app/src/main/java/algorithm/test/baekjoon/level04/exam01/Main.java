package algorithm.test.baekjoon.level04.exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split(" ");
    int n = Integer.parseInt(br.readLine());

    int count = 0;
    for (String i : arr) {
      if (n == Integer.parseInt(i)) {
        count++;
      }
    }

    System.out.print(count);
  }
}
