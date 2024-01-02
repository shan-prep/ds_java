package xyz.shanmugavel.prep.interview.ds.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import xyz.shanmugavel.prep.interview.ds.GetInput;

public class DFS {

  public static void main(String[] args) {
    List<Integer> nos =  GetInput.readBinaryTree();
    Node rootNode = convertInputToBinaryTree(nos);
    System.out.println(rootNode);
  }

  private static Node convertInputToBinaryTree(List<Integer> nos) {
    Node rootNode = new Node(nos.get(0));
    Node currentNode;
    Node firstNode, secondNode;
    int totalNoOfElements = nos.size();
    int index = 1;
    LinkedList<Node> nodes = new LinkedList<>();

    nodes.add(rootNode);
    while (!nodes.isEmpty()) {
      currentNode = nodes.poll();
      if ( index < totalNoOfElements ) {
        firstNode = new Node(nos.get(index++));
        nodes.add(firstNode);
      } else {
        firstNode = null;
      }
      if ( index < totalNoOfElements ) {
        secondNode = new Node(nos.get(index++));
        nodes.add(secondNode);
      } else {
        secondNode = null;
      }
      currentNode.setLeftNode(firstNode);
      currentNode.setRightNode(secondNode);
    }
    return rootNode;
  }

}

class Node {

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
