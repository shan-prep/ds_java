package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountingChange {

  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter the no>>");
      int amount = scanner.nextInt();
      System.out.println("Enter comma separated coin denominations>>");
      List<Integer> coins = Arrays.stream(scanner.next().split(",")).map(Integer::valueOf).collect(
          Collectors.toList());
      int coinIndex = 0;
      Map<List<Integer>, Integer> memory = new HashMap<>();
      int noOfWaysToCountChange = countChange(amount, coins, coinIndex, memory);
      System.out.println("Total no of ways to count change >> " + noOfWaysToCountChange);
    }
  }

  private static int countChange(int amount, List<Integer> coins, int coinIndex, Map<List<Integer>, Integer> memory) {
    if ( amount == 0 ) {
      return 1;
    }

    if (coinIndex >= coins.size()) {
      return 0;
    }

    List<Integer> key = List.of(amount, coinIndex);
    if(memory.containsKey(key)) {
      return memory.get(key);
    }

    int totalNoOfWays = 0;
    int coinValue = coins.get(coinIndex);
    for (int qty=0; qty * coinValue <= amount; qty++ ) {
      int subAmount = amount - (qty * coinValue);
      totalNoOfWays += countChange(subAmount, coins, coinIndex+1, memory);
    }

    memory.put(key, totalNoOfWays);
    return memory.get(key);
  }
}
