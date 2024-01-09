package xyz.shanmugavel.prep.interview.ds.dynamicprogramming.memoization;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

  private static boolean canSum(int sum, int[] numbers, Map<Integer, Boolean> memory) {
    int remainingAmount;
    if ( sum == 0 ) {
      return true;
    }
    if ( sum < 0 ) {
      return false;
    }

    if (memory.containsKey(sum)) {
      return memory.get(sum);
    }

    for (int n : numbers) {
      remainingAmount = sum - n;
      if (canSum(remainingAmount, numbers, memory)) {
        memory.put(sum, true);
        return true;
      }
    }

    memory.put(sum, false);
    return false;
  }
  public static void main(String[] args) {
    System.out.println(LocalDateTime.now()+">>>"+canSum(7, new int[]{2, 3}, new HashMap<>()));//true
    System.out.println(LocalDateTime.now()+">>>"+canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));//true
    System.out.println(LocalDateTime.now()+">>>"+canSum(7, new int[]{2, 4}, new HashMap<>()));//false
    System.out.println(LocalDateTime.now()+">>>"+canSum(8, new int[]{2, 3, 5}, new HashMap<>()));//true
    System.out.println(LocalDateTime.now()+">>>"+canSum(300, new int[]{7, 14}, new HashMap<>()));//false
    System.out.println(LocalDateTime.now());
  }
}
