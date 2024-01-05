// Byte Stream - 바이트 단위로 읽기 II
package com.eomcs.io.ex02;

import java.io.FileInputStream;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("sample/utf8.txt");

    // 반복문을 이용하여 여러 바이트를 읽는다.
    int b;
    // while (true) {
    // b = in.read();
    // if (b == -1) // 파일의 끝에 도달하면 -1을 리턴한다.
    // break;
    // System.out.printf("%02x ", b);
    // }

    // read() 의 리턴타입이 int 이기때문에, int 메모리를 준비해야 한다.
    while ((b = in.read()) != -1) { // 읽어온 내용을 변수에 담아서 즉시 비교
      System.out.printf("%02x ", b);
    }

    in.close();
  }

}
