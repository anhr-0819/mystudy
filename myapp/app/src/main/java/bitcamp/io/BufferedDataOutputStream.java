package bitcamp.io;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedDataOutputStream extends DataOutputStream {

  int size;
  private byte[] buffer = new byte[8192];


  public BufferedDataOutputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public void write(int b) throws IOException {
    if (size == buffer.length) {
      // 버퍼가 모두 찼다면, 즉시 버퍼에 저장된 데이터를 파일로 출력한다.
      flush();
      //      super.write(buffer);
      //      size = 0;
    }
    buffer[size++] = (byte) b; // 맨 끝에 byte 크기로 잘라서 담고, size 변수를 증가 시킨다
  }

  @Override
  public void write(byte[] bytes) throws IOException {
    for (byte b : bytes) {
      if (size == buffer.length) {
        // 버퍼가 모두 찼다면, 즉시 버퍼에 저장된 데이터를 파일로 출력한다.
        flush();
      }
      buffer[size++] = b;
    }
  }

  // 버퍼에 저장된 데이터를 파일로 출력한다.
  public void flush() throws IOException {
    super.write(buffer, 0, size);
    size = 0;
  }

  @Override
  public void close() throws IOException {
    // 출력 스트림을 닫기 전에 버퍼에 남아 있는 데이터를 파일로 출력한다.
    flush();

    super.close();
  }
}
