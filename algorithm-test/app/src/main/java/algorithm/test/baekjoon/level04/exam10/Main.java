package algorithm.test.baekjoon.level04.exam10;

import java.util.Scanner;

public class Main {
  static double max = 0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    double[] arr = new double[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextDouble();
      max = arr[i] > max ? arr[i] : max;
    }
    scan.close();

    score(arr);
    System.out.print(aver(arr));
  }

  private static double aver(double[] arr) {
    double sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum / arr.length;
  }

  private static double[] score(double[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / max * 100;
    }
    return arr;
  }

}
