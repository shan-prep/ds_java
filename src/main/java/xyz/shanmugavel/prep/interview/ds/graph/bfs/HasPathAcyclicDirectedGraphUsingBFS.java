package xyz.shanmugavel.prep.interview.ds.graph.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPathAcyclicDirectedGraphUsingBFS {

  public static void main(String[] args) {

    //Adjancency List
    Map<String, List<String>> graph = Map.of(
    "f", List.of("g", "i"),
    "g", List.of("h"),
    "h", List.of(""),
    "i", List.of("g", "k"),
    "j", List.of("i"),
    "k", List.of("")
    );

    System.out.println(graph);

    String sourceNode = "j";
    String destinationNode = "k";
    boolean result = hasPath(graph, sourceNode, destinationNode);
    if(result) {
      System.out.println("Path exists between " + sourceNode +"..and .. " + destinationNode +".");
    } else {
      System.err.println("Path DOESn't exists between " + sourceNode +"..and .. " + destinationNode +".");
    }

  }


  private static boolean hasPath(Map<String, List<String>> graph, String source, String destination) {
    Queue<String> queue = new LinkedList<>();
    String currentNode;

    queue.add(source);

    while(!queue.isEmpty()) {
      currentNode = queue.poll();
      if (currentNode.equals(destination)) {
        return  true;
      }
      if ( graph.containsKey(currentNode) ) {
        for(String child : graph.get(currentNode)) {
          queue.add(child);
        }
      }
    }
    return false;
  }

}
