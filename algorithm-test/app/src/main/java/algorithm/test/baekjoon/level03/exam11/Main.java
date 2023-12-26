package algorithm.test.baekjoon.level03.exam11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int a = 0, b = 0;

    do {
      String[] strArr = br.readLine().split(" ");
      a = Integer.parseInt(strArr[0]);
      b = Integer.parseInt(strArr[1]);
      sb.append(a + b).append("\n");
    } while (a != 0 && b != 0);
    {
      String[] strArr = br.readLine().split(" ");
      a = Integer.parseInt(strArr[0]);
      b = Integer.parseInt(strArr[1]);
      sb.append(a + b).append("\n");
      System.out.print(sb);

    }
    System.out.print(sb);
  }
}
