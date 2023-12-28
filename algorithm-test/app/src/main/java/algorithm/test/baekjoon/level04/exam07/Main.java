package algorithm.test.baekjoon.level04.exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[30];
    int[] arr2 = new int[2];

    for (int i = 0; i < 28; i++) {
      int n = Integer.parseInt(br.readLine()) - 1;
      arr[n] = n + 1;
    }
    br.close();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        if (i + 1 > arr2[0] && arr2[0] != 0) {
          arr2[1] = i + 1;
        } else {
          arr2[0] = i + 1;
        }
      }
    }
    System.out.printf("%d\n%d", arr2[0], arr2[1]);
  }
}
