package xyz.shanmugavel.prep.interview.ds.graph.dfs;

import java.util.List;
import java.util.Map;

public class HasPathAcyclicDirectedGraphusingDFS {

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

    String sourceNode = "f";
    String destinationNode = "k";
    boolean result = hasPath(graph, sourceNode, destinationNode);
    if(result) {
      System.out.println("Path exists between " + sourceNode +"..and .. " + destinationNode +".");
    } else {
      System.err.println("Path DOESn't exists between " + sourceNode +"..and .. " + destinationNode +".");
    }

  }


  private static boolean hasPath(Map<String, List<String>> graph, String source, String destination) {
    if (source.equals(destination)) {
      return  true;
    }
    boolean pathExists;
    System.out.println("Source>>"  +source + ".."+ graph.get(source));
    if ( graph.containsKey(source) ) {
      for(String child : graph.get(source)) {
        pathExists = hasPath(graph, child, destination);
        if ( pathExists ) {
          return true;
        }
      }
    }

    return false;
  }

}
