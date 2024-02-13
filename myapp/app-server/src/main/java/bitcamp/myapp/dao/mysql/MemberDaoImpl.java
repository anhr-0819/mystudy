package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ThreadConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  ThreadConnection threadConnection;

  public MemberDaoImpl(ThreadConnection threadConnection) {
    this.threadConnection = threadConnection;
  }

  @Override
  public void add(Member member) {
    Connection con = null;
    try {
      con = threadConnection.get(); // 현재 스레드에 보관된 Connection 객체를 꺼낸다. 없으면 만들어준다.
      try (PreparedStatement pstmt = con.prepareStatement(
          "insert into members(name,email,password) values(?,?,sha2(?,256))")) {
        pstmt.setString(1, member.getName());
        pstmt.setString(2, member.getEmail());
        pstmt.setString(3, member.getPassword());
        pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    Connection con = null;
    try {
      con = threadConnection.get(); // 현재 스레드에 보관된 Connection 객체를 꺼낸다. 없으면 만들어준다.
      try (PreparedStatement pstmt = con.prepareStatement(
          "delete from members where member_no=?")) {
        pstmt.setInt(1, no);
        return pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    Connection con = null;
    try {
      con = threadConnection.get(); // 현재 스레드에 보관된 Connection 객체를 꺼낸다. 없으면 만들어준다.
      try (PreparedStatement pstmt = con.prepareStatement(
          "select * from members order by member_no desc");
          ResultSet rs = pstmt.executeQuery()) {
        ArrayList<Member> list = new ArrayList<>();
        while (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setCreatedDate(rs.getDate("created_date"));
          list.add(member);
        }
        return list;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 조회 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    Connection con = null;
    try {
      con = threadConnection.get(); // 현재 스레드에 보관된 Connection 객체를 꺼낸다. 없으면 만들어준다.
      try (PreparedStatement pstmt = con.prepareStatement(
          "select * from members where member_no=?")) {
        pstmt.setInt(1, no);
        try (ResultSet rs = pstmt.executeQuery()) {
          if (rs.next()) {
            Member member = new Member();
            member.setNo(rs.getInt("member_no"));
            member.setName(rs.getString("name"));
            member.setEmail(rs.getString("email"));
            member.setCreatedDate(rs.getDate("created_date"));
            return member;
          }
          return null;
        }
      }
    } catch (Exception e) {
      throw new DaoException("데이터 조회 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    Connection con = null;
    try {
      con = threadConnection.get(); // 현재 스레드에 보관된 Connection 객체를 꺼낸다. 없으면 만들어준다.
      try (PreparedStatement pstmt = con.prepareStatement(
          "update members set name=?,email=?, password=sha2(?,256) where member_no=?")) {
        pstmt.setString(1, member.getName());
        pstmt.setString(2, member.getEmail());
        pstmt.setString(3, member.getPassword());
        pstmt.setInt(4, member.getNo());

        return pstmt.executeUpdate();
      }
    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}

