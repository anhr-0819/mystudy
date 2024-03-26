package bitcamp.myapp.vo;

import lombok.Builder;
import lombok.Data;

@Builder // 이 객체는 반드시 Builder을 통해서 만들어야 한다는 뜻
@Data
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;
}