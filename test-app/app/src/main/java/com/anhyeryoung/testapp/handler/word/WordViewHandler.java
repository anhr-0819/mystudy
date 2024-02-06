package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.AnsiEscape;
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
      System.out.println(AnsiEscape.RED_BRIGHT + "ERROR : Unknown column" + AnsiEscape.RESET);
      return;
    }
    System.out.println(AnsiEscape.GREEN + "------------------------------------------" + AnsiEscape.RESET);
    System.out.printf("word: %s%s%s\n", AnsiEscape.GREEN_BOLD, word.getWord(), AnsiEscape.RESET);
    System.out.printf("mean: %s%s%s\n", AnsiEscape.GREEN_BOLD, word.getMean(), AnsiEscape.RESET);
    System.out.printf("reference: %s\n", word.getReference());
    System.out.printf("memo: %s\n", word.getMemo());
    System.out.printf("createdDate: %1$tY-%1$tm-%1$td\n", word.getCreatedDate());
  }
}
