package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.AnsiEscape;
import com.anhyeryoung.util.Prompt;

public class WordModifyHandler extends AbstractMenuHandler {

  private WordDao wordDao;

  public WordModifyHandler(WordDao wordDao, Prompt prompt) {
    super(prompt);
    this.wordDao = wordDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("no : ");

    Word oldWord = wordDao.findBy(no);
    if (oldWord == null) {
      System.out.println(AnsiEscape.RED_BRIGHT+"ERROR : Unknown column"+AnsiEscape.RESET);
      return;
    }

    Word word = new Word();
    word.setNo(oldWord.getNo());
    System.out.println(AnsiEscape.GREEN + "------------------------------------------" + AnsiEscape.RESET);
    word.setWord(this.prompt.input("word(%s) : ", oldWord.getWord()));
    word.setMean(this.prompt.input("mean(%s) : ", oldWord.getMean()));
    word.setReference(this.prompt.input("Reference(%s) : ", oldWord.getReference()));
    word.setMemo(this.prompt.input("memo(%s) : ", oldWord.getMemo()));

    wordDao.update(word);
    System.out.println(AnsiEscape.YELLOW_BOLD +"Changed"+AnsiEscape.RESET);
  }
}
