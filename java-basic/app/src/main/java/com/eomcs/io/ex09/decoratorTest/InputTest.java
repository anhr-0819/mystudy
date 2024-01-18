package com.eomcs.io.ex09.decoratorTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

  public static void main(String[] args) {
    int c;

    try (InputStream in =
        new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("temp/test.txt")));) {
      while ((c = in.read()) >= 0) {
        System.out.println((char) c);
        System.out.print(Integer.toBinaryString(c) + " ");
        System.out.println(c);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
