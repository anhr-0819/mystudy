package com.anhyeryoung.tapp.handler.member;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import com.anhyeryoung.util.Prompt;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  } 

  @Override
  protected void action() {
    Member member = new Member();
    member.setEmail(this.prompt.input("이메일? "));
    member.setName(this.prompt.input("이름? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
