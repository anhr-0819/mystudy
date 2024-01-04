package bitcamp.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataInputStream extends DataInputStream {

  int size; // 버퍼에 읽어들인 갯수
  int cursor; // 버퍼에서 꺼낸 순서
  private byte[] buffer = new byte[8192];

  public BufferedDataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (cursor == size) { // 커서가 읽은 사이즈에 도달하면
      cursor = 0; // 커서를 제로로 세팅하고
      size = super.read(buffer); // 버퍼에 읽어 들여온다
      // 8200 byte가 있을때 8192 바이트를 읽어서 저장. 그 다음 8byte를 읽어서 저장할 것이다.
      if (size == -1) {
        return -1; // 더 이상 읽을 것이 없다는 뜻
      }
    }
    return buffer[cursor++] & 0xff; // 주의!
    // buffer[cursor++] & 000000ff
    // 앞의  3byte가 0으로 처리됨
  }

  @Override
  public int read(byte[] arr) throws IOException {
    return read(arr, 0, arr.length);
  }

  @Override
  public int read(byte[] arr, int off, int len) throws IOException {
    for (int i = off, count = 0; count < len; i++, count++) {
      int b = read(); // 파일에서 1byte를 읽어온다.
      if (b == -1) {
        return count > 0 ? count : -1; // 현재까지 읽은 것을 리턴
      }
      arr[i] = (byte) read(); // 읽어온 데이터를 배열에 저장
    }
    return len;
  }
}
