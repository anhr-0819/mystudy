package bitcamp.util;

import java.util.Arrays;

public class ObjectRepository<E> {

  // 수퍼 클래스의 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있다.
  // 따라서 Object 레퍼런스는 Member, Board, Assignment 등 어떤 객채의 주소라도 담을 수 있다.
  private Object[] objects = new Object[3];
  private int length = 0;

  public void add(E object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

//      Object[] arr = new Object[newSize];
//      System.arraycopy(this.objects, 0, arr, 0, oldSize);

      this.objects = Arrays.copyOf(this.objects, newSize);
//      System.out.println("새 배열 크기 : " + this.objects.length);
    }

    this.objects[this.length++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object deleted = this.objects[index];
    System.arraycopy(this.objects, index + 1, this.objects, index, this.length - (index + 1));

    this.objects[--this.length] = null;

    return (E) deleted;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.length);
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.length) { // 현재
      System.arraycopy(this.objects, 0, arr, 0, this.length);
      // 오리지날 배열에서 넘겨준 배열을 복사.
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.length, arr.getClass());
    // arr.getClass() 타입의 배열을 새로 만들고 배열을 복사해서 보냄.
    // arr.getClass() : 주어진 레퍼런스가 어느 클래스의 타입인지 리턴해줌
    // 지정된 타입이 없으므로 형변환 해야함.

    // Arrays.copyOf(this.objects,this.length);
    // 복사를 하는데 기존 배열과 똑같은 타입으로 복사를 하므로 object 타입으로 복사가 되므로 쓸 수 없다.
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }

  public int size() {
    return this.length;
  }
}
