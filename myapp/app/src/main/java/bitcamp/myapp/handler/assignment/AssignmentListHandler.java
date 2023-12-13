package bitcamp.myapp.handler.assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import java.util.ArrayList;

public class AssignmentListHandler implements MenuHandler {

  ArrayList<Assignment> objectRepository;


  public AssignmentListHandler(ArrayList<Assignment> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

//    for (Assignment assignment : (Assignment[]) this.objectRepository.toArray()) {
//      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
//    }

//    Assignment[] assignments = new Assignment[this.objectRepository.size()];
    for (Assignment assignment : this.objectRepository.toArray(new Assignment[0])) {
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
