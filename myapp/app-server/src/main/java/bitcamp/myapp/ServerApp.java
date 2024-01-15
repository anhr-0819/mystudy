package bitcamp.myapp;

import bitcamp.RequestException;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerApp {

  HashMap<String, Object> daoMap = new HashMap<>();
  Gson gson;

  public ServerApp() {
    daoMap.put("board", new BoardDaoImpl("board.json"));
    daoMap.put("greeting", new BoardDaoImpl("greeting.json"));
    daoMap.put("assignment", new AssignmentDaoImpl("assignment.json"));
    daoMap.put("member", new MemberDaoImpl("member.json"));

    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public static void main(String[] args) {
    new ServerApp().run();
  }

  void run() {
    System.out.println("[과제관리 서버시스템]");

    try {
      // 1) 랜카드 연결 정보를 준비한다.
      // => 랜카드와 연결하는 것은 실제 OS가 수행한다.
      // => JVM은 OS가 작업한 결과를 가져온다.
      // new ServerSocket(포트번호)
      // => 포트번호: 랜카드로 들어온 데이터를 받을 때 사용할 식별 번호. 중복 불가.
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 실행!");

      while (true) {
        // 2) 클라이언트의 연결을 기다림
        // => 클라이언트 대기 목록에서 먼저 연결된 순서대로 클라이언트 연결 정보를 꺼낸다.
        // => 클라이언트 대기 목록에 아무것도 없다면 연결이 될 때까지 리턴하지 않고 기다린다.
        // Socket socket = serverSocket.accept();
        service(serverSocket.accept());
        // 클라이언트와 연결됐을 때, 연결된 정보를 리턴
      }
    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void service(Socket socket) throws Exception { // 소켓을 받으면 하나의 클라이언트와 무한으로 통신. 하나의 클라이언트의 연결을 처리.
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      System.out.println("클라이언트와 연결됨!");

      // 3) 클라이언트와 통신
      while (processRequest(in, out) != -1) {
        System.out.println("----------------------------"); // 요청과 요청 사이의 구분선 표시용
      }

      System.out.println("클라이언트 연결 종료!");


    } catch (Exception e) {
      System.out.println("클라이언트 연결 오류!");
    }
  }

  // 입출력 스트림을 통해 클라이언트 요청을 읽어서 응답
  int processRequest(DataInputStream in, DataOutputStream out) throws IOException {
    System.out.println("[클라이언트 요청]");
    String dataName = in.readUTF();
    if (dataName.equals("quit")) {
      out.writeUTF("Goodbye!");
      // 더이상 클라이언트로부터 데이터를 읽을일이 없으면 -1 리턴
      return -1;
    }

    String command = in.readUTF();
    String value = in.readUTF();

    try {
      // dataName으로 DAO를 찾는다.
      Object dao = daoMap.get(dataName);
      if (dao == null) { // 클라이언트가 요청한 데이터를 처리할 DAO가 없다면
        throw new RequestException("요청 데이터가 없습니다!");
      }
      System.out.printf("데이터: %s\n", dataName);

      Method commandHandler = findMethod(dao.getClass(), command);
      System.out.printf("메서드: %s\n", commandHandler.getName());

      Object[] args = getArguments(commandHandler, value);

      // 메서드의 리턴 타입을 알아낸다.
      // Class<?> returnType = commandHandler.getReturnType();
      // System.out.printf("리턴: %s\n", returnType.getName());

      // 메서드를 호출한다.
      Object returnValue = commandHandler.invoke(dao, args);

      // 응답 : 정상적으로 처리
      out.writeUTF("200");
      out.writeUTF(gson.toJson(returnValue));
      System.out.println("클라이언트에게 응답 완료!");

    } catch (RequestException e) { // 응답 : 요청에 문제 발생
      out.writeUTF("400");
      out.writeUTF(gson.toJson(e.getMessage()));

    } catch (Exception e) { // 응답 : 서버쪽 문제 발생
      out.writeUTF("500");
      out.writeUTF(gson.toJson(e.getMessage()));
    }
    // 정상적으로 클라이언트 요청을 처리했으면 0 리턴
    return 0;
  }

  Method findMethod(Class<?> clazz, String name) {
    // getDeclaredMethods(): 클래스 정보에서 현재 클래스에 선언된 메서드 목록을 리턴
    Method[] methods = clazz.getDeclaredMethods();
    for (Method m : methods) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    // 해당되는 메서드를 못찾으면 예외 던지기
    throw new RuntimeException("요청 메서드가 없습니다!");
  }

  // 메서드 정보와 메서드에 넘겨줄 값 정보를 받아서 아규먼트를 준비
  Object[] getArguments(Method m, String json) {
    Parameter[] params = m.getParameters();
    System.out.printf("파라미터 개수: %d\n", params.length);

    Object[] args = new Object[params.length];

    // 아규먼트 값 준비하기
    // => 현재 모든 DAO의 메서드는 파라미터가 최대 1개만 있다.
    // => 1개만 있다는 가정하에서 아규먼트 값을 준비한다.
    if (params.length > 0) {
      Class<?> paramType = params[0].getType(); // 파라미터 타입을 알아낸다.
      // 클라이언트가 보낸 JSON 문자열을 해당 파라미터 타입 객체로 변환한다.
      Object paramValue = gson.fromJson(json, paramType);

      // 아규먼트 배열에 저장한다.
      args[0] = paramValue;
    }
    return args;
  }
}
