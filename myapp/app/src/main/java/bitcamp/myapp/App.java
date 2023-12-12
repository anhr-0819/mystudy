package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuHandler;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.menu.BoardAddHandler;
import bitcamp.myapp.menu.BoardDeleteHandler;
import bitcamp.myapp.menu.BoardModifyHandler;
import bitcamp.myapp.menu.BoardRepository;
import bitcamp.myapp.menu.BoardViewHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    BoardRepository boardRepository = new BoardRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("변경"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");

    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다.
    MenuHandler boardAddHandler = new BoardAddHandler(boardRepository, prompt);

    // "등록" 이라는 메뉴를 선택했을 때 BoardAddHandler를 실행시키는 일을 한다.
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);

    // 게시글 등록을 처리하는 메뉴를 게시글 메뉴에 추가한다.
    boardMenu.add(boardAddMenu);

    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    // 조회라는 타이틀을 가진 메뉴 생성한다( 작업을 수행할 때 사용할 객체를 함께 넘김 )

//    BoardModifyHandler handler = new BoardModifyHandler(boardRepository, prompt);
//    // 변경작업을 할 때 배열정보와 프롬프트 정보가 필요함
//    MenuItem menuItem = new MenuItem("변경",handler);
//    boardMenu.add(menuItem);
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));

    //boardMenu.add(new MenuItem("변경", new BoardModifyHandler()));
    // boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록"));
    memberMenu.add(new MenuItem("조회"));
    memberMenu.add(new MenuItem("변경"));
    memberMenu.add(new MenuItem("삭제"));
    memberMenu.add(new MenuItem("목록"));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록"));
    greetingMenu.add(new MenuItem("조회"));
    greetingMenu.add(new MenuItem("변경"));
    greetingMenu.add(new MenuItem("삭제"));
    greetingMenu.add(new MenuItem("목록"));
    mainMenu.add(greetingMenu);

    mainMenu.add(new MenuItem("도움말"));

    mainMenu.execute(prompt);

    prompt.close();


  }
}
