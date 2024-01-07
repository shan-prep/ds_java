package xyz.shanmugavel.prep.interview.ds.graph.dfs;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LargestConnectedComponentsCountInUndirectedGraph {

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
    findLargestNoOfConnectedComponents(graph);//4


    graph = Map.of(
        1, List.of(2),
        2, List.of(1,8),
        6, List.of(7),
        9, List.of(8),
        7, List.of(6, 8),
        8, List.of(9, 7, 2)
    );
    findLargestNoOfConnectedComponents(graph);//6

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
    findLargestNoOfConnectedComponents(graph);//5

    graph = Map.of();
    findLargestNoOfConnectedComponents(graph);//0
  }

  private static void findLargestNoOfConnectedComponents(Map<Integer, List<Integer>> graph) {
    int source;
    Set<Integer> visitedNodes = new HashSet<>();
    int currentMax = 0;
    int noOfConnectedComponents;
    for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      source = entry.getKey();
      noOfConnectedComponents = noOfConnectedComponents(graph, source, visitedNodes);
      currentMax = Math.max(currentMax, noOfConnectedComponents);
    }
    System.out.println("Largest No of connected components >>" + currentMax);
  }

  private static int noOfConnectedComponents(Map<Integer, List<Integer>> graph, int source, Set<Integer> visitedNodes) {

    if (visitedNodes.contains(source)) {
      return 0;
    }

    visitedNodes.add(source);
    int noOfConnectedNodes = 1;
    for ( Integer connectedNode : graph.get(source)) {
      noOfConnectedNodes += noOfConnectedComponents(graph, connectedNode, visitedNodes);
    }
    return noOfConnectedNodes;
  }


}
