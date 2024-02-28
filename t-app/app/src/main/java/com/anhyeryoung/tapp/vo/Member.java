package com.anhyeryoung.tapp.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Member implements Serializable {
  private static final long serialVersionUID = 100L;

  private int no; // 회원번호
  private String name; // 이름
  private String tel; // 전화
  private String email; // 이메일
  private String password; // 암호
  private String pCode; // 우편번호
  private String bAddr; // 기본주소
  private String dAddr; // 상세주소
  private Date createdDate; // 등록일
  private Timestamp lastLogin; // 최종접속일
  private String authority; // 권한

  @Override
  public String toString() {
    return "Member{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", tel='" + tel + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", pCode='" + pCode + '\'' +
        ", bAddr='" + bAddr + '\'' +
        ", dAddr='" + dAddr + '\'' +
        ", createdDate=" + createdDate +
        ", lastLogin=" + lastLogin +
        ", authority='" + authority + '\'' +
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

  public String getbAddr() {
    return bAddr;
  }

  public void setbAddr(String bAddr) {
    this.bAddr = bAddr;
  }

  public String getdAddr() {
    return dAddr;
  }

  public void setdAddr(String dAddr) {
    this.dAddr = dAddr;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Timestamp getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Timestamp lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}

