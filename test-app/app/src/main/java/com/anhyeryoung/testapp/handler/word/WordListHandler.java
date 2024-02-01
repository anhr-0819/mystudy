package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.AnsiEscape;
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
    System.out.printf("%s%-4s\t%s%s\n", AnsiEscape.GREEN_BOLD, "No", "word",AnsiEscape.RESET);

    List<Word> list = wordDao.findAll();

    for (Word word : list) {
      System.out.printf("%-4d\t%-20s\n",
          word.getNo(),
          word.getWord());
    }
  }
}
