package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자
@Data // ToString();
public class Assignment implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;
  private Date deadline;
}

// final은 인스턴스를 생성할때 반드시 값이 주어져야한다.
// 생성자가 호출될 때 final 값을 받는 생성자를 만들어야한다!