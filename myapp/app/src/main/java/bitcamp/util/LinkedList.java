package bitcamp.util;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;

    if (last == null) {
      // 노드 객체가 없을 때,
      first = last = node;
    } else {
      // 기존에 노드 객체가 있을 때,
      // 마지막 노드에 다음 노드로 새로 만든 노드를 가리키게 한다.
      last.next = node;
      last = node;
    }
    size++;
  }

  public void add(int index, Object value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node node = new Node();
    node.value = value;

    if (first == null) {
      first = last = node;

    } else if (index == 0) {
      node.next = first;
      first = node;

    } else if (index == size) {
      last.next = node;
      last = node;

    } else {
      int cursor = 0;
      Node currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }

    size++;
  }

  public Object[] toArray() {
    // 노드에 담겨 있는 배열을 꺼내서 배열에 담아서 리턴
    Object[] arr = new Object[size];
    Node node = first;
    int index = 0;
    while (node != null) {
      arr[index++] = node.value;
      //index++;

//      int temp = index;
//      index = index +1;
//      arr[temp] = node.value;
      node = node.next;
    }
    return arr;
  }

  public Object get(int index) /*throws IndexOutOfBoundsException*/ {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    int cursor = 0;
    Node node = first;
    while (cursor++ < index) { // 증가시키기 전의 커서와 인덱스를 비교
      node = node.next;
      //cursor++;
    }
    return node.value;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    int cursor = 0;
    Node node = first;
    while (cursor++ < index) { // 증가시키기 전의 커서와 인덱스를 비교
      node = node.next;
      //cursor++;
    }
    Object old = node.value;
    node.value = value;
    return old;
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node old = null;
    if (size == 1) {
      // 1개 일 때,
      old = null;
      first = last = null;

    } else if (index == 0) {
      // 맨 앞
      old = first;
      first = first.next;


    } else {
      int cursor = 0;
      Node currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      old = currNode.next;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }
    size--;
    return old;
  }
}

