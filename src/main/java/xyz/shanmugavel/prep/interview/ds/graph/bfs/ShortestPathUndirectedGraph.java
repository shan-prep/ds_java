package xyz.shanmugavel.prep.interview.ds.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathUndirectedGraph {

  public static void main(String[] args) {
    List<List<String>> edges = List.of(
        List.of("w", "x"),
        List.of("x", "y"),
        List.of("z", "y"),
        List.of("z", "v"),
        List.of("w", "v")
    );

    String source = "w";
    String destination = "z";
    findShortestPath(edges, source, destination);//2


    edges = List.of(
        List.of("w", "x"),
        List.of("x", "y"),
        List.of("z", "y"),
        List.of("z", "v"),
        List.of("w", "v")
    );
    source = "y";
    destination = "x";
    findShortestPath(edges, source, destination);//1


    edges = List.of(
        List.of("a", "c"),
        List.of("a", "b"),
        List.of("c", "b"),
        List.of("c", "d"),
        List.of("b", "d"),
        List.of("e", "d"),
        List.of("g", "f")
    );
    source = "a";
    destination = "e";
    findShortestPath(edges, source, destination);//3

    edges = List.of(
        List.of("a", "c"),
        List.of("a", "b"),
        List.of("c", "b"),
        List.of("c", "d"),
        List.of("b", "d"),
        List.of("e", "d"),
        List.of("g", "f")
    );
    source = "e";
    destination = "c";
    findShortestPath(edges, source, destination);//2

    edges = List.of(
        List.of("a", "c"),
        List.of("a", "b"),
        List.of("c", "b"),
        List.of("c", "d"),
        List.of("b", "d"),
        List.of("e", "d"),
        List.of("g", "f")
    );
    source = "b";
    destination = "g";
    findShortestPath(edges, source, destination);//-1 doesn't exist
  }

  private static void findShortestPath(List<List<String>> edges, String source, String destination) {
    Set<String> visitedNodes = new HashSet<>();
    int noOfEdges = 0;
    Map<String, List<String>>  graph = convertToAdjacencyList(edges);
    noOfEdges = noOfConnectedComponents(graph, source, destination, visitedNodes);
    System.out.println("Shortest Path (Least No of edges) from source to destination is  >>" + noOfEdges);
  }

  private static int noOfConnectedComponents(Map<String, List<String>>  graph, String source, String destination, Set<String> visitedNodes) {
    int level = -1;
    NodeWithLevel currentNodeWitLevel;
    Queue<NodeWithLevel> nodes = new LinkedList<>();
    NodeWithLevel nodeWithLevel = new NodeWithLevel();
    nodeWithLevel.level = 0;
    nodeWithLevel.nodeName = source;
    nodes.add(nodeWithLevel);

    while(!nodes.isEmpty()) {
      currentNodeWitLevel = nodes.poll();
      if (!visitedNodes.contains(currentNodeWitLevel.nodeName)) {
        visitedNodes.add(currentNodeWitLevel.nodeName);
        if ( currentNodeWitLevel.nodeName.equals(destination) ) {
          return  currentNodeWitLevel.level;
        }
        for (String children : graph.get(currentNodeWitLevel.nodeName)) {
          NodeWithLevel nodeWithLevelTmp = new NodeWithLevel();
          nodeWithLevelTmp.nodeName = children;
          nodeWithLevelTmp.level = currentNodeWitLevel.level + 1;
          nodes.add(nodeWithLevelTmp);
        }
      }
    }

    return level;
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

  private static class NodeWithLevel {
    private int level;
    private String nodeName;
  }
}
