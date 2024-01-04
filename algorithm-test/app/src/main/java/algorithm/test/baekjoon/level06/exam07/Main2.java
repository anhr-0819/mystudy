package algorithm.test.baekjoon.level06.exam07;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {
    // 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.nextLine();

    loop1: for (int i = 0; i < n; i++) {
      HashMap<String, Integer> map = new HashMap<>();
      String[] arr = scan.nextLine().split("");
      String next = "";

      if (arr.length == 1)
        continue;
      loop2: for (int k = 0; k < arr.length - 1; k++) {

        try {
          next = arr[k + 1]; // 다음 문자
        } catch (Exception e) {
          e.printStackTrace();
          next = arr[k];
        }
        System.out.println("map = " + map.entrySet());

        System.out.println("arr[k] = " + arr[k]);
        System.out.println("next = " + next);



        // 현재 문자가 다음 문자와 같지 않다면
        if (!next.equals(arr[k])) {
          System.out.println("현재 문자가 다음 문자와 일치하지 않음 ");
          if (map.containsKey(arr[k]) && !arr[k].equals(arr[k - 1])) { // 일치하는 키가 존재 한다면
            n--;
            System.out.println("키가 존재 하므로 n--. 현재 n = " + n);
            break loop2;
          }
        }

        if (!map.containsKey(arr[k])) { // 일치하는 키가 없다면
          map.put(arr[k], 1);
          System.out.println("일치하는 키가 없으므로 맵에 추가 : " + arr[k] + " 현재 n = " + n);
        }
        // if (!map.containsKey(next)) { // 일치하는 키가 없다면
        // map.put(next, 1);
        // System.out.println("일치하는 키가 없으므로 맵에 추가 : " + next + " 현재 n = " + n);
        // }
        System.out.println("");
      }

      System.out.println("-----------------------------n = " + n);
      System.out.println("실행 종료 map = " + map.entrySet());
      System.out.println("---------------------------------------------------------");
    }
    scan.close();

    System.out.println(n);
  }
}
