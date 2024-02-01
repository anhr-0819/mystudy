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
    word.setReference(this.prompt.input("reference : "));
    word.setMemo(this.prompt.input("memo : "));

    wordDao.add(word);
  }
}
