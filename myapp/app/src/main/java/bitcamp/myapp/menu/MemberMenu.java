package bitcamp.myapp.Menu;

import bitcamp.menu.Menu;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;

public class MemberMenu implements Menu {

  String title;
  Member[] members = new Member[3];
  int length;

  // 의존 객체(Dependency Object ==> dependency);
  // - 클래스가 작업을 수행할 때 사용하는 객체
  Prompt prompt;

  // BoardMenu 인스턴스를 생성할 때 반드시 게시판 제목을 설정하도록 강요한다.
  // 생성자란(constructor)?
  // => 인스턴스를 사용하기 전에 유효한 상태로 설정하는 작업을 수행하는 메서드
  public MemberMenu(String title, Prompt prompt) {
    this.title = title;
    this.prompt = prompt;
  }

  void printMenu() {
    System.out.printf("[%s]\n", this.title);
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  @Override
  public String getTitle() {
    return null;
  }

  public void execute(Prompt prompt) {
    this.printMenu();
    while (true) {
      String input = prompt.input("메인/%s> ", this.title);

      switch (input) {
        case "1":
          this.add();
          break;
        case "2":
          this.view();
          break;
        case "3":
          this.modify();
          break;
        case "4":
          this.delete();
          break;
        case "5":
          this.list();
          break;
        case "0":
          return;
        case "menu":
          this.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  void add() {
    System.out.printf("%s 등록:\n", title);

    if (this.length == this.members.length) {
      int oldSize = this.members.length;
      int newSize = oldSize + (oldSize >> 1);

      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.members[i];
      }

      this.members = arr;
    }

    Member member = new Member();
    member.name = prompt.input("이름? ");
    member.email = prompt.input("이메일? ");
    member.password = prompt.input("암호? ");
    member.createdDate = prompt.input("가입일? ");

    this.members[this.length++] = member;
  }

  void list() {
    System.out.printf("%s 목록:\n", title);
    System.out.printf("%-20s\t%10s\t%s\n", "Name", "Email", "Created Date");

    for (int i = 0; i < this.length; i++) {
      Member member = this.members[i];
      System.out.printf("%-20s\t%10s\t%s\n", member.name, member.email, member.createdDate);
    }
  }

  void view() {
    System.out.printf("%s 조회:\n", title);

    int index = prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", title);
      return;
    }

    Member member = this.members[index];
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("암호: %s\n", member.password);
    System.out.printf("가입일: %s\n", member.createdDate);
  }

  void modify() {
    System.out.printf("%s 변경:\n", title);

    int index = prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", title);
      return;
    }

    Member member = this.members[index];
    member.name = prompt.input("제목(%s)? ", member.name);
    member.email = prompt.input("내용(%s)? ", member.email);
    member.password = prompt.input("작성자(%s)? ", member.password);
    member.createdDate = prompt.input("작성일(%s)? ", member.createdDate);
  }

  void delete() {
    System.out.printf("%s 삭제:\n", title);

    int index = prompt.inputInt("번호? ");
    if (index < 0 || index >= this.length) {
      System.out.printf("%s 번호가 유효하지 않습니다.\n", title);
      return;
    }

    for (int i = index; i < (this.length - 1); i++) {
      this.members[i] = this.members[i + 1];
    }
    this.members[--this.length] = null;
  }
}
