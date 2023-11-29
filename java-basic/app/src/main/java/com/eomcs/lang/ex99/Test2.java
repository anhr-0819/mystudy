package com.eomcs.lang.ex99;

// import java.io.InputStream;
// import java.util.Scanner;

public class Test2 {

  public static void main(String[] args) throws Exception {
    // InputStream in = System.in;
    java.io.InputStream in = System.in;

    // System.in에서 수행할 수 있는 명령
    // read(), read(byte[]) ... <= 한 줄 단위로 입력된 문자열을 읽는 작업을 수행시킬 명령은 없다

    // Scanner keyIn = new Scanner(in);
    java.util.Scanner keyIn = new java.util.Scanner(in);
    String str = keyIn.nextLine(); // keyIn 객체에 대해 nextLint()을 호출
    // int b = in.read(); // 리턴값 : byte (기본단위는 int)

    // Scanner () // 표준입력스트림을 좀더 정교하게 제어하려면 *추가 데이터와 *도구(메서드)가 필요하다
    // java.util에 있는 클래스. 생성자의 매개변수로 InputStream를 받는다.
    // InputStream형의 source를 InputStreamReader로 다시 인스턴스화하여 넘겨주기 때문에
    // 2byte의 한글도 읽을 수 있다.
    // Scanner() 에서 수행할 수 있는 명령
    // next(), nextLine(), nextInt() ...
    // 토큰을 기준으로 데이터를 입력받는다. (*토큰 : 공백 문자(Spacebar), 탭(Tab), 개행(Enter) 등으로 구분되는 요소*)

    System.out.println("===> " + str);
    keyIn.close(); // 종료

  }

}
