package test;

public class test4 {

  public static void main(String[] args) {
    int a = 2;
    int b = 2;
    while (b > 0) {
      a++;
      b--;
    }
    do {
      a--;
      b++;
    } while (a > 0);
    System.out.println(b);

  }

}
