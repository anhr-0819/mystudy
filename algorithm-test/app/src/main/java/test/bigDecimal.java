package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class bigDecimal {
  // a / b 결과를 소수점 20째자리까지 출력

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    BigDecimal a = new BigDecimal(scan.nextInt());
    BigDecimal b = new BigDecimal(scan.nextInt());

    System.out.print(a.divide(b, 20, RoundingMode.FLOOR));
  }
}
