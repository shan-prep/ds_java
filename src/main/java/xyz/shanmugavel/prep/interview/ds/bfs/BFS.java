package xyz.shanmugavel.prep.interview.ds.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import xyz.shanmugavel.prep.interview.ds.GetInput;
import xyz.shanmugavel.prep.interview.ds.Node;
import xyz.shanmugavel.prep.interview.ds.Util;

public class BFS {

  public static void main(String[] args) {
    List<Integer> nos =  GetInput.readBinaryTree();
    Node rootNode = Util.convertInputToBinaryTree(nos);
    levelOrderTraversal(rootNode);
  }

  private static void levelOrderTraversal(Node rootNode) {
    Queue<Node> holder = new LinkedList<>();
    Node currentNode = rootNode;

    holder.add(rootNode);

    while(!holder.isEmpty()) {
      currentNode = holder.poll();
      System.out.println(currentNode.getValue());
      if ( null != currentNode.getLeftNode() ) {
        holder.add(currentNode.getLeftNode());
      }
      if ( null != currentNode.getRightNode() ) {
        holder.add(currentNode.getRightNode());
      }
    }

  }

}
