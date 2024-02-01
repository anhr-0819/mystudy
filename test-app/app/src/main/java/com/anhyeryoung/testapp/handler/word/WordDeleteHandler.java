package com.anhyeryoung.testapp.handler.word;

import static com.anhyeryoung.util.AnsiEscape.YELLOW;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.util.AnsiEscape;
import com.anhyeryoung.util.Prompt;
import com.anhyeryoung.util.AnsiEscape.*;

public class WordDeleteHandler extends AbstractMenuHandler {

  private WordDao wordDao;

  public WordDeleteHandler(WordDao wordDao, Prompt prompt) {
    super(prompt);
    this.wordDao = wordDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("no : ");
    if (wordDao.delete(no) == 0) {
      System.out.println(AnsiEscape.RED_BRIGHT +"ERROR : Unknown column" + AnsiEscape.RESET);
    } else {
      System.out.println(AnsiEscape.YELLOW_BOLD+"deleted");
    }
  }
}
