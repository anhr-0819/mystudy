// FileOutputStream: float, double 값 출력
package com.eomcs.io.ex04;

import java.io.FileOutputStream;

public class Exam0510 {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("temp/test6.data");

    float f = 12.375f; // hex: 41460000
    double d = 12.375; // hex: 4028c00000000000

    // out.write(f >> 24); // f 출력 <= 에러
    // float, double에 대해서는 비트이동 연산자를 사용할 수 없다.

    // f 출력
    out.write(Float.floatToIntBits(f) >> 24);
    out.write(Float.floatToIntBits(f) >> 16);
    out.write(Float.floatToIntBits(f) >> 8);
    out.write(Float.floatToIntBits(f));

    // d 출력
    out.write((int) (Double.doubleToLongBits(d) >> 56));
    out.write((int) (Double.doubleToLongBits(d) >> 48));
    out.write((int) (Double.doubleToLongBits(d) >> 40));
    out.write((int) (Double.doubleToLongBits(d) >> 32));
    out.write((int) (Double.doubleToLongBits(d) >> 24));
    out.write((int) (Double.doubleToLongBits(d) >> 16));
    out.write((int) (Double.doubleToLongBits(d) >> 8));
    out.write((int) (Double.doubleToLongBits(d)));

    out.close();

    System.out.println("실행 완료!");
  }

}
