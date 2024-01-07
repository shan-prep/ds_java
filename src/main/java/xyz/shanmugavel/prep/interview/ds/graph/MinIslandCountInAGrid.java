package xyz.shanmugavel.prep.interview.ds.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinIslandCountInAGrid {

  public static void main(String[] args) {
    List<List<String>>grid = List.of(
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "W", "W", "L", "W"),
        List.of("W", "W", "L", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("L", "L", "W", "W", "W")
    );//2
    findMinCountOfIslands(grid);

    grid = List.of(
        List.of("L", "W", "W", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("W", "L", "W", "L", "W"),
        List.of("W", "W", "W", "W", "W"),
        List.of("W", "W", "L", "L", "L")
    );//1
    findMinCountOfIslands(grid);

    grid = List.of(
        List.of("L", "L", "L"),
        List.of("L", "L", "L"),
        List.of("L", "L", "L")
    );//9
    findMinCountOfIslands(grid);

    grid = List.of(
        List.of("W", "W"),
        List.of("L", "L"),
        List.of("W", "W"),
        List.of("W", "L")
    );//1
    findMinCountOfIslands(grid);
  }

  private static void findMinCountOfIslands(List<List<String>> grid) {
    int smallestIslandCount = minCountOfIsland(grid);
    System.out.println("Min count of Island --> " + smallestIslandCount);
  }

  private static int minCountOfIsland(List<List<String>> grid) {
    int mincountOfIsland = Integer.MAX_VALUE;
    Set<String> visitedNodes = new HashSet<>();
    String nodeKey;
    int noOfNodesInIsland;
    for (int r=0; r < grid.size(); r++) {
      for (int c=0; c < grid.get(0).size(); c++) {
        nodeKey = r+","+c;
        if ("L".equals(grid.get(r).get(c)) && !visitedNodes.contains(nodeKey)) {
          noOfNodesInIsland = traverseIslandByDFSAndReturnNoOfNodes(grid, r, c, visitedNodes);
          mincountOfIsland = Math.min(mincountOfIsland, noOfNodesInIsland);
        }
      }
    }
    return mincountOfIsland;
  }

  private static int traverseIslandByDFSAndReturnNoOfNodes(List<List<String>> grid, int r, int c, Set<String> visitedNodes) {
    if((r < 0 || r >= grid.size()) || (c <0 || c >= grid.get(0).size())) {
      return 0;
    }
    String nodeKey = r+","+c;

    if(visitedNodes.contains(nodeKey)) {
      return 0;
    }
    visitedNodes.add(nodeKey);
    int size = 0;
    if ("L".equals(grid.get(r).get(c))) {
      size = 1 + traverseIslandByDFSAndReturnNoOfNodes(grid, r, c+1, visitedNodes) + traverseIslandByDFSAndReturnNoOfNodes(grid, r+1, c, visitedNodes) + traverseIslandByDFSAndReturnNoOfNodes(grid, r, c-1, visitedNodes) + traverseIslandByDFSAndReturnNoOfNodes(grid, r-1, c, visitedNodes);
    }
    return size;
  }
}
