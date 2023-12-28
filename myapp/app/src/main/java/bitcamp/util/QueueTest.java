package bitcamp.util;

public class QueueTest {

  public static void main(String[] args) {
    Queue<String> queue = new Queue<>();
    queue.offer("a");
    queue.offer("b");
    queue.offer("c");
    queue.offer("d");
    queue.offer("e");

    while (queue.size() > 0) {
      System.out.println(queue.poll());
    }
  }
}
