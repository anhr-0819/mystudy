package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.util.Prompt;

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
      System.out.println("ERROR : Unknown column");
    } else {
      System.out.println("deleted");
    }
  }
}
