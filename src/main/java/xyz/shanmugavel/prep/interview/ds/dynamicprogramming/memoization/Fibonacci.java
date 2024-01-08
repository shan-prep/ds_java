package xyz.shanmugavel.prep.interview.ds.dynamicprogramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  private static long fib(int no, Map<Integer, Long> memory) {
    if (no == 1 || no == 2) {
      return 1;
    }

    if ( memory.containsKey(no) ) {
      return memory.get(no);
    }
    long result = fib(no-1, memory) + fib(no-2, memory);
    memory.put(no, result);

    return memory.get(no);

  }
  public static void main(String[] args) {
    System.out.println(fib(1, new HashMap<>()));
    System.out.println(fib(2, new HashMap<>()));
    System.out.println(fib(3, new HashMap<>()));
    System.out.println(fib(4, new HashMap<>()));
    System.out.println(fib(5, new HashMap<>()));
    System.out.println(fib(6, new HashMap<>()));
    System.out.println(fib(7, new HashMap<>()));
    System.out.println(fib(8, new HashMap<>()));
    System.out.println(fib(9, new HashMap<>()));
    System.out.println(fib(10, new HashMap<>()));
  }
}
