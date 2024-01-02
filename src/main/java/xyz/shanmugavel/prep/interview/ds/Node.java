package xyz.shanmugavel.prep.interview.ds;

import java.util.StringJoiner;

public class Node {
  private int value;
  private boolean visited;

  private Node leftNode;
  private Node rightNode;

  public Node(int value) {
    this.value = value;
    this.visited = false;
    this.leftNode = null;
    this.rightNode = null;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
        .add("value=" + value)
        .add("visited=" + visited)
        .add("leftNode=" + leftNode)
        .add("rightNode=" + rightNode)
        .toString();
  }
}
