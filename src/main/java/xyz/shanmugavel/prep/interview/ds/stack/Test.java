package xyz.shanmugavel.prep.interview.ds.stack;

public class Test {

  public static void main(String[] args) {
    ShanStack<Integer> stack = new ShanStack<>();
    System.out.println("<<Empty stack>>");
    printStackInfo(stack);
    stack.push(1);
    System.out.println("<<After adding 1 element>>");
    printStackInfo(stack);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println("<<After adding 3 more elements>>");
    printStackInfo(stack);

    while (!stack.isEmpty()) {
      System.out.println("Top most element >>" + stack.pop());
      printStackInfo(stack);
    }
  }

  private static <T> void printStackInfo(ShanStack<T> stack) {
    System.out.printf("Size=%d isEmpty=%s%n", stack.size(), stack.isEmpty());
  }
}
