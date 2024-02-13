package bitcamp.myapp.handler.member;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;
import java.util.Date;

public class MemberAddHandler extends AbstractMenuHandler {

  private DBConnectionPool connectionPool;
  private MemberDao memberDao;

  public MemberAddHandler(DBConnectionPool connectionPool, MemberDao memberDao) {
    this.connectionPool = connectionPool;
    this.memberDao = memberDao;
  }

  @Override
  protected void action(Prompt prompt) {
    Connection con = null;
    try {
      Member member = new Member();
      member.setEmail(prompt.input("이메일? "));
      member.setName(prompt.input("이름? "));
      member.setPassword(prompt.input("암호? "));
      member.setCreatedDate(new Date());

      memberDao.add(member);
    } catch (Exception e) {
      prompt.println("회원 추가 중 오류 발생!");
      prompt.println("다시 시도하시기 바랍니다.");
    } finally {
      // Connection은 다른 작업할 때 다시 사용해야 하기 때문에 원래 상태로 되돌린다.
      try {
        con.setAutoCommit(true);
      } catch (Exception e) {
      }
      connectionPool.returnConnection(con);
    }
  }
}
