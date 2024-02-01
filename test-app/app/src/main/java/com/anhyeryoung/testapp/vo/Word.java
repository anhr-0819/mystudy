package com.anhyeryoung.testapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Word implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String word;
  private String mean;
  private String writer;
  private String reference;
  private int category;
  private int check;
  private Date createdDate;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getMean() {
    return mean;
  }

  public void setMean(String mean) {
    this.mean = mean;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public int getCheck() {
    return check;
  }

  public void setCheck(int check) {
    this.check = check;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }
}
