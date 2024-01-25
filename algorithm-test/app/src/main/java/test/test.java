package test;

import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();

    while (a <= b) {
      Math.pow(a, b); // return <= double형
      a++;
    }

  }

}
