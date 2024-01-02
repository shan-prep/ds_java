package xyz.shanmugavel.prep.interview.ds.queue;

public class Test {

  public static void main(String[] args) {
    ShanQueue<Integer> queue = new ShanQueue<>();
    System.out.println("<<Empty Queue>>");
    printQueueInfo(queue);
    queue.add(1);
    System.out.println("<<After adding 1 element>>");
    printQueueInfo(queue);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println("<<After adding 3 more elements>>");
    printQueueInfo(queue);

    while (!queue.isEmpty()) {
      System.out.println("Retrieve next element >>" + queue.poll());
      printQueueInfo(queue);
    }
  }

  private static <T> void printQueueInfo(ShanQueue<T> queue) {
    System.out.printf("Size=%d isEmpty=%s%n", queue.size(), queue.isEmpty());
  }
}
