package test;

public class test2 {

  public static void main(String[] args) {
    int a = 128, b = 2021;
    while (b != 0) {
      int tmp = a % b;
      a = b;
      b = tmp;

      System.out.println(a + " " + b);
      System.out.println("///////////");
    }
    System.out.print(a);

  }

}
