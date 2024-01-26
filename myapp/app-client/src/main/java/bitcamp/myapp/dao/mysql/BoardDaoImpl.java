package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import java.sql.Connection;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  int category;
  Connection con;

  public BoardDaoImpl(Connection con, int category) { // 게시판이 여러개 존재할 수 있기 때문에 구분하기 위한 변수
    this.category = category;
    this.con = con;
  }

  @Override
  public void add(Board board) {

  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public List<Board> findAll() {
    return null;
  }

  @Override
  public Board findBy(int no) {
    return null;
  }

  @Override
  public int update(Board board) {
    return 0;
  } // BoardDao 인터페이스 구현체

}
