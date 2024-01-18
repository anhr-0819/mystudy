package com.eomcs.io.ex09.decoratorTest;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// 입력 스트림에 있는 대문자를 전부 소문자로 바꿔주는 데코레이터
public class LowerCaseInputStream extends FilterInputStream {

  protected LowerCaseInputStream(InputStream in) {
    super(in);
  }

  @Override
  public int read() throws IOException {
    int c = in.read();
    return (c == -1 ? c : Character.toLowerCase((char) c));
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int result = in.read(b, off, len);
    for (int i = off; i < off + result; i++) {
      b[i] = (byte) Character.toLowerCase((char) b[i]);
    }
    return result;
  }
}
