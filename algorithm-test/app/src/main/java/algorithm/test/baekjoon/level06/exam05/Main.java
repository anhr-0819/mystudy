package algorithm.test.baekjoon.level06.exam05;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] arr = scan.nextLine().split("");
    scan.close();

    HashMap<String, Integer> map = new HashMap<>();

    Integer value = 1;
    for (String s : arr) {
      if (map.containsKey(s.toUpperCase())) {
        value = (map.get(s.toUpperCase()) + 1 > value) ? map.get(s.toUpperCase()) + 1 : value;
        map.replace(s.toUpperCase(), map.get(s.toUpperCase()) + 1);
      } else {
        map.put(s.toUpperCase(), 1);
      }
    }
    map.put(String.valueOf(value), 0);

    String key = "";
    for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() == value) {
        map.replace(String.valueOf(value), map.get(String.valueOf(value)) + 1);
        key = entry.getKey();
      }
    }
    System.out.print((map.get(String.valueOf(value)) > 1) ? "?" : key);
  }
}
