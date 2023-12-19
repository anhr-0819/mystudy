package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardAddHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardAddHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    // 생략할 수 없다. 생략하게 되면 컴파일러가 수퍼 클래스에 기본 생성자를 호출하는 코드를 생성하게 되는데
    // 수퍼 클래스에는 기본 생성자가 없으므로 생략하면 에러가 발생한다.
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    // MenuHandler 인터페이스에 선언된 메서드 대신
    // AbstractMenuHandler 클래스에 선언된 action() 추상 메서드를 구현한다.
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(this.prompt.input("작성일? "));

    objectRepository.add(board);

    // 레퍼런스를 선언하는 시점에 지정된 타입이 아닌 값을 넣으려고 하면
    // 컴파일 오류가 발생한다.
    // 즉 특정 타입만 사용하도록 제한할 수 있는 문법이 제네릭(generic) 이다.
    //    objectRepository.add(new String("Hello"));
  }
}
