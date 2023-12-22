package algorithm.test.baekjoon.level03.exam08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      String[] strArr = br.readLine().split(" ");
      sb.append("Case #").append(i + 1).append(": ").append(strArr[0]).append(" + ")
          .append(strArr[1]).append(" = ")
          .append(Integer.valueOf(strArr[0]) + Integer.valueOf(strArr[1])).append("\n");
    }
    System.out.print(sb);
    br.close();
  }
}
