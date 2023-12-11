package bitcamp.myapp.Menu;

import bitcamp.menu.MeunHandler;
import bitcamp.myapp.vo.Board;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MeunHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListeHandler implements MeunHandler {

  BoardRepository boardRepository;

  public BoardListeHandler(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public void action() {
    System.out.println("게시글 목록:");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < this.boardRepository.length; i++) {
      Board board = this.boardRepository.boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
