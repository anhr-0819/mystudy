package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.ArrayList;
import java.util.List;

public class BoardModifyHandlerTest extends AbstractMenuHandler {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardModifyHandlerTest(TransactionManager txManager, BoardDao boardDao,
      AttachedFileDao attachedFileDao) {
    this.txManager = txManager;
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {
    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      }

      Board board = new Board();
      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
      board.setCreatedDate(oldBoard.getCreatedDate());
      prompt.println("첨부파일: ");
      for (AttachedFile file : files) {
        prompt.println(file.getFilePath());
      }
      int inputNum = prompt.inputInt(" [1]추가 [2]삭제 [enter]변경안함 -> ");
      if (inputNum == 1) {
        List<AttachedFile> addfiles = new ArrayList<>();
        while (true) {
          String filepath = prompt.input("파일?(종료: 그냥 엔터) ");
          if (filepath.length() == 0) {
            break;
          }
          addfiles.add(new AttachedFile(board.getNo()).filePath(filepath));
        }
        txManager.startTransaction();
        attachedFileDao.addAll(addfiles);
      } else if (inputNum == 2) {
        for (AttachedFile file : files) {
          String del = prompt.input("(%s) 삭제?(y) ", file.getFilePath());
          if (del.equalsIgnoreCase("y")) {
            attachedFileDao.delete(file.getNo());
          }
        }
      }
      boardDao.update(board);
      txManager.commit();
      prompt.println("게시글을 변경했습니다.");
    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      prompt.println("게시글 변경 오류!");
      e.printStackTrace();
    }
  }
}
