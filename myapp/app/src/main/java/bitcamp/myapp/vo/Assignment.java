package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;


@Data // @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
public class Assignment implements Serializable {

  private static final long serialVersionUID = 100L;
  private final String title;
  private int no;
  private String content;
  private Date deadline;

}
