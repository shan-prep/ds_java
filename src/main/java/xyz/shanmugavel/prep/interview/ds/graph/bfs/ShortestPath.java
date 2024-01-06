package xyz.shanmugavel.prep.interview.ds.graph.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ShortestPath {

  public static void main(String[] args) {
    Node hannah  = new Node("Hannah");
    Node mary  = new Node("Mary");
    Node mei  = new Node("Mei");
    Node max  = new Node("Max");
    Node dan  = new Node("Dan");
    Node nis  = new Node("Nis");
    Node chris  = new Node("Chris");
    Node nicolette = new Node("Nicolette");
    Node yair = new Node("Yair");
    Node mabel  = new Node("Mabel");
    Node liz  = new Node("Liz");

    List<Node> nodes = List.of(hannah, mary, mei, max, dan, nis, chris, nicolette, yair, mabel, liz);
    Graph graph = new Graph(nodes);

    hannah.connect(mary);
    hannah.connect(max);
    hannah.connect(mei);
    hannah.connect(nis);
    hannah.connect(liz);
    mei.connect(max);
    dan.connect(nis);
    nis.connect(chris);
    nis.connect(yair);
    chris.connect(nicolette);
    chris.connect(yair);
    yair.connect(mabel);
    yair.connect(liz);
    mabel.connect(liz);

    System.out.println(graph.shortestPathUsingBreadthFirstSearch(mabel, hannah));
  }
  private static class Node {
    private String value;
    private List<Node> edges;


    public Node(String value) {
      this.value = value;
      this.edges = new ArrayList<>();
    }

    public void connect(Node node) {
      this.edges.add(node);
      node.edges.add(this);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
          .add("value='" + value + "'")
          .add("edges=" + edges.stream().map(edge -> edge.value).collect(Collectors.joining(",")))
          .toString();
    }
  }

  private static class Graph {
    private List<Node> nodes;

    public Graph(List<Node> nodes) {
      this.nodes = nodes;
    }

    public String shortestPathUsingBreadthFirstSearch(Node source, Node destination) {
      Map<String, Node> visitedNodes = new HashMap<>();
      Node currentNode;
      Queue<Node> queue = new LinkedList<>();

      queue.add(source);
      visitedNodes.put(source.value, null);//Starting point, so no parent/predecessor
      while ( !queue.isEmpty() ) {
        currentNode = queue.poll();

        if ( currentNode.value.equals(destination.value) ) {
          System.out.println("Reached destination!!!");
          return constructPath(visitedNodes, source, destination);
        }
        for ( Node adjacentNode: currentNode.edges ) {
          if (!visitedNodes.containsKey(adjacentNode.value)) {
            queue.add(adjacentNode);
            visitedNodes.put(adjacentNode.value, currentNode);
          }
        }
      }

      return "No Path found!!!";
    }

    private String constructPath(Map<String, Node> visitedNodes, Node source, Node destination) {
      List<String> traversedPath = new ArrayList<>();
      traversedPath.add(destination.value);

      Node currentNode = visitedNodes.get(destination.value);
      while (null != currentNode) {
        traversedPath.add(currentNode.value);
        currentNode = visitedNodes.get(currentNode.value);
      }
      Collections.reverse(traversedPath);

      return  traversedPath.stream()
          .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
          .add("nodes=" + nodes)
          .toString();
    }
  }
}
