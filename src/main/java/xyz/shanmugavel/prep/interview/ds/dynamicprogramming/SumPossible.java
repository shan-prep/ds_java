package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumPossible {

  private static boolean sumPossible(int sum, List<Integer> inputNumbers, Map<Integer, Boolean> memory) {
    boolean result;
    if (sum == 0) {
      return true;
    }

    if (memory.containsKey(sum)) {
      System.out.println("Return value from cache!");
      return memory.get(sum);
    }
    for (int i = 0; i < inputNumbers.size() && inputNumbers.get(i) <= sum; i++) {
       result = sumPossible(sum - inputNumbers.get(i), inputNumbers, memory);
       memory.put(sum - inputNumbers.get(i), result);
       if ( result ) {
         return result;
       }
    }
    memory.put(sum, false);
    return false;
  }

  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter sum to find>>");
      int no = scanner.nextInt();
      System.out.println("Enter comma separated numbers>>");
      String csInputNumbers = scanner.next();
      List<Integer> inputNumbers = Arrays.stream(csInputNumbers.split(",")).sequential()
          .map(Integer::parseInt)
          .sorted()
          .collect(Collectors.toList());
      System.out.println(no);
      System.out.println(inputNumbers);
      System.out.println(sumPossible(no, inputNumbers, new HashMap<>()));
    }
  }
}
