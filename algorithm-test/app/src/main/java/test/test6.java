package test;

import java.util.Scanner;

public class test6 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    StringBuilder sb = new StringBuilder();
    int cnt = 1;
    for (int i = 1; cnt != 0; i++) {
      if (i % 2 != 0) {
        for (int j = 0; j < cnt; j++) {
          sb.append("*");
          System.out.print("*");
        }
        cnt = i > n ? --cnt : ++cnt;
        System.out.println(cnt);
        System.out.println("i = " + i);
        System.out.println("");
        sb.append("\n");
      } else {
        System.out.println("");
        sb.append("\n");
      }

    }
    // System.out.print(sb);
  }

}
