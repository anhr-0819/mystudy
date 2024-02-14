package bitcamp.util;

import java.sql.Connection;

public class TransactionManager {

  ConnectionPool connectionPool;

  public TransactionManager(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }


  // getConnection()은 스레드에 보관된 커넥션을 꺼낸다.
  public void startTransaction() throws Exception {
    connectionPool.getConnection().setAutoCommit(false);
    System.out.printf("[%s] 트랜잭션 시작\n", Thread.currentThread().getName());
  }

  public void commit() throws Exception {
    connectionPool.getConnection().commit();
    complete();
  }

  public void rollback() throws Exception {
    connectionPool.getConnection().rollback();
    complete();
  }

  private void complete() throws Exception {
    Connection con = connectionPool.getConnection();
    con.setAutoCommit(true);
    con.close(); // close()를 호출하면 커넥션을 커넥션풀로 되돌린다.
    System.out.printf("[%s] 트랜잭션 종료\n", Thread.currentThread().getName());
  }
}
