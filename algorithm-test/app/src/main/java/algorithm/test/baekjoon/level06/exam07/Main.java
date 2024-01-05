package algorithm.test.baekjoon.level06.exam07;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.nextLine();

    String[] arr = new String[n];
    int count = n;

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextLine();
    }
    scan.close();

    for (String str : arr) {
      HashMap<String, Integer> map = new HashMap<>(str.length());
      subLoop1: for (int k = 0; k < str.length(); k++) {

        if (!map.containsKey(String.valueOf(str.charAt(k)))) {
          map.put(String.valueOf(str.charAt(k)), 1);
        } else {
          continue;
        }

        int first = str.indexOf(str.charAt(k));
        int last = str.lastIndexOf(str.charAt(k));

        if (first != last) {
          String[] subStr = str.substring(first, last).split("");
          subLoop2: for (String s : subStr) {
            if (!s.equals(String.valueOf(str.charAt(k)))) {
              count = count - 1;
              break subLoop1;
            }
          }
        }
      }
    }
    System.out.print(count);
  }
}
