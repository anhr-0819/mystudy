package bitcamp.myapp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Mybatis가 사용할 기본 생성자를 만들어야 한다.
@AllArgsConstructor
@Builder // 동일한 이름의 중첩클래스가 만들어지고 필드와 같은 이름의 메서드가 만들어진다. 체이닝 기법.
@Data
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;

}
