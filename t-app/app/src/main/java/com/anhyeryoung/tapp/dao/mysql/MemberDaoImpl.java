package com.anhyeryoung.tapp.dao.mysql;

import com.anhyeryoung.tapp.dao.DaoException;
import com.anhyeryoung.tapp.dao.MemberDao;
import com.anhyeryoung.tapp.vo.Member;
import com.anhyeryoung.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  DBConnectionPool connectionPool;

  public MemberDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Member member) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into tapp_member(name,tel,email,password,post_code,basic_addr,detail_addr,authority_no)"
                + " values("
                + " ?, ?, ?, sha2(?,256), ?, ?, ?, ?"
                + " )")) {
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getTel());
      pstmt.setString(3, member.getEmail());
      pstmt.setString(4, member.getPassword());
      pstmt.setString(5,member.getpCode());
      pstmt.setString(6, member.getbAddr());
      pstmt.setString(7, member.getdAddr());
      pstmt.setString(8, member.getAuthority());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from tapp_member where member_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select id, name, email, created_date from tapp_member");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("id"));
        member.setEmail(rs.getString("email"));
        member.setName(rs.getString("name"));
        member.setCreatedDate(rs.getDate("created_date"));

        list.add(member);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select id,name,tel,email,post_code,basic_addr,detail_addr,authority_no,created_date from tapp_member where id=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("id"));
          member.setName(rs.getString("name"));
          member.setTel(rs.getString("tel"));
          member.setEmail(rs.getString("email"));
          member.setpCode(rs.getString("post_code"));
          member.setbAddr(rs.getString("basic_addr"));
          member.setdAddr(rs.getString("detail_addr"));
          member.setAuthority(rs.getString("authority_no"));
          member.setCreatedDate(rs.getDate("created_date"));
          return member;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    String sql = null;
    if (member.getPassword().isEmpty()) {
      sql = "update tapp_member set name=?,tel=?,email=?,post_code=?,basic_addr=?,detail_addr=? where id=?";
    } else {
      sql = "update tapp_member set name=?,tel=?,email=?,post_code=?,basic_addr=?,detail_addr=?,password=sha2(?,256) where id=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getTel());
      pstmt.setString(3, member.getEmail());
      pstmt.setString(4,member.getpCode());
      pstmt.setString(5,member.getbAddr());
      pstmt.setString(6,member.getdAddr());
      if (member.getPassword().isEmpty()) {
        pstmt.setInt(7, member.getNo());
      } else {
        pstmt.setString(7, member.getPassword());
        pstmt.setInt(8, member.getNo());
      }
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  public int update(Timestamp loginTime) {
    String sql = "update tapp_member set last_login=? where id=?";

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }

  @Override
  public Member findByEmailAndPassword(String email, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select id, email, name from tapp_member where email=? and password=sha2(?,256)")) {
      pstmt.setString(1, email);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("id"));
          member.setEmail(rs.getString("email"));
          member.setName(rs.getString("name"));
          return member;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }
}
