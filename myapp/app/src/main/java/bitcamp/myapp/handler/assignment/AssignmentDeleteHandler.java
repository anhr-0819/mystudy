package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentDao;

  public AssignmentDeleteHandler(AssignmentDao assignmentDao, Prompt prompt) {
    super(prompt);
    this.assignmentDao = assignmentDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    if (assignmentDao.delete(no) == 0) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제 했습니다!");
    }
  }
}

