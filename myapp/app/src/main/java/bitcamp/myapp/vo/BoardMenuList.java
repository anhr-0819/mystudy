package bitcamp.myapp.vo;

import bitcamp.myapp.Prompt;

public class BoardMenuList {

  public String title;
  public String content;
  public String writer;
  public String createdDate;

  public void add() {
    System.out.println("게시글 등록:");
    this.title = Prompt.input("제목? ");
    this.content = Prompt.input("내용? ");
    this.writer = Prompt.input("작성자? ");
    this.createdDate = Prompt.input("작성일? ");
  }

  public void view() {
    System.out.println("게시글 조회:");
    System.out.printf("제목: %s\n", this.title);
    System.out.printf("내용: %s\n", this.content);
    System.out.printf("작성자: %s\n", this.writer);
    System.out.printf("작성일: %s\n", this.createdDate);
  }

  public void modify() {
    System.out.println("게시글 변경:");
    this.title = Prompt.input("제목(%s)? ", this.title);
    this.content = Prompt.input("내용(%s)? ", this.content);
    this.writer = Prompt.input("작성자(%s)? ", this.writer);
    this.createdDate = Prompt.input("작성일(%s)? ", this.createdDate);
  }

  public void delete() {
    System.out.println("게시글 삭제:");
    this.title = "";
    this.content = "";
    this.writer = "";
    this.createdDate = "";
  }
}
