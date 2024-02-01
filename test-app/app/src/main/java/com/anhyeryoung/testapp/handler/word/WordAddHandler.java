package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
import com.anhyeryoung.util.Prompt;

public class WordAddHandler extends AbstractMenuHandler {

  private WordDao wordDao;

  public WordAddHandler(WordDao wordDao, Prompt prompt) {
    super(prompt);
    this.wordDao = wordDao;
  }

  @Override
  protected void action() {
    Word word = new Word();
    word.setWord(this.prompt.input("word : "));
    word.setMean(this.prompt.input("mean : "));
    //board.setWriter(this.prompt.input("writer : "));
    word.setCheck(this.prompt.inputInt("check(default:0) : "));

    wordDao.add(word);
  }
}
