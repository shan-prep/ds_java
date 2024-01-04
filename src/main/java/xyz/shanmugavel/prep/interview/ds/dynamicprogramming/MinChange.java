package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinChange {


  private static int minChange(int amount, List<Integer> denominations, Map<Integer, Integer> memory) {
    int newAmount;
    if ( amount == 0 ) {
      return 0;
    }

    if ( amount < 0 ) {
      return -1;
    }

    if (memory.containsKey(amount)) {
      return memory.get(amount);
    }

    int minCoins = -1;
    for (int i=0; i < denominations.size(); i++) {
      newAmount = amount - denominations.get(i);
      int subCoins = minChange(newAmount, denominations, memory);
      if (subCoins != -1) {
        subCoins += 1;
        if ( subCoins < minCoins || minCoins == -1 ) {
          minCoins = subCoins;
        }
      }
    }

    memory.put(amount, minCoins);
    return memory.get(amount);
  }


  public static void main(String[] args) {
    try(Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter amount>>");
      int amount = scanner.nextInt();
      System.out.println("Enter comma separated denominations>>");
      String denominations = scanner.next();
      Map<Integer, Integer> memory = new HashMap<>();
      List<Integer> inputNumbers = Arrays.stream(denominations.split(",")).sequential()
          .map(Integer::parseInt)
          //.sorted()
          .collect(Collectors.toList());
      System.out.println(amount);
      System.out.println(inputNumbers);
      int result = minChange(amount, inputNumbers, memory);
      if (result == -1) {
        System.err.println("Not possible to give change.");
      } else {
        System.out.println("Min change requried >>" + result);
      }
      //memory.entrySet().forEach( kv -> System.out.println("Key=" + kv.getKey() +", Value=" + kv.getValue()));
    }
  }
}
