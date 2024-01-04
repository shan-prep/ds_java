package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountPath {
//,,,,,,,,,,,,,,
  private static int countPath(int row, int col, List<List<String>> grid, Map<List<Integer>, Integer> memory) {
    if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {//Target cell!!!
      return 1;
    }
    if (row > grid.size()-1 || col > grid.get(0).size() - 1) {
      return 0;
    }

    if (grid.get(row).get(col).equals("X")) {
      return 0;
    }

    List<Integer> pos = List.of(row, col);
    if (memory.containsKey(pos)) {
      return memory.get(pos);
    }

    int pathCount = countPath(row, col+1, grid, memory) + countPath(row+1, col, grid, memory);
    memory.put(pos, pathCount);
    return memory.get(pos);
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter no of rows");
      int noOfRows = scanner.nextInt();
      List<List<String>> grid = new ArrayList<>();
      String data;

      for(int i=0; i < noOfRows; i++) {
        System.out.println("Enter data for row#"+(i+1) + " as comma separated value O for open, X for closed.");
        data = scanner.next();
        grid.add(Arrays.stream(data.split(",", -1)).collect(Collectors.toList()));
      }
      System.out.println(grid);
      Map<List<Integer>, Integer> memory = new HashMap<>();
      int noPOfPaths = countPath(0, 0, grid, memory);
      if ( noPOfPaths == 0) {
        System.err.println("No path exists!!!");
      } else {
        System.out.println("No of paths >>" + noPOfPaths);
      }
    }
  }
}
