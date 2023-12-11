package bitcamp.myapp.Menu;

import bitcamp.menu.MeunHandler;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MeunHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardModifyHandler implements MeunHandler {

  @Override
  public void action() {
    System.out.println("게시글 변경!");
  }
}
