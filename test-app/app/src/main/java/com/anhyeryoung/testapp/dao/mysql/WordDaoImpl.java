package com.anhyeryoung.testapp.dao.mysql;

import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.dao.DaoException;
import com.anhyeryoung.testapp.vo.Word;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WordDaoImpl implements WordDao {

  int category;
  Connection con;

  public WordDaoImpl(Connection con, int category) { // 게시판이 여러개 존재할 수 있기 때문에 구분하기 위한 변수
    this.category = category;
    this.con = con;
  }

  @Override
  public void add(Word word) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(
          String.format(
              "insert into words(word,mean,is_check,reference,category) values('%s','%s','%d','%s',%d)",
              word.getWord(),
              word.getMean(),
              word.getCheck(),
              word.getReference(),
              this.category
          ));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format("delete from words where word_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Word> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from words where category = " + this.category);

      ArrayList<Word> list = new ArrayList<>();
      while (rs.next()) {
        Word word = new Word();
        word.setNo(rs.getInt("word_no"));
        word.setWord(rs.getString("word"));
        word.setMean(rs.getString("mean"));
        word.setWriter(rs.getString("writer"));
        word.setCreatedDate(rs.getDate("created_date"));
        word.setReference(rs.getString("reference"));
        word.setCheck(rs.getInt("is_check"));

        list.add(word);
      }
      return list;

    } catch (Exception e) {
      e.printStackTrace();
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Word findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from words where word_no = " + no);
      if (rs.next()) {
        Word word = new Word();
        word.setNo(rs.getInt("word_no"));
        word.setWord(rs.getString("word"));
        word.setMean(rs.getString("mean"));
        word.setWriter(rs.getString("writer"));
        word.setCheck(rs.getInt("is_check"));
        word.setCreatedDate(rs.getDate("created_date"));
        return word;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Word word) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format(
              "update words set word='%s', mean='%s', writer='%s', check=%d where word_no=%d",
              word.getWord(),
              word.getMean(),
              word.getWriter(),
              word.getCheck(),
              word.getNo()
          ));
    } catch (Exception e) {
      e.printStackTrace();
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
