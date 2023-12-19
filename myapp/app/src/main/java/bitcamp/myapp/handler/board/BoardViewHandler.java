package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//

// 직접 인터페이스를 구현하는대신 AbstractMenuHandler를 상속 받는다.
public class BoardViewHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;

  public BoardViewHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  protected void action() {
    // super 키워드 사용 : 현재 이 메소드가 소속된 클래스의 수퍼 클래스의 action() 메소드를 호출
    // 오버라이딩(재정의) 하기 전의 메소드를 호출해서 원래 하던 일을 유지하되 기능은 추가 시킨다.

    int index = this.prompt.inputInt("번호? ");
    Board board = this.objectRepository.get(index);
    if (board == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
  }
}
