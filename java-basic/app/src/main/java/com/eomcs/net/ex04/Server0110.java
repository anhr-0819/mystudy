// 통신 방식 - Stateful
package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0110 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 실행!");
      // try 선언문에 일반 문장은 넣을 수 없기 때문에
      // try를 분리해서 사용한것

      try (Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        System.out.println("클라이언트가 연결되었음!");

        // stateful 방식은 클라이언트와 데이터를 주고 받는 동안
        // 그 클라이언트의 작업 상태를 유지할 수 있다.
        // 예를 들어 다음과 같이 몇 번 요청했는지 요청 횟수를 유지할 수 있다.
        int count = 0;

        while (true) { // 반복해서 데이터를 읽고 보낸다.
          String name = in.readLine(); // 클라이언트에서 한 줄을 보내기 때문에 한줄을 읽는다.
          if (name.equalsIgnoreCase("quit")) {
            out.println("Goodbye!");
            out.flush();
            break;
          }
          count++;
          out.printf("%s 님 반갑습니다!(%d)\n", name, count); // 클라이언트에서 한 줄을 읽기 때문에 반드시 줄바꿈 문자를 포함해야한다.
          out.flush();
        }
      }
      System.out.println("클라이언트와의 연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
    // 한 명의 클라이언트 요청을 처리하고 서버 종료
  }

}

