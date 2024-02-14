package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;
import java.util.ArrayList;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardModifyHandler(BoardDao boardDao, AttachedFileDao attachedFileDao) {
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
      prompt.println("첨부파일 : ");
      for (AttachedFile file : files) {
        prompt.println(file.getFilePath());
      }
      int inputNum = prompt.inputInt("1.추가, 2.삭제, 0.변경없음");

      if (inputNum == 1) {
        while (true) {
          List<AttachedFile> addfiles = new ArrayList<>();
          String filepath = prompt.input("파일?(종료: 그냥 엔터) ");
          if (filepath.length() == 0) {
            break;
          }
          addfiles.add(new AttachedFile(board.getNo()).filePath(filepath));
        }
      } else if (inputNum == 2) {
        for (AttachedFile file : files) {
          if (prompt.input("(%s) 삭제?(y/n)", file.getFilePath()) == "y") {
            attachedFileDao.delete(file.getNo());
          }

        }
      }

      boardDao.update(board);
      prompt.println("게시글을 변경했습니다.");
    } catch (NumberFormatException e) {
      prompt.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      prompt.println("게시글 변경 오류!");
      prompt.println("다시 시도 하세요.");

    } catch (Exception e) {
      prompt.println("실행 오류!");
      e.printStackTrace();
    }
  }
}
