package algorithm.test.baekjoon.level04.exam08;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 수 10개를 입력받은 뒤, 42로 나눈 나머지 값이 서로 다른 것이 몇 개 있는지 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    HashMap<Integer, Integer> hm = new HashMap<>();
    int[] arr = new int[10];

    for (int i = 0; i < 10; i++) {
      arr[i] = scan.nextInt() % 42;
      hm.put(arr[i], i);
    }
    System.out.print(hm.size());
    scan.close();
  }
}
