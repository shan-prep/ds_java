package xyz.shanmugavel.prep.interview.ds.stack;

public class ShanStack<T> {

  /*
    LIFO
    Add --> at the end
    Remove --> at the end
    Head --> points to the last node
   */
  private int size;
  private StackElement<T> head;

  public void push(T element) {
    StackElement<T> entry = new StackElement<>();
    entry.setValue(element);
    if ( null == head ) {
      head = entry;
    } else {
      entry.setPreviousNode(head);
      head = entry;
    }
    size++;
  }

  public T pop() {
    T value = null;

    if ( null != head ) {
      value = head.getValue();
      head = head.getPreviousNode();
      size--;
    }

    return value;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

}

class StackElement<T> {

  private T value;
  private StackElement<T> previousNode;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public StackElement<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(StackElement<T> previousNode) {
    this.previousNode = previousNode;
  }
}