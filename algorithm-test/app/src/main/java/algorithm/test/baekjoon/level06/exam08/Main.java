package algorithm.test.baekjoon.level06.exam08;

import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Map<String, Double> map = Map.of("A+", 4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0, "C+", 2.5, "C0",
        2.0, "D+", 1.5, "D0", 1.0, "F", 0.0);


    double d = 0.0;
    double sum = 0.0;

    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 20; i++) {
      String s = scan.next();
      double credit = scan.nextDouble();
      s = scan.next();

      if (map.containsKey(s)) {
        d += credit;
        sum += credit * map.get(s);
      } else {
        continue;
      }
    }
    scan.close();
    System.out.print(sum / d);
  }
}
