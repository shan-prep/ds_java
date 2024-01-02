package xyz.shanmugavel.prep.interview.ds.dfs;

import java.util.List;
import java.util.Stack;
import xyz.shanmugavel.prep.interview.ds.GetInput;
import xyz.shanmugavel.prep.interview.ds.Node;
import xyz.shanmugavel.prep.interview.ds.Util;

public class DFS {

  public static void main(String[] args) {
    List<Integer> nos =  GetInput.readBinaryTree();
    Node rootNode = Util.convertInputToBinaryTree(nos);
    //traverseTreeUsingPreOrderWithoutRecursion(rootNode);
    System.out.println("*************PRE ORDER Begins************");
    traverseTreeUsingPreOderRecursively(rootNode);
    System.out.println();
    System.out.println("*************IN ORDER Begins************");
    traverseTreeUsingInOderRecursively(rootNode);
    System.out.println();
    System.out.println("*************POST ORDER Begins************");
    traverseTreeUsingPostOderRecursively(rootNode);
  }

  private static void traverseTreeUsingPreOderRecursively(Node rootNode) {
    // visit root node, traverse left , traver right
    if ( null == rootNode ) {
      return;
    }

    System.out.print(" " + rootNode.getValue());
    traverseTreeUsingPreOderRecursively(rootNode.getLeftNode());
    traverseTreeUsingPreOderRecursively(rootNode.getRightNode());
  }
  private static void traverseTreeUsingInOderRecursively(Node rootNode) {
  // traverse left , visit root node repeat , traver right
    if ( null == rootNode ) {
      return;
    }
    traverseTreeUsingInOderRecursively(rootNode.getLeftNode());
    System.out.print(" " + rootNode.getValue());
    traverseTreeUsingInOderRecursively(rootNode.getRightNode());
  }
  private static void traverseTreeUsingPostOderRecursively(Node rootNode) {
// traverse right , traver left, visit root node repeat
    if ( null == rootNode ) {
      return;
    }
    traverseTreeUsingPostOderRecursively(rootNode.getLeftNode());
    traverseTreeUsingPostOderRecursively(rootNode.getRightNode());
    System.out.print(" " + rootNode.getValue());
  }


  private static void traverseTreeUsingPreOrderWithoutRecursion(Node rootNode) {
    System.out.println("PreOrder -- BEGIN.");
    Stack<Node> stack = new Stack<>();
    stack.push(rootNode);
    Node currentNode;
    while( !stack.isEmpty() ) {
      currentNode = stack.pop();
      System.out.println(currentNode.getValue());
      currentNode.setVisited(true);
      if ( null != currentNode.getRightNode() ) {
        stack.push(currentNode.getRightNode());
      }
      if ( null != currentNode.getLeftNode() ) {
        stack.push(currentNode.getLeftNode());
      }
    }
    System.out.println("PreOrder -- END.");
  }



}

