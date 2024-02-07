package com.anhyeryoung.tapp.handler.member;

import com.anhyeryoung.menu.AbstractMenuHandler;
import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import com.anhyeryoung.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Member old = memberDao.findBy(no);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다!");
      return;
    }

    Member member = new Member();
    member.setNo(old.getNo());
    member.setEmail(this.prompt.input("이메일(%s)? ", old.getEmail()));
    member.setName(this.prompt.input("이름(%s)? ", old.getName()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(old.getCreatedDate());

    memberDao.update(member);
    System.out.println("회원을 변경했습니다.");
  }
}
