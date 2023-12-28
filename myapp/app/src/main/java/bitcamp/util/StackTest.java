package bitcamp.util;

public class StackTest {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");

    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }
}