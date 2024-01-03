package bitcamp.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataInputStream extends FileInputStream {

  public DataInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  public short readShort() throws IOException { // 2번 읽어서 short로 형변환 후 리턴
    return (short) (read() << 8 | read());
  }

  public int readInt() throws IOException { // 4번 읽어서 리턴
    return read() << 24 |
        read() << 16 |
        read() << 8 |
        read();
  }

  public long readLong() throws IOException { // 8번 읽어서 long 으로 형변환 후 리턴
    return (long) read() << 56 |
        (long) read() << 48 |
        (long) read() << 40 |
        (long) read() << 32 |
        (long) read() << 24 |
        (long) read() << 16 |
        (long) read() << 8 |
        read();
  }

  public boolean readBoolean() throws IOException {
    return read() == 1;
  }

  public String readUTF() throws IOException {
    int len = read() << 8 | read();
    byte[] bytes = new byte[60000];
    read(bytes, 0, len);
    return new String(bytes, 0, len, StandardCharsets.UTF_8);
  }
}
