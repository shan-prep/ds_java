package xyz.shanmugavel.prep.interview.ds.list;

import java.util.StringJoiner;

public class ShanLinkedList<T>{

  /*
   insert at tail
   iterate from first
   */

  private int size;
  private ListElement<T> head;
  private ListElement<T> tail;
  public void add(T element) {
    ListElement<T> node = new ListElement<>();
    node.value = element;
    if ( null == head ) {
      head = node;
      tail = node;
    } else {
      node.prevNode = tail;
      tail.nextNode = node;
      tail = node;
    }
    size++;
  }

  public T get(int index) {
    T result = null;
    int lc = 0;
    ListElement<T> currentNode = head;
    while ( null != currentNode ) {
      if ( lc == index ) {
        result = currentNode.value;
        break;
      }
      currentNode = currentNode.nextNode;
      lc++;
    }

    return result;
  }

  public void removeByValue(T value) {
    ListElement<T> currentNode = head;
    int index = -1;
    int lc = 0;
    while ( null != currentNode ) {
      if ( currentNode.value.equals(value) ) {
        index = lc;
        break;
      }
      currentNode = currentNode.nextNode;
      lc++;
    }

    if ( index != -1 ) {
      removeByIndex(index);
    }
  }

  public void removeByIndex(int index) {
    int lc = 0;
    ListElement<T> currentNode = head;
    while ( null != currentNode ) {
      if ( lc == index ) {
        if ( null != currentNode.nextNode ) {
          if (null != currentNode.prevNode) {
            currentNode.prevNode.nextNode = currentNode.nextNode;
          }
          currentNode.nextNode.prevNode = currentNode.prevNode;
        } else {
          currentNode.prevNode.nextNode = null;
          tail = currentNode.prevNode;
        }
        if ( currentNode.prevNode == null ) {
          head = currentNode.nextNode;
        }
        size--;
      }
      currentNode = currentNode.nextNode;
      lc++;
    }
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void print() {
    ListElement<T> curNode = head;
    System.out.println("<<BEGIN>>");
    while( null != curNode ) {
      System.out.print(curNode);
      curNode = curNode.nextNode;
    }
    System.out.println();
    System.out.println("<<END>>");
  }

  private static class ListElement<T> {
    private T value;
    private ListElement<T> prevNode;
    private ListElement<T> nextNode;

    @Override
    public String toString() {
      return new StringJoiner(", ", ListElement.class.getSimpleName() + "[", "]")
          .add("value=" + value)
          .add("prevNode=" + ((null != prevNode) ? prevNode.value : null))
          .add("nextNode=" + ((null != nextNode) ? nextNode.value : null))
          .toString();
    }
  }

}

