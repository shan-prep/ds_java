package xyz.shanmugavel.prep.interview.ds.graph.dfs;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsCountInUndirectedGraph {

  public static void main(String[] args) {
    Map<Integer, List<Integer>> graph = Map.of(
        0, List.of(8, 1, 5),
        1, List.of(0),
        5, List.of(0, 8),
        8, List.of(0, 5),
        2, List.of(3, 4),
        3, List.of(2, 4),
        4, List.of(3, 2)
    );
    findNoOfConnectedComponents(graph);


    graph = Map.of(
        1, List.of(2),
        2, List.of(1,8),
        6, List.of(7),
        9, List.of(8),
        7, List.of(6, 8),
        8, List.of(9, 7, 2)
    );
    findNoOfConnectedComponents(graph);

    graph = Map.of(
        3, List.of(),
        4, List.of(6),
        6, List.of(4, 5, 7, 8),
        8, List.of(6),
        7, List.of(6),
        5, List.of(6),
        1, List.of(2),
        2, List.of(1)
    );
    findNoOfConnectedComponents(graph);

    graph = Map.of();
    findNoOfConnectedComponents(graph);
  }

  private static void findNoOfConnectedComponents(Map<Integer, List<Integer>> graph) {
    int noOfConnectedComponents = 0;
    int source;
    Set<Integer> visitedNodes = new HashSet<>();
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      source = entry.getKey();
      if (noOfConnectedComponents(graph, source, visitedNodes)) {
        noOfConnectedComponents += 1;
      }

    }
    System.out.println("No of connected components >>" + noOfConnectedComponents);
  }

  private static boolean noOfConnectedComponents(Map<Integer, List<Integer>> graph, int source, Set<Integer> visitedNodes) {

    if (visitedNodes.contains(source)) {
      return false;
    }

    visitedNodes.add(source);
    for ( Integer connectedNode : graph.get(source)) {
      noOfConnectedComponents(graph, connectedNode, visitedNodes);
    }
    return true;
  }


}
