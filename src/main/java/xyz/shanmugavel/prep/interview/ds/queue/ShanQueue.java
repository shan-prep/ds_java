package xyz.shanmugavel.prep.interview.ds.queue;

public class ShanQueue <T> {

  /*
    FIFO
    Add --> at the end
    Remove --> at the beginning
    Head --> points to the first node
    Tail --> points to the last node
   */

  private int size;
  private QueueElement<T> head;
  private QueueElement<T> tail;

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void add(T element) {
    QueueElement<T> node = new QueueElement<>();

    node.value = element;
    if (null == head) {
      head = node;
      tail = node;
    }  else {
      tail.nextNode = node;
      tail = node;
    }

    size++;
  }

  public T poll() {
    T value = null;
    if ( null != head ) {
      value = head.value;
      head = head.nextNode;
      size--;
    }
    return value;
  }

  private static class QueueElement<T> {

    private T value;
    private QueueElement<T> nextNode;

  }
}
