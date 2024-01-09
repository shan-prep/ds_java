package xyz.shanmugavel.prep.interview.ds.dynamicprogramming.memoization;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

  private static List<Integer> howSum(int sum, int[] numbers, Map<Integer, List<Integer>> memory) {
    int remainingAmount;
    List<Integer> result;
    if ( sum == 0 ) {
      return new ArrayList<>();
    }
    if ( sum < 0 ) {
      return null;
    }

    if (memory.containsKey(sum)) {
      return memory.get(sum);
    }

    for (int n : numbers) {
      remainingAmount = sum - n;
      result = howSum(remainingAmount, numbers, memory);
      if (null != result) {
        result.add(n);
        memory.put(sum, result);
        return memory.get(sum);
      }
    }

    memory.put(sum, null);
    return memory.get(sum);
  }
  public static void main(String[] args) {
    System.out.println(LocalDateTime.now()+">>>"+ howSum(7, new int[]{2, 3}, new HashMap<>()));//[3,2,2]]
    System.out.println(LocalDateTime.now()+">>>"+ howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));//NULL
    System.out.println(LocalDateTime.now()+">>>"+ howSum(7, new int[]{2, 4}, new HashMap<>()));//[4,3]]
    System.out.println(LocalDateTime.now()+">>>"+ howSum(8, new int[]{2, 3, 5}, new HashMap<>()));//[2,2,2,2]
    System.out.println(LocalDateTime.now()+">>>"+ howSum(300, new int[]{7, 14}, new HashMap<>()));//NULL
    System.out.println(LocalDateTime.now());
  }
}
