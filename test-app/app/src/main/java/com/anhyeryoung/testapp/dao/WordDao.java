package com.anhyeryoung.testapp.dao;

import com.anhyeryoung.testapp.vo.Word;
import java.util.List;

public interface WordDao {

  void add(Word word);

  int delete(int no);

  List<Word> findAll();

  Word findBy(int no);

  int update(Word word);

}
