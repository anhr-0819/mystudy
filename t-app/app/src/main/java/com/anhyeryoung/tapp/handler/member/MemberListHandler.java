package com.anhyeryoung.tapp.handler.member;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import com.anhyeryoung.util.Prompt;
import java.util.List;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%30s\t%s\n", "번호", "이름", "이메일", "가입일");

    List<Member> list = memberDao.findAll();

    for (Member member : list) {
      System.out.printf("%-4d\t%-10s\t%30s\t%4$tY-%4$tm-%4$td\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getCreatedDate());
    }
  }
}
