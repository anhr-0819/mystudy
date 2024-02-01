package com.anhyeryoung.testapp.handler.word;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.vo.Word;
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
      System.out.println("ERROR : Unknown column");
      return;
    }

    Word word = new Word();
    word.setNo(oldWord.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
    word.setWord(this.prompt.input("word(%s) : ", oldWord.getWord()));
    word.setMean(this.prompt.input("mean(%s) : ", oldWord.getMean()));
    word.setWriter(this.prompt.input("writer(%s) : ", oldWord.getWriter()));
    word.setCreatedDate(oldWord.getCreatedDate());

    wordDao.update(word);
    System.out.println("Changed");
  }
}
