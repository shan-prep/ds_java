package xyz.shanmugavel.prep.interview.ds.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fibonacci {

  private static long[] map;
  private static long fib(int no) {
    if ( map[no] == -1 ) {
      map[no] = fib(no-1) + fib(no-2);
    }
    return map[no];
  }
  public static void main(String[] args) {
    int n = 15;
    map = new long[n];
    Arrays.fill(map, -1);
    map[0] = 0;
    map[1] = 1;
    List<Long> result = IntStream.range(0, n)
        .mapToLong( val -> fib(val))
        .boxed()
        .collect(Collectors.toList());
    System.out.println(result);
    System.out.println(Arrays.toString(map));
  }
}
