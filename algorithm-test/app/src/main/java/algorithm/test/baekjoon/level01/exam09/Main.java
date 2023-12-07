package algorithm.test.baekjoon.level01.exam09;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // (A+B)%C, ((A%C) + (B%C))%C, (A×B)%C, ((A%C) × (B%C))%C 을 구하는 프로그램
    int a, b, c;

    Scanner scan = new Scanner(System.in);
    a = scan.nextInt();
    b = scan.nextInt();
    c = scan.nextInt();

    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);
    scan.close();
  }
}
