package xyz.shanmugavel.prep.interview.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetInput {

  public static List<Integer> readBinaryTree() {
    List<Integer> input = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Total no of nodes(Should be an ODD number)>>");
    int total = scanner.nextInt();

    while (total%2 != 1) {
      System.out.print("Enter Total no of nodes(*****Should be an ODD number, you had entered an even number****)>>");
      total = scanner.nextInt();
    }
    System.out.print("Enter Value for root node>>");
    input.add(scanner.nextInt());
    for (int lc = 1; lc < total; lc++) {
      System.out.printf("%nEnter The Value for node [%d], '0' for blank>>", lc+1);
      input.add(scanner.nextInt());
    }

    scanner.close();
    printBinaryTree(input);
    return input;
  }

  private static void printBinaryTree(List<Integer> nodes) {
    int rootIndex;
    int leftNodeIndex;
    int rightNodeIndex;
    if (1 == nodes.size()) {
      //System.out.printf("Root=%-4d  Left=NULL Right=NULL %n", nodes.get(0));
      printTree(nodes.get(0), 0, 0);
    } else {
      for(int lc=0; (2*lc+2) < nodes.size(); lc+=1) {
        rootIndex = lc;
        leftNodeIndex = 2 * rootIndex + 1;
        rightNodeIndex = 2 * rootIndex + 2;
        //System.out.printf("Root=%-4d  Left=%-4d Right=%-4d %n", nodes.get(rootIndex), nodes.get(leftNodeIndex), nodes.get(rightNodeIndex));
        printTree(nodes.get(rootIndex), nodes.get(leftNodeIndex), nodes.get(rightNodeIndex));
      }
    }
  }

  private static void printTree(int rootNodeValue, int leftNodeValue, int rightNodeValue) {
    System.out.println("**************Begin**************");
    System.out.printf("%5d%n",rootNodeValue);
    System.out.println("  /   \\  ");
    System.out.printf("%-4d %4d%n", leftNodeValue, rightNodeValue);
    System.out.println("**************End**************");
  }

  public static void main(String[] args) {
    readBinaryTree();
  }
}
