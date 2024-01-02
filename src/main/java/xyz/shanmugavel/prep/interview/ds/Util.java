package xyz.shanmugavel.prep.interview.ds;

import java.util.LinkedList;
import java.util.List;

public class Util {

  public static Node convertInputToBinaryTree(List<Integer> nos) {
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
