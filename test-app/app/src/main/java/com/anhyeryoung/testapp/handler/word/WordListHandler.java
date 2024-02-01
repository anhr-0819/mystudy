package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.Prompt;
import java.util.List;

public class WordListHandler extends AbstractMenuHandler {

  private WordDao wordDao;

  public WordListHandler(WordDao wordDao, Prompt prompt) {
    super(prompt);
    this.wordDao = wordDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-8s\t%s\n", "No", "check", "word");

    List<Word> list = wordDao.findAll();

    for (Word word : list) {
      System.out.printf("%-4d\t%-8d\t%-20s\n",
          word.getNo(),
          word.getCheck(),
          word.getWord());
    }
  }
}
