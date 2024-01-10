package algorithm.test.baekjoon.level07.exam04;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<int[]> list = new ArrayList<>();
    int n = scan.nextInt();

    int area = 0;
    for (int i = 0; i < n; i++) {
      int[] arr = new int[2];
      arr[0] = scan.nextInt();
      arr[1] = scan.nextInt();
      area += 100;
      try {
        for (int[] arr2 : list) {
          System.out.println(arr2[0] + "<=arr2[0]" + (arr2[0] + 10) + "<=arr2[0]+10 " + arr2[1]
              + "<=arr2[1]" + (arr2[1] + 10) + "<=arr2[1]+10");
          if ((arr2[0] < arr[0] && arr[0] < (arr2[0] + 10))
              && (arr2[1] < arr[1] && arr[1] < (arr2[1] + 10))) {
            area = area - (arr2[0] + 10 - arr[0]) * (arr2[1] + 10 - arr[1]);
            System.out.println("넓이 빼기");
          }
        }
        list.add(arr);
        System.out.println(list.size());
      } catch (ConcurrentModificationException e) {
        e.printStackTrace();
      }
    }

    System.out.print(area);
    scan.close();
  }
}
