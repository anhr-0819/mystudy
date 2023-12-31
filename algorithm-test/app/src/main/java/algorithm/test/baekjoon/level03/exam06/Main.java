package algorithm.test.baekjoon.level03.exam06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    int[] intArr = new int[t];

    for (int i = 0; i < t; i++) {
      String[] strArr = br.readLine().split(" ");
      intArr[i] = Integer.parseInt(strArr[0]) + Integer.parseInt(strArr[1]);
      sb.append(intArr[i]).append("\n");
    }
    System.out.print(sb);
    br.close();
  }
}
