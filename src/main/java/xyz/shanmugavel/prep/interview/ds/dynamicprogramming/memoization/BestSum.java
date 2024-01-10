package xyz.shanmugavel.prep.interview.ds.dynamicprogramming.memoization;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

  private static Integer[] howSum(int sum, int[] numbers, Map<Integer, Integer[]> memory) {
    int remainingAmount;
    Integer[] result;
    if ( sum == 0 ) {
      return new Integer[0];
    }
    if ( sum < 0 ) {
      return null;
    }

    if (memory.containsKey(sum)) {
      return memory.get(sum);
    }

    Integer[] bestSum = null;
    int len;
    for (int n : numbers) {
      remainingAmount = sum - n;
      result = howSum(remainingAmount, numbers, memory);
      if (null != result) {
        len = result.length+1;
        result = Arrays.copyOf(result, len);
        result[len-1] = n;
        if ( bestSum == null || result.length < bestSum.length ) {
          bestSum = Arrays.copyOf(result, result.length);
        }
      }
    }

    memory.put(sum, bestSum);
    //System.out.println(memory);
    return memory.get(sum);
  }
  public static void main(String[] args) {
    System.out.println(LocalDateTime.now()+">>>"+ Arrays.toString(howSum(7, new int[]{2, 3}, new HashMap<>())));//[3,2,2]]
    System.out.println(LocalDateTime.now()+">>>"+ Arrays.toString(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>())));//[7]
    System.out.println(LocalDateTime.now()+">>>"+ Arrays.toString(howSum(8, new int[]{2, 3, 5}, new HashMap<>())));//[3,5]
    System.out.println(LocalDateTime.now()+">>>"+ Arrays.toString(howSum(8, new int[]{1, 4, 5}, new HashMap<>())));//[4,4]]
    System.out.println(LocalDateTime.now()+">>>"+ Arrays.toString(howSum(100, new int[]{1, 2,5,25}, new HashMap<>())));//[25,25,25,25]
    System.out.println(LocalDateTime.now());
  }
}
