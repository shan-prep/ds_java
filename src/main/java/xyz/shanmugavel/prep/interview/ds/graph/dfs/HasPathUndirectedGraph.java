package xyz.shanmugavel.prep.interview.ds.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HasPathUndirectedGraph {

  public static void main(String[] args) {
    List<List<String>> edges = List.of(
        List.of("i", "j"),
        List.of("k", "i"),
        List.of("m", "k"),
        List.of("k", "l"),
        List.of("o", "n")

    );

    System.out.println(edges);

    String sourceNode = "j";
    String destinationNode = "m";
    Map<String, List<String>> graph = convertToAdjacencyList(edges);
    System.out.println(graph);
    Set<String> visitedNodes = new HashSet<>();
    boolean result = hasPath(graph, sourceNode, destinationNode, visitedNodes);
    if(result) {
      System.out.println("Path exists between " + sourceNode +"..and .. " + destinationNode +".");
    } else {
      System.err.println("Path DOESn't exists between " + sourceNode +"..and .. " + destinationNode +".");
    }

    sourceNode = "j";
    destinationNode = "n";
    visitedNodes = new HashSet<>();
    result = hasPath(graph, sourceNode, destinationNode, visitedNodes);
    if(result) {
      System.out.println("Path exists between " + sourceNode +"..and .. " + destinationNode +".");
    } else {
      System.err.println("Path DOESn't exists between " + sourceNode +"..and .. " + destinationNode +".");
    }
  }

  private static Map<String, List<String>> convertToAdjacencyList(List<List<String>> edges) {
    Map<String, List<String>> graph = new HashMap<>();
    String firstNode;
    String secondNode;
    for(int i=0; i < edges.size(); i++) {
      firstNode = edges.get(i).get(0);
      secondNode = edges.get(i).get(1);
      if (!graph.containsKey(firstNode)) {
        graph.put(firstNode, new ArrayList<>());
      }
      if (!graph.containsKey(secondNode)) {
        graph.put(secondNode, new ArrayList<>());
      }
      graph.get(firstNode).add(secondNode);
      graph.get(secondNode).add(firstNode);
    }
    return graph;
  }

  private static boolean hasPath(Map<String, List<String>> graph, String source, String destination, Set<String> visitedNodes) {
    if (source.equals(destination)) {
      return true;
    }
    if (visitedNodes.contains(source)) {
      return false;
    }
    visitedNodes.add(source);
    boolean isDestination;

    for(String child : graph.get(source)) {
      isDestination = hasPath(graph, child, destination, visitedNodes);
      if ( isDestination ) {
        return true;
      }
    }
    return false;
  }
}
