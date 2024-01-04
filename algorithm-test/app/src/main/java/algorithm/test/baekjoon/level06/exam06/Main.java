package algorithm.test.baekjoon.level06.exam06;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("c=", "č");

    Scanner scan = new Scanner(System.in);
    String[] arr = scan.nextLine().split("");

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {

      }
    }

    scan.close();

  }


}
