package com.anhyeryoung.tapp.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
  private static final long serialVersionUID = 100L;

  private int no; // 회원번호
  private String name; // 이름
  private String tel; // 전화
  private String email; // 이메일
  private String password; // 암호
  private String pCode; // 우편번호
  private String 기본주소; // 기본주소
  private String 상세주소; // 상세주소
  private Date createdDate; // 등록일
  private Date lastLogin; // 최종접속일
  private String grant; // 권한

  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", tel='" + tel + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", pCode='" + pCode + '\'' +
        ", 기본주소='" + 기본주소 + '\'' +
        ", 상세주소='" + 상세주소 + '\'' +
        ", createdDate=" + createdDate +
        ", lastLogin=" + lastLogin +
        ", grant='" + grant + '\'' +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getpCode() {
    return pCode;
  }

  public void setpCode(String pCode) {
    this.pCode = pCode;
  }

  public String get기본주소() {
    return 기본주소;
  }

  public void set기본주소(String 기본주소) {
    this.기본주소 = 기본주소;
  }

  public String get상세주소() {
    return 상세주소;
  }

  public void set상세주소(String 상세주소) {
    this.상세주소 = 상세주소;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getGrant() {
    return grant;
  }

  public void setGrant(String grant) {
    this.grant = grant;
  }
}
