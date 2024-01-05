package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.CsvString;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

  Prompt prompt = new Prompt(System.in);

  List<Board> boardRepository = new ArrayList<>();
  List<Assignment> assignmentRepository = new LinkedList<>();
  List<Member> memberRepository = new ArrayList<>();
  List<Board> greetingRepository = new LinkedList<>();

  MenuGroup mainMenu;

  App() {
    assignmentRepository = loadData("assignment.csv", Assignment.class);
    memberRepository = loadData("member.csv", Member.class);
    boardRepository = loadData("board.csv", Board.class);
    greetingRepository = loadData("greeting.csv", Board.class);
    // 어떤 객체를 만들어야 하는지 파라미터로 전달

    prepareMenu();
  }

  public static void main(String[] args) {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardRepository, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardRepository, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardRepository, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardRepository, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
    saveData("assignment.csv", assignmentRepository);
    saveData("member.csv", memberRepository);
    saveData("board.csv", boardRepository);
    saveData("greeting.csv", greetingRepository);
  }

//  <E> void loadData(String filepath, List<E> dataList) { // 선언부의 타입 파라미터의 제네릭 <E> <= (메서드 안에서만 유효)
//    try (ObjectInputStream in = new ObjectInputStream(
//        new BufferedInputStream(new FileInputStream(filepath)))) {
//
//      List<E> list = (List) in.readObject();
//      dataList.addAll(list);
//      // 단점 : add 후에 가비지가 생김
//
//    } catch (Exception e) {
//      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }

  <E> List<E> loadData(String filepath, Class<E> clazz) { // 어떤 객체를 만들어야 하는지 파라미터로 받기
    // 0) 객체를 저장할 List를 준비한다.
    ArrayList<E> list = new ArrayList<>();
    try (Scanner in = new Scanner(new FileReader(filepath))) {
      // 1) 클래스 정보를 가지고 팩토리 메서드를 알아낸다
      Method factoryMethod = clazz.getMethod("createFromCsv", String.class);
      while (true) {
        // 2) 팩토리 메서드에 csv 문자열을 전달하고 객체를 리턴 받는다.
        E obj = (E) factoryMethod.invoke(null, in.nextLine()); // static 메서드는 인스턴스가 필요없으므로 null을 넘김
        // 3) 생성한 객체를 List에 저장한다.
        list.add(obj);
      }
    } catch (NoSuchElementException e) { // 더이상 로딩할 데이터가 없으면
      System.out.printf("%s 파일 로딩 완료!\n", filepath);
    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
    return list;
    // 단점 : 읽다가 실패하면 새 배열을 생성해서 리턴
  }

//  void saveData(String filepath, List<?> dataList) {
//    try (ObjectOutputStream out = new ObjectOutputStream(
//        new BufferedOutputStream(new FileOutputStream(filepath)))) {
//
//      out.writeObject(dataList);
//
//    } catch (Exception e) {
//      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }

  void saveData(String filepath,
      List<? extends CsvString> dataList) { // CsvString 인터페이스 규칙에 따라 만든 객체를 리스트로 받아서 파라미터로 받겠다
    try (FileWriter out = new FileWriter(filepath)) {
      for (CsvString csvObject : dataList) {
        out.write(csvObject.toCsvString() + "\n");
      }

    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
  }
}
