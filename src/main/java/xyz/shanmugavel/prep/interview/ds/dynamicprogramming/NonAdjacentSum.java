package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NonAdjacentSum {
  private static int maxNonAdjSum(List<Integer> input, int startIndex, Map<Integer, Integer> memory) {
    if (startIndex >= input.size()) {
      return 0;
    }

    if(memory.containsKey(startIndex)) {
      return memory.get(startIndex);
    }
    int result = Math.max(input.get(startIndex) + maxNonAdjSum(input, startIndex + 2, memory), maxNonAdjSum(input, startIndex + 1,memory));
    memory.put(startIndex, result);
    return result;
  }

  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter comma separated input values to find maximum non adjacent sum");
      List<Integer> input = Arrays.stream(scanner.next().split(",")).map(Integer::valueOf).collect(Collectors.toList());
      System.out.println(input);
      int startIndex = 0;
      Map<Integer, Integer> memory = new HashMap<>();
      int maxNonAdjacentSum = maxNonAdjSum(input, startIndex, memory);
      System.out.println("Result>>>" + maxNonAdjacentSum);
    }
  }
}
