package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxPathSum {

  private static double maxPathSum(int row, int col, List<List<Integer>> grid, Map<List<Integer>, Double> memory) {
    if (row == grid.size() || col == grid.get(0).size()) {
      return Double.NEGATIVE_INFINITY;
    }

    if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
      return grid.get(row).get(col);
    }
    List<Integer> pos = List.of(row, col);
    if (memory.containsKey(pos)) {
      return memory.get(pos);
    }

    double maxPathSum = grid.get(row).get(col) + Math.max(maxPathSum(row, col+1, grid, memory),  maxPathSum(row+1, col, grid, memory));
    memory.put(pos, maxPathSum);

    return memory.get(pos);
  }
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter no of rows");
      int noOfRows = scanner.nextInt();
      List<List<Integer>> grid = new ArrayList<>();
      String data;

      for(int i=0; i < noOfRows; i++) {
        System.out.println("Enter data(only numbers as we are going to add them) for row#"+(i+1) + " as comma separated values.");
        data = scanner.next();
        grid.add(Arrays.stream(data.split(",", -1)).map(Integer::valueOf).collect(Collectors.toList()));
      }
      System.out.println(grid);
      Map<List<Integer>, Double> memory = new HashMap<>();
      double maxSumPath = maxPathSum(0, 0, grid, memory);
      System.out.println("Max Path Sum >>" + maxSumPath);
    }
  }
}
