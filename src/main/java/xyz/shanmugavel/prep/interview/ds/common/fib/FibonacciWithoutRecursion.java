package xyz.shanmugavel.prep.interview.ds.common.fib;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FibonacciWithoutRecursion {

  private static long fib(int no) {
    if ( no == 0 ) {
      return 0;
    }
    if ( no == 1 ) {
      return 1;
    }

    long result = 0;
    long firstVal = 0;
    long secondVal = 1;

    for (int i = 2; i <= no; i++) {
      result  = firstVal + secondVal;
      firstVal = secondVal;
      secondVal = result;
    }
    return result;
  }

  public static void main(String[] args) {
    List<Long> result = IntStream.rangeClosed(0, 15)
        .mapToLong( val -> fib(val))
        .boxed()
        .collect(Collectors.toList());
    System.out.println(result);
  }
}
