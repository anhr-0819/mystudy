package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 수 10개를 입력받은 뒤, 42로 나눈 나머지 값이 서로 다른 것이 몇 개 있는지 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[10];
    int count = 0;

    for (int i = 0, k = 0; i < 10; i++) {
      arr[i] = scan.nextInt() % 42;
      count = (i == 0 || k != arr[i]) ? ++count : count;
      System.out.print("count : " + count + " ");
      k = arr[i];
    }
    System.out.print(count);
    scan.close();
  }

}
