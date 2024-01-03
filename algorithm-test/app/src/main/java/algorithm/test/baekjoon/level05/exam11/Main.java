package algorithm.test.baekjoon.level05.exam11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = "";
    while ((str = br.readLine()) != null && !str.isEmpty()) {
      sb.append(str).append("\n");
    }
    br.close();
    System.out.print(sb);
  }
}
