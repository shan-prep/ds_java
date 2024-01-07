package xyz.shanmugavel.prep.interview.ds.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandCountInAGrid {

  public static void main(String[] args) {
    List<List<String>> grid = List.of(
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "L", "W", "W", "W"),
        List.of("W", "W", "W", "L", "W"),
        List.of("W", "W", "L", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("L", "L", "W", "W", "W"));//3
    findNoOfIslands(grid);

    grid = List.of(
        List.of("L", "W", "W", "L", "W"),
        List.of("L", "W", "W", "L", "L"),
        List.of("W", "L", "W", "L", "W"),
        List.of("W", "W", "W", "W", "W"),
        List.of("W", "W", "L", "L", "L"));//4
    findNoOfIslands(grid);

    grid = List.of(
        List.of("L", "L", "L"),
        List.of("L", "L", "L"),
        List.of("L", "L", "L")
    );//1
    findNoOfIslands(grid);

    grid = List.of(
        List.of("W", "W"),
        List.of("W", "W"),
        List.of("W", "W")
    );//0
    findNoOfIslands(grid);
  }

  private static void findNoOfIslands(List<List<String>> grid) {
    int noOfIslands = countNoOfIslands(grid);
    System.out.println("NoOfIslands --> " + noOfIslands);
  }

  private static int countNoOfIslands(List<List<String>> grid) {
    int noOfIslands = 0;
    Set<String> visitedNodes = new HashSet<>();
    String nodeKey;
    for (int r=0; r < grid.size(); r++) {
      for (int c=0; c < grid.get(0).size(); c++) {
        nodeKey = r+","+c;
        if ("L".equals(grid.get(r).get(c)) && !visitedNodes.contains(nodeKey)) {
          traverseIslandByDFS(grid, r, c, visitedNodes);
          noOfIslands++;
        }
      }
    }
    return noOfIslands;
  }

  private static void traverseIslandByDFS(List<List<String>> grid, int r, int c, Set<String> visitedNodes) {
    if((r < 0 || r >= grid.size()) || (c <0 || c >= grid.get(0).size())) {
      return;
    }
    String nodeKey = r+","+c;

    if(visitedNodes.contains(nodeKey)) {
      return;
    }
    visitedNodes.add(nodeKey);
    if ("L".equals(grid.get(r).get(c))) {
      traverseIslandByDFS(grid, r, c+1, visitedNodes);
      traverseIslandByDFS(grid, r+1, c, visitedNodes);
      traverseIslandByDFS(grid, r, c-1, visitedNodes);
      traverseIslandByDFS(grid, r-1, c, visitedNodes);
    }
  }
}
