package algorithm.test.baekjoon.level06.exam06;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("c=", "č");
    map.put("c-", "ć");
    map.put("dz=", "dž");
    map.put("d-", "đ");
    map.put("lj", "lj");
    map.put("nj", "nj");
    map.put("s=", "š");
    map.put("z=", "ž");

    Scanner scan = new Scanner(System.in);
    String[] arr = scan.nextLine().split("");
    scan.close();

    for (int i = 0; i < arr.length; i++) {
      if (i < arr.length - 2) {
        String s = arr[i] + arr[i + 1] + arr[i + 2];
      }
    }

  }
}
