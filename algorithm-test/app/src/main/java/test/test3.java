package test;

public class test3 {

  public static void main(String[] args) {
    int tmp = 0, i = 1;
    while (i < 10) {
      if (i % 2 == 0)
        i++;
      if (tmp > 5)
        break;
      tmp += i;
    }
    System.out.println(tmp);
  }

}
