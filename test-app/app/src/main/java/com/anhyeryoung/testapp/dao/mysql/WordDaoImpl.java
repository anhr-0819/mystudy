package com.anhyeryoung.testapp.dao.mysql;

import com.anhyeryoung.testapp.dao.WordDao;
import com.anhyeryoung.testapp.dao.DaoException;
import com.anhyeryoung.testapp.vo.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WordDaoImpl implements WordDao {
  int category;
  Connection con;

  public WordDaoImpl(Connection con, int category) {
    this.category = category;
    this.con = con;
  }

  @Override
  public void add(Word word) {
    try(PreparedStatement pstmt = con.prepareStatement("insert into words(word,mean,reference,memo,category) values(?,?,?,?,?)")) {
      pstmt.setString(1,word.getWord());
      pstmt.setString(2, word.getMean());
      pstmt.setString(3, word.getReference());
      pstmt.setString(4,word.getMemo());
      pstmt.setInt(5,this.category);

      pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try(PreparedStatement pstmt = con.prepareStatement("delete from words where word_no=?")) {
      pstmt.setInt(1,no);
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Word> findAll() {
    try(PreparedStatement pstmt = con.prepareStatement("select * from words where category=? order by word_no desc")) {
      pstmt.setInt(1,this.category);
      try(ResultSet rs = pstmt.executeQuery()) {
        ArrayList<Word> list = new ArrayList<>();
        while (rs.next()) {
          Word word = new Word();
          word.setNo(rs.getInt("word_no"));
          word.setWord(rs.getString("word"));
          word.setMean(rs.getString("mean"));
          word.setWriter(rs.getString("writer"));
          word.setCreatedDate(rs.getDate("created_date"));
          word.setReference(rs.getString("reference"));
          word.setMemo(rs.getString("memo"));
          list.add(word);
        }
        return list;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Word findBy(int no) {
    try(PreparedStatement pstmt = con.prepareStatement("select * from words where word_no=?")) {
      pstmt.setInt(1,no);
      try(ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Word word = new Word();
          word.setNo(rs.getInt("word_no"));
          word.setWord(rs.getString("word"));
          word.setMean(rs.getString("mean"));
          word.setWriter(rs.getString("writer"));
          word.setReference(rs.getString("reference"));
          word.setMemo(rs.getString("memo"));
          word.setCreatedDate(rs.getDate("created_date"));
          return word;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Word word) {
    try(PreparedStatement pstmt = con.prepareStatement("update words set word=?, mean=?, writer=?, reference=?, memo=? where word_no=?")) {
      pstmt.setString(1, word.getWord());
      pstmt.setString(2,word.getMean());
      pstmt.setString(3, word.getWriter());
      pstmt.setString(4, word.getReference());
      pstmt.setString(5, word.getMemo());
      pstmt.setInt(6,word.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
