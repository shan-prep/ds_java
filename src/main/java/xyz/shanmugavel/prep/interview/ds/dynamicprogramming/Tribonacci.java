package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tribonacci {

  private static Long tribonacci(int no, Map<Integer, Long> map) {
    if ( no == 0 || no == 1) {
      return 0L;
    }
    if ( no == 2 ) {
      return 1L;
    }
    if (map.containsKey(no)) {
      System.out.println("Loaded from cache!!!" + no);
      return map.get(no);
    }
    map.put(no, tribonacci(no-1, map) + tribonacci(no-2, map) +tribonacci(no-3, map));
    return map.get(no);
  }

  public static void main(String[] args) {
    List<Long> result = IntStream.rangeClosed(0,8)
        .mapToLong(val -> tribonacci(val, new HashMap<>()))
        .boxed()
        .collect(Collectors.toList());
    System.out.println(result);
  }
}
