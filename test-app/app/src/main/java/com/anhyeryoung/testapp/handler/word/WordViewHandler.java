package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.Prompt;

public class WordViewHandler extends AbstractMenuHandler {

  private WordDao wordDao;

  public WordViewHandler(WordDao wordDao, Prompt prompt) {
    super(prompt);
    this.wordDao = wordDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("no : ");

    Word word = wordDao.findBy(no);
    if (word == null) {
      System.out.println("ERROR : Unknown column");
      return;
    }

    System.out.printf("no: %d\n", word.getNo());
    System.out.printf("word: %s\n", word.getWord());
    System.out.printf("mean: %s\n", word.getMean());
    System.out.printf("writer: %s\n", word.getWriter());
    System.out.printf("createdDate: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", word.getCreatedDate());
  }
}
